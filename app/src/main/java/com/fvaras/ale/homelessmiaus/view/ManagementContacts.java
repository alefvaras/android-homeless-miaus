package com.fvaras.ale.homelessmiaus.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.SearchView;

import android.widget.Button;
import android.widget.EditText;

import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.db.BdHelper;
import com.fvaras.ale.homelessmiaus.model.Contact;


public class ManagementContacts extends AppCompatActivity {

    private EditText managerContactName;
    private EditText  managerContactPhone;
    private EditText  managerContactEmail;
    private EditText  managerContactPassword;
    private Button btnDeleteContact;
    private Button btnUpdateContact;
    private BdHelper bdHelper;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_contacts);
        showTollbar(getResources().getString(R.string.toolbar_tittle_management_contact), true);

        managerContactName=(EditText ) findViewById(R.id.managerContactName);
        managerContactPhone=(EditText ) findViewById(R.id.managerContactPhone);
        managerContactEmail=(EditText ) findViewById(R.id.managerContactEmail);
        managerContactPassword=(EditText ) findViewById(R.id.managerContactPassword);
        btnDeleteContact=(Button) findViewById(R.id.btnDeleteContact);
        btnUpdateContact=(Button) findViewById(R.id.btnUpdateContact);

        bdHelper = new BdHelper(this);

        btnUpdateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();
              contact.setNom(managerContactName.getText().toString());
                contact.setEmail(managerContactEmail.getText().toString());
                contact.setPassword(managerContactPassword.getText().toString());
                contact.setPhone(managerContactPhone.getText().toString());
                contact.setId(id);

             bdHelper.updateContact(contact);
             clear();

            }
        });
        btnDeleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdHelper.deleteContact(id);
                clear();
            }
        });
    }

    @Override
    //creo las opciones del menu_search, inflandolo/cargandolo
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) search.getActionView();

        //agregar un oyente al searchview
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                id= Integer.parseInt(s);

                Contact contact=bdHelper.getContact(id);
                managerContactName.setText(contact.getNom());
                managerContactPhone.setText(contact.getPhone());
                managerContactEmail.setText(contact.getEmail());
                managerContactPassword.setText(contact.getPassword());

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }


    @Override
    //saber cual elemento del menu_search el usuario selecciono
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public void showTollbar(String tittle, boolean upButton) {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//para que pueda verse bien en versiones anteriores
        getSupportActionBar().setTitle(tittle);//obtenemos el titulo con el soporte
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//boton de regreso

    }
    public  void clear(){
        managerContactName.setText("");
        managerContactPhone.setText("");
        managerContactEmail.setText("");
        managerContactPassword.setText("");
    }
}
