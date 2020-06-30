package com.guilherm.hearthstone.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String descodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
    public static Integer descodeParamInt(Integer tipo){
        try {
            return Integer.valueOf(URLDecoder.decode(String.valueOf(tipo), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return Integer.valueOf("");
        }
    }
    public static Date convertDate(String textDate, Date defaultValue) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return simpleDateFormat.parse(textDate);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
