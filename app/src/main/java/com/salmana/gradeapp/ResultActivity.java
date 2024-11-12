package com.salmana.gradeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textNIM = findViewById(R.id.txt_nim);
        TextView textName = findViewById(R.id.txt_name);
        TextView textMatkul = findViewById(R.id.txt_matkul);
        TextView textSemester = findViewById(R.id.txt_semester);
        TextView textNilaiAkhir = findViewById(R.id.txt_nilaiAkhir);
        TextView textGrade = findViewById(R.id.txt_grade);
        Button buttonBack = findViewById(R.id.button);

        Intent intent = getIntent();
        String nim = intent.getStringExtra("NIM");
        String name = intent.getStringExtra("Name");
        String matkul = intent.getStringExtra("Matkul");
        String semester = intent.getStringExtra("Semester");
        double nilaiAkhir = intent.getDoubleExtra("NilaiAkhir", 0);

        String grade;
        if (nilaiAkhir >= 85) {
            grade = "A";
        } else if (nilaiAkhir >= 70) {
            grade = "B";
        } else if (nilaiAkhir >= 50) {
            grade = "C";
        } else if (nilaiAkhir < 50) {
            grade = "D";
        } else {
            grade = "E";
        }

        textNIM.setText("NIM: " + nim);
        textName.setText("Nama: " + name);
        textMatkul.setText("Matkul: " + matkul);
        textSemester.setText("Semester: " + semester);
        textNilaiAkhir.setText("Nilai Akhir: " + nilaiAkhir);
        textGrade.setText("Grade: " + grade);

        buttonBack.setOnClickListener(view -> {
            Intent backIntent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(backIntent);
            finish();
        });
    }
}