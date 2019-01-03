package com.fvaras.ale.homelessmiaus.view;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.db.BdHelper;
import com.fvaras.ale.homelessmiaus.model.Contact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccount extends AppCompatActivity {
    private Button btnJointUs;
    private TextInputEditText email, name, phone, passwordCreateAccount, confirmPassword;
    private Contact contact;
    private BdHelper bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
     showTollbar(getResources().getString(R.string.toolbar_tittle_createaccount), true);

        btnJointUs = (Button) findViewById(R.id.btnJointUs);
        email = (TextInputEditText) findViewById(R.id.email);
        name = (TextInputEditText) findViewById(R.id.name);
        phone = (TextInputEditText) findViewById(R.id.phone);
        passwordCreateAccount = (TextInputEditText) findViewById(R.id.passwordCreateAccount);
        confirmPassword = (TextInputEditText) findViewById(R.id.confirmPassword);

        bdHelper = new BdHelper(this);

        btnJointUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAccount();
            }
        });


    }

    public void showTollbar(String tittle, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//para que pueda verse bien en versiones anteriores
        getSupportActionBar().setTitle(tittle);//obtenemos el titulo con el soporte
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//boton de regreso

    }

    public void saveAccount() {
        contact = new Contact();
        contact.setNom(name.getText().toString());

        if(isEmailValid(email.getText().toString())){
            contact.setEmail(email.getText().toString());
        }else{
            Toast.makeText(CreateAccount.this,"Ingrese un email valido",Toast.LENGTH_SHORT).show();
        }
        contact.setPhone(phone.getText().toString());
        contact.setPassword(passwordCreateAccount.getText().toString());
        Boolean validation=valdationPassword(passwordCreateAccount.getText().toString(),confirmPassword.getText().toString());
        if (validation && contact.getEmail()!=null ) {

            bdHelper.saveContact(contact);
        }else {
            Toast.makeText(CreateAccount.this,"Las contraseñas tienen que ser identicas",Toast.LENGTH_LONG).show();
        }
    }
    public  Boolean valdationPassword(String password, String confirmPassword){

       if (password.equals(confirmPassword)){
            return true;
        }else {
            return false;
        }

    }
    public boolean isEmailValid(String email)
    {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }
}
