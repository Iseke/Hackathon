package com.example.newschecker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class News_adapter extends ArrayAdapter<News> {
    ArrayList<News> news;
    public News_adapter(@NonNull Context context, ArrayList<News> c) {

        super(context, R.layout.news_info);
        news=c;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") View news_view=inflater.inflate(R.layout.news_info,parent,false);

        ImageView iv = news_view.findViewById(R.id.news_info_image_view);
        TextView title = news_view.findViewById(R.id.news_info_title);
        String url=news.get(position).getPictureURL();
        LoadImage loadImage=new LoadImage(iv);
        loadImage.execute(url);
        title.setText(news.get(position).getTitle());
        return news_view;

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
    @Override
    public int getCount() {
        return news.size();
    }
}
