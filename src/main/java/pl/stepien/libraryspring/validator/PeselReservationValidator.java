package pl.stepien.libraryspring.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeselReservationValidator
        implements ConstraintValidator<PeselValid, Long> {

    private static final String regexp = "^[0-9]{11}$";

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(aLong.toString());
        return matcher.find();
    }
}
