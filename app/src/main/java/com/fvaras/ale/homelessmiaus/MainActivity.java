package com.fvaras.ale.homelessmiaus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.fvaras.ale.homelessmiaus.view.ContactList;
import com.fvaras.ale.homelessmiaus.view.CreateAccount;
import com.fvaras.ale.homelessmiaus.view.CreateAccountPet;
import com.fvaras.ale.homelessmiaus.view.Login;
import com.fvaras.ale.homelessmiaus.view.ManagementContacts;
import com.fvaras.ale.homelessmiaus.view.ManagementPets;
import com.fvaras.ale.homelessmiaus.view.ManagementProvider;
import com.fvaras.ale.homelessmiaus.view.PetList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTollbar(getResources().getString(R.string.toolbar_tittle_homeless), false);




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //cambiar por un switch
        if(id==R.id.management_contact){
            Intent i = new Intent(MainActivity.this, ManagementContacts.class);

            startActivity(i);
        }
        else if(id==R.id.management_pet){
            Intent i = new Intent(MainActivity.this, ManagementPets.class);
            startActivity(i);
        }else if(id==R.id.list_pet){
            Intent i = new Intent(MainActivity.this, PetList.class);
            startActivity(i);
        }
        else if(id==R.id.list_contact){
            Intent i = new Intent(MainActivity.this, ContactList.class);
            startActivity(i);
        } else if(id==R.id.login_contact){
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
        }else if(id==R.id.create_account_contact){
            Intent i = new Intent(MainActivity.this, CreateAccount.class);
            startActivity(i);
        }else if(id==R.id.publish_pet){
            Intent i = new Intent(MainActivity.this, CreateAccountPet.class);
            startActivity(i);
        }else if(id==R.id.provider_menu){
            Intent i = new Intent(MainActivity.this, ManagementProvider.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void showTollbar(String tittle, boolean upButton) {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//para que pueda verse bien en versiones anteriores
        getSupportActionBar().setTitle(tittle);//obtenemos el titulo con el soporte
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//boton de regreso

    }
}
