package com.example.wall720.menudolgozat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_jumpToSave, btn_jumpToExit, btn_getInformation, btn_JumpToAnother;
    private AlertDialog.Builder WantToQuit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onClickLiseteners();

        //Itt nem kell meghivnod, mert már az Onclick-be meghivtad és igy automatikusan nem indul el.


        //Quit();


    }

    public void init() {
        btn_JumpToAnother = (Button) findViewById(R.id.btn_GoNext);
        btn_jumpToExit = (Button) findViewById(R.id.btn_ToExit);
        btn_jumpToSave = (Button) findViewById(R.id.btn_ToSave);
        btn_getInformation = (Button) findViewById(R.id.btn_ToInformation);
    }

    public void onClickLiseteners(){



        btn_JumpToAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goNext = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(goNext);
                finish();
            }
        });

        btn_jumpToSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goSave = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(goSave);
                finish();
            }
        });

        btn_getInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("Mydata: ", Context.MODE_PRIVATE);
                String informacio = sharedPreferences.getString("Name", "");
                Toast.makeText(MainActivity.this, "Sharedpreferences Adat: " + informacio, Toast.LENGTH_SHORT).show();
            }
        });

        btn_jumpToExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quit();
            }
        });
    }

    public void Quit() {
        this.WantToQuit = new AlertDialog.Builder(MainActivity.this);
        this.WantToQuit.setMessage("Biztos kiszeretne lépni?");

        this.WantToQuit.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        this.WantToQuit.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        this.WantToQuit.setCancelable(false);
        this.WantToQuit.create();
        this.WantToQuit.show();
    }


}
