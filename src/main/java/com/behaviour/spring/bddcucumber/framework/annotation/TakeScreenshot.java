package com.behaviour.spring.bddcucumber.framework.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TakeScreenshot {
}
