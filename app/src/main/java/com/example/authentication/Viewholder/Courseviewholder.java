package com.example.authentication.Viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.authentication.R;

public class Courseviewholder extends RecyclerView.ViewHolder
{

    public TextView coursename;
    public TextView courseid;
    public TextView abbravation;

    public Courseviewholder(@NonNull View itemView) {
        super(itemView);
        coursename=(TextView)itemView.findViewById(R.id.coursename);

        courseid=(TextView)itemView.findViewById(R.id.courseid);
        abbravation =(TextView)itemView.findViewById(R.id.abbr);

    }

}
