package com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_articles;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;
import com.example.aliaboubakr.faselet_eldam_2.recyclerview.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Frag_Article extends Fragment {
int pages=1;

String apitokin="W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl";
private RecyclerView rv_articles;
private ArticlesCustomAdaptorr articlesCustomAdaptorr;
private  LinearLayoutManager llm ;
private ArrayList<ArticlesModel.Datum> arrayList;
private ProgressBar pArticles;
   //ArrayList<ArticleRecyclerView> articleRecyclerViews=new ArrayList<>();




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_frag__article,container,false);
       //thith line to be able to call fragment  by >> this.getActivity()
        super.onActivityCreated(savedInstanceState);
pArticles=v.findViewById(R.id.progressBararticles);
pArticles.setVisibility(View.INVISIBLE);

        rv_articles=v.findViewById(R.id.rv_articless);
        rv_articles.setHasFixedSize(true);
       rv_articles.setAdapter(articlesCustomAdaptorr);
//GetArticles();

/*articlesCustomAdaptorr.SetOnItemclickListener(new ArticlesCustomAdaptorr.OnItemclickListener() {
    @Override
    public void OnItemClick(int position) {
      Changeitem(position,"hellow ali am working");


    }
});
*/

return v;
    }
/*    public void Changeitem(int position,String t){

        articleRecyclerViews.get(position).Changtext(t);
articlesCustomAdaptorr.notifyItemChanged(position);
    }
*/



    private void getArticles(){
        pArticles.setVisibility(View.VISIBLE);
 Retrofit retrofit= RetrofitClient.getInstant();
    Api api=retrofit.create(Api.class);
    Call<ArticlesModel> ordersModelCall=api.getallArticles(apitokin,pages);
ordersModelCall.enqueue(new Callback<ArticlesModel>() {
    @Override
    public void onResponse(Call<ArticlesModel> call, Response<ArticlesModel> response) {
    pArticles.setVisibility(View.GONE);
        if (response.body().getStatus()==1){
          arrayList.addAll(response.body().getArticleData().getArticleData());
            rv_articles.setAdapter(articlesCustomAdaptorr);
            articlesCustomAdaptorr.notifyItemRangeInserted( articlesCustomAdaptorr.getItemCount(),arrayList.size());

           // response.body().getArticleData().getCurrentPage();

// articleB.putString("title",);
          //  articlesCustomAdaptorr=new ArticlesCustomAdaptorr(getActivity(), (ArrayList<ArticlesModel.Datum>) response.body().getArticleData().getArticleData());
            //rv_articles.setAdapter(articlesCustomAdaptorr);
        }
    }

    @Override
    public void onFailure(Call<ArticlesModel> call, Throwable t) {

    }
});


}


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        arrayList=new ArrayList<>();
        llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_articles.setItemAnimator(new DefaultItemAnimator());
        rv_articles.setLayoutManager(llm);
        articlesCustomAdaptorr = new ArticlesCustomAdaptorr(getContext(), arrayList);
        rv_articles.addOnScrollListener(new EndlessRecyclerViewScrollListener(llm) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                pages++;
                getArticles();
            }
        });
        getArticles();

    }

}