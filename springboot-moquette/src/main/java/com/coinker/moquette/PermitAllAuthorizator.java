package com.coinker.moquette;

import io.moquette.broker.security.IAuthorizatorPolicy;
import io.moquette.broker.subscriptions.Topic;
import org.springframework.stereotype.Component;

/**
 * @author Cui Shenpeng
 * @Classname PermitAllAuthorizator
 * @Description TODO
 * @Date 2021/9/26 17:41
 */
@Component
public class PermitAllAuthorizator implements IAuthorizatorPolicy {
    @Override
    public boolean canWrite(Topic topic, String user, String client) {
        /**可以控制某个用户的client，是否具有发布某个主题的权限，目前默认任何Client可以发布任主题*/
        return true;
    }

    @Override
    public boolean canRead(Topic topic, String user, String client) {
        /**可以控制某个用户的client，是否具有接收某个主题的权限，目前默认任何Client可以接收任何主题*/
        return true;
    }
}