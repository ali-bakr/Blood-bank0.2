package com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_articles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aliaboubakr.faselet_eldam_2.PostDetals.PostDtals;
import com.example.aliaboubakr.faselet_eldam_2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ArticlesCustomAdaptorr extends RecyclerView.Adapter<ArticlesCustomAdaptorr.ViewHolder> {
    private Context ordContext;
ArrayList<ArticlesModel.Datum> ArticlesArrayList;
private OnItemclickListener mlistiner;
int postId;
    int pageId;

    public Intent articleI;
    public  Bundle articleB;
   // private URL newurl=null;
    //private Bitmap bitmap=null ;


    public ArticlesCustomAdaptorr(Context ordContext, ArrayList<ArticlesModel.Datum> articlesArrayList) {
        this.ordContext = ordContext;
        ArticlesArrayList = articlesArrayList;
    }


    // viewholder : class descripe views
    public   class ViewHolder extends RecyclerView.ViewHolder {

        public TextView rv_caption;
        public ImageView rv_articles_image;
        public ImageView rv_favourite_image;

        //constructor
        public ViewHolder(@NonNull View itemView, final OnItemclickListener listener) {

            super(itemView);
            rv_articles_image=itemView.findViewById(R.id.imag_article);
            rv_caption=itemView.findViewById(R.id.articl_caption);
            rv_favourite_image=itemView.findViewById(R.id.favv);

itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if (listener!=null){
          int position=getAdapterPosition();
          if (position!=RecyclerView.NO_POSITION)
listener.OnItemClick(position);
        }

    }
});
            // image favourite click
        }

        // interface
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       //تهيئة
      View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
      ViewHolder vHolder =new ViewHolder(v,mlistiner);
      //  articleI =new Intent(v.getContext(),PostDtals.class);

      return  vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        ArticlesModel.Datum current_item_articleRecyclerView=ArticlesArrayList.get(i);

Picasso.get().load(ArticlesArrayList.get(i).getThumbnailFullPath()).into(viewHolder.rv_articles_image);
        viewHolder.rv_favourite_image.setImageResource(R.drawable.favourit_icon);
        viewHolder.rv_caption.setText(ArticlesArrayList.get(i).getCategory().getName());
        viewHolder.rv_favourite_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.rv_favourite_image.setImageResource(R.drawable.ic_favorite_black_24dp);
            }
        });
       // articleI =new Intent(in,PostDtals.class);
        //articleB=new Bundle();
        //postId=ArticlesArrayList.get(i).getId();
       //pageId=ArticlesArrayList.indexOf(i);
       //articleB.putInt("post",postId);
     //   articleB.putInt("page",pageId);
        viewHolder.rv_articles_image.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      // item click

        AppCompatActivity activity = (AppCompatActivity) v.getContext();
        PostDtals postDtals = new PostDtals();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, postDtals).addToBackStack(null).commit();


    }
});

    }
    @Override
    public int getItemCount() { return ArticlesArrayList.size(); }



    public  interface OnItemclickListener{

        void OnItemClick(int position);

    }

    public  void  SetOnItemclickListener( OnItemclickListener listener  ) {
        mlistiner=listener;

    }
}
