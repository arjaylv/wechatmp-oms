package com.sftxy.wechatmp.sdk.model.mpnews;

public class MpNewsGroupArg {

    private int groupId;
    private String mediaId;

    public MpNewsGroupArg() {}

    public MpNewsGroupArg(int groupId, String mediaId) {
        this.groupId = groupId;
        this.mediaId = mediaId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    private static final String JSON_TEMPLATE = 
            "{\n" +
               "\"filter\":{\n" +
                  "\"group_id\":\"%d\"\n" +
               "},\n" +
               "\"mpnews\":{\n" +
                  "\"media_id\":\"%s\"\n" +
               "},\n" +
                "\"msgtype\":\"mpnews\"\n" +
            "}";

    public String toJSON() {
        return String.format(JSON_TEMPLATE, groupId, mediaId);
    }
}
