package com.sftxy.wechatmp.irs.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sftxy.wechatmp.framework.processor.Processor;
import com.sftxy.wechatmp.irs.util.ValidationUtil;
import com.sftxy.wechatmp.sdk.client.MessageConverterClient;
import com.sftxy.wechatmp.sdk.model.message.Message;

@Controller
public class WechatmpController {
    private static Logger logger = LoggerFactory.getLogger(WechatmpController.class);

    @Resource(name = "processors")
    private Map<String, Processor<? extends Message>> processors;

    @Resource(name = "messageConverterClient")
    private MessageConverterClient messageConverterClient;

    @RequestMapping(value = "/wechat/{tenantUid}", method = RequestMethod.GET)
    @ResponseBody
    public String validate(@PathVariable String tenantUid, @RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce, @RequestParam String echostr) throws IOException {
        String token = null; // TODO
        if (StringUtils.hasText(signature) && StringUtils.hasText(timestamp) && StringUtils.hasText(nonce) && StringUtils.hasText(echostr)) {
            if (ValidationUtil.validate(signature, timestamp, nonce, token)) {
                return echostr;
            }
        }
        return "This is an attack";
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "/wechat/{tenantUid}", method = RequestMethod.POST)
    @ResponseBody
    public String handle(@PathVariable String tenantUid, @RequestBody String body) throws IOException {
        Message input = messageConverterClient.xml2Message(body);

        String msgType = input.getMessageType();
        Processor processor = processors.get(msgType);

        if (null == processor) {
            logger.warn(String.format("No Processor specified for this MsgType => [%s]", msgType));
            return null;
        }

        Message output = processor.process(input);
        return null == output ? null : output.toXML();
    }

}
