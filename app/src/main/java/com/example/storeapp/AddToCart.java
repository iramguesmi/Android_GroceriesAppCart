package com.example.storeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.storeapp.adapter.CartAdapter;
import com.example.storeapp.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class AddToCart extends AppCompatActivity {
 RecyclerView recycler_cart;
 TextView txt_final_price;
 Button btn_order;
 ArrayList<RecentlyViewed> cartList;
 CartAdapter cartAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        btn_order = findViewById(R.id.orderbtn);

        cartList = new ArrayList<>();

        recycler_cart = findViewById(R.id.recycler_cart);
        recycler_cart.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(cartList);
        recycler_cart.setAdapter(cartAdapter);


        txt_final_price = findViewById(R.id.txt_final_price);

        afficherTotal();





    }

    private void afficherTotal() {
        double total = 0;
        for (RecentlyViewed produit : cartList){
            total += produit.getPrice();
        }
        txt_final_price.setText(total+" DT");
    }

}