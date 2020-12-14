package com.erdem.sert.erdemsert_hw1.mainandsecondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.erdem.sert.erdemsert_hw1.R;

public class SecondActivity extends AppCompatActivity {
    TextView tvInputNameSurname,tvInputAge,tvInputWeight,tvInputHeight,tvInputGender;
    ImageView imgPicture,imgFood;
    RadioGroup rdGroup;
    RadioButton rbHamburger,rbPizza,rbChicken,radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second);

        tvInputNameSurname=findViewById(R.id.tvInputNameSurname);
        tvInputAge=findViewById(R.id.tvInputAge);
        tvInputWeight=findViewById(R.id.tvInputWeight);
        tvInputHeight=findViewById(R.id.tvInputHeight);
        tvInputGender=findViewById(R.id.tvInputGender);

        imgPicture=findViewById(R.id.imgPicture);
        imgFood=findViewById(R.id.imgFood);

        rdGroup=findViewById(R.id.rdGroup);

        rbHamburger=findViewById(R.id.rbHamburger);
        rbPizza=findViewById(R.id.rbPizza);
        rbChicken=findViewById(R.id.rbChicken);

        imgPicture.setImageResource(R.drawable.profile);

        String name=getIntent().getStringExtra("keyname");
        String surname=getIntent().getStringExtra("keysurname");
        int age=getIntent().getIntExtra("keyage",0);
        double weight=getIntent().getDoubleExtra("keyweight",0.0);
        double height=getIntent().getDoubleExtra("keyheight",0.0);
        String gender=getIntent().getStringExtra("keygender");

        tvInputNameSurname.setText("Name: "+name+" "+surname);


        tvInputAge.setText("Age :"+age);
        tvInputHeight.setText("Height: "+height);
        tvInputWeight.setText("Weight: "+weight);
        tvInputGender.setText("Gender: "+gender);


        int selectedradioButtonId = rdGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedradioButtonId);
    }

    public void radioClick(View view) {
        int selectedradioButtonId = rdGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedradioButtonId);

        if(radioButton == rbHamburger) // if(selectedradioButtonId == R.id.rdbtnFirst)
            imgFood.setImageResource(R.drawable.hamburger);
        else if(radioButton == rbChicken)
            imgFood.setImageResource(R.drawable.chicken);
        else
            imgFood.setImageResource(R.drawable.pizza);
    }
    public void onClick(View view){
        finish();
    }
}