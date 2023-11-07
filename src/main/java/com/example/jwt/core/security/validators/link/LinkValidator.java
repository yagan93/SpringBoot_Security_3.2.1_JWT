package com.example.jwt.core.security.validators.link;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

@Component
public class LinkValidator implements ConstraintValidator<Link, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});

    return urlValidator.isValid(value);
  }
}




