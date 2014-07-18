package com.sftxy.wechatmp.sdk.model.mpnews;

import java.util.Iterator;
import java.util.List;

public class MpNewsOidsArg {

    private List<String> openIds;
    private String mediaId;

    public MpNewsOidsArg() {}

    public MpNewsOidsArg(List<String> openIds, String mediaId) {
        this.openIds = openIds;
        this.mediaId = mediaId;
    }

    public List<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(List<String> openIds) {
        this.openIds = openIds;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    private static final String JSON_TEMPLATE = 
        "{\n" +
            "\"touser\":\n" +
                  "%s,\n" +
            "\"mpnews\":{\n" +
               "\"media_id\": \"%s\"\n" +
            "},\n" +
             "\"msgtype\":\"mpnews\"\n" +
        "}";

    public String toJSON() {
        String result = null;
        Iterator<String> it = openIds.iterator();
        if (!it.hasNext()) {
            result = "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[\"");
            String e = null;
            while (null != (e = it.next())) {
                sb.append(e);
                if (!it.hasNext()) {
                    result = sb.append("\"]").toString();
                    break;
                } else {
                    sb.append("\",\"");
                }
            }
        }
        return String.format(JSON_TEMPLATE, result, mediaId);
    }
}
