package com.moveon.blog_moveon.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MainUtil {

    public String getUUID() {
        String s = UUID.randomUUID().toString();
        String uuid = "";
        for (String s1 : s.split("-")) {
            uuid += s1;
        }
        return uuid;
    }

    public String DateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        return time;
    }
}
