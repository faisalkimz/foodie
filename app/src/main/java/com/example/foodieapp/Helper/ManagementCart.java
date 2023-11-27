package com.example.foodieapp.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.foodieapp.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);
    }
    public void insertfood(FoodDomain item){
        ArrayList<FoodDomain>listFood=getlistcart();
                boolean existAlready = false;
                int n=0;
                for (int i=0; i< listFood.size(); i++){
                    if (listFood.get(i).getTitle().equals(item.getTitle())){
                        existAlready=true;
                        n=i;
                        break;
                    }
                }
                if (existAlready){
                    listFood.get(n).setNumberincart(item.getNumberincart());
                }else {
                    listFood.add(item);
                }
                tinyDB.putListObject("CartList", listFood);
        Toast.makeText(context, "Added to Cart.", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<FoodDomain>getlistcart(){
        return tinyDB.getListObject("CartList");
    }
}
