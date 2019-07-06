package com.example.newschecker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = news.get(position).getToUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                //Intent.startActivity(i);

            }
        });
    }


    @Override
    public int getItemCount() {
        return news.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.news_info_image_view);
            title = itemView.findViewById(R.id.news_info_title);
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
