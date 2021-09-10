package com.coinker.websocket;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class SpringbootWebsocketApplicationTests {

    @Test
    void contextLoads() {
    }

    class Solution {
        public boolean isUnique(String astr) {
            Set<Byte> hashSet = new HashSet<>();
            byte[] strbyte = astr.getBytes(StandardCharsets.UTF_8);
            for (byte aByte : strbyte) {
                hashSet.add(aByte);
            }
            return strbyte.length == hashSet.size();
        }
    }

}
