//package com.bsd.library;
//
//import android.app.Activity;
//
//import com.netease.permission.library.listener.RequestPermission;
//
//public class PermissionManager {
//
//
//    public static void request(Activity activity,String[] permissions){
//        String className = activity.getClass().getName() + "$Permissions";
//        try {
//            Class<?> clazz = Class.forName(className);
//            RequestPermission rPermission = (RequestPermission) clazz.newInstance();
//            rPermission.requestPermission(activity,permissions);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void onRequestPermissionsResult(Activity activity,int requestCode,int[] grantResults){
//        String className = activity.getClass().getName() + "$Permissions";
//        try {
//            Class<?> clazz = Class.forName(className);
//            RequestPermission rPermission = (RequestPermission) clazz.newInstance();
//            rPermission.onRequestPermissionsResult(activity,requestCode,grantResults);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
package cn.bsd.learn.permission.library;

import android.app.Activity;
import android.support.annotation.NonNull;

import cn.bsd.learn.permission.library.listener.RequestPermission;


public class PermissionManager {

    public static void request(Activity activity, String[] permissions) {
        String className = activity.getClass().getName() + "$Permission";

        try {
            Class<?> clazz = Class.forName(className);
            RequestPermission rPermission = (RequestPermission) clazz.newInstance();
            rPermission.requestPermission(activity, permissions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull int[] grantResults) {
        String className = activity.getClass().getName() + "$Permission";

        try {
            Class<?> clazz = Class.forName(className);
            RequestPermission rPermission = (RequestPermission) clazz.newInstance();
            rPermission.onRequestPermissionsResult(activity, requestCode, grantResults);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

