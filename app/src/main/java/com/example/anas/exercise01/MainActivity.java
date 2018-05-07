package com.example.anas.exercise01;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.text.InputFilter;
import android.content.Intent;




public class MainActivity extends AppCompatActivity {
    static String TAG="MainActivity";
    private static SeekBar seekBar1 ;
    private static SeekBar seekBar2 ;
    private static SeekBar seekBar3 ;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final EditText editText1 ;
        final EditText editText2 ;
        final EditText editText3 ;

        final TextView textView4 ;
        final RadioGroup radioGroup;
        final RadioButton radioButton1 ;
        final RadioButton radioButton2;
        final RadioButton radioButton3 ;
        final RadioButton radioButton4 ;
        final Button button ;


        int progress=0 ;
        setSupportActionBar(toolbar);

      final FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Information: Wipe to the right to dismiss...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        //red
        EditText myEditText1 = (EditText)findViewById(R.id.editText1);
        myEditText1.setFilters(new InputFilter[]{ new InputFilterMinMax("1","255")});

        //blue
        EditText myEditText2 = (EditText)findViewById(R.id.editText2);
        myEditText2.setFilters(new InputFilter[]{ new InputFilterMinMax("1","255")});

        //green
        EditText myEditText3 = (EditText)findViewById(R.id.editText3);
        myEditText3.setFilters(new InputFilter[]{ new InputFilterMinMax("1","255")});

        editText1 =  findViewById(R.id.editText1);
        editText2 =  findViewById(R.id.editText2);
        editText3 =  findViewById(R.id.editText3);
        seekBar1 =  findViewById(R.id.seekBar1);
        seekBar2 =  findViewById(R.id.seekBar2);
        seekBar3 =  findViewById(R.id.seekBar3);
        textView4=  findViewById(R.id.textView4);
        radioGroup =(RadioGroup) findViewById(R.id.radioGroup);
        radioButton1 =  findViewById(R.id.radioButton1);
        radioButton2 =  findViewById(R.id.radioButton2);
        radioButton3 =  findViewById(R.id.radioButton3);
        radioButton4 =  findViewById(R.id.radioButton4);
        button = findViewById(R.id.button);




        seekBar1.setProgress(progress);
        seekBar1.setMax(255);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editText1.setText(""+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2.setProgress(progress);
        seekBar2.setMax(255);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editText2.setText(""+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar3.setProgress(progress);
        seekBar3.setMax(255);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editText3.setText(""+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                seekBar1.setProgress(Integer.parseInt(s.toString()));

            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                seekBar2.setProgress(Integer.parseInt(s.toString()));

            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                seekBar3.setProgress(Integer.parseInt(s.toString()));

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String red =Integer.toHexString(Integer.parseInt(editText1.getText().toString()));
                String green =Integer.toHexString(Integer.parseInt(editText2.getText().toString()));
                String blue =Integer.toHexString(Integer.parseInt(editText3.getText().toString()));
                int r=Integer.parseInt(red,16);
                int g=Integer.parseInt(green,16);
                int b=Integer.parseInt(blue,16);
                if(r<16){
                    red="0"+red;

                }
                if(g<16){
                    green="0"+green;

                }
                if(b<16){
                    blue="0"+blue;

                }

                if(radioButton1.isChecked()){

                   textView4.setTextColor(Color.parseColor("#"+red+green+blue));
                }
                if(radioButton2.isChecked()){

                    textView4.setBackgroundColor(Color.parseColor("#"+red+green+blue));
                }
                if(radioButton3.isChecked()){

                    button.setBackgroundColor(Color.parseColor("#"+red+green+blue));
                }
               if(radioButton4.isChecked()){
                    fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#"+red+green+blue)));
                }
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String aboutColor = String.format("(%02X,%02X,%02X)",seekBar1.getProgress(),seekBar2.getProgress(),seekBar3.getProgress());
            Intent i=new Intent(MainActivity.this,Main2Activity.class);
           i.putExtra("color",aboutColor);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
