package com.yogi.annotations.ex1;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface TestParameters {
	String testStage();

	String testMethods();

	String testOutputType(); // “db” or “file”

	String testOutput(); // filename or data source/table name
}