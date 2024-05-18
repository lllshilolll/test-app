package org.example.spring.zoo.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//жизненный цикл аннотации
//SOURCE - присутствовать только в исходном коде,
//CLASS - в скомпилированном файле
//RUNTIME - будет также видна и в процессе выполнения.
@Retention(RetentionPolicy.RUNTIME)
//что именно мы можем пометить этой аннотацией
@Target(ElementType.METHOD)
public @interface AspectAnnotation {
}
