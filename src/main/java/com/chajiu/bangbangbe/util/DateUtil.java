package com.chajiu.bangbangbe.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String toCleanDate(Date date){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = dateFormat.format(date);
        return s;
    }

}
