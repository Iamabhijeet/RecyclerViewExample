package com.example.abhi.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<Contacts> contact = new ArrayList<>();
    EditText etName, etNumber;
    Button btAddContact;
    ArrayList<Contacts> createContact = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

                Contacts contacts = new Contacts(Name, Number);
                contact.add(contacts);
//            Toast.makeText(MainActivity.this, Name[i], Toast.LENGTH_SHORT).show();
                // i++;

                adapter = new ContactAdapter(contact, MainActivity.this);
                recyclerView.setAdapter(adapter);

            }
        });
    }
}