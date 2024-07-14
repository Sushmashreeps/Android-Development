package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnPause, btnPlay, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPause = findViewById(R.id.btnPause);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);

//        create an object for media player class
        MediaPlayer mp = new MediaPlayer();
        // set the typr of audio .setAudioStreamType (AudioManager. type_of_audio)
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        // path of the audio file, from directory and online
        String aPath = "android.resource://"+getPackageName()+"/raw/song2";

        String onlineAudioPath = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
//        allow internet premission in android manifest (<uses-permission android:name="android.permission.INTERNET"/>)

       Uri audioURI = Uri.parse(aPath);



        try{

            mp.setDataSource(this,audioURI);
            mp.prepare();

        }
        catch (Exception e){

        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();

            }
        });


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause(); // pause the audio
                mp.seekTo(0); // play the audio from starting

            }
        });


    }
}