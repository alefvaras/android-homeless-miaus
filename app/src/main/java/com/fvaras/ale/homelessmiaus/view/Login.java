package com.fvaras.ale.homelessmiaus.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fvaras.ale.homelessmiaus.R;
import com.fvaras.ale.homelessmiaus.db.BdHelper;

public class Login extends AppCompatActivity {
private TextView goCreateAccount;
private Button bnLogin;
private BdHelper bdHelper;
private TextInputEditText username;
    private TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        goCreateAccount =(TextView) findViewById(R.id.createHere);
        username =(TextInputEditText) findViewById(R.id.username) ;
        password=(TextInputEditText) findViewById(R.id.password) ;
        bnLogin =(Button) findViewById(R.id.bnLogin) ;

bdHelper = new BdHelper(this);
        bnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bdHelper.isAcountExists(username.getText().toString(),password.getText().toString());
            }
        });

        goCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, CreateAccount.class);
                startActivity(i);
            }
        });

    }

}
