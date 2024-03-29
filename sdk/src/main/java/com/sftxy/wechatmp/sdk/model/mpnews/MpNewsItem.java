package com.sftxy.wechatmp.sdk.model.mpnews;

public class MpNewsItem {

    private String title;
    private String author;
    private String digest;
    private String content;
    private String contentSourceUrl;
    private String thumbMediaId;

    private static final String EMPTY_STR = "";

    public MpNewsItem() {}

    public MpNewsItem(String title, String author, String digest, String content, String contentSourceUrl, String thumbMediaId) {
        this.title = title;
        this.author = null == author ? EMPTY_STR : author;
        this.digest = null == digest ? EMPTY_STR : digest;
        this.content = content;
        this.contentSourceUrl = null == contentSourceUrl ? EMPTY_STR : contentSourceUrl;
        this.thumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = null == author ? EMPTY_STR : author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = null == digest ? EMPTY_STR : digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = null == contentSourceUrl ? EMPTY_STR : contentSourceUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    private static final String MP_NEWS_TEMPLATE= 
            "{" + "\n" +
                    "\"title\":\"%s\"," + "\n" +
                    "\"author\":\"%s\"," + "\n" +
                    "\"digest\":\"%s\"," + "\n" +
                    "\"content\":\"%s\"," + "\n" +
                    "\"content_source_url\":\"%s\"," + "\n" +
                    "\"thumb_media_id\":\"%s\"" + "\n" +
            "}" + "\n";

    public String toJSON() {
        return String.format(MP_NEWS_TEMPLATE, title, author, digest, content, contentSourceUrl, thumbMediaId);
    }
}
