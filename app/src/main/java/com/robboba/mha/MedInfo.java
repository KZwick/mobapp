package com.robboba.mha;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.robboba.mha.model.Medication;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;

public class MedInfo extends AppCompatActivity implements View.OnClickListener{

    //March 31 add
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    //Boolean Added;

    private EditText medName, dos, pillFreq;
    // for Firestore
    private FirebaseFirestore mFirestore;
    private Calendar calRefill = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_info);

        mFirestore = FirebaseFirestore.getInstance();

        //March 31 add
        dateView = (TextView) findViewById(R.id.textView4);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        //Button back = findViewById(R.id.backButton);
        //back.setOnClickListener(this);
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(this);

        // hide the button to the list meds intent.
        Button bList = findViewById(R.id.medListButton);
        bList.setVisibility(View.GONE);

        medName = (EditText) findViewById(R.id.medNameEditText);
        dos = (EditText) findViewById(R.id.dosageEditText);
        pillFreq = (EditText) findViewById(R.id.pillFreqEditText);

        /*Spinner monthSpin = (Spinner) findViewById(R.id.monthSpinner);
        ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        monthSpin.setAdapter(monthAdapter);
        Spinner daySpin = (Spinner) findViewById(R.id.daySpinner);
        ArrayAdapter<CharSequence> dayAdapter = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_item);
        daySpin.setAdapter(dayAdapter);
        Spinner yearSpin = (Spinner) findViewById(R.id.yearSpinner);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        yearSpin.setAdapter(yearAdapter);*/
    }

    public void onClick (View view){
        switch (view.getId()){
            /*case R.id.backButton:
                Intent intent = new Intent(this, TestMainMenu.class);
                startActivity(intent);
                break;*/
            case R.id.submitButton:
                submitData(view);
                break;
            case R.id.medListButton:
                Log.v("List","Started the Switch medListButton clickMedList method");
                Intent intent21 = new Intent(this, MedsList.class);
                startActivity(intent21);
                break;
        }
    }
    public void clickMedList(View view){
        Log.v("List","Started the clickMedList method");
        Intent intent21 = new Intent(this, MedsList.class);
        startActivity(intent21);
    }


    @SuppressWarnings("deprecation")
    public void setDate(View view){
        showDialog(999);
        //Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==999){
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            showDate(year, month, dayOfMonth);
            // for Firstore
            int iZero = 0;
            calRefill.set(Calendar.YEAR, year);
            calRefill.set(Calendar.MONTH,month);
            calRefill.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            calRefill.set(Calendar.HOUR_OF_DAY, iZero);
            calRefill.set(Calendar.MINUTE, iZero);
            calRefill.set(Calendar.SECOND, iZero);
        }
    };

    private void showDate(int year, int month, int day){
        dateView.setText(new StringBuilder().append(day).append("/").append(month+1).append("/").append(year));
    }

    /*
    private void clearForm(ViewGroup group){
        for(int i = 0, count = group.getChildCount(); i < count; ++i){
            View view = group.getChildAt(i);
            if(view instanceof EditText){
                ((EditText)view).setText("");
            }
            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount()>0))
                clearForm((ViewGroup)view);
        }
    }
    */

    public void clear(View v){
        medName.setText("");
        dos.setText("");
        pillFreq.setText("");
    }

    private void submitData(final View view){

        // Convert input data to Strings and java.util.Date
        String sMedication = medName.getText().toString();
        String sDosage = dos.getText().toString();
        String sPillsPer = pillFreq.getText().toString();
        // Using java.util.Date
        java.util.Date refillDate = calRefill.getTime();
        //Added = Boolean.FALSE;

        // change data to be ready for Firestore via the Model for the data
        // get the current user and their email
        FirebaseUser mUser= FirebaseAuth.getInstance().getCurrentUser();
        String mUserEmail = mUser.getEmail();


        // put the input data into the Model
        Medication oMed = new Medication();
        oMed.setMedname(sMedication);
        oMed.setMeddosage(sDosage);
        oMed.setMedinstruct(sPillsPer);
        oMed.setRefilldate(refillDate);
        //String sToast = "Med info name: "+ oMed.getMedname()+ " Dose: " + oMed.getMeddosage() + " Instuct: "+oMed.getMedname();

        // Get a reference to the Users collection
        // the document using their email, then collection "Medications"
        CollectionReference UserMeds = mFirestore.collection("Users")
                .document(mUserEmail).collection("Medications");

        // add the data to the above sub collection
        UserMeds.add(oMed);

        // Code to check the Firestore has added the data mFirestore = DB
        /* not working
        DocumentReference docRef =  mFirestore.collection("Users").document(mUserEmail);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot docSnapshot, FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w("MedAdd", "Listen failed.", e);
                    return;
                }
                if (docSnapshot != null && docSnapshot.exists()) {
                    Log.d("MedAdd", " data: " + docSnapshot.getData());
                    Added = Boolean.TRUE;
                } else {
                    Log.d("MedAdd", " data: null");
                }
            }
        }); */

        //if(Added ) {
            Toast.makeText(this, "Medication Added", Toast.LENGTH_LONG).show();
        //}

        clear(view);

        //Toast.makeText(this, "User is: " + mUser +" Email: "+ mUserEmail +" CL: "+UserMeds, Toast.LENGTH_LONG).show();
        //Log.v("Kevin","User is: " + mUser +" Email: "+ mUserEmail + " CL: "+UserMeds);

        /*
        CollectionReference subRef = mFirestore.collection("restaurants")
        .document("abc123")
        .collection("ratings");
         */
        // Add a new document to the collection
        // Using the email for the document ID makes then Unique
        // example  Users.document(sUser.getEmail()).set(sUser);
        // or Users.document(mUserEmail).set(sUser);

        //Users.document(mUserEmail).collection("Medications").add(oMed);
        // the first collection is "Users"
        // the douments had the ID "users email", with fields
        // the subcollection is "Medications"
        // this ducment has a auto generated ID, with fields
    }
}
