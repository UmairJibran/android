package com.example.assignment9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation bottomToTop,topToBottom;
    ImageView signatureImage;
    TextView cusitId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topToBottom = AnimationUtils.loadAnimation(this,R.anim.top_to_bottom);
        bottomToTop = AnimationUtils.loadAnimation(this,R.anim.bottom_to_top);

        signatureImage = findViewById(R.id.image);
        cusitId = findViewById(R.id.cusit_id);

        signatureImage.setAnimation(topToBottom);
        cusitId.setAnimation(bottomToTop);
    }
}