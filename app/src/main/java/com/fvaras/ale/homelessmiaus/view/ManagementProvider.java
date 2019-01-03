package com.fvaras.ale.homelessmiaus.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.SearchView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.db.BdHelper;
import com.fvaras.ale.homelessmiaus.model.Provider;

public class ManagementProvider extends AppCompatActivity {

    private EditText managerProviderName;
    private EditText managerProvidertPhone;
    private EditText managerProviderEmail;
    private EditText managerProviderRazonSocial;
    private EditText managerProviderAddress;
    private Spinner spTurn;
    private Button btnUpdateProvider;
    private Button btnDeleteProvider;
    private Button btnSaveProvider;
    private BdHelper bdHelper;
    private int id;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) search.getActionView();
        //agregar un oyente al searchview
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                id= Integer.parseInt(s);
                int positionProvider=0;

                Provider provider=bdHelper.getProvider(id);

                managerProviderAddress.setText(provider.getAddress());
                managerProviderName.setText(provider.getNomBusiness());
                managerProvidertPhone.setText(provider.getPhone());
                managerProviderEmail.setText(provider.getEmail());
                managerProviderRazonSocial.setText(provider.getRazonSocial());

                //Obtener valor de posicion spinner
                int spinner_pos = spTurn.getSelectedItemPosition();
                String[] size_values = getResources().getStringArray(R.array.turn_array);
                String value = size_values[spinner_pos]; // medicamentos, comida, accesorios para mascotas


                Log.d("spinner es: ", provider.getTurn());
                if(provider.getTurn().equals("Comida")){
                    positionProvider =0;
                }else if(provider.getTurn().equals("Medicamentos")){
                    positionProvider =1;
                }else if(provider.getTurn().equals("Accesorios mascotas")){
                    positionProvider =2;
                }
                spTurn.setSelection(positionProvider);


                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return  true;
    }
    @Override
    //saber cual elemento del menu_search el usuario selecciono
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_provider);
        showTollbar(getResources().getString(R.string.toolbar_tittle_management_provider), true);


        managerProviderName = (EditText) findViewById(R.id.managerProviderName);
        managerProvidertPhone = (EditText) findViewById(R.id.managerProvidertPhone);
        managerProviderEmail = (EditText) findViewById(R.id.managerProviderEmail);
        managerProviderRazonSocial = (EditText) findViewById(R.id.managerProviderRazonSocial);
        managerProviderAddress = (EditText) findViewById(R.id.managerProviderAddress);
        spTurn = (Spinner) findViewById(R.id.spTurn);
        btnDeleteProvider = (Button) findViewById(R.id.btnDeleteProvider);
        btnUpdateProvider = (Button) findViewById(R.id.btnUpdateProvider);
        btnSaveProvider=(Button) findViewById(R.id.btnSaveProvider) ;

        bdHelper = new BdHelper(this);



        btnUpdateProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Provider provider = new Provider();
                provider.setNomBusiness(managerProviderName.getText().toString());
                provider.setAddress(managerProviderAddress.getText().toString());
                provider.setEmail(managerProviderEmail.getText().toString());
                provider.setPhone(managerProvidertPhone.getText().toString());
                provider.setRazonSocial(managerProviderRazonSocial.getText().toString());
                provider.setId(id);
                provider.setTurn(spTurn.getSelectedItem().toString());

                bdHelper.updateProvider(provider);
                clear();

            }
        });
        btnDeleteProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdHelper.deleteProvider(id);
                clear();
            }
        });


    btnSaveProvider.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Provider provider= new Provider();
            provider.setNomBusiness(managerProviderName.getText().toString());
            provider.setAddress(managerProviderAddress.getText().toString());
            provider.setEmail(managerProviderEmail.getText().toString());
            provider.setPhone(managerProvidertPhone.getText().toString());
            provider.setRazonSocial(managerProviderRazonSocial.getText().toString());
            provider.setId(id);
            provider.setTurn(spTurn.getSelectedItem().toString());
            bdHelper.saveProvider(provider);
            clear();
        }
    });
    }


    public void clear() {
        managerProviderAddress.setText("");
        managerProviderName.setText("");
        managerProvidertPhone.setText("");
        managerProviderEmail.setText("");
        managerProviderRazonSocial.setText("");
        spTurn.setSelection(0);
    }
    public void showTollbar(String tittle, boolean upButton) {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//para que pueda verse bien en versiones anteriores
        getSupportActionBar().setTitle(tittle);//obtenemos el titulo con el soporte
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//boton de regreso

    }
}
