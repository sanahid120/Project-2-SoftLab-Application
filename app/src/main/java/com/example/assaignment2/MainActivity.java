package com.example.assaignment2;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch darkMode;
    private TextView cgpa;
    private EditText Name, Email;
    private RatingBar ratingBar;
    private SeekBar cgpaBar;
    private CheckBox SE, AD,WD;
    private RadioGroup radioGroupDegree;
    private RadioButton radioButton;
    private Button btnSubmit;
    private String name,email,Preferences="", Cg, Education;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUIcomponents();

        darkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                Toast.makeText(this, "Dark Mode is still on Progress. Please wait until the developer learns how to do it!", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Thank you!", Toast.LENGTH_SHORT).show();
            }
        });

        cgpaBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            double CGPA_value=(progress/25.0);
            cgpa.setText("CGPA: "+CGPA_value);
            Cg=String.valueOf(CGPA_value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnSubmit.setOnClickListener(v -> {
            if (validateInput()) {

                collectPreferences();
                collectEducation();


                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("preferences", Preferences);
                intent.putExtra("education", Education);
                intent.putExtra("cgpa",Cg);
                startActivity(intent);


            }
        });

    }

    private void collectEducation() {
       /* radioGroupDegree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
                Education = radioButton.getText().toString();
            }
        });*/

        int selectedId = radioGroupDegree.getCheckedRadioButtonId();

            if (selectedId != -1) {

                radioButton = findViewById(selectedId);
                Education = radioButton.getText().toString();
            }
    }

    private void collectPreferences() {
        if (SE.isChecked()) {
            Preferences += "Software Engineer, ";
        }
        if (AD.isChecked()) {
            Preferences += "App Developer, ";
        }
        if (WD.isChecked()) {
            Preferences += "Web Developer, ";
        }
        if (!Preferences.isEmpty()) {
            Preferences = Preferences.substring(0, Preferences.length() - 2);
        }
    }

    private boolean validateInput() {
        boolean isValid = true;

        name = Name.getText().toString().trim();
        email = Email.getText().toString().trim();
       /* Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

        if (name.isEmpty()) {
            Name.setError("Name is required!");
           // Name.setHintTextColor(Color.RED); // Make hint text red
            isValid = false;
        }
        if (email.isEmpty()) {

            Email.setError("E-mail/Phone is required!");
          //  Email.setHintTextColor(Color.RED); // Make hint text red
            Email.setHint(Color.RED);
            isValid = false;
        }
        if (!SE.isChecked() && !AD.isChecked() && !WD.isChecked()) {
            Toast.makeText(this, "Check Preferences!", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        if (radioGroupDegree.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select your education level first", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        return isValid;
    }

    private void initializeUIcomponents() {
        Name = findViewById(R.id.et_name);
        Email = findViewById(R.id.et_email);
        darkMode = findViewById(R.id.switch_theme);
        //ratingBar = findViewById(R.id.rating_bar);
        cgpaBar = findViewById(R.id.seek_bar_cgpa);
        SE = findViewById(R.id.SE);
        AD = findViewById(R.id.AD);
        WD = findViewById(R.id.WD);
        radioGroupDegree = findViewById(R.id.radio_group_degree);
        cgpa=findViewById(R.id.tv_cgpa);
        btnSubmit = findViewById(R.id.btn_submit);
    }


}