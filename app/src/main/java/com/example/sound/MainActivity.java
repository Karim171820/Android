package com.example.sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    AudioManager audioManeger;

    public void Play(View view){
        mp.start();
    }
    public void Pause(View view){
        mp.pause();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManeger=(AudioManager) getSystemService(AUDIO_SERVICE);
         int maxVolume= audioManeger.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        mp = MediaPlayer.create(this.getApplicationContext(), R.raw.alien);

        SeekBar VolumeControl =(SeekBar) findViewById(R.id.VolumeSeekBar);
        VolumeControl.setMax(maxVolume);
        VolumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.i("index", Integer.toString(i));
        audioManeger.setStreamVolume(AudioManager.STREAM_MUSIC,i, 0);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});
    }
}
