package pl.stepien.libraryspring.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = PeselReservationValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
@Documented
public @interface PeselValid {
    String message() default "Please, provide a valid PESEL";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
