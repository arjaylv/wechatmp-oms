package com.sftxy.wechatmp.sdk.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.exception.WechatSDKException;
import com.sftxy.wechatmp.sdk.model.Authorization;
import com.sftxy.wechatmp.sdk.model.Media;
import com.sftxy.wechatmp.sdk.model.MimeType;
import com.sftxy.wechatmp.sdk.util.PropertiesUtil;
import com.sftxy.wechatmp.sdk.util.RequestUtil;

public class MediaClient extends BaseClient{

    private static final String FORM_DATA_NAME = "media";

    /**
     * image: 128K JPF <br/>
     * voice: 256K AMR length < 60s <br/>
     * video: 1MB MP4 <br/>
     * thumb: 64K JPG <br/>
     * Tip: all media life cycle is 3 days
     * @throws WechatSDKException 
     */
    public Media uploadMediaMaterial(Authorization authorization, String filePath, MimeType mimeType) throws WechatSDKException {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        params.put(Constants.ARG_MEDIA_TYPE, mimeType.toString());
        String uploadMediaApi = PropertiesUtil.getAPI(Constants.API_MEDIA_UPLOAD);
        String result = RequestUtil.uploadMaterial(uploadMediaApi, params, FORM_DATA_NAME, filePath);
        Media media = this.wrapModel(result, Media.class);
        return media;
    }

    /**
     * the image page
     * @param mediaId
     * @return HttpResponse
     */
    public HttpResponse downloadMeidaMaterial(Authorization authorization, String mediaId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        params.put(Constants.ARG_MEDIA_ID, mediaId);
        String downloadMediaApi = PropertiesUtil.getAPI(Constants.API_MEDIA_DOWNLOAD);
        HttpResponse response = RequestUtil.doGetResource(downloadMediaApi, params);
        return response;
    }

}
