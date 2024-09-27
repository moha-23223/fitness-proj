package com.example.fitnessproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView regText;
    EditText log,pass;
    RegistrtionDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       dataBase= new RegistrtionDataBase(this);
       regText = findViewById(R.id.textView3);
       log = findViewById(R.id.login);
       pass = findViewById(R.id.pass);
       regText.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, Registration.class);
               startActivity(intent);
           }
       });
    }
    public void onLoginClick(View v)
    {
        if (dataBase.getUser(log.getText().toString(),
                pass.getText().toString())!=null)
        {
            Intent intent = new Intent(MainActivity.this, MainWindow.class);
            startActivity(intent);
        } else
        {
            Toast.makeText(this,
                    getResources().getString(R.string.invalid),Toast.LENGTH_LONG).show();
        }
    }

}