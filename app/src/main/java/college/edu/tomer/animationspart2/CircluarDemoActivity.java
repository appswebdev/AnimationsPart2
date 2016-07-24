package college.edu.tomer.animationspart2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

public class CircluarDemoActivity extends AppCompatActivity {

    ImageView ivReveal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circluar_demo);

        ivReveal = (ImageView) findViewById(R.id.ivReveal);
    }

    public void animateReveal(View view) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {
            return;
        }
        hideImage();
    }

    private void hideImage() {
        int cx = 0;
        int cy = 0;
        float startRadius = Math.max(ivReveal.getHeight(), ivReveal.getWidth());
        float endRadius = 0;


        Animator reveal  = ViewAnimationUtils.createCircularReveal(ivReveal, cx, cy, startRadius, endRadius);
        reveal.start();

        reveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ivReveal.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void revealImage() {
        int cx = 0;
        int cy = 0;
        float startRadius = 0;
        float endRadius = Math.max(ivReveal.getHeight(), ivReveal.getWidth());


        Animator reveal  = ViewAnimationUtils.createCircularReveal(ivReveal, cx, cy, startRadius, endRadius);
        ivReveal.setVisibility(View.VISIBLE);
        reveal.start();
    }
}
