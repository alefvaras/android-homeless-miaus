package com.fvaras.ale.homelessmiaus.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.adapters.ContactAdapter;
import com.fvaras.ale.homelessmiaus.adapters.PetAdapter;
import com.fvaras.ale.homelessmiaus.db.BdHelper;
import com.fvaras.ale.homelessmiaus.model.Contact;
import com.fvaras.ale.homelessmiaus.model.Pet;

import java.util.ArrayList;

public class PetList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BdHelper bdHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);


        bdHelper = new BdHelper(this);



        recyclerView=(RecyclerView)findViewById(R.id.rvPet);

        //crear manager
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);//orientacion


        //QUE EL RECYCLERVIEW SE COMPORTE COMO UN LINEAR LANAYOUT

        recyclerView.setLayoutManager(llm);

        inicializarAdaptador();


    }
    public  void inicializarAdaptador(){
        ArrayList<Pet> pets = bdHelper.getAllPets();

       PetAdapter adapter = new PetAdapter(pets, PetList.this);

        recyclerView.setAdapter(adapter);

    }
    }

