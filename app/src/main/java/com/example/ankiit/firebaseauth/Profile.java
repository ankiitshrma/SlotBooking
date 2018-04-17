package com.example.ankiit.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Random;

public class Profile extends AppCompatActivity {



    private EditText tvname;
    private Button logout;
    private EditText tvcont;
    private EditText tvemail;
    private Button btncreate;
    private TextView tvEmail;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseUser;

  /*  public class UserProfile {
        public String userContact;
        public String userEmail;
        public String userName;
        public int number;

        public UserProfile(){
        }

        public UserProfile(String userContact, String userEmail, String userName) {
            this.userContact = userContact;
            this.userEmail = userEmail;
            this.userName = userName;
        }





        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }*/














    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvEmail = (TextView) findViewById(R.id.tvEmailProfile);
        tvEmail.setText(getIntent().getExtras().getString("Email"));
        tvname=(EditText)findViewById(R.id.tvname);
        tvemail=(EditText)findViewById(R.id.tvmail);
        tvcont=(EditText)findViewById(R.id.tvcont);
        btncreate=(Button)findViewById(R.id.btncreate);
        FirebaseApp.initializeApp(this);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("users");


        firebaseAuth = FirebaseAuth.getInstance();
        logout = (Button) findViewById(R.id.logout);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userProf();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Profile.this, MainActivity.class));
            }
        });
    }

    private void userProf(){
        String nm = tvname.getText().toString().trim();
        String con = tvcont.getText().toString().trim();
        String mail = tvemail.getText().toString().trim();

        if(!TextUtils.isEmpty(nm))

            {

                String id = databaseUser.push().getKey();
                userprofile profile = new userprofile(id,nm,con,mail);

                databaseUser.child(id).setValue(profile);
                Toast.makeText(this, "User added", Toast.LENGTH_LONG).show();
                Intent inte = new Intent(this,SlotBook.class);
                startActivity(inte);
            }else{
                Toast.makeText(this, "Enter a name", Toast.LENGTH_LONG).show();
            }
    }
}

