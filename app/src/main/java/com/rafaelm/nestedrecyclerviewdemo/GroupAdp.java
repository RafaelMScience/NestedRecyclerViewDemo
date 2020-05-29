package com.rafaelm.nestedrecyclerviewdemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class GroupAdp extends RecyclerView.Adapter<GroupAdp.ViewHolder> {

    //Initialize  activity and array list
    private Activity activity;
    ArrayList<String> arrayListGroup;

    //Create constructor
    GroupAdp(Activity activity, ArrayList<String> arrayListGroup){
        this.activity = activity;
        this.arrayListGroup = arrayListGroup;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_group, parent, false);

        return new GroupAdp.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Initialize variable
        holder.tvName.setText(arrayListGroup.get(position));

        //Initializa member Arralist
        ArrayList<String> arrayListMember = new ArrayList<>();

        //Using for loop to add multiple member
        for (int i=1; i<=4; i++){
            arrayListMember.add("Member "+ i);
        }

        //Initialize member adapter
        MemberAdp adapterMember = new MemberAdp(arrayListMember);

        //Initizalize Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);

        //set Layou manager
        holder.rvMember.setLayoutManager(layoutManager);

        //Set Adapter
        holder.rvMember.setAdapter(adapterMember);
    }

    @Override
    public int getItemCount() {
        return arrayListGroup.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //Initialize variable
        TextView tvName;
        RecyclerView rvMember;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            tvName = itemView.findViewById(R.id.tv_name);
            rvMember = itemView.findViewById(R.id.rv_member);
        }
    }
}
