package com.example.calorie_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


//public class MainActivity extends AppCompatActivity {

//    EditText email,password;
//    TextView btn;
//    Button login;
//    ProgressDialog progressDialog;
//    String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//    FirebaseAuth mAuth;
//    FirebaseUser mUser;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        btn= findViewById(R.id.btnLogin);
//        email=findViewById(R.id.inputEmail);
//        password=findViewById(R.id.inputPassword);
//        login=findViewById(R.id.btnLogin);
//        progressDialog=new ProgressDialog(this);
//        mAuth=FirebaseAuth.getInstance();
//        mUser=mAuth.getCurrentUser();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Intent i=new Intent(getApplicationContext(),RegisterActivity.class);
//                // startActivity(i);
//                startActivity(new Intent(MainActivity.this, calci.class));
//            }
//        });
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                performLogin();
//            }
//
//            private void performLogin() {
//                String useremail = email.getText().toString();
//                String password1 = password.getText().toString();
//
//                if (!useremail.matches(emailPattern)) {
//                    email.setError("Enter correct Email");
//                } else if (password1.isEmpty() || password1.length() < 6) {
//                    password.setError("Enter proper password");
//                } else {
//                    progressDialog.setMessage(" Please wait while Login....");
//                    progressDialog.setTitle("Login");
//                    progressDialog.setCanceledOnTouchOutside(false);
//                    progressDialog.show();
//                    mAuth.signInWithEmailAndPassword(useremail, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                progressDialog.dismiss();
//                                sendUserToNextActivity();
//                                Toast.makeText(MainActivity.this, "Login successfull", Toast.LENGTH_SHORT).show();
//
//                            }
//                            else
//                            {
//                                progressDialog.dismiss();
//                                Toast.makeText(MainActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        private void sendUserToNextActivity() {
//                            Intent intent=new Intent(MainActivity.this,calci.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
//                            startActivity(intent);
//                        }
//
//
//                    });
//
//                }
//            }
//        });
//
//        //authenticate user
//
//        String finalEmail = email.getText().toString();
//        mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(MainActivity.this,"Logged in Successfully",Toast.LENGTH_SHORT).show();
//                    startActivity(intent);
//                    finish();
//                }
//                else{
//                    Toast.makeText(Login.this,"Error!!! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                    progressBar.setVisibility(View.GONE);
//                }
//            }
//        });
//    }




    public class MainActivity extends AppCompatActivity {
        EditText jEmail,jPassword;
        Button jLoginButton;
        TextView jCreateButton,forgotTextLink;
        FirebaseAuth fAuth;
        ProgressBar progressBar;

        String email;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Removes status bar
            Objects.requireNonNull(getSupportActionBar()).hide();
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            Intent intent=new Intent(MainActivity.this,calci.class);

            jEmail=findViewById(R.id.inputEmail);
            jPassword=findViewById(R.id.inputPassword);
            jLoginButton=findViewById(R.id.btnLogin);
            jCreateButton=findViewById(R.id.createNewAccount);
            fAuth=FirebaseAuth.getInstance();
            //progressBar=findViewById(R.id.progressBar);
            forgotTextLink=findViewById(R.id.forgotPassword);

            jLoginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email=jEmail.getText().toString().trim();
                    email=jEmail.getText().toString();
                    System.out.println(email);
                    intent.putExtra("User",email);
                    String password=jPassword.getText().toString().trim();

                    if(TextUtils.isEmpty(email)){
                        jEmail.setError("Email is required!!!");
                        return;
                    }

                    if(TextUtils.isEmpty(password)){
                        jPassword.setError("Password is required!!!");
                        return;
                    }

                    if(password.length()<6){
                        jPassword.setError("Password must atleast 6 characters");
                        return;
                    }

                    //progressBar.setVisibility(View.VISIBLE);

                    //authenticate user

                    String finalEmail = email;
                    fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Logged in Successfully",Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(MainActivity.this,"Error!!! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                //progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
            });


            jCreateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("In here");
                    startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
                }
            });

            forgotTextLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText resetMail=new EditText(view.getContext());
                    AlertDialog.Builder passwordResetDailog = new AlertDialog.Builder(view.getContext());
                    passwordResetDailog.setTitle("Reset Password");
                    passwordResetDailog.setMessage("Enter your Email id to receive reset link");
                    passwordResetDailog.setView(resetMail);

                    passwordResetDailog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //extract the email to send reset link
                            String mail=resetMail.getText().toString();
                            fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(MainActivity.this,"Rest link sent Succesfully",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this,"Link is not sent "+e.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });

                    passwordResetDailog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //closing dailog and to move to login page
                        }
                    });

                    passwordResetDailog.create().show();
                }
            });

//            fAuth = FirebaseAuth.getInstance();
//            if (fAuth.getCurrentUser() != null) {
//                Intent intent1=new Intent(getApplicationContext(), calci.class);
//                intent1.putExtra("User",email);
//                startActivity(intent1);
//                finish();
//            }
        }
    }
