package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {
    Button btn;
   public static EditText edt1,edt2,edt3,edt4,edt5;
    private DatabaseReference dbref= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        edt1=findViewById(R.id.editText1);
        edt2=findViewById(R.id.editText2);
        edt3=findViewById(R.id.editText3);
        edt4=findViewById(R.id.editText4);
        edt5=findViewById(R.id.editText5);
        findViewById(R.id.Submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u=new User(edt1.getText().toString(),edt3.getText().toString(),edt2.getText().toString(),edt4.getText().toString(),edt5.getText().toString());
                dbref.child("Profile").push().setValue(u);

                Intent i=new Intent(Profile.this,MainActivity.class);
                startActivity(i);
    }
});
    }}