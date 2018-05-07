package com.example.anas.exercise01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        Toast.makeText(getApplicationContext(),"close by pressing one of the buttons",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button1 ;
        Button button2 ;
        TextView textView;

        button1 =findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView5);

        String Color=getIntent().getExtras().getString("color");
        textView.setText("the selected color value is (R,G,B) ="+Color);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,MainActivity.class);
                finish();
                Toast.makeText(getApplicationContext(),"About activity was closed using CANCEL",Toast.LENGTH_SHORT).show();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,MainActivity.class);
                finish();
                Toast.makeText(getApplicationContext(),"About activity was closed using Ok",Toast.LENGTH_SHORT).show();


            }
        });

    }
}
