package com.cosis.crm.cash.annotation.core;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cosis.crm.cash.annotation.CosisLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
//@Component
public class CosisLogAspect {

    public static final String dateformat = "yyyy:MM:dd HH:mm:ss";
    public static final String STIRNG_START = ">>>";
    public static final String STIRNG_END = ">>>";
    //execution the scan of pakage 切点package
    @Pointcut("execution( * com.cosis.crm..*(..))")
    public void serviceLog(){

    }

    @Around("serviceLog()")
    public Object around(ProceedingJoinPoint joinPoint) { // ProceedingJoinPoint 为JoinPoint 的子类，在父类基础上多了proceed()方法，用于增强切面
        try {
            // 获取方法签名
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            //java reflect相关类，通过反射得到注解
            Method method = signature.getMethod();
            Class<?> targetClass = method.getDeclaringClass();

            StringBuffer classAndMethod = new StringBuffer();

            //获取类注解Log
            CosisLog classAnnotation = targetClass.getAnnotation(CosisLog.class);
            //获取方法注解Log
            CosisLog methodAnnotation = method.getAnnotation(CosisLog.class);

            //如果类上Log注解不为空，则执行proceed()
            if (classAnnotation != null) {
                if (classAnnotation.ignore()) {
                    //proceed() 方法执行切面方法，并返回方法返回值
                    return joinPoint.proceed();
                }
                log.info(" classAnnotation classAnnotation.topic() : {}", classAnnotation.topic());
                classAndMethod.append(classAnnotation.topic()).append("-");
            }

            //如果方法上Log注解不为空，则执行proceed()
            if (methodAnnotation != null) {
                if (methodAnnotation.ignore()) {
                    return joinPoint.proceed();
                }
                log.info(" methodAnnotation classAnnotation.topic() : {}", methodAnnotation.topic());
                classAndMethod.append(methodAnnotation.topic());
            }

            //拼凑目标类名和参数名
            String target = targetClass.getName() + "#" + method.getName();
            String params = JSONObject.toJSONStringWithDateFormat(joinPoint.getArgs(), dateformat, SerializerFeature.WriteMapNullValue);

            log.info(STIRNG_START + "{} 开始调用--> {} 参数:{}", classAndMethod.toString(), target, params);

           // log.info(STIRNG_START + "begin 方法:{} 参数:{}", target, params);

            long start = System.currentTimeMillis();
            //如果类名上和方法上都没有Log注解，则直接执行 proceed()
            Object result = joinPoint.proceed();
            long timeConsuming = System.currentTimeMillis() - start;

            log.info(STIRNG_END + "end 方法:{}, 返回值:{}  耗时:{}ms " , target, JSONObject.toJSONStringWithDateFormat(result, dateformat), timeConsuming);
            return result;
        } catch (Throwable throwable) {
            log.error(throwable.getMessage(), throwable);
        }
        return null;
    }
}

