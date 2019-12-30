package www.vibhorgupta.in.blinkeffect;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Animation atg , btgOne , btgTwo;

    private TextView txt;
    private Button blinkBtn ,notificationBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);
        blinkBtn = (Button) findViewById(R.id.btn);
        notificationBox = (Button) findViewById(R.id.notificationBox);
        blinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageBlinkEffect();
            }
        });


        //Animation  loading

        atg = AnimationUtils.loadAnimation(this,R.anim.alphatogo);
        btgOne = AnimationUtils.loadAnimation(this,R.anim.alphatogo);
        btgTwo = AnimationUtils.loadAnimation(this,R.anim.alphatogo);

        notificationBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
    @SuppressLint("WrongConstant")
    private void manageBlinkEffect() {
        ObjectAnimator anim = ObjectAnimator.ofInt(txt, "backgroundColor", Color.WHITE, Color.RED,
                Color.WHITE);
        anim.setDuration(1500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }

}
