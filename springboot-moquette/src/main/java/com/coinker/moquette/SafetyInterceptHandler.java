package com.coinker.moquette;

import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.messages.InterceptAcknowledgedMessage;
import io.moquette.interception.messages.InterceptConnectMessage;
import io.moquette.interception.messages.InterceptConnectionLostMessage;
import io.moquette.interception.messages.InterceptPublishMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Cui Shenpeng
 * @Classname SafetyInterceptHandler
 * @Description TODO
 * @Date 2021/9/26 17:41
 */
@Slf4j
@Component
public class SafetyInterceptHandler extends AbstractInterceptHandler {

    @Override
    public String getID() {
        return SafetyInterceptHandler.class.getName();
    }

    @Override
    public void onConnect(InterceptConnectMessage msg) {

    }

    @Override
    public void onConnectionLost(InterceptConnectionLostMessage msg) {

    }


    @Override
    public void onPublish(InterceptPublishMessage msg) {

    }


    @Override
    public void onMessageAcknowledged(InterceptAcknowledgedMessage msg) {

    }

}