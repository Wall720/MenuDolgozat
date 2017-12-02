package com.example.wall720.menudolgozat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button btn_SaveName;
    private EditText editText_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_SaveName = (Button)findViewById(R.id.btn_Save);
        editText_Name = (EditText)findViewById(R.id.ET_Name);

        btn_SaveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Mentés folyamat
                SharedPreferences sharedPreferences = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", editText_Name.getText().toString());
                editor.commit();

                //Vissza gomb
                Intent back_ToMenu = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(back_ToMenu);
                Toast.makeText(Main2Activity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


    }
}
