package com.example.all_news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class sportsadapter extends RecyclerView.Adapter<sportsadapter.viewholder> {
    List<modelarticles> listnew;
    Context context;

    public sportsadapter(List<modelarticles> listnew, Context context) {
        this.listnew = listnew;
        this.context = context;
    }


    @NonNull
    @Override
    public sportsadapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.singlerow_general,parent,false);
        return new sportsadapter.viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull sportsadapter.viewholder holder, int position) {
        holder.title.setText(listnew.get(position).getTitle());
        holder.time.setText(listnew.get(position).getPublishedAt());
        holder.author.setText(listnew.get(position).getAuthor());
        Glide.with(context)
                .load(listnew.get(position).urlToImage)
                .into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,webview.class);
                intent.putExtra("url",listnew.get(position).getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listnew.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView title,time,author;
        ImageView imageView;
        CardView cardView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.timepgeneral);
            title=itemView.findViewById(R.id.titlegeneral);
            author=itemView.findViewById(R.id.authorgeneral);
            imageView=itemView.findViewById(R.id.img);
            cardView=itemView.findViewById(R.id.cvgeneral);
        }
    }
}
