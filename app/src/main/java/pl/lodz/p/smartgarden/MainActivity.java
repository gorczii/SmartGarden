package pl.lodz.p.smartgarden;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    private String flowerSpinnerValue, modeSpinnerValue;
    private Flower flower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner flowerSpinner = (Spinner) findViewById(R.id.flowerSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.flowers_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flowerSpinner.setAdapter(adapter);
        flowerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (flowerSpinner.getSelectedItem().equals("Basil")) {
                    flower = new Basil();
                }

                if(flowerSpinner.getSelectedItem().equals("Mint")) {
                    flower = new Mint();
                    System.out.println("jusia");
                }
                if (flowerSpinner.getSelectedItem().equals("Thyme")) {
                    flower = new Thyme();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner modeSpinner = (Spinner) findViewById(R.id.modeSpinner);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this,
                R.array.mode_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modeSpinner.setAdapter(adapterTwo);

        final Button okButton = (Button) findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (modeSpinner.getSelectedItem().equals("Manual")) {

                    goToManualActivity();
               }
               else {
                   goToAutoActivity();
               }
            }
        });
    }

    private void goToManualActivity() {
        Intent intent = new Intent(this, ManualActivity.class);
        intent.putExtra("myFlower", flower);
        startActivity(intent);
    }

    private void goToAutoActivity() {
        Intent intent = new Intent(this, AutoActivity.class);
        intent.putExtra("myFlower", flower);
        startActivity(intent);
    }
}
