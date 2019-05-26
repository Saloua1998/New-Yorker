package com.example.newyorker;

import android.support.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class FirebaseDBHelper {
    private FirebaseDatabase mDB;
    private DatabaseReference mRefProducts;
    private List<Products> products = new ArrayList<>();

//    https://www.youtube.com/watch?v=eCfJMseN0-8
    public interface DataStatus{
        void DataIsLoaded(List<Products> products, List<String> keys);
        void DataInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDBHelper() {
        mDB = FirebaseDatabase.getInstance();
        mRefProducts = mDB.getReference("Products");
    }

    public void readProducts(final DataStatus dataStatus){
        mRefProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                products.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Products products = keyNode.getValue(Products.class);
                    FirebaseDBHelper.this.products.add(products);
                }
                dataStatus.DataIsLoaded(products, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

}

