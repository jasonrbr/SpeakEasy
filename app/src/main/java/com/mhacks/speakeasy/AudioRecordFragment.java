package com.mhacks.speakeasy;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import at.markushi.ui.CircleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AudioRecordFragment extends Fragment {


    public AudioRecordFragment() {
        // Required empty public constructor
    }

    public static AudioRecordFragment newInstance(String title){
        AudioRecordFragment f = new AudioRecordFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return (f);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        CircleButton button;
        View v =  inflater.inflate(R.layout.fragment_audio_record, container, false);
        final Context context = v.getContext();
        button = (CircleButton)v.findViewById(R.id.record_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Pressed", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }


}
