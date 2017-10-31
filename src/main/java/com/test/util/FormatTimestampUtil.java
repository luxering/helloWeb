package com.test.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ${user}
 * Date: ${date}
 * Time: ${time}
 * To change this template use File | Settings | File Templates.
 */
public class FormatTimestampUtil {
    public static Timestamp formatTimestamp(Timestamp timestamp){
        System.out.println("timestamp=="+timestamp);//  timestamp==2017-10-25 14:08:59.0
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String string = simpleDateFormat.format(new Date(timestamp.getTime()));
        System.out.println("string=="+string);//    string==2017-10-25 14:08:59
        Timestamp timestamp1 = Timestamp.valueOf(string);
        System.out.println("time==="+timestamp1);// time===2017-10-25 14:08:59.0
        return timestamp1;
    }
}
