package com.luisf.learning.appmyannotations;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.luisf.learning.appmyannotations.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PreferenceSettingData preferenceSettingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceSettingData = new PreferenceSettingData(getApplicationContext());
        EditText noteApplication = findViewById(R.id.editTextTextMultiLine);
        noteApplication.setText(preferenceSettingData.readDataPreference());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText noteApplication = findViewById(R.id.editTextTextMultiLine);
                String sTextToSave = noteApplication.getText().toString();

                if (sTextToSave.trim().isEmpty()) {
                    Snackbar.make(v, "Por favor, preencha a anotação!", Snackbar.LENGTH_LONG).show();
                }
                else {
                    preferenceSettingData.saveDataPreference(sTextToSave);
                    Snackbar.make(v, "Suas anotações foram salvas com sucesso", Snackbar.LENGTH_LONG).setAction("Ok", null).show();
                }
            }
        });
    }
}