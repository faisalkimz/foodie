package com.example.foodieapp.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodieapp.Domain.FoodDomain;
import com.example.foodieapp.Domain.categoryDomain;
import com.example.foodieapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class PopularAdoptor extends RecyclerView.Adapter<PopularAdoptor.ViewHolder> {
    ArrayList<FoodDomain> categoryFoods;

    public PopularAdoptor(ArrayList<FoodDomain> categoryFoods) {
        this.categoryFoods = categoryFoods;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = String.valueOf(categoryFoods.get(position).getTitle());
        holder.title.setText(title != null ? title : "");

        int fee = categoryFoods.get(position).getFee();
        holder.fee.setText(String.format(Locale.getDefault(), "%,d UGSH", fee));


        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(categoryFoods.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return categoryFoods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, fee;
        ImageView pic;
        TextView addButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addButton=itemView.findViewById(R.id.addButton);

        }
    }
}

