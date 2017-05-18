package pl.lodz.p.smartgarden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AutoActivity extends AppCompatActivity {
    private Flower flower;
    private boolean isFullyWatered, isFullyLighted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        flower = getIntent().getParcelableExtra("myFlower");

        TextView flowerName = (TextView) findViewById(R.id.currentFlowerTextView);
        flowerName.setText(flower.getName());

        TextView lightStatus = (TextView) findViewById(R.id.lightMessageTextView);
        if (isFullyLighted == true) {
            lightStatus.setText(R.string.fullLight);
        }
        else {
            lightStatus.setText(R.string.lighting);
        }

        TextView waterStatus = (TextView) findViewById(R.id.waterMessageTextView);
        if (isFullyWatered == true) {
            waterStatus.setText(R.string.fullWater);
        }
        else {
            waterStatus.setText(R.string.watering);
        }


    }
}
