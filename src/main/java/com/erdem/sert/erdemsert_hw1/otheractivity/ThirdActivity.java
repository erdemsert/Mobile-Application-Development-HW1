package com.erdem.sert.erdemsert_hw1.otheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.erdem.sert.erdemsert_hw1.R;

public class ThirdActivity extends AppCompatActivity {
     Spinner spSport;
     ImageView imgSport;
     SeekBar skBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        spSport=findViewById(R.id.spSport);
        imgSport=findViewById(R.id.imgSport);
        skBar=findViewById(R.id.skBar);



        spSport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    imgSport.setImageResource(R.drawable.never);
                }
                else if (i == 1) {
                    imgSport.setImageResource(R.drawable.sometimes);
                }
                else if(i==2){
                    imgSport.setImageResource(R.drawable.often);
                }
                else{
                    imgSport.setImageResource(R.drawable.always);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        skBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //called when progress level (thumb position) has been changed.

                Toast.makeText(ThirdActivity.this, "The given point to the application is "+skBar.getProgress(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public void onClick(View view){
        finish();
    }
    public void result(View view){
        int age=getIntent().getIntExtra("keyage",0);
        double weight=getIntent().getDoubleExtra("keyweight",0.0);
        double height=getIntent().getDoubleExtra("keyheight",0.0);
        String gender=getIntent().getStringExtra("keygender");

        if(gender=="Male"){
            //  The formule for Female is that
            //  66 + [ 13,7 x kilo (kg) ] + [ 5 x boy (cm)] – [ 6,8 x yaş (yıl)]
            double res= 66+(13.7*weight)+(5*height)-(6.8*age);
            makeAndShowDialog("The result is: "+res);
        }
        else{

            // The formule for Female is that
            // 655 + [ 9,6 x kilo (kg) ] + [ 1,8 x boy (cm)] – [ 4,7 x yaş (yıl) ]
            double res=655+(9.6*weight)+(1.8*height)-(4.7*age);
            makeAndShowDialog("The result is: "+res);
        }


    }
    private void makeAndShowDialog(String message) {
        AlertDialog.Builder box = new AlertDialog.Builder(this);
        box.setTitle("Daily Calorie Calculation");
        box.setMessage(message);

        box.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        box.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        box.create();
        box.show();
    }
}