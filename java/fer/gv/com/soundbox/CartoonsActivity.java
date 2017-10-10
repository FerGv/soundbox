package fer.gv.com.soundbox;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CartoonsActivity extends AppCompatActivity implements View.OnClickListener {
    int[] btnIDs, soundIDs;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoons);

        initializeComponents();
    }

    private void initializeComponents() {
        btnIDs = new int[]{R.id.activity_cartoons_btnBart, R.id.activity_cartoons_btnFlintstones,
                R.id.activity_cartoons_btnHomero, R.id.activity_cartoons_btnKrilin};
        soundIDs = new int[]{R.raw.cartoon_bart, R.raw.cartoon_flintstones,
                R.raw.cartoon_homero, R.raw.cartoon_krilin};

        for (int i = 0; i < btnIDs.length; i++) {
            ImageButton btn = (ImageButton) findViewById(btnIDs[i]);
            btn.setOnClickListener(this);
        }

        ImageButton btnBack = (ImageButton) findViewById(R.id.activity_cartoons_btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.activity_cartoons_btnBack) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        } else {
            for (int i = 0; i < btnIDs.length; i++) {
                if (btnIDs[i] == v.getId()) {
                    if (mediaPlayer != null) mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(this, soundIDs[i]);
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                }
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
