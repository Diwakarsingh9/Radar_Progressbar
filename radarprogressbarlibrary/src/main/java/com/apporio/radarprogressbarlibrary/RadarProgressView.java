package com.apporio.radarprogressbarlibrary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by apporio6 on 20-12-2016.
 */
public class RadarProgressView extends LinearLayout {

    LinearLayout  llforpb;
    ImageView pbimage,imagehide,imagehide2,imagehide3;
    public RadarProgressView(Context context) {
        super(context);
        initialize(context);
    }

    public RadarProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        Log.d(TAG, "onCreateView: ");
//        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//
//        View view = inflater.inflate(R.layout.mdtp_date_picker_dialog, null);
//
//
//        return view;
//    }

    private void initialize(Context context){
        LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.radarprogressview, this);
        pbimage = (ImageView)v.findViewById(R.id.pbimage);
        imagehide = (ImageView)v.findViewById(R.id.imgh);
        imagehide2 = (ImageView)v.findViewById(R.id.imh2);
        imagehide3 = (ImageView)v.findViewById(R.id.imgh3);
        llforpb = (LinearLayout)v.findViewById(R.id.llforprogress);


        pbimage.startAnimation(
                AnimationUtils.loadAnimation(context, R.anim.anima));


        fadeIn();
        fadeIn2();
        fadeIn3();



    }


    private void fadeIn() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide, "alpha", 0f, 1f);
        objectAnimator.setDuration(500L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeOut();
            }
        });
        objectAnimator.start();
    }

    private void fadeOut() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide, "alpha", 1f, 0f);
        objectAnimator.setDuration(500L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeIn();
            }
        });
        objectAnimator.start();
    }

    private void fadeIn2() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide2, "alpha", 0f, 1f);
        objectAnimator.setDuration(1000L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fadeOut2();
                    }
                }, 2000);
            }
        });
        objectAnimator.start();
    }

    private void fadeOut2() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide2, "alpha", 1f, 0f);
        objectAnimator.setDuration(500L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeIn2();
            }
        });
        objectAnimator.start();
    }
    private void fadeIn3() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide3, "alpha", 0f, 1f);
        objectAnimator.setDuration(500L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeOut3();
            }
        });
        objectAnimator.start();
    }

    private void fadeOut3() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide3, "alpha", 1f, 0f);
        objectAnimator.setDuration(1000L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fadeIn3();

                    }
                }, 2000);
            }
        });

        objectAnimator.start();
    }

}
