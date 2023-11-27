package com.example.foodieapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.foodieapp.Domain.FoodDomain;
import com.example.foodieapp.Helper.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTXT, priceTXT, numberOrderTXT, descriptionTXT;
    ImageView minusbtn, plusbtn, foodbtn;
    private FoodDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_show_detail);
        initView();
        getBundle();
        managementCart = new ManagementCart(this);
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTXT = findViewById(R.id.titleTXT);
        priceTXT = findViewById(R.id.priceTXT);
        numberOrderTXT = findViewById(R.id.numberOrderTXT);
        descriptionTXT = findViewById(R.id.descriptionTXT);
        plusbtn = findViewById(R.id.plusbtn);
        minusbtn = findViewById(R.id.minusbtn);
        foodbtn = findViewById(R.id.foodbtn);
    }

    public void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");

        if (object != null) {
            String picName = object.getPic();
            int drawableResourceId = getResources().getIdentifier(picName, "drawable", getPackageName());

            if (drawableResourceId != 0) {
                if (foodbtn != null) {  // Check if foodbtn is not null before using Glide
                    Glide.with(this)
                            .load(drawableResourceId)
                            .listener(new RequestListener() {
                                @Override
                                public boolean onLoadFailed(GlideException e, Object model, Target target, boolean isFirstResource) {
                                    Log.e("ShowDetailActivity", "Glide load failed", e);
                                    return false;
                                }

                                @Override
                                public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                                    return false;
                                }
                            })
                            .into(foodbtn);
                } else {
                    Log.e("ShowDetailActivity", "foodbtn is null");
                }

                titleTXT.setText(object.getTitle());
                priceTXT.setText(String.valueOf(object.getFee())); // Convert to String
                descriptionTXT.setText(object.getDescription());

                // Use String.valueOf() to convert the integer to a string before setting it as text
                numberOrderTXT.setText(String.valueOf(numberOrder));

                plusbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numberOrder = numberOrder + 1;
                        // Use String.valueOf() here as well
                        numberOrderTXT.setText(String.valueOf(numberOrder));
                    }
                });

                minusbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (numberOrder > 1) {
                            numberOrder = numberOrder - 1;
                        }
                        // Use String.valueOf() here as well
                        numberOrderTXT.setText(String.valueOf(numberOrder));
                    }
                });

                addToCartBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        object.setNumberincart(numberOrder);
                        managementCart.insertfood(object);
                    }
                });
            } else {
                // Log an error or handle the case where the drawable resource is not found
                Log.e("ShowDetailActivity", "Drawable resource not found for: " + picName);
            }
        } else {
            // Log an error or handle the case where the object is null
            Log.e("ShowDetailActivity", "FoodDomain object is null");
        }
    }
}
