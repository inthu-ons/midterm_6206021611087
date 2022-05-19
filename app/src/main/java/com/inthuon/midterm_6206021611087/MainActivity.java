package com.inthuon.midterm_6206021611087;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Toast;
import android.view.ViewGroup;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAppGpa , btnAppTax, btnAppShow ,btnAbout, btnQuit;
    private int id;
    LayoutInflater layoutInflater;
    View toastLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAppGpa = (Button) findViewById(R.id.btnAppGpa);
        btnAppTax = (Button) findViewById(R.id.btnAppTax);
        btnAppShow = (Button) findViewById(R.id.btnAppShow);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnQuit = (Button) findViewById(R.id.btnQuit);

        btnAppGpa.setOnClickListener(this);
        btnAppTax.setOnClickListener(this);
        btnAppShow.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnQuit.setOnClickListener(this);

        layoutInflater = getLayoutInflater();
        toastLayout = layoutInflater.inflate(R.layout.activity_about, (ViewGroup) findViewById(R.id.myAbout));
    }

    @Override
    public void onClick(View v){
        int id = v.getId();

        if(id == R.id.btnAppGpa){
            Intent gpaIntent = new Intent(this, GpaActivity.class);
            startActivity(gpaIntent);
        }
        else if (id == R.id.btnAppTax){
            Intent taxIntent = new Intent(this, TaxActivity.class);
            startActivity(taxIntent);
        }
        else if (id == R.id.btnAppShow){
            Intent showIntent = new Intent(this, ShowActivity.class);
            startActivity(showIntent);
        }
        else if (id == R.id.btnAbout){
            Toast toastCustom;
            toastCustom = Toast.makeText(this, "Custom", Toast.LENGTH_LONG);
            toastCustom.setGravity(Gravity.CENTER, 0, 0);
            toastCustom.setView( toastLayout );
            toastCustom.show();

            //finish();
        }
        else if (id == R.id.btnQuit){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("Exit");
            builder.setMessage("Are you sure you want to leave ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
            showAlertDialog();
        }

    }

    public void showAlertDialog() {
    }
}