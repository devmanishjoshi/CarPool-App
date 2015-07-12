package com.example.manishjoshi.carpool.login;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.manishjoshi.carpool.R;


public class LoginActivity extends ActionBarActivity {

    private LinearLayout layout_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//      find all the views in activity
        EditText email = (EditText)findViewById(R.id.et_email);
        EditText password = (EditText)findViewById(R.id.et_password);
        final CheckBox offerRide = (CheckBox)findViewById(R.id.check_offer_ride);
        final CheckBox findRide = (CheckBox)findViewById(R.id.check_find_ride);
        Button btn_login = (Button)findViewById(R.id.btn_login);
        layout_password = (LinearLayout)findViewById(R.id.layout_password);
//      hide action bar in Login and signup activity
        getSupportActionBar().hide();
//      set functionality on click selecting the check boxes
        findRide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                offerRide.setChecked(false);
                if(isChecked)
                findRide.setChecked(true);
                else
                findRide.setChecked(false);
                layout_password.setVisibility(View.GONE);
            }
        });
        offerRide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                findRide.setChecked(false);
                if(isChecked)
                    offerRide.setChecked(true);
                else
                    offerRide.setChecked(false);
                layout_password.setVisibility(View.VISIBLE);
            }
        });
        final String mEmail = email.getText().toString();
        final String mPassword = password.getText().toString();
//      send to home page on click of this button
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,mEmail,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
            }
        });


    }

}
