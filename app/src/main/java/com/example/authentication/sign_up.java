package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_up extends AppCompatActivity {
    EditText editTextEmail, editTextPassword,name,mob;
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextEmail = findViewById(R.id.signup_email);

        name = findViewById(R.id.name);
        mob= findViewById(R.id.phnum);
        editTextPassword = findViewById(R.id.signup_password);
        progressBar = findViewById(R.id.progressbar);
        sign_up=findViewById(R.id.signup_button);
        mAuth = FirebaseAuth.getInstance();


//        TextView t=(TextView)findViewById(R.id.login_link);
//        t.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent m=new Intent(sign_up.this,MainActivity.class);
//                startActivity(m);
//            }
//        });

//            if(mAuth.getCurrentUser()!=null)
//            {
//                startActivity(new Intent(sign_up.this,MainActivity.class));
//                finish();
//
//            }
            sign_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String email=editTextEmail.getText().toString();
                    String Pass=editTextPassword.getText().toString();

                    if(TextUtils.isEmpty(email)){
                        editTextEmail.setError("Email is required");
                        return;
                    }
                    if(TextUtils.isEmpty(Pass)){
                        editTextPassword.setError("Password is required");
                        return;
                    }

                    if(Pass.length()<6){
                        editTextPassword.setError("Password nust be more than 6 char");
                    }

                    progressBar.setVisibility(View.VISIBLE);



                    mAuth.createUserWithEmailAndPassword(email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"User Added",Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(sign_up.this,MainActivity.class));

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            });
    }
}
