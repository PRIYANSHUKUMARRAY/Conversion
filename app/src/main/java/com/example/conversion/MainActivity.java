package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private RadioButton celsiusRadioButton;
    private RadioButton fahrenheitRadioButton;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.inputEditText);
        celsiusRadioButton = findViewById(R.id.celsiusRadioButton);
        fahrenheitRadioButton = findViewById(R.id.fahrenheitRadioButton);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    @SuppressLint("StringFormatInvalid")
    private void convertTemperature() {
        String input = inputEditText.getText().toString().trim();
        if (input.isEmpty()) {
            resultTextView.setText(getString(R.string.enter_valid_temperature));
            return;
        }

        double temperature = Double.parseDouble(input);

        if (celsiusRadioButton.isChecked()) {
            double convertedTemp1 = (temperature * 9 / 5) + 32;
            resultTextView.setText(String.valueOf(convertedTemp1)+"°F");
        } else if (fahrenheitRadioButton.isChecked()) {
            double convertedTemp2 = (temperature - 32) * 5 / 9;
            resultTextView.setText(String.valueOf(convertedTemp2)+"°C");
        }
    }
}