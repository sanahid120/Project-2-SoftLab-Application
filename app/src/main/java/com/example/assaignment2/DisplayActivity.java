package com.example.assaignment2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvPreferences, tvEducation, tvCgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // Initialize UI components
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvPreferences = findViewById(R.id.tv_preferences);
        tvEducation = findViewById(R.id.education);
        tvCgpa = findViewById(R.id.tv_cgpa);

        // Get data from the Intent
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String preferences = getIntent().getStringExtra("preferences");
        String education = getIntent().getStringExtra("education");
        String cgpa = getIntent().getStringExtra("cgpa");

        // Set data in TextViews
        tvName.setText("Name: " + name);
        tvEmail.setText("Email/Phone: " + email);
        tvPreferences.setText("Preferences: " + preferences);
        tvEducation.setText("Education: " + education);
        tvCgpa.setText("CGPA: " + cgpa);
    }
}