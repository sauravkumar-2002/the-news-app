package com.example.all_news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class businessadapter extends RecyclerView.Adapter<businessadapter.viewholder> {
    List<modelarticles> listnew;
    Context context;

    public businessadapter(List<modelarticles> listnew, Context context) {
        this.listnew = listnew;
        this.context = context;
    }

    @NonNull
    @Override
    public businessadapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.singlerow_general,parent,false);
        return new businessadapter.viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull businessadapter.viewholder holder, int position) {
        holder.title.setText(listnew.get(position).getTitle());
        holder.time.setText(listnew.get(position).getPublishedAt());
        holder.author.setText(listnew.get(position).getAuthor());
        Glide.with(context)
                .load(listnew.get(position).urlToImage)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listnew.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView title,time,author;
        ImageView imageView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.timepgeneral);
            title=itemView.findViewById(R.id.titlegeneral);
            author=itemView.findViewById(R.id.authorgeneral);
            imageView=itemView.findViewById(R.id.img);
        }
    }
}
