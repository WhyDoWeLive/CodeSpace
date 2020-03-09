package com.wxs.codespace.AnnotationTest.CustomizedAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
    String message();
}
