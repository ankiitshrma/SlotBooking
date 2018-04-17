package com.example.ankiit.firebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            finish();
            startActivity(new Intent(MainActivity.this, Profile.class));
        }
        else{
            finish();
        }*/
    }
    public void btnRegistration_Click(View v) {
        Intent i1 = new Intent(MainActivity.this, Reg.class);
        startActivity(i1);
    }
    public void btnLogin_Click(View v) {
        Intent i2 = new Intent(MainActivity.this, Login.class);
        startActivity(i2);
    }
}

