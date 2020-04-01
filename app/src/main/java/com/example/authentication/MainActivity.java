package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText mail,pass;
    Button b1;
    FirebaseAuth bauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.mail);
        pass=findViewById(R.id.pass);
        b1=findViewById(R.id.button);
        bauth = FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail1=mail.getText().toString().trim();

                String pass1=pass.getText().toString().trim();


                bauth.signInWithEmailAndPassword(mail1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Loggin In", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), Home.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }

                    }
                });
            }
        });


        TextView t=(TextView)findViewById(R.id.signup_link);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, sign_up.class);
                startActivity(myIntent);
            }
        });
    }
}
