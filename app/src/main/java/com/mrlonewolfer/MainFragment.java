package com.mrlonewolfer;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.mrlonewolfer.example49.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    SeekBar seekBarRed,seekBarGreen,seekBarBlue;
    TextView txtColor;
    int redColor=0,greenColor=0,blueColor=0,finalColor=0;
    LinearLayout linearLayout;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        seekBarRed=view.findViewById(R.id.seekbarRed);
        seekBarGreen=view.findViewById(R.id.seekbarGreen);
        seekBarBlue=view.findViewById(R.id.seekbarBlue);
        linearLayout=view.findViewById(R.id.myfragmentScreen);


        txtColor=view.findViewById(R.id.txtColor);
  SeekBar.OnSeekBarChangeListener mySeekBarChangeListner=new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
          switch(seekBar.getId()){
              case R.id.seekbarRed:
                  redColor=progress;
                  txtColor.setText(redColor+"");
                  break;
              case R.id.seekbarGreen:
                  greenColor=progress;
                  txtColor.setText(greenColor+"");
                  break;
              case R.id.seekbarBlue:
                  blueColor=progress;
                  txtColor.setText(blueColor+"");
                  break;
          }
          setMyBackgroundColor();
      }

      private void setMyBackgroundColor() {
          finalColor= Color.rgb(redColor,greenColor,blueColor);
          linearLayout.setBackgroundColor(finalColor);


      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {


      }
  };

        seekBarRed.setOnSeekBarChangeListener(mySeekBarChangeListner);
        seekBarGreen.setOnSeekBarChangeListener(mySeekBarChangeListner);
        seekBarBlue.setOnSeekBarChangeListener(mySeekBarChangeListner);
        return view;
    }

}
