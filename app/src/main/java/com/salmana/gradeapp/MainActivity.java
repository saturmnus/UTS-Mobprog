package com.salmana.gradeapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputNim, inputName, inputPresensi, inputTugas, inputUTS, inputUAS;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNim = findViewById(R.id.input_nim);
        inputName = findViewById(R.id.input_name);
        inputPresensi = findViewById(R.id.input_presensi);
        inputTugas = findViewById(R.id.input_tugas);
        inputUTS = findViewById(R.id.input_uts);
        inputUAS = findViewById(R.id.input_uas);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(view -> calculateFinalScore());
    }

    private void calculateFinalScore() {
        if (TextUtils.isEmpty(inputNim.getText()) || TextUtils.isEmpty(inputName.getText()) ||
                TextUtils.isEmpty(inputPresensi.getText()) || TextUtils.isEmpty(inputTugas.getText()) ||
                TextUtils.isEmpty(inputUTS.getText()) || TextUtils.isEmpty(inputUAS.getText())) {

            Toast.makeText(this, "Seluruh data wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double presensi = Double.parseDouble(inputPresensi.getText().toString());
            double tugas = Double.parseDouble(inputTugas.getText().toString());
            double uts = Double.parseDouble(inputUTS.getText().toString());
            double uas = Double.parseDouble(inputUAS.getText().toString());

            if (presensi < 10 || presensi > 100 || tugas < 10 || tugas > 100 || uts < 10 || uts > 100 || uas < 10 || uas > 100) {

                Toast.makeText(this, "Nilai tidak boleh lebih kecil dari 10 dan tidak boleh lebih besar dari 100", Toast.LENGTH_SHORT).show();
                return;
            }

            double finalScore = (presensi * 0.1) + (tugas * 0.2) + (uts * 0.3) + (uas * 0.4);

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("NIM", inputNim.getText().toString());
            intent.putExtra("Name", inputName.getText().toString());
            intent.putExtra("FinalScore", finalScore);
            startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Nilai harus berupa angka", Toast.LENGTH_SHORT).show();
        }
    }
}