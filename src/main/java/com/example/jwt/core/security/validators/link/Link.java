package com.example.jwt.core.security.validators.link;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = LinkValidator.class)
public @interface Link {

  String message() default "{javax.validation.constraints.Link.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}

