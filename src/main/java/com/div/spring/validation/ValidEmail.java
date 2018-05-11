package com.div.spring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Div on 2018-05-11.
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {ValidEmailImpl.class}
)
public @interface ValidEmail {
    String message() default "This does not appear to be a valid email address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 10;
}