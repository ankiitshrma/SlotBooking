package com.example.ankiit.firebaseauth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Reg extends AppCompatActivity{


    private EditText email;
    private EditText password;
    private EditText name;
    private EditText contact;
    private FirebaseAuth firebaseAuth;

   // String Email,User,Cont;

    DatabaseReference databaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        email = (EditText) findViewById(R.id.txtEmailRegistration);
        password = (EditText) findViewById(R.id.txtPasswordRegistration);
      ////  name = (EditText) findViewById(R.id.name);
      //  contact = (EditText) findViewById(R.id.cont);
        FirebaseApp.initializeApp(this);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("users");



    }
    public void btnRegistrationUser_Click(View v) {

       // userProf();

        final ProgressDialog progressDialog = ProgressDialog.show(Reg.this, "Please wait...", "Processing...", true);
        (firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(Reg.this, "Registration successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Reg.this, Login.class);
                            startActivity(i);
                        }
                        else
                        {
                           // Log.e("ERROR", task.getException().toString());
                            //Toast.makeText(Reg.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            Toast.makeText(Reg.this, "Registration Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }}

   /*  private void userProf(){
        String nm = name.getText().toString().trim();
        String con = contact.getText().toString().trim();

        if(!TextUtils.isEmpty(nm))
            if(!TextUtils.isEmpty(con))
              {

            String id = databaseUser.push().getKey();
            Profile profile = new Profile(id,nm);

            databaseUser.child(id).setValue(profile);
            Toast.makeText(this, "User added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Enter a name", Toast.LENGTH_LONG).show();
        }
     }

   // private void userDataSent(){
       // FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
      //  Profile userProfile = new Profile.UserProfile(Cont, Email, User);
     //   myRef.setValue(userProfile);
  //  }


}*/

