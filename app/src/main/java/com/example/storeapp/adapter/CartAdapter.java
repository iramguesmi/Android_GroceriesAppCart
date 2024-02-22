package com.example.storeapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeapp.R;
import com.example.storeapp.model.RecentlyViewed;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    ArrayList<RecentlyViewed> produits;
    OnCartItemClickListener listener;

    public CartAdapter(ArrayList<RecentlyViewed> produits) {
        this.produits = produits;
    }

    public interface OnCartItemClickListener{
        void onSupprimerClick(int position);
    }
    public void setOnCartItemClickListener(OnCartItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        return new CartViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        RecentlyViewed produit = produits.get(position);
        holder.name.setText(produit.getName());
        holder.price.setText(produit.getPrice()+" TND");
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }


    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;
        public ImageButton supprimerButton;
        public CartViewHolder(@NonNull View itemView, final OnCartItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.nomTextView);
            price = itemView.findViewById(R.id.prixTextView);
            supprimerButton = itemView.findViewById(R.id.supprimerButton);

            supprimerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!= null){
                        int position = getAdapterPosition();
                        if (position!= RecyclerView.NO_POSITION){
                            listener.onSupprimerClick(position);
                        }
                    }
                }
            });
        }
    }
}
