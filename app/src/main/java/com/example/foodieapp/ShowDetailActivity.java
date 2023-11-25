package com.example.foodieapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.foodieapp.Domain.FoodDomain;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTXT, priceTXT, numberOrderTXT, descriptionTXT;
    ImageView minusbtn, plusbtn, foodbtn;
    private FoodDomain object;
    int numberOrder=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        initView();
        getBundle();
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTXT = findViewById(R.id.titleTXT);
        priceTXT = findViewById(R.id.priceTXT);
        numberOrderTXT = findViewById(R.id.numberOrderTXT);
        descriptionTXT = findViewById(R.id.descriptionTXT);
        plusbtn = findViewById(R.id.plusbtn);
        minusbtn = findViewById(R.id.minusbtn);
        foodbtn= findViewById(R.id.foodbtn);
    }

    public void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId= this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(foodbtn);

        titleTXT.setText(object.getTitle());
        priceTXT.setText(object.getFee());
        descriptionTXT.setText(object.getDescription());
        numberOrderTXT.setText(String.valueOf(numberOrder));
        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder=numberOrder+1;
                numberOrderTXT.setText(String.valueOf(numberOrder));
            }
        });
        minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOrder>1){
                    numberOrder=numberOrder-1;
                }
                numberOrderTXT.setText(String.valueOf(numberOrder));
            }
        });

    }


}