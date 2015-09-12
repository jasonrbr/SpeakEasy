package com.mhacks.speakeasy;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;

import at.markushi.ui.CircleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AudioRecordFragment extends Fragment {


    boolean recording;
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
        recording = false;
        View v =  inflater.inflate(R.layout.fragment_audio_record, container, false);
        final Context context = v.getContext();
        final CircleButton button = (CircleButton)v.findViewById(R.id.record_button);
        final TextView topTV = (TextView)v.findViewById(R.id.record_question);
        final TextView btmTV = (TextView)v.findViewById(R.id.rec_desc);
        button.setImageDrawable(
                new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_microphone)
                        .color(Color.WHITE)
                        .sizeDp(24));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Pressed", Toast.LENGTH_SHORT).show();
                if (!recording) {
                    button.setColor(getResources().getColor(R.color.cb_color_red));
                    button.setImageDrawable(
                            new IconicsDrawable(context)
                                    .icon(FontAwesome.Icon.faw_microphone_slash)
                                    .color(Color.WHITE)
                                    .sizeDp(24));
                    topTV.setText(R.string.record_listening);
                    btmTV.setText(R.string.record_listen_desc);
                    recording = true;
                } else {
                    button.setColor(getResources().getColor(R.color.cb_color_green));
                    button.setImageDrawable(
                            new IconicsDrawable(context)
                                    .icon(FontAwesome.Icon.faw_microphone)
                                    .color(Color.WHITE)
                                    .sizeDp(24));
                    topTV.setText(R.string.record_question);
                    btmTV.setText(R.string.record_description);
                    recording = false;
                }
            }
        });
        return v;
    }


}
