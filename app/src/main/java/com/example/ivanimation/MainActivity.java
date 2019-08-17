package com.example.ivanimation;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button btnPlay;
    Spinner animSelect;
    ImageView IvAnim;

    Animation fade_in,fade_out,zoom_in,
            zoom_out,move,rotate,slide,bounce,
            blink,rotate_zoom_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        animSelect = findViewById(R.id.animSelect);
        IvAnim = findViewById(R.id.IvAnim);

        String [] Anim = {"Infinite Zooming","Fade In","Fade Out","Zoom_In","Zoom_Out","Move",
                "Rotate","Slide","Bounce","Blink","Rotate,Zoom,& Move"};
        ArrayAdapter<String> listAnimAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,Anim);
        animSelect.setAdapter(listAnimAdapter);

        //Init Animasi
        fade_in = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_out);
        zoom_in = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_in);
        zoom_out = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_out);
        move = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);
        rotate = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
        slide = AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide);
        bounce = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
        blink = AnimationUtils.loadAnimation(MainActivity.this,R.anim.blink);
        rotate_zoom_move = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_zoom_move);

        PropertyValuesHolder scalex = PropertyValuesHolder.ofFloat(View.SCALE_X,1.1f);
        PropertyValuesHolder scaley = PropertyValuesHolder.ofFloat(View.SCALE_Y,1.1f);

        final ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(IvAnim,scalex,scaley);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (animSelect.getSelectedItemPosition() == 0){
                    animator.setRepeatCount(ValueAnimator.INFINITE);
                    animator.setRepeatMode(ValueAnimator.REVERSE);
                    animator.setDuration(800);
                    animator.start();
                }
                else if(animSelect.getSelectedItemPosition() == 1){
                    IvAnim.startAnimation(fade_in);
                    animator.cancel();
                }
                else if(animSelect.getSelectedItemPosition() == 2){
                    IvAnim.startAnimation(fade_out);
                    animator.cancel();
                }
                else if(animSelect.getSelectedItemPosition() == 3){
                    IvAnim.startAnimation(zoom_in);
                    animator.cancel();
                }
                else if(animSelect.getSelectedItemPosition() == 4){
                    IvAnim.startAnimation(zoom_out);
                    animator.cancel();
                }
                else if(animSelect.getSelectedItemPosition() == 5){
                    IvAnim.startAnimation(move);
                    animator.cancel();
                }
                else if(animSelect.getSelectedItemPosition() == 6){
                    IvAnim.startAnimation(rotate);
                    animator.cancel();
                }
                else if(animSelect.getSelectedItemPosition() == 7){
                    IvAnim.startAnimation(slide);
                    animator.cancel();
                }
                else if(animSelect.getSelectedItemPosition() == 8){
                    IvAnim.startAnimation(bounce);
                    animator.cancel();
                }
                else if(animSelect.getSelectedItemPosition() == 9){
                    IvAnim.startAnimation(blink);
                    animator.cancel();
                }
                else{
                    IvAnim.startAnimation(rotate_zoom_move);
                    animator.cancel();
                }
            }
        });
    }
}
