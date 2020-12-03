package com.joe.gene4droid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static int SPLASH_SCREEN=5000;
    Animation topani,botani;
    ImageView image;
    TextView logo,sologon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        topani= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botani= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image=findViewById(R.id.imageView);
        logo=findViewById(R.id.textView);


        image.setAnimation(topani);
        logo.setAnimation(botani);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(image, "logoimg");
                pairs[1] = new Pair<View, String>(logo, "logotxt");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Main2Activity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        },SPLASH_SCREEN);
    }

}
