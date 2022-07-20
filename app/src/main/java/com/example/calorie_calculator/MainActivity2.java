package com.example.calorie_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calorie_calculator.R;
import com.example.calorie_calculator.MainActivity3;

public class MainActivity2 extends AppCompatActivity {
    float rbm,rtdee;
    double ab;
    EditText ed1;
    EditText ed2;
    EditText ed3;
    private Button move;

    TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*t=(TextView) findViewById(R.id.he);
        System.out.println(t);
        t.setBackgroundColor(Color.BLACK);
        t.setTextColor(Color.WHITE);*/


        System.out.println("Ho");
        setContentView(R.layout.activity_main2);
        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        ed3=(EditText)findViewById(R.id.ed3);
        Bundle extras=getIntent().getExtras();
        rbm=extras.getFloat("sbm");
        System.out.println(rbm);
        rtdee=extras.getFloat("stdee");
        System.out.println(rtdee);
        ed1.setText(String.valueOf(rbm));
        ed2.setText(String.valueOf(rtdee));
        ab=rtdee-(rtdee*0.25);
        ed3.setText(String.valueOf(ab));
        System.out.println(rbm+" is the value"+rtdee);

        //move to next page
        move=findViewById(R.id.Move);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ringgg");
                Intent intent1=new Intent(MainActivity2.this, MainActivity3.class);
                System.out.println("ringg1");
                startActivity(intent1);
                System.out.println("ring 2");
            }
        });


    }
}