package com.zero.test;

import java.lang.reflect.Constructor;

public class ClassTest {

	public static void main(String[] args) throws Exception, IllegalAccessException {
		String s = "slkjdf";
		Class<?> klass = s.getClass();
		Constructor constructor = klass.getConstructor(String.class);
		Object obj = constructor.newInstance("123456");
		System.out.println("新对象："+obj);
		
		
	}
class MethodClass {
	int add(int a, int b){
		return a + b;
	}
}
}
