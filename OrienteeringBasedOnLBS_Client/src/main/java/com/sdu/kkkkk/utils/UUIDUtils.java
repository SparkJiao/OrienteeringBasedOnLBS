package com.sdu.kkkkk.utils;

import java.util.UUID;

/**
 * Created by kkkkk on 2018/6/9.
 */
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
