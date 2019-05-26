package com.example.newyorker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class Inventory extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        mRecyclerView = findViewById(R.id.recycler_products);

        new FirebaseDBHelper().readProducts(new FirebaseDBHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Products> products, List<String> keys) {
                new RecyclerView_config().setConfig(mRecyclerView, Inventory.this, products, keys);
            }

            @Override
            public void DataInserted() { }

            @Override
            public void DataIsUpdated() { }

            @Override
            public void DataIsDeleted() { }
        });


    }
}
