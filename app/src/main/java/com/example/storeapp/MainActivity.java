package com.example.storeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.storeapp.adapter.CategoryAdapter;
import com.example.storeapp.adapter.DiscountedProductAdapter;
import com.example.storeapp.adapter.RecentlyViewedAdapter;
import com.example.storeapp.model.Category;
import com.example.storeapp.model.DiscountedProducts;
import com.example.storeapp.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    List<RecentlyViewed> cartList = new ArrayList<>();


    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    ImageView allCategory;
    ImageView cartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        cartButton = findViewById(R.id.cartbtn);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddToCart.class);
                startActivity(intent);
            }
        });

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });


        //ajouter les data au model
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountonions));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountbesissa));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discounteddates));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountthon));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountedpaper));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discountedorange));

//ajouter les data au model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.home_fruits));
        categoryList.add(new Category(2,R.drawable.home_vegetables));
        categoryList.add(new Category(3,R.drawable.ic_bss));
        categoryList.add(new Category(4,R.drawable.home_spices));
        categoryList.add(new Category(5,R.drawable.home_meat));
        /*categoryList.add(new Category(6,R.drawable.home_meat));
        categoryList.add(new Category(7,R.drawable.home_fish__1_));
        categoryList.add(new Category(8,R.drawable.home_meat));*/

        /*categoryList.add(new Category(1,R.drawable.dairy));
        categoryList.add(new Category(2,R.drawable.snacks));
        categoryList.add(new Category(3,R.drawable.carbs));
        categoryList.add(new Category(4,R.drawable.bsissa));
        categoryList.add(new Category(5,R.drawable.nuts));
        categoryList.add(new Category(6,R.drawable.fruit));
        categoryList.add(new Category(7,R.drawable.vegetables));
        categoryList.add(new Category(8,R.drawable.condiments));
        categoryList.add(new Category(9,R.drawable.coffee));
        categoryList.add(new Category(10,R.drawable.cheese));
        categoryList.add(new Category(11,R.drawable.cat));
        categoryList.add(new Category(12,R.drawable.pattes));
        categoryList.add(new Category(13,R.drawable.drink));
        categoryList.add(new Category(14,R.drawable.cleaning));*/

        //ajouter les data au model
        recentlyViewedList= new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Bsissa", "Bsissa is a typical Mediterranean food, based on flour of roasted barley which dates back to Roman times.", 19.900,"1","KG",R.drawable.bsissacard, R.drawable.bgbsissa));
        recentlyViewedList.add(new RecentlyViewed("Spices: red chilli pepper", "The main oriental spices associated with Tunisian spices, mild chilli pepper ...", 6.500,"1","KG",R.drawable.spices, R.drawable.bgspices));
        recentlyViewedList.add(new RecentlyViewed("Pates Coquillette", "Superior pasta made from pure extracted durum wheat semolina.", 0.420,"0.5","KG",R.drawable.pates, R.drawable.bgpates));
        recentlyViewedList.add(new RecentlyViewed("Fromage Presedent", "To spread, to cook, or to snack on, President offers you a wide range of cheeses to suit every taste.", 2.750,"8","triangle",R.drawable.fromaga, R.drawable.bgfromage));

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(MainActivity.this,dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(MainActivity.this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(MainActivity.this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

}