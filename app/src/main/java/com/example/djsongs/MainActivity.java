package com.example.djsongs;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnLongClickListener, View.OnClickListener {
    //***************step1*****************
MediaPlayer mediaPlayer1,mediaPlayer2,mediaPlayer3;
Random random;
SoundPool soundPool;
int blast=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        View view=new View(this);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        view.setOnTouchListener(this);
        setContentView(view);
        random=new Random();
        view.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(268),random.nextInt(268)));

        //****************step3
        soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        blast=soundPool.load(this,R.raw.saffron_games,1);

        //*************************step2***********************
      //  mediaPlayer1=MediaPlayer.create(this,R.raw.backgroundmusic);
        mediaPlayer2=MediaPlayer.create(this,R.raw.deva_shree_ganesha);
        mediaPlayer3=MediaPlayer.create(this,R.raw.x_gonna_give_it);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //        //*************************step3*************************

        if (blast!=0)
        {
            soundPool.play(blast,1,1,1,0,1);
        }
        view.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(268),random.nextInt(268)));

        return false;
    }

    @Override
    public boolean onLongClick(View view) {
        mediaPlayer2.start();
        return false;
    }

    @Override
    public void onClick(View view) {
        mediaPlayer3.start();

    }
}
