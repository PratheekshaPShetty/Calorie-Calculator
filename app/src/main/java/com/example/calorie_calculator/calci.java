package com.example.calorie_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class calci extends AppCompatActivity {
    //defining values
    EditText age;
    EditText height;
    EditText weight;
    Spinner act;
    private RadioGroup genderrg;
    private RadioButton rbmale;
    private RadioButton rbfemale;
    Button calculate;
    float A,bm,tdee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calci);
        act=findViewById(R.id.act);
        genderrg=findViewById(R.id.genderrg);
        age=(EditText) findViewById(R.id.age);
        height=(EditText)findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weight);
        calculate=(Button)findViewById(R.id.calculate);
        rbmale=(RadioButton)findViewById(R.id.m1);
        rbfemale=(RadioButton)findViewById(R.id.f1);


        //Spinner_act
            /*actarr.add("Sedentary");
            actarr.add("Lightly Active");
            actarr.add("Moderately Active");
            actarr.add("Very Active");
            actarr.add("Extremely Active");*/

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.activitylist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        act.setAdapter(adapter);
        act.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                /*String actdata=adapterView.getItemAtPosition(i).toString();
                 */

                System.out.println(adapterView.getItemAtPosition(i));
                System.out.println("Hey there");
                if (adapterView.getItemAtPosition(i).equals("Select Activity level"))
                {
                    //do nothing
                    System.out.println("No activity selected");
                }
                else
                {
                    //String item=adapterView.getItemAtPosition(i).toString();
                    // Toast.makeText(adapterView.getContext(),item,Toast.LENGTH_SHORT).show();
                    if(adapterView.getItemAtPosition(i).equals("Sedentary"))
                    {
                        //                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        //                        startActivity(intent);
                        A= (float) 1.2;
                        System.out.println("Sedentary");
                    }
                    else if(adapterView.getItemAtPosition(i).equals("Lightly Active"))
                    {
                        //                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        //                        startActivity(intent);
                        A= (float) 1.375;
                        System.out.println("Lightly Active");
                    }
                    else if(adapterView.getItemAtPosition(i).equals("Moderately Active"))
                    {
                        //                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        //                        startActivity(intent);
                        A= (float) 1.55;
                        System.out.println("Moderately Active");
                        System.out.println(A);
                    }
                    else if(adapterView.getItemAtPosition(i).equals("Very Active"))
                    {
                        //                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        //                        startActivity(intent);
                        A= (float) 1.7525;
                        System.out.println("Very Active");
                    }
                    else if(adapterView.getItemAtPosition(i).equals("Extremely Active"))
                    {
                        //
                        A= (float) 1.9;
                        System.out.println("Extremely Active");
                    }
                    else
                    {
                        //do nothing
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //gender
        System.out.println(A);

        //sending
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbmale.isChecked())
                {
                    bm= (float) (66+(13.7*Float.parseFloat(String.valueOf(weight.getText())))+(5*Float.parseFloat(String.valueOf(height.getText())))-(6.8*Float.parseFloat(String.valueOf(age.getText()))));
                    tdee=bm*A;
                    System.out.println("Male");
                }
                if(rbfemale.isChecked())
                {
                    bm=(float) (655+(9.6*Float.parseFloat(String.valueOf(weight.getText())))+(1.8*Float.parseFloat(String.valueOf(height.getText())))-(4.7*Double.parseDouble(String.valueOf(age.getText()))));
                    tdee=bm*A;
                    System.out.println("Female");
                }
                System.out.println(A);
                System.out.println(bm);
                System.out.println(tdee);
                Intent intent=new Intent(calci.this, MainActivity2.class);
                System.out.println("In");
                intent.putExtra("sbm",bm);
                System.out.println("Void");
                intent.putExtra("stdee",tdee);
                System.out.println("Far");
                startActivity(intent);

                System.out.println("Gone");

            }
        });

    }}
