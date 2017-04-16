package com.an.example3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvN2, tvAcc2, tvBal2;
    Button btnN2,btnAcc2, btnBal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvN2 = (TextView)findViewById(R.id.tvN);
        tvAcc2 = (TextView)findViewById(R.id.tvAcc);
        tvBal2 = (TextView)findViewById(R.id.tvBal);
        btnN2 = (Button)findViewById(R.id.btnN);
        btnAcc2 = (Button)findViewById(R.id.btnAcc);
        btnBal2 = (Button)findViewById(R.id.btnBal);

        btnN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvN2.setText("Artan");
            }
        });
        btnAcc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvAcc2.setText("95482");
            }
        });
        btnBal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                View myView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_demo_alert,null);

                final EditText etU2 = (EditText) myView.findViewById(R.id.etU);
                final EditText etP2 = (EditText) myView.findViewById(R.id.etP);


                AlertDialog.Builder builderBal = new AlertDialog.Builder(MainActivity.this);
                        builderBal.setMessage("Login Here")
                                .setView(myView)
                                .setPositiveButton("Login", new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String etU3 = etU2.getText().toString();
                                        String etP3 = etP2.getText().toString();

                                        if (etU3.equals("Artan") && etP3.equals("0000")){

                                            tvBal2.setText("$5000");
                                    }else{
                                            Toast.makeText(getApplicationContext(),"Wrong username or Password!", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                })

                                .setNegativeButton("Cancel",null)
                                .setCancelable(false);  // it doesn't allow you to click outside the alert dialog

                        AlertDialog alertBal = builderBal.create();
                        alertBal.show();

            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builderBal = new AlertDialog.Builder(MainActivity.this);
        builderBal.setTitle("Really exit?")
                .setMessage("Are you sure?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })

                .setNegativeButton("Cancel",null)
                .setCancelable(false); // it doesn't allow you to click outside the alert dialog

        AlertDialog alertBal = builderBal.create();
        alertBal.show();

    }
}
