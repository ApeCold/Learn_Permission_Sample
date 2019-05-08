//package com.bsd.annotation;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Target(ElementType.METHOD)//该注解作用在方法之上
//@Retention(RetentionPolicy.CLASS)//在源码和class文件中都存在，编译器注解方式
//public @interface OnPermissionDenied {
//}
package cn.bsd.learn.permission.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Register some methods which permissions are needed.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface OnPermissionDenied {
}