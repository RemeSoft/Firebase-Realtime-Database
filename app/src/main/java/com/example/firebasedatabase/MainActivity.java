package com.example.firebasedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    Button submit;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing Database Reference
        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        //Gating Touch to The XML
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        submit = findViewById(R.id.submit);

        //If Submit Button is clicked.
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

    }

    private void saveData() {
        //Gating Entered Data...
        String entered__name = name.getText().toString().trim();
        String entered__age = age.getText().toString().trim();

        //Generating Key...
        String key = databaseReference.push().getKey();

        //Setting Up Data into Database Model...
        DB_Model db_model = new DB_Model(entered__name,entered__age);

        //Inserting Data into Firebase Database...
        databaseReference.child(key).setValue(db_model);

        //If Data Inserting Successful, a Toast will Shown.
        Toast.makeText(this, "Data Inserted !!", Toast.LENGTH_SHORT).show();

    }
}