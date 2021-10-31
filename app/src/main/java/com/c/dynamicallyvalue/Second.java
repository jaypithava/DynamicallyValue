package com.c.dynamicallyvalue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Second extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Back");


        Bundle extras = getIntent().getExtras();
        String string = extras.getString("count");
        String d = extras.getString( "data" );


        int Count = Integer.parseInt(String.valueOf(string));

        Bundle bundle = getIntent().getExtras();
        String details = bundle.get("data").toString();
        ArrayList<String> value = new ArrayList<>();




        if (details.equals("EditText")) {

            for (int i = 1; i <= Count; i++) {
                LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);


                EditText editText = new EditText(this);
                editText.setPadding(50,50,50,50);
                editText.setText("EditText"+i);

                //Add Data in Layout
                layout.addView(editText);
            }

        }
        else if (details.equals("TextView")) {

            for (int i = 1; i <= Count; i++) {
                LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);

                TextView textView = new TextView(this);
                textView.setText("TextView"+i);
                textView.setPadding(50,50,50,50);

                layout.addView(textView);
            }

        }
        else if (details.equals("CheckBox")) {

            for (int i = 1; i <= Count; i++) {
                LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);

                CheckBox checkBox = new CheckBox(this);
                checkBox.setText("CheckBox"+i);
                checkBox.setPadding(50,50,50,50);
                layout.addView(checkBox);
            }

        }
        else if (details.equals("RadioButton")) {
            for (int i = 1; i <= Count; i++) {
                LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);

                RadioButton radioButton = new RadioButton(this);
                radioButton.setText("RadioButton"+i);
                radioButton.setPadding(50,50,50,50);
                layout.addView(radioButton);
            }
        }
        else if (details.equals( "RatingBar" )) {
            for (int i = 1;i<=Count;i++) {
                LinearLayout layout = (LinearLayout) findViewById( R.id.linear );
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0.0F );

                LinearLayout ll = new LinearLayout(getApplicationContext());
                ll.setMinimumWidth(300);
                ll.setMinimumHeight(100);
                RatingBar r_b = new RatingBar(getApplicationContext());
                r_b.setNumStars(5);
                ll.addView(r_b);
                layout.addView( ll );}
        }


    }

}
