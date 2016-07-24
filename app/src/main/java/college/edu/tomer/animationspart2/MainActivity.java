package college.edu.tomer.animationspart2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView cardFace;
    ImageView cardBack;

    boolean isFace = false;
    private Animator outAnimator;
    private Animator inAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cardBack = (ImageView) findViewById(R.id.imageViewBack);
        cardFace = (ImageView) findViewById(R.id.imageViewFront);
        setupCardFlipAnimation();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateCardOut();
            }
        });
    }

    private void setupCardFlipAnimation() {
        cardFace.setCameraDistance(8000);
        cardBack.setCameraDistance(8000);
        outAnimator = AnimatorInflater.
                loadAnimator(this, R.animator.card_out);

        inAnimator = AnimatorInflater.
                loadAnimator(this, R.animator.card_in);
    }

    private void animateCardOut() {

        if (isFace) {
            outAnimator.setTarget(cardFace);
            inAnimator.setTarget(cardBack);
        } else {
            outAnimator.setTarget(cardBack);
            inAnimator.setTarget(cardFace);
        }
        outAnimator.start();
        inAnimator.start();


        isFace = !isFace;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
