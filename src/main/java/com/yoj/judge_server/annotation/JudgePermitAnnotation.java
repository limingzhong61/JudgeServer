package com.yoj.judge_server.annotation;


import java.lang.annotation.*;

/**
 * validate if has right header of Judge-Permit
 */
@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取
@Target(ElementType.METHOD)//目标是方法
@Documented
public @interface JudgePermitAnnotation {
}
