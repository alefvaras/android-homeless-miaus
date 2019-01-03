package com.fvaras.ale.homelessmiaus.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.db.BdHelper;

import com.fvaras.ale.homelessmiaus.model.Pet;

public class ManagementPets extends AppCompatActivity {
    private EditText managerPetName;
    private EditText  managerPetSex;
    private EditText  managerPetAge;
    private EditText  managerPetDescription;

    private Button btnDeletePet;
    private Button btnUpdatePet;
    private BdHelper bdHelper;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_pets);
        showTollbar(getResources().getString(R.string.toolbar_tittle_management_pet), true);

        managerPetName=(EditText ) findViewById(R.id.managerPetName);
        managerPetSex=(EditText ) findViewById(R.id.managerPetSex);
        managerPetAge=(EditText ) findViewById(R.id.managerPetAge);
        managerPetDescription=(EditText ) findViewById(R.id.managerPetDescription);

        btnDeletePet=(Button) findViewById(R.id.btnDeletePet);
        btnUpdatePet=(Button) findViewById(R.id.btnUpdatePet);

        bdHelper = new BdHelper(this);

        btnUpdatePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pet pet = new Pet();
                pet.setNom(managerPetName.getText().toString());
                pet.setAge(managerPetAge.getText().toString());
                pet.setDescription(managerPetDescription.getText().toString());
                pet.setSex(managerPetSex.getText().toString());
                pet.setId(id);


                bdHelper.updatePet(pet);
                clear();

            }
        });
        btnDeletePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdHelper.deletePet(id);
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

                Pet pet=bdHelper.getPet(id);
                managerPetName.setText(pet.getNom());
                managerPetSex.setText(pet.getSex());
                managerPetAge.setText(pet.getAge());
                managerPetDescription.setText(pet.getDescription());

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
        managerPetName.setText("");
        managerPetSex.setText("");
        managerPetAge.setText("");
        managerPetDescription.setText("");
    }
}
