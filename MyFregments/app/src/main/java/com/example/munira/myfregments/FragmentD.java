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

public class FragmentD extends Fragment implements View.OnClickListener {
    /*step 2 mapping*/
    private Button buttonFour;
    Context context;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view=inflater.inflate(R.layout.fragmentd_activity,container,false);
        buttonFour=view.findViewById(R.id.btnFD);
        buttonFour.setOnClickListener(this);
        context=getActivity().getBaseContext();
        return view;


    }



    //step 1 create it
    @Override
    public void onClick(View v) {
        if (buttonFour.getId()==view.getId())
        {
            Toast.makeText(context,"Button D clicked!!",Toast.LENGTH_SHORT).show();
        }

    }
}
