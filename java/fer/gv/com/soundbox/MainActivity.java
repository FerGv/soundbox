package fer.gv.com.soundbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    int[] btnIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    private void initializeComponents() {
        btnIDs = new int[]{R.id.activity_main_btnFunny, R.id.activity_main_btnCartoons,
                            R.id.activity_main_btnAnimals, R.id.activity_main_btnAlerts};

        for (int i = 0; i < btnIDs.length; i++) {
            ImageButton btn = (ImageButton)findViewById(btnIDs[i]);
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.activity_main_btnAlerts:
                i = new Intent(this, AlertsActivity.class);
                break;
            case R.id.activity_main_btnAnimals:
                i = new Intent(this, AnimalsActivity.class);
                break;
            case R.id.activity_main_btnCartoons:
                i = new Intent(this, CartoonsActivity.class);
                break;
            case R.id.activity_main_btnFunny:
                i = new Intent(this, FunnyActivity.class);
                break;
        }
        startActivity(i);
    }
}
