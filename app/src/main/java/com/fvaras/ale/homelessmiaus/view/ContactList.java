package com.fvaras.ale.homelessmiaus.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.adapters.ContactAdapter;
import com.fvaras.ale.homelessmiaus.db.BdHelper;
import com.fvaras.ale.homelessmiaus.model.Contact;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BdHelper bdHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

         bdHelper = new BdHelper(this);



        recyclerView=(RecyclerView)findViewById(R.id.rvContact);

        //crear manager
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);//orientacion


        //QUE EL RECYCLERVIEW SE COMPORTE COMO UN LINEAR LANAYOUT

        recyclerView.setLayoutManager(llm);

        inicializarAdaptador();


    }
    public  void inicializarAdaptador(){
        ArrayList<Contact> contacts = bdHelper.getAllContacts();

        ContactAdapter adapter = new ContactAdapter(contacts,ContactList.this);

        recyclerView.setAdapter(adapter);

    }


}

