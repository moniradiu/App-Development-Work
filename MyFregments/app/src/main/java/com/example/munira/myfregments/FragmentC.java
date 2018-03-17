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

public class FragmentC extends Fragment implements View.OnClickListener {
    /*step 2 mapping*/
    private Button buttonThree;
    Context context;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view=inflater.inflate(R.layout.fragmentc_activity,container,false);
        buttonThree=view.findViewById(R.id.btnFC);
        buttonThree.setOnClickListener(this);
        context=getActivity().getBaseContext();
        return view;


    }



    //step 1 create it
    @Override
    public void onClick(View v) {
        if (buttonThree.getId()==view.getId())
        {
            Toast.makeText(context,"Button C clicked!!",Toast.LENGTH_SHORT).show();
        }

    }
}
