package com.example.munira.myfregments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //step 1: mapping activity main page.
    private Button btnA,btnB,btnC,btnD;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*step:2 custing with button activity main xml button*/
        btnA=(Button) findViewById(R.id.buttonA);
        btnB=(Button)findViewById(R.id.buttonB);
        btnC=(Button)findViewById(R.id.buttonC);
        btnD=(Button)findViewById(R.id.buttonD);

        fragmentManager=getFragmentManager();
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(btnA.getId()==view.getId())
        {
            FragmentA fragmentA= new FragmentA();
            fragmentManager.beginTransaction().replace(R.id.mylayout,fragmentA).commit();
        }
        if(btnB.getId()==view.getId())
        {
            FragmentB fragmentB=new FragmentB();
            fragmentManager.beginTransaction().replace(R.id.mylayout,fragmentB).commit();
        }

        if(btnC.getId()==view.getId())
        {
            FragmentC fragmentC= new FragmentC();
            fragmentManager.beginTransaction().replace(R.id.mylayout,fragmentC).commit();
        }



        if(btnD.getId()==view.getId())
        {
            FragmentD fragmentD= new FragmentD();
            fragmentManager.beginTransaction().replace(R.id.mylayout,fragmentD).commit();
        }

    }
}
