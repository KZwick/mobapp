package com.robboba.mha;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
//import com.google.api.core.ApiFutures;

/**
 * Created by kevin on 2018-04-10.
 */

public class MedsList extends AppCompatActivity {

    // for Firestore
    private FirebaseFirestore mFirestore;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private Query mQuery;
    private static int LIMIT = 30;
    @BindView(R.id.listmeds)
    ListView listView;
    private List<String> medList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        Log.v("List","Med List intent did onCreate");

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();
        // Initialize Firestore
        mFirestore = FirebaseFirestore.getInstance();
        // Enable Firestore logging
        FirebaseFirestore.setLoggingEnabled(true);
        // Getting the firebase user
        mUser = FirebaseAuth.getInstance().getCurrentUser();

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("List","Med List intent did onStart");

        //FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void GetMedListQuery(){
        FirebaseUser mUser= FirebaseAuth.getInstance().getCurrentUser();
        String mUserEmail = mUser.getEmail();

        // Create a reference to the Medications collection
        CollectionReference UserMeds = mFirestore.collection("Users")
                .document(mUserEmail).collection("Medications");

        mQuery = UserMeds.orderBy("medname", Query.Direction.ASCENDING)
                .limit(LIMIT);
        mQuery.get();
        Log.v("potato",mQuery.toString());
        //ApiFuture<QuerySnapshot> querySnapshot = mQuery.get();

       UserMeds.addSnapshotListener(new EventListener<QuerySnapshot>() {
           @Override
           public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
               medList.clear();
               for(DocumentSnapshot snapshot : queryDocumentSnapshots){
                   medList.add(snapshot.getString("medname"));
               }
               ArrayAdapter<String>adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,medList);
               adapter.notifyDataSetChanged();
               listView.setAdapter(adapter);
           }
       });

        // Get the 50 highest rated restaurants
        /*
        mQuery = mFirestore.collection("restaurants")
                .orderBy("avgRating", Query.Direction.DESCENDING)
                .limit(LIMIT);

        db.collection("group").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                namesList.clear();
                for (DocumentSnapshot snapshot : documentSnapshots){
                    namesList.add(snapshot.getString("name"));
                }
                ArrayAdapter<String>adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_selectable_list_item,namesList);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
            }
        });
                */

    }
}
