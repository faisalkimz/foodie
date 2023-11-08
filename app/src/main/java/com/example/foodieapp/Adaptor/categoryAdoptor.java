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

import com.example.foodieapp.Domain.categoryDomain;
import com.example.foodieapp.R;

import java.util.ArrayList;

public class categoryAdoptor extends RecyclerView.Adapter<categoryAdoptor.ViewHolder>{
    ArrayList<categoryDomain>categoryDomains;

    public categoryAdoptor(ArrayList<categoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(parent, R.layout., false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.categoryName.setText(categoryDomains.get(position).getTitle());
    String picURL="";
    switch (position){
        case 0:{
            picURL="cat_1";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background1));
        }
        case 1:{
            picURL="cat_2";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background2));
        }
        case 2:{
            picURL="cat_3";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background3));
        }
        case 3:{
            picURL="cat_4";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background4));
        }
        case 4:{
            picURL="cat_5";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background5));
        }
    }
    int drawableResourceid=holder.itemView.getContext().getResources().getIdentifier(picURL, "drawable", holder.itemView.getContext().getPackageName());
    Glide.with()
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout= itemView.findViewById(R.id.mainlayout);
        }
    }

}
