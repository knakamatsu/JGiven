package com.tngtech.jgiven.tags;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.tngtech.jgiven.annotation.IsTag;

@Feature
@IsTag( value = "JUnit",
    description = "tests can be be executed with JUnit" )
@Retention( RetentionPolicy.RUNTIME )
public @interface FeatureJUnit {

}
