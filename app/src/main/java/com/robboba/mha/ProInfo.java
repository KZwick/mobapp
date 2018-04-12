package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.robboba.mha.model.Professional;

public class ProInfo extends AppCompatActivity /*implements View.OnClickListener*/{

    private EditText name, tel, address;
    // for Firestore
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_info);

        //Button back = findViewById(R.id.backButton);

        //back.setOnClickListener(this);

        name = (EditText) findViewById(R.id.nameEditText);
        tel = (EditText) findViewById(R.id.telEditText);
        address = (EditText) findViewById(R.id.addressEditText);

        Spinner proSpin = (Spinner) findViewById(R.id.proSpinner);

        ArrayAdapter<CharSequence> proAdapter = ArrayAdapter.createFromResource(this, R.array.proName, android.R.layout.simple_spinner_item);

        proSpin.setAdapter(proAdapter);

        // Initialize Firestore
        mFirestore = FirebaseFirestore.getInstance();
    }

    /*public void onClick (View view){
        switch (view.getId()){
            case R.id.backButton:
                Intent intent = new Intent(this, TestMainMenu.class);
                startActivity(intent);
                break;
        }
    }*/

    public void clear(View v){
        name.setText("");
        tel.setText("");
        address.setText("");
    }

    public void clickSubmit(View view){
        submitData(view);
    }

    private void submitData(View view){
        // Convert input data to Strings
        Spinner proSpin = (Spinner) findViewById(R.id.proSpinner);
        String sName = name.getText().toString();
        String sTel = tel.getText().toString();
        String sAddress = address.getText().toString();
        String sSpin = proSpin.getSelectedItem().toString();

        // get the current user and their email
        FirebaseUser mUser= FirebaseAuth.getInstance().getCurrentUser();
        String mUserEmail = mUser.getEmail();

        Professional oProf = new Professional();
        oProf.setName(sName);
        oProf.setPhone(sTel);
        oProf.setAddress1(sAddress);
        oProf.setType(sSpin);

        // the document using their email, then collection "Medications"
        CollectionReference UserProfessionals = mFirestore.collection("Users")
                .document(mUserEmail).collection("Professionals");

        UserProfessionals.add(oProf);

        Toast.makeText(this, "Professional Added", Toast.LENGTH_LONG).show();

        clear(view);

    }
}
