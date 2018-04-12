package com.robboba.mha;

/**
 * Created by kevin on 2018-04-12.
 */

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class ListExample extends AppCompatActivity {
    @BindView(R.id.btn)
    Button button;
    @BindView(R.id.edittext)
    EditText editText;
    @BindView(R.id.listView)
    ListView listView;
    private List<String> namesList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_list_example);
        ButterKnife.bind(this);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        FirebaseUser mUser= FirebaseAuth.getInstance().getCurrentUser();
        final String mUserEmail = mUser.getEmail();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> map = new HashMap<>(); // this is the document ID being created in the program
                map.put("name",editText.getText().toString()); // this is adding the data
                // db.collection("group").document().set(map)
                db.collection("Users").document(mUserEmail).collection("Example").document().set(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) { // checking if the data is added.
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Data saved",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }); // end of adding Data to the DB

        // db.collection("group")
        db.collection("Users").document(mUserEmail).collection("Example").
                addSnapshotListener(new EventListener<QuerySnapshot>() {
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
    }
}
