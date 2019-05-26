package com.example.newyorker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class RecyclerView_config {
    private Context mContext;
    private ProductAdapter mProductadapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Products> products, List<String>keys){
        mContext = context;
        mProductadapter=new ProductAdapter(products, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mProductadapter);
    }

    class ProductItemView extends RecyclerView.ViewHolder{
//        private ImageView mImage;
        private TextView mBrand, mPrice;
        private String key;

        public ProductItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.inventorytemplate, parent, false));
//            mImage = itemView.findViewById(R.id.ProductImage);
            mBrand = itemView.findViewById(R.id.ProductBrand);
            mPrice = itemView.findViewById(R.id.ProductPrice);
        }
        public void bind(Products products, String key){
//            mImage.setImageBitmap(products.);
            mBrand.setText(products.getBrand());
            mPrice.setText(products.getPrice());
            this.key =key;
        }
    }
    class ProductAdapter extends  RecyclerView.Adapter<ProductItemView>{
        private List<Products> mProductList;
        private  List<String> mKeys;

        public ProductAdapter(List<Products> mProductList, List<String> mKeys) {
            this.mProductList = mProductList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public ProductItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ProductItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductItemView holder, int position) {
            holder.bind(mProductList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {return mProductList.size();}
    }
}
