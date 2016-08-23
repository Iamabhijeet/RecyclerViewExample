package com.example.abhi.recyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhi on 22-08-2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<Contacts> adapter_list=new ArrayList<>();
    MainActivity mainActivity;
    Context context;
    public ContactAdapter(ArrayList<Contacts> adapter_list,Context context){
        this.adapter_list=adapter_list;
        this.context=context;
        mainActivity=(MainActivity) context;



    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        ContactViewHolder contactViewHolder=new ContactViewHolder(view,mainActivity);

        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.tvName.setText(adapter_list.get(position).getName());
        holder.tvNumber.setText(adapter_list.get(position).getNumber());


    }

    @Override
    public int getItemCount() {
        return adapter_list.size();
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder {


        TextView tvName,tvNumber;
        MainActivity mainActivity;

        public ContactViewHolder(View itemView,MainActivity mainActivity) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvNumber = (TextView)itemView.findViewById(R.id.tvNumber);
            this.mainActivity=mainActivity;

        }
    }
}
