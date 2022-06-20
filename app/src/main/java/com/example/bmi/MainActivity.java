package com.example.bmi;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText heightET , weightET;
    RadioGroup genderRG;
    Button b1;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightET = findViewById(R.id.height_et);
        weightET = findViewById(R.id.weight_et);
        b1 = findViewById(R.id.b1);
        genderRG = findViewById(R.id.gender_rg);

 genderRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
     @Override
     public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
         if (checkedID == R.id.boy_rb) {
             gender = "boy";
         } else {
             gender = "girl";
         }
         ;

         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String heightVal = heightET.getText().toString().trim();
                 String weightVal = weightET.getText().toString().trim();
                 float height = Float.parseFloat(heightVal);
                 float weight = Float.parseFloat(weightVal);
                 float bmi = calBMI(height, weight);
                 Toast.makeText(MainActivity.this,String.valueOf(bmi)+" "+gender,Toast.LENGTH_LONG).show();
             }
         });

     }



     public float calBMI(float h, float w) {
         float bmi = 0;
         float h_m = h / 100;
         bmi = w / (h_m * h_m);

         return bmi;

     }


     });
    }
}
