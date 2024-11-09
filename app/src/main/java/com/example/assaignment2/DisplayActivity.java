package com.example.assaignment2;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvPreferences, tvEducation, tvCgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        showRatingDialog();

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
    private void showRatingDialog() {
        // Create a Dialog
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.rating_bar);

        RatingBar ratingBar = dialog.findViewById(R.id.rt_rating_bar);
        Button btnSubmitRating = dialog.findViewById(R.id.btn_submit_rating);

        btnSubmitRating.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            Toast.makeText(this, "You rated: " + rating + " stars", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }
}