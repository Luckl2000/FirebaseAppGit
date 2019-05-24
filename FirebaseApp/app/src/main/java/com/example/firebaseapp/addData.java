package com.example.firebaseapp;

import android.content.Intent;
import android.media.Image;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.firebase.client.Firebase;

public class addData extends AppCompatActivity {

    EditText myEditFrom, myEditUntil, myEditFarm, myKeyValue,Inputkey;
    ImageView myApplyBt;

    String myStringDataFrom, myKeyValueDataFrom, myStringDataUntil, myKeyValueDataUntil, myStringDataFarm, myKeyValueDataFarm;

    Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Reading Data from Input
        myKeyValue = (EditText) findViewById(R.id.editText4);
        myEditFrom = (EditText) findViewById(R.id.editText3);
        myEditUntil = (EditText) findViewById(R.id.editText6);
        myEditFarm = (EditText) findViewById(R.id.editText5);

        //initiate apply button
        myApplyBt =  (ImageView) findViewById(R.id.button3);


        // Initiate Firebase
        Firebase.setAndroidContext(this);

        final String DeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);


        myKeyValue.addTextChangedListener(DateTextWatcher);
        myEditFrom.addTextChangedListener(DateTextWatcherFrom);
        myEditUntil.addTextChangedListener(DateTextWatcherUntil);
        myEditFarm.addTextChangedListener(DateTextWatcherFarm);


    // Reading Data from Input
        myApplyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Keydate =  myKeyValue.getText().toString();
                myFirebase = new Firebase( "https://fir-app-bdbe3.firebaseio.com/Users" + DeviceID +"/"+ Keydate);

                // Block From
                myStringDataFrom = myEditFrom.getText().toString();
                myKeyValueDataFrom = "From";

                Firebase myNewChildFrom = myFirebase.child(myKeyValueDataFrom);
                myNewChildFrom.setValue(myStringDataFrom);

                // Block Until
                myStringDataUntil = myEditUntil.getText().toString();
                myKeyValueDataUntil = "Until";

                Firebase myNewChildUntil = myFirebase.child(myKeyValueDataUntil);
                myNewChildUntil.setValue(myStringDataUntil);

                // Block Farm
                myStringDataFarm = myEditFarm.getText().toString();
                myKeyValueDataFarm = "Farm";

                Firebase myNewChildFarm = myFirebase.child(myKeyValueDataFarm);
                myNewChildFarm.setValue(myStringDataFarm);

                Toast.makeText(addData.this, Keydate + " is updated with" + myKeyValueDataFrom + " and " + myKeyValueDataUntil + " and " +  myKeyValueDataFarm , Toast.LENGTH_SHORT).show();

            }
        });



    }
    private TextWatcher DateTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        String DateInput = myKeyValue.getText().toString().trim();

        ImageView iv=(ImageView) findViewById(R.id.imageView8);
            if(DateInput.isEmpty()) {

            }
            else {
                iv.setVisibility(iv.VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            String DateInput = myKeyValue.getText().toString().trim();
            ImageView iv=(ImageView) findViewById(R.id.imageView8);
            if(DateInput.isEmpty()) {
                iv.setVisibility(iv.INVISIBLE);
            }
        }
    };

    private TextWatcher DateTextWatcherFrom = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String DateInput = myEditFrom.getText().toString().trim();

            ImageView iv=(ImageView) findViewById(R.id.imageView9);
            if(DateInput.isEmpty()) {

            }
            else {
                iv.setVisibility(iv.VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            String DateInput = myEditFrom.getText().toString().trim();
            ImageView iv=(ImageView) findViewById(R.id.imageView9);
            if(DateInput.isEmpty()) {
                iv.setVisibility(iv.INVISIBLE);
            }
        }
    };

    private TextWatcher DateTextWatcherUntil = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String DateInput = myEditUntil.getText().toString().trim();

            ImageView iv=(ImageView) findViewById(R.id.imageView11);
            if(DateInput.isEmpty()) {

            }
            else {
                iv.setVisibility(iv.VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            String DateInput = myEditUntil.getText().toString().trim();
            ImageView iv=(ImageView) findViewById(R.id.imageView11);
            if(DateInput.isEmpty()) {
                iv.setVisibility(iv.INVISIBLE);
            }
        }
    };

    private TextWatcher DateTextWatcherFarm = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String DateInput = myEditFarm.getText().toString().trim();

            ImageView iv=(ImageView) findViewById(R.id.imageView10);
            if(DateInput.isEmpty()) {

            }
            else {
                iv.setVisibility(iv.VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            String DateInput = myEditFarm.getText().toString().trim();
            ImageView iv=(ImageView) findViewById(R.id.imageView10);
            if(DateInput.isEmpty()) {
                iv.setVisibility(iv.INVISIBLE);
            }
        }
    };
}
