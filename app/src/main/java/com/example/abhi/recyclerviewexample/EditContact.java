package com.example.abhi.recyclerviewexample;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class EditContact extends AppCompatActivity //implements Parcelable{
{   EditText etEditName, etEditNumber;
    Button btEditContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        etEditName = (EditText) findViewById(R.id.etEditName);
        etEditNumber = (EditText) findViewById(R.id.etEditNumber);
        btEditContact = (Button) findViewById(R.id.btEditContact);
        final ArrayList<Contacts> EContact = new ArrayList<>();



        btEditContact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // hesap islemi
                String EName = etEditName.getText().toString();
                String ENumber = etEditNumber.getText().toString();
//                String position;

//                if (bundle != null) {
//                    position = bundle.getString("Adapter_Position");
//                }
//        String[] Name;
//        Name =getResources().getStringArray(R.array.nm);
//        String[] Number;
//        Number =getResources().getStringArray(R.array.num);
//       int i=0;
//
//        for (String NAME : ){
                if (TextUtils.isEmpty(EName) || TextUtils.isEmpty(ENumber)) {
                    if (TextUtils.isEmpty(EName)) {
                        etEditName.setError("Enter Name!!");
                    } else {
                        etEditNumber.setError("Enter Number!!");

                    }
                } else {
                        Bundle bundle = getIntent().getExtras();
                        int position = Integer.parseInt(bundle.getString("Adapter_Position"));


                        Contacts editContact =new Contacts(EName,ENumber);
                        EContact.add(editContact);


//                    Contacts contacts = new Contacts(EName, ENumber);
//                    contact.add(contacts);
                    Intent Eintent = new Intent(EditContact.this, MainActivity.class);
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST",(Serializable)EContact);
                    Eintent.putExtra("BUNDLE",args);
//                    startActivity(Eintent);
//                    Eintent.putExtra("Arraylist_element", EContact);
                    Eintent.putExtra("Position_no", position);
                    startActivity(Eintent);

//            Toast.makeText(MainActivity.this, Name[i], Toast.LENGTH_SHORT).show();
                    // i++;

//                    adapter = new ContactAdapter(EditContact, MainActivity.this);
//                    recyclerView.setAdapter(adapter);
                    etEditName.setText("");
                    etEditNumber.setText("");


                }
            }
        });

    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//
//    }
}