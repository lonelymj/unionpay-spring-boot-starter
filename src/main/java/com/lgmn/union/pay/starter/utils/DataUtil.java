package com.lgmn.union.pay.starter.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    public static String getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
