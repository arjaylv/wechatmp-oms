package com.sftxy.wechatmp.sdk.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.exception.WechatSDKException;
import com.sftxy.wechatmp.sdk.model.Authorization;
import com.sftxy.wechatmp.sdk.model.Ticket;
import com.sftxy.wechatmp.sdk.model.TicketArgs;
import com.sftxy.wechatmp.sdk.util.PropertiesUtil;
import com.sftxy.wechatmp.sdk.util.RequestUtil;

public class QrCodeClient extends BaseClient {

    /**
     * request a ticket, the ticket can use to redeem the QR code
     * @param ticketArgs
     * @return Ticket
     * @throws WechatSDKException
     */
    public Ticket requestTicket(Authorization authorization, TicketArgs ticketArgs) throws WechatSDKException {
        String getTicketAPI = PropertiesUtil.getAPI(Constants.API_QRCODE_TICKET_CREATE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(getTicketAPI, params, ticketArgs.toString());
        Ticket ticket = this.wrapModel(result, Ticket.class);
        return ticket;
    }

    /**
     * the QR-Code image page
     * @param ticket
     * @return HttpResponse
     */
    public HttpResponse redeemTicket(Ticket ticket) {
        String redeemTicketAPI = PropertiesUtil.getAPI(Constants.API_QRCODE_TICKET_REDEEM);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_TICKET, ticket.getTicket());
        HttpResponse response = RequestUtil.doGetResource(redeemTicketAPI, params);
        return response;
    }

}
