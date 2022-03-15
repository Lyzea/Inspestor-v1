package com.thesis.inspestorapplication.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SplashScreen;

import com.thesis.inspestorapplication.R;
import com.thesis.inspestorapplication.Userhome.UserHome;

public class IntroScreen extends AppCompatActivity {
    //set splash screen time
    private static int SPLASH_TIMER = 5000;

    //intro variables
    ImageView logoImage;
    TextView createdBy, introSlogan;

    //animation
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //to remove Action BAr
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.intro_screen);

        //assigning variables
        logoImage=findViewById(R.id.logo_image);
        createdBy=findViewById(R.id.created_by);
        introSlogan=findViewById(R.id.intro_slogan);

        //animation code
        sideAnim= AnimationUtils.loadAnimation(this, R.anim.side_animation);
        bottomAnim= AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //set Anim elemnts
        logoImage.setAnimation(sideAnim);
        introSlogan.setAnimation(sideAnim);
        createdBy.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               //move to dashboard screen
                Intent intent=new Intent(getApplicationContext(),UserHome.class);
                startActivity(intent);
                finish(); //close application
            }
        },SPLASH_TIMER);

    }
}