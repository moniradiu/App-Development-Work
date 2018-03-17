package com.example.munira.myfregments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Munira on 15-Mar-18.
 */

public class FragmentA extends Fragment implements View.OnClickListener {
    /*step 2 mapping*/
    private Button buttonOne;
    Context context;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view=inflater.inflate(R.layout.fragmenta_activity,container,false);
        buttonOne=view.findViewById(R.id.btnFA);
        buttonOne.setOnClickListener(this);
        context=getActivity().getBaseContext();
        return view;


    }



    //step 1 create it
    @Override
    public void onClick(View v) {
        if (buttonOne.getId()==view.getId())
        {
            Toast.makeText(context,"Button A clicked!!",Toast.LENGTH_SHORT).show();
        }

    }
}
