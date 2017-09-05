package com.dempseywood.loadcounter;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dempseywood.loadcounter.dao.EquipmentStatusDao;

public class MainActivity extends AppCompatActivity {
    private EquipmentStatusDao equipmentStatusDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB.init(getApplicationContext());
        equipmentStatusDao = DB.getInstance().equipmentStatusDao();


        TextView countText = (TextView)findViewById(R.id.textView);
        countText.setText(Data.getCount()+"");


        Button loadButton = (Button )findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button loadButton = (Button )findViewById(R.id.loadButton);
                Button loadMaterialButton = (Button )findViewById(R.id.loadMaterialButton);
                loadMaterialButton.setVisibility(View.GONE);
                loadButton.setVisibility(View.GONE);
                Button unLoadButton = (Button )findViewById(R.id.unloadButton);
                Button unloadMaterialButton = (Button )findViewById(R.id.unloadMaterialButton);
                unLoadButton.setVisibility((View.VISIBLE));
                unloadMaterialButton.setVisibility((View.VISIBLE));

            }
        });

        Button unLoadButton = (Button )findViewById(R.id.unloadButton);
        unLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.setCount(Data.getCount() + 1);
                TextView countText = (TextView)findViewById(R.id.textView);
                countText.setText(Data.getCount() +"");

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setCancelable(false);
                builder.setMessage("Haul of "+ Data.getMaterial() + " completed.");
                final AlertDialog dialog = builder.create();

                        dialog.show();

                new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onFinish() {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                }.start();
                // Create the AlertDialog object and return it

                Button loadButton = (Button )findViewById(R.id.loadButton);
                Button loadMaterialButton = (Button )findViewById(R.id.loadMaterialButton);
                loadMaterialButton.setVisibility(View.VISIBLE);
                loadButton.setVisibility(View.VISIBLE);
                Button unLoadButton = (Button )findViewById(R.id.unloadButton);
                Button unloadMaterialButton = (Button )findViewById(R.id.unloadMaterialButton);
                unLoadButton.setVisibility((View.GONE));
                unloadMaterialButton.setVisibility((View.GONE));

            }
        });

        Button loadMaterialButton = (Button )findViewById(R.id.loadMaterialButton);
        Button unloadMaterialButton = (Button )findViewById(R.id.unloadMaterialButton);
        loadMaterialButton.setText(Data.getMaterial());
        unloadMaterialButton.setText(Data.getMaterial());
        loadMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) v.getContext();
                Intent intent = new Intent(activity, ChooseMaterialActivity.class);
                activity.startActivity(intent);
            }
        });
    }
}
