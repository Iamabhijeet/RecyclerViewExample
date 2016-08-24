package com.example.abhi.recyclerviewexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by abhi on 22-08-2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>  {
    ArrayList<Contacts> adapter_list = new ArrayList<>();
    MainActivity mainActivity;
    Context context;

    public ContactAdapter(ArrayList<Contacts> adapter_list, Context context) {
        this.adapter_list = adapter_list;
        this.context = context;
        mainActivity = (MainActivity) context;
//        CardView cardView;
//        cardView = (CardView) itemView.findViewById(R.id.cardView);
//        //cardView.setOnLongClickListener(mainActivity);
//        cardView.setOnClickListener(this);
    }

//    public void delete(int position){
//        adapter_list.remove(position);
//        notifyItemRemoved(position);
//    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view, mainActivity);

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



    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView tvName, tvNumber;
        MainActivity mainActivity;
        CardView cardView;

        public ContactViewHolder(View itemView, MainActivity mainActivity) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvNumber = (TextView) itemView.findViewById(R.id.tvNumber);
            this.mainActivity = mainActivity;
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            //cardView.setOnLongClickListener(mainActivity);
           tvName.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {

            Toast.makeText(context,"i am clicked",Toast.LENGTH_SHORT).show();

            int position = getAdapterPosition();
                // your changes
            Intent CAintent = new Intent(context, EditContact.class);
            CAintent.putExtra("Adapter_Position", position);
            context.startActivity(CAintent);
                notifyDataSetChanged();
            }
        }


}
