package pl.lodz.p.smartgarden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ManualActivity extends AppCompatActivity {

    public boolean isFullyLighted, isFullyWatered;
    public Flower flower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        flower = getIntent().getParcelableExtra("myFlower");

        TextView flowerName = (TextView) findViewById(R.id.currentFlowerTextView);
        flowerName.setText(flower.getName());

        final ToggleButton lightButton = (ToggleButton) findViewById(R.id.lightButton);
        if (isFullyLighted == false) {
            lightButton.setChecked(false);
        }
        else {
            lightButton.setChecked(true);
        }
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFullyLighted == true) {
                    lightButton.setChecked(false);
                    isFullyLighted = false;
                }
                else {
                    lightButton.setChecked(true);
                    isFullyLighted = true;
                }
            }
        });

        final ToggleButton waterButton = (ToggleButton) findViewById(R.id.waterButton);
        if (isFullyWatered == false) {
            waterButton.setChecked(false);
        }
        else {
            waterButton.setChecked(true);
        }
        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFullyWatered == true) {
                    waterButton.setChecked(false);
                    isFullyWatered = false;
                }
                else {
                    waterButton.setChecked(true);
                    isFullyWatered = true;
                }

            }
        });




    }
}
