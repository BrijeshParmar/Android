package com.example.genesis.watermeter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private static EditText emailid, password;
    private static Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth =FirebaseAuth.getInstance();
        emailid = (EditText)findViewById(R.id.login_emailid);
        password = (EditText)findViewById(R.id.login_password);
        loginButton = (Button)findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailid.getText().toString();
                String passw = password.getText().toString();
                SignIn(email,passw);
            }
        });
    }

    void SignIn(final String email,final String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent userIntent = new Intent(getApplicationContext(),UserDashboard.class);
                            userIntent.putExtra("E-mail", email);
                            startActivity(userIntent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Incorrect Username/Password",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
