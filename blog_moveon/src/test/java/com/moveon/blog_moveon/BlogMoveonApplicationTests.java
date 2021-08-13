package com.moveon.blog_moveon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class BlogMoveonApplicationTests {

    @Test
    void contextLoads() {
        String uuids = UUID.randomUUID().toString();
        String uuid = "";
        for (String s : uuids.split("-")) {
            uuid += s;
        }
        System.out.println(uuid);
    }

}
