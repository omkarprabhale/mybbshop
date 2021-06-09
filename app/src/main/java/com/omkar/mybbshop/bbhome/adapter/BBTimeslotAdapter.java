package com.omkar.mybbshop.bbhome.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.omkar.mybbshop.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BBTimeslotAdapter extends RecyclerView.Adapter<BBTimeslotAdapter.BBTimeslotHolder>{

    public List<String> slots;
    public Context context;
    private LayoutInflater inflater;


    public BBTimeslotAdapter(List<String>slotts,Context context){

            this.slots=slotts;
            this.context=context;
            this.inflater = LayoutInflater.from(context);
            }


        @NonNull
        @Override
        public BBTimeslotHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
            View view = inflater.inflate(R.layout.slotadapter,parent,false);
            return new BBTimeslotHolder(view); }

        @Override
        public void onBindViewHolder(@NonNull BBTimeslotHolder holder,int position){

               String slot = slots.get(position);
               holder.titleText.setText(slot);

                }

        @Override
        public int getItemCount(){
                return slots.size();
                }

        class BBTimeslotHolder extends RecyclerView.ViewHolder {

          private TextView titleText;

           public BBTimeslotHolder(View itemView)
           {
               super(itemView);
               titleText =itemView.findViewById(R.id.slotTv);
           }

        }

}
