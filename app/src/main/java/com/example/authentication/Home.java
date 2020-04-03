package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.authentication.Model.Courselist;
import com.example.authentication.Viewholder.Courseviewholder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView1;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Courselist, Courseviewholder> adapter;
    FirebaseDatabase db;
    DatabaseReference dbref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db=FirebaseDatabase.getInstance();
        dbref=db.getReference("/Course_list");



        recyclerView1=findViewById(R.id.recyclerview);
        recyclerView1.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager);

        showlist();





//
//        Button b1=(Button)findViewById(R.id.log);

//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth fAuth = FirebaseAuth.getInstance();
//                fAuth.signOut();
//                startActivity(new Intent(Home.this,MainActivity.class));
//            }
//        });
    }
     void  showlist()
     {

         FirebaseRecyclerOptions options=new FirebaseRecyclerOptions.
                 Builder<Courselist>()
                 .setQuery(dbref,Courselist.class).build();

         adapter=new FirebaseRecyclerAdapter<Courselist, Courseviewholder>(options) {
             @Override
             protected void onBindViewHolder(@NonNull Courseviewholder courseviewholder, int i, @NonNull Courselist courselist) {
                courseviewholder.coursename.setText(courselist.getCname());
                 courseviewholder.courseid.setText(courselist.getCid());
                 courseviewholder.abbravation.setText(courselist.getAbbr());

             }

             @NonNull
             @Override
             public Courseviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                 View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_catogory,parent,false);

                 return  new Courseviewholder(view);
             }
         };


         adapter.startListening();
         adapter.notifyDataSetChanged();
         recyclerView1.setAdapter(adapter);
     }
}
