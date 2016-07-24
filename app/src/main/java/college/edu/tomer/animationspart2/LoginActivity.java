package college.edu.tomer.animationspart2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout tilEmail;
    TextInputLayout tilPassword;
    ImageView bgSunny;
    ImageView cloud1, cloud2, cloud3, cloud4;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bgSunny = (ImageView) findViewById(R.id.bgSunny);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        cloud1 = (ImageView) findViewById(R.id.cloud1);
        cloud2 = (ImageView) findViewById(R.id.cloud2);
        cloud3 = (ImageView) findViewById(R.id.cloud3);
        cloud4 = (ImageView) findViewById(R.id.cloud4);

        // animate();

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animate(cloud1);
        animate(cloud2);
        animate(cloud3);
        animate(cloud4);
    }

    private void animate(View v) {
        Random rand = new Random();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                v, "X", 0 - v.getWidth(),
                bgSunny.getWidth() );
/*        animator.setPropertyName("translationX");
        animator.setFloatValues(0-cloud1.getWidth(),
                bgSunny.getWidth() + cloud1.getWidth() );*/

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setDuration(3 * (rand.nextInt(2000) + 1000));
        animator.setInterpolator(new LinearInterpolator());

        animator.setStartDelay(rand.nextInt(400));
        //animator.setTarget(cloud1);
        animator.start();


        Animator slide = AnimatorInflater.loadAnimator(this, R.animator.slide_in);
        slide.setTarget(tilEmail);
        slide.setStartDelay(400);
        slide.start();




    }
}
