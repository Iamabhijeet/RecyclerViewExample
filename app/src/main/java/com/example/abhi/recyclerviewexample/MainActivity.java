package com.example.abhi.recyclerviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<Contacts> contact = new ArrayList<>();
    EditText etName, etNumber;
    Button btAddContact;
    //Contacts econtact;
    ArrayList<Contacts> econtact;

    //ArrayList<Contacts> createContact = new ArrayList<>();

   int position;
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent Eintent = getIntent();
//        Bundle args = Eintent.getBundleExtra("BUNDLE");
//        econtact  = (ArrayList<Contacts>) args.getSerializable("ARRAYLIST");
//        position=   Integer.parseInt(args.getString("Position_no"));
//        contact.addAll(position,econtact);
//        Bundle bun = getIntent().getExtras();
//        if (bun != null) {
//            position = Integer.parseInt(bun.getString("Position_no"));
//            econtact="Arraylist_element";
////        element = bun.getString("EContact_thing");
////        contact.add(position,element);
////
//        }
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.etName);
        etNumber = (EditText) findViewById(R.id.etNumber);
        btAddContact = (Button) findViewById(R.id.btAddContact);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        btAddContact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // hesap islemi
                String Name = etName.getText().toString();
                String Number = etNumber.getText().toString();
//        String[] Name;
//        Name =getResources().getStringArray(R.array.nm);
//        String[] Number;
//        Number =getResources().getStringArray(R.array.num);
//       int i=0;
//
//        for (String NAME : ){
                if (TextUtils.isEmpty(Name) || TextUtils.isEmpty(Number)) {
                    if (TextUtils.isEmpty(Name)) {
                        etName.setError("Enter Name!!");
                    } else {
                        etNumber.setError("Enter Number!!");

                    }
                } else {

                    Contacts contacts = new Contacts(Name, Number);
                    contact.add(contacts);

//            Toast.makeText(MainActivity.this, Name[i], Toast.LENGTH_SHORT).show();
                    // i++;

                    adapter = new ContactAdapter(contact, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                    etName.setText("");
                    etNumber.setText("");

                }
            }
        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Intent Eintent = getIntent();
//        Bundle args = Eintent.getBundleExtra("BUNDLE");
//        econtact  = (ArrayList<Contacts>) args.getSerializable("ARRAYLIST");
//        position=   Integer.parseInt(args.getString("Position_no"));
//        contact.addAll(position,econtact);
//    }

//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Intent Eintent = getIntent();
//        Bundle args = Eintent.getBundleExtra("BUNDLE");
//        econtact  = (ArrayList<Contacts>) args.getSerializable("ARRAYLIST");
//        position=   Integer.parseInt(args.getString("Position_no"));
//        contact.addAll(position,econtact);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Intent Eintent = getIntent();
//        Bundle args = Eintent.getBundleExtra("BUNDLE");
//        econtact  = (ArrayList<Contacts>) args.getSerializable("ARRAYLIST");
//        position=   Integer.parseInt(args.getString("Position_no"));
//        contact.addAll(position,econtact);
//    }
}