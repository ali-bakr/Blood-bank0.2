package com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_articles;


public class ArticleRecyclerView {


    private String caption_article;
    private  String image;
    private int image_favourit;


    public ArticleRecyclerView(String caption_article, String image, int image_favourit) {
        this.caption_article = caption_article;
        this.image = image;
        this.image_favourit = image_favourit;
    }
 /*   public void Changtext(String t1){

caption_article=t1;
    }
   */
    public void setImage_favourit(int image_favourit) {
        this.image_favourit = image_favourit;
    }

    public int getImage_favourit() {
        return image_favourit;
    }

    public String getCaption_article() {
        return caption_article;
    }

    public String getImage() {
        return image;
    }

    public void setCaption_article(String caption_article) {
        this.caption_article = caption_article;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
