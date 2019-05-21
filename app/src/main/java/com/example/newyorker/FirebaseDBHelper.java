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
    private FirebaseDatabase DB;
    private DatabaseReference RefClothes;
    private List<Clothes> clothes = new ArrayList<>();

//    https://www.youtube.com/watch?v=eCfJMseN0-8
    public interface DataStatus{
        void DataIsLoaded(List<Clothes> clothes, List<String> keys);
        void DataInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDBHelper() {
        DB = FirebaseDatabase.getInstance();
        RefClothes = DB.getReference("Clothes");
    }

    public void readClothes(final DataStatus dataStatus){
        RefClothes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clothes.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Clothes clothe = keyNode.getValue(Clothes.class);
                    clothes.add(clothe);
                }
                dataStatus.DataIsLoaded(clothes, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

}

