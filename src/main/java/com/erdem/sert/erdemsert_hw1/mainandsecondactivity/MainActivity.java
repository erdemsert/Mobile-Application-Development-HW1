package com.erdem.sert.erdemsert_hw1.mainandsecondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.erdem.sert.erdemsert_hw1.R;
import com.erdem.sert.erdemsert_hw1.otheractivity.ThirdActivity;

public class MainActivity extends AppCompatActivity {
       EditText etName,etSurname,etAge,etHeight,etWeight;
       RadioGroup rgGender;
       RadioButton rbGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etSurname=findViewById(R.id.etSurname);
        etAge=findViewById(R.id.etAge);
        etHeight=findViewById(R.id.etHeight);
        etWeight=findViewById(R.id.etWeight);

        rgGender=findViewById(R.id.rdGroup);

        Button Display=(Button)findViewById(R.id.Display);
        Button Calculate=(Button)findViewById(R.id.Calculate);
          Display.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  openSecondActivity();
              }
          });

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openThirdActivity();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        int radiobuttonId=rgGender.getCheckedRadioButtonId();
        rbGender=findViewById(radiobuttonId);

        Toast.makeText(this, "The gender is "+rbGender.getText().toString(), Toast.LENGTH_SHORT).show();

    }
    public void openSecondActivity(){
        String name=etName.getText().toString();
        String surname=etSurname.getText().toString();
        int age=Integer.parseInt(etAge.getText().toString());
        double height=Double.parseDouble(etHeight.getText().toString());
        double weight=Double.parseDouble(etWeight.getText().toString());
        String gender=rbGender.getText().toString();

        Intent intent=new Intent(this, SecondActivity.class);
        intent.putExtra("keyname",name);
        intent.putExtra("keysurname",surname);
        intent.putExtra("keyage",age);
        intent.putExtra("keyheight",height);
        intent.putExtra("keyweight",weight);
        intent.putExtra("keygender",gender);

        startActivity(intent);

    }
    public void openThirdActivity(){
        int age=Integer.parseInt(etAge.getText().toString());
        double height=Double.parseDouble(etHeight.getText().toString());
        double weight=Double.parseDouble(etWeight.getText().toString());
        String gender=rbGender.getText().toString();
        Intent intent=new Intent(this, ThirdActivity.class);

        intent.putExtra("keyage",age);
        intent.putExtra("keyheight",height);
        intent.putExtra("keyweight",weight);
        intent.putExtra("keygender",gender);

        startActivity(intent);
    }

}