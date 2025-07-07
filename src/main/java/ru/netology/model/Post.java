package ru.netology.model;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    private long id;

    @SerializedName("content")
    private String content;

    public Post(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}