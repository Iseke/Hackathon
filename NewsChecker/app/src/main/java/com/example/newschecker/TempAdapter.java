package com.example.newschecker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TempAdapter  extends RecyclerView.Adapter<TempAdapter.MyViewHolder >{
    ArrayList<News> news;
    public TempAdapter(ArrayList<News> list){
        this.news=list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_info,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        String url=news.get(position).getPictureURL();
        LoadImage loadImage=new LoadImage(myViewHolder.iv);
        loadImage.execute(url);
        myViewHolder.title.setText(news.get(position).getTitle());
        myViewHolder.from.setText(news.get(position).getFrom());
        if(news.get(position).getSentimentAnalysis().equals("-1")) {
            myViewHolder.relativeLayout.getBackground().setColorFilter(Color.parseColor("#e6e6ff"), PorterDuff.Mode.DARKEN);
        }else if(news.get(position).getSentimentAnalysis().equals("1")){
            myViewHolder.relativeLayout.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.DARKEN);
        }

    }



    @Override
    public int getItemCount() {
        return news.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView title,from;
        RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.news_info_image_view);
            title = itemView.findViewById(R.id.news_info_title);
            from=itemView.findViewById(R.id.news_info_from);
            relativeLayout=itemView.findViewById(R.id.relative_layout);
        }
    }
    private class LoadImage extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;
        public LoadImage(ImageView iv) {
            this.imageView=iv;

        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url=strings[0];
            Bitmap bitmap=null;
            try{
                InputStream inputStream=new java.net.URL(url).openStream();
                bitmap= BitmapFactory.decodeStream(inputStream);
            }catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }

}
