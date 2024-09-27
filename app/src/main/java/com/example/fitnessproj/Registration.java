package com.example.fitnessproj;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registration extends AppCompatActivity {

    EditText login, pass;
    RegistrtionDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        login = findViewById(R.id.regLogin);
        pass = findViewById(R.id.regPass);
        dataBase = new RegistrtionDataBase(this);

    }
    public void onClick (View v)
    {
        try {
         dataBase.newUser(new User(login.getText().toString(),
                 pass.getText().toString()));
         finish();
        } catch (Exception e)
        {
            Toast.makeText(this,
                    getResources().getString(R.string.exists),Toast.LENGTH_LONG).show();
            login.setText("");
            pass.setText("");
        }

    }
}