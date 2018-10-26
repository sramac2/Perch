package com.example.android.perch;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText mNameEditText, mEmailEditText, mPhoneEditText, mPasswordEditText;
    private Button mSignUpButton;
    private String sName, sEmail, sPhone, sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        mNameEditText = findViewById(R.id.NameBox);
        mEmailEditText = findViewById(R.id.EmailBox);
        mPhoneEditText = findViewById(R.id.PhoneBox);
        mPasswordEditText = findViewById(R.id.PasswordBox);
        mSignUpButton = findViewById(R.id.SignUpButton);
        mAuth = FirebaseAuth.getInstance();

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sName = mNameEditText.getText().toString();
                sEmail = mEmailEditText.getText().toString();
                sPhone = mPhoneEditText.getText().toString();
                sPassword = mPasswordEditText.getText().toString();

                createUser();
            }
        });
    }

    private void createUser() {
        mAuth.createUserWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener
                (this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            // Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(SignUpActivity.this, task.getResult().toString(),
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            //   Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        // TODO: add userID and ownerID
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        Person user = new Person("user123", sName, sEmail, sPhone, "owner420");
        myRef.setValue(user);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

}
