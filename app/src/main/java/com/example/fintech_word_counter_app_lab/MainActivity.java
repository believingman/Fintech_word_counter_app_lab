package com.example.fintech_word_counter_app_lab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner ddSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize spinner and options
        ddSelection = findViewById(R.id.ddSelection);
        ArrayList<String> selectionOptionsList = new ArrayList<>();
        selectionOptionsList.add("zodziai");
        selectionOptionsList.add("raides");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, selectionOptionsList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ddSelection.setAdapter(arrayAdapter);
    }

    public void btnCalculateOnClick(View view) {
        EditText edUserInput = findViewById(R.id.edUserInput);
        TextView tvOutput = findViewById(R.id.tvOutput);
        String userInputText = edUserInput.getText().toString();

        if (userInputText.isEmpty()) {
            Toast.makeText(this, "Iveskite teksta", Toast.LENGTH_SHORT).show();
            return;
        }

        String selection = ddSelection.getSelectedItem().toString();
        int result;

        if (selection.equalsIgnoreCase("zodziai")) {
            result = ElementsCalculator.getWordsCount(userInputText);
            tvOutput.setText("zodziai: " + result);
        } else {
            result = ElementsCalculator.getCharsCount(userInputText);
            tvOutput.setText("raides: " + result);
        }
    }
}
