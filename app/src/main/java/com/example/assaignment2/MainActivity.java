package com.example.assaignment2;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
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
    TextView cgpa;
    private EditText Name, Email;
    private RatingBar ratingBar;
    private SeekBar cgpaBar;
    private CheckBox SE, AD,WD;
    private RadioGroup radioGroupDegree;
    private Button btnSubmit;
    private String name,email,Preferences=" ", Cg, Education;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUIcomponents();

        darkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                Toast.makeText(this, "Dark Mode is on Progress. Please wait until the developer learns how to do it!", Toast.LENGTH_LONG).show();
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
        cgpa=findViewById(R.id.tv_cgpa);
        btnSubmit = findViewById(R.id.btn_submit);
    }

}

