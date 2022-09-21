package com.example.tablebooking.validation;

import com.example.tablebooking.validation.impl.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordValid {
    String message() default "confirmed password is different than password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
