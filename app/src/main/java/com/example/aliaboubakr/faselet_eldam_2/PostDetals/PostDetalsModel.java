package com.example.aliaboubakr.faselet_eldam_2.PostDetals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostDetalsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private PostDetalsData postDetalsData;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PostDetalsData getPostDetalsData() {
        return postDetalsData;
    }

    public void setData(PostDetalsData postDetalsData) {
        this.postDetalsData = postDetalsData;
    }



    public class Category {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


    public class PostDetalsData {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("publish_date")
        @Expose
        private String publishDate;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("thumbnail_full_path")
        @Expose
        private String thumbnailFullPath;
        @SerializedName("is_favourite")
        @Expose
        private Boolean isFavourite;
        @SerializedName("category")
        @Expose
        private Category category;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getThumbnailFullPath() {
            return thumbnailFullPath;
        }

        public void setThumbnailFullPath(String thumbnailFullPath) {
            this.thumbnailFullPath = thumbnailFullPath;
        }

        public Boolean getIsFavourite() {
            return isFavourite;
        }

        public void setIsFavourite(Boolean isFavourite) {
            this.isFavourite = isFavourite;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

    }



}
