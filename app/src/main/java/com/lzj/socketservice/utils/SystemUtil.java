package com.lzj.socketservice.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by lzj on 2019/5/20
 * Describe ：注释
 */
public class SystemUtil {

    /**
     *  获取系统今日
     * @return
     */
    public static String getDayTime(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
        String newData = sdf.format(d);
        return newData;
    }

    /** 屏幕分辨率高 **/
    public static int getScreenHeightFen(Activity paramActivity) {
        Display display = paramActivity.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        return metrics.heightPixels;
    }
    /** 屏幕分辨率高 **/
    public static int getScreenWidthFen(Activity paramActivity) {
        Display display = paramActivity.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        return metrics.widthPixels;
    }
    /**
     * 替换空格
     * @param str
     * @return
     */
    public static String replaceStr(String str){
        String s=str.replaceFirst(" ","_");

       return s.replaceFirst(":","-");
    }

    /**
     *  获取当前系统时间 精确到秒
     * @return
     */
    public static String newDataTime(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newData = sdf.format(d);
        MLog.i("test","--------------现在日期：" + newData);
        return newData;
    }

    /**
     *  获取当前系统时间 精确到秒
     * @return
     */
    public static String newDataTime2(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String newData = sdf.format(d);
        return newData;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    /**
     * 将数组 拼接为字符串
     */
     public static String listToString(List<String> list){
         if(list!=null){
             if(list.size()==0){
                 return "";
             }
             String split="#";
             StringBuilder strBuilder=new StringBuilder();
             for (int i=0;i<list.size();i++){
                 strBuilder.append(list.get(i)).append( split );
             }
             return strBuilder.toString();
         }
         return "";
     }

    /**
     * 将字符串 截断为数组
     * @param strList
     * @return
     */
     public static List<String> stringTolist(String strList){
         if(!strList.equals("")){
             String split="#";
             return Arrays.asList(strList.split(split));
         }
         return null;
     }
}
