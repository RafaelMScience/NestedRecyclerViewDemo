package com.rafaelm.nestedrecyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MemberAdp extends RecyclerView.Adapter<MemberAdp.ViewHolder> {
    //Initialize Arraylist
    private ArrayList<String> arrayListMember;

    //Create construtor
    MemberAdp(ArrayList<String> arrayListMember){
        this.arrayListMember = arrayListMember;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_member, parent, false);
        return new MemberAdp.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Set member name on TextView
        holder.tvName.setText(arrayListMember.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayListMember.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //initialize variable

        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Assign variable
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
