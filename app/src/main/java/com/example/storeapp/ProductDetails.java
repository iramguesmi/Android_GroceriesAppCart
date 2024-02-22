package com.example.storeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.storeapp.model.RecentlyViewed;

public class ProductDetails extends AppCompatActivity {

    ImageView img, back,addcartbtn;
    TextView proName, proPrice, proDesc;

    String name, price, desc;

    int image;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        Intent i = getIntent();

        name = i.getStringExtra("name");
        image = i.getIntExtra("image",R.drawable.bgbsissa);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");

        proName = findViewById(R.id.productName);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.big_image);
        back = findViewById(R.id.back2);

        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        img.setImageResource(image);





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ProductDetails.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });


    }

    /*public void onCartClick(View view){
        RecentlyViewed produit = new RecentlyViewed();
        produit.setName();
        produit.setPrice(proPrice);
        addToCart(produit);
    }
    private void addToCart(RecentlyViewed produit){
        cartlist.add(produit);
        CartAdapter.notifyDataSetCahged();
        afficherTotal();
    }*/
}