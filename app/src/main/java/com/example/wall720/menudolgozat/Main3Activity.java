package com.example.wall720.menudolgozat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    private Button btn_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        btn_Back = (Button)findViewById(R.id.btn_GoBack);

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent gonNxt = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(gonNxt);
                finish();
            }
        });


    }
}

