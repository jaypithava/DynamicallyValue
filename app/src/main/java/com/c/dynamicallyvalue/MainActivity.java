package com.c.dynamicallyvalue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edNo;
    Button btnSubmit;
    Spinner spinner;
    String details;

    private String fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edNo = findViewById(R.id.edNo);
        spinner = findViewById(R.id.spinner);
        btnSubmit= findViewById(R.id.btnSubmit);

        ArrayList<String> value = new ArrayList<>();
        value.add("EditText");
        value.add("TextView");
        value.add("CheckBox");
        value.add( "RadioButton" );
        value.add( "RatingBar" );


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, value);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, value);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                details = parent.getItemAtPosition(position).toString();
                String positions = parent.getItemAtPosition(position).toString();
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        btnSubmit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                registration();

            }

            private void registration() {

                intialize();
                if(!validate()) {
                    //Toast.makeText(this, "SignUP Has Failed", Toast.LENGTH_SHORT).show();
                }
                else {
                    onSignupSuccess();
                }
            }

            private void intialize() {
                fname=edNo.getText().toString();

            }

            public void onSignupSuccess()
            {
                Intent i = new Intent(MainActivity.this, Second.class);
                i.putExtra("count", edNo.getText().toString());

                i.putExtra("data", String.valueOf(spinner.getSelectedItem()));
                startActivity(i);

            }


            private boolean validate() {
                boolean valid=true;
                if(fname.isEmpty()||fname.length()>32){
                    edNo.setError("Enter Valid Details");
                    valid=false;
                }
                return valid;

            }
        });

    }
}