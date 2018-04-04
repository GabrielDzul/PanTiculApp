package com.kokomusoft.panticul.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Created by Gabriel on 25/04/2015.
 */
public class Post {
    private static final String TAG = "Post";

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;
    @SerializedName("preview")
    private String preview;
    @SerializedName("body")
    private String body;
    @SerializedName("url")
    private String url;
    @SerializedName("date")
    private Date date;

    public Post(long id, String title, String preview, String body, String url,
                Date date) {
        this.id = id;
        this.title = title;
        this.preview = preview;
        this.body = body;
        this.url = url;
        this.date = date;
    }

    /**
     * Returns the body of the Post in a way that is better handled by WebViews.
     * @return
     */
    public String getURLEncodedBody() {
        try {
            return URLEncoder.encode(body, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException ex) {
            Log.i(TAG, "Failed to encode Post body due to: " + ex);
            return null;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
