package com.sftxy.wechatmp.sdk.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Ticket {

    private String ticket;
    @JsonProperty(value = "expire_seconds")
    private int expiredTime;

    public Ticket() {}

    public Ticket(String ticket, int expiredTime) {
        this.ticket = ticket;
        this.expiredTime = expiredTime;
    }

    public String getTicket() {
        return ticket;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

}
