package com.fvaras.ale.homelessmiaus.view;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.db.BdHelper;
import com.fvaras.ale.homelessmiaus.model.Contact;
import com.fvaras.ale.homelessmiaus.model.Pet;

public class CreateAccountPet extends AppCompatActivity {
    private Button btnPostPet;
    private EditText nomPet;
    private EditText descriptionPet;
    private EditText agePet;
    private BdHelper bdHelper;
    private Pet pet;
    private Spinner spSexPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_pet);


        showTollbar(getResources().getString(R.string.toolbar_tittle_createaccount_pet), true);

        btnPostPet = (Button) findViewById(R.id.btnPostPet);
        nomPet = (EditText) findViewById(R.id.nomPet);
        agePet = (EditText) findViewById(R.id.agePet);
        spSexPet = (Spinner) findViewById(R.id.spSexPet);
        descriptionPet = (EditText) findViewById(R.id.textAreaDscriptionPet);



        bdHelper = new BdHelper(this);

        btnPostPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAccountPet();
            }
        });


    }

    public void showTollbar(String tittle, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//para que pueda verse bien en versiones anteriores
        getSupportActionBar().setTitle(tittle);//obtenemos el titulo con el soporte
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//boton de regreso

    }
    public void saveAccountPet() {
        pet = new Pet();
        pet.setNom(nomPet.getText().toString());
        pet.setSex(spSexPet.getSelectedItem().toString());
        pet.setAge(agePet.getText().toString());

        pet.setDescription(descriptionPet.getText().toString());
        pet.setAvatar(R.drawable.gato);
        bdHelper.savePet(pet);

    }


}

