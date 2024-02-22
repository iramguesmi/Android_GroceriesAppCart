package com.example.storeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.example.storeapp.adapter.AllCategoryAdapter;
import com.example.storeapp.model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {


    RecyclerView AllCategoryRecycler;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategoryModel> allCategoryModelList;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        AllCategoryRecycler = findViewById(R.id.allCategory);
        back = findViewById(R.id.back2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(AllCategory.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        allCategoryModelList = new ArrayList<>();
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_fruit));
        allCategoryModelList.add(new AllCategoryModel(2,R.drawable.ic_veggies));
        allCategoryModelList.add(new AllCategoryModel(3,R.drawable.ic_meat));
        allCategoryModelList.add(new AllCategoryModel(4,R.drawable.ic_spices));
        allCategoryModelList.add(new AllCategoryModel(5,R.drawable.ic_egg));
        allCategoryModelList.add(new AllCategoryModel(6,R.drawable.ic_dairy));
        allCategoryModelList.add(new AllCategoryModel(7,R.drawable.ic_drinks));
        allCategoryModelList.add(new AllCategoryModel(8,R.drawable.ic_snacks));
        allCategoryModelList.add(new AllCategoryModel(9,R.drawable.ic_bss));
        allCategoryModelList.add(new AllCategoryModel(10,R.drawable.ic_dessert));
        allCategoryModelList.add(new AllCategoryModel(11,R.drawable.ic_juice));
        allCategoryModelList.add(new AllCategoryModel(12,R.drawable.ic_salade));


        setCategoryRecycler(allCategoryModelList);

    }

    private void setCategoryRecycler(List<AllCategoryModel> allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,4);
        AllCategoryRecycler.setLayoutManager(layoutManager);

        AllCategoryRecycler.addItemDecoration(new GridSpacingItemDecoration(4, dpToPx(16), true));
        AllCategoryRecycler.setItemAnimator(new DefaultItemAnimator());

        allCategoryAdapter = new AllCategoryAdapter(this,allCategoryModelList);
        AllCategoryRecycler.setAdapter(allCategoryAdapter);
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        //decoration des icons et leur emplacement
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }


     // Converting dp to pixel

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
