package com.aca.coctailappmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aca.coctailappmvvm.viewmodels.MainActivityViewModel;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    EditText pretragaEdit;

    TextView textPretraga1,textPretraga2,textPretraga3;

    Button pretraziBtn;

    ImageView refreshButton;

    ImageView randomKoktelImg;
    TextView randomKoktelIme;
    TextView rendomKoktelTip;

    private MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pretragaEdit = findViewById(R.id.pretragaEdit);

        textPretraga1 = findViewById(R.id.textPretraga1);
        textPretraga2 = findViewById(R.id.textPretraga2);
        textPretraga3 = findViewById(R.id.textPretraga3);

        pretraziBtn = findViewById(R.id.pretraziBtn);

        refreshButton = findViewById(R.id.refreshButton);

        randomKoktelImg = findViewById(R.id.randomKoktelImg);
        randomKoktelIme = findViewById(R.id.koktelIme);
        rendomKoktelTip = findViewById(R.id.koktelTip);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        mainActivityViewModel.init();

        mainActivityViewModel.getRandomCoctail().observe(this,coctail -> {
            Glide.with(this).load(coctail.getDrinkImg()).centerCrop()
                    .placeholder(getDrawable(R.drawable.ic_launcher_background)).into(randomKoktelImg);
            randomKoktelIme.setText(coctail.getDrinkName());
            rendomKoktelTip.setText(coctail.getDrinkType());
        });

        mainActivityViewModel.getmRecentSearches().observe(this,searchList->{
            textPretraga1.setText(searchList.get(0));
            textPretraga2.setText(searchList.get(1));
            textPretraga3.setText(searchList.get(2));
        });

        refreshButton.setOnClickListener(view -> {
            mainActivityViewModel.refreshCoctail();
        });

        pretraziBtn.setOnClickListener(view -> {
            mainActivityViewModel.searchCoctail(pretragaEdit.getText().toString());
        });
    }
}