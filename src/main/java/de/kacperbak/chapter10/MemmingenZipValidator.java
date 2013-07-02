package de.kacperbak.chapter10;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

/**
 * User: bakka
 * Date: 01.07.13
 */
public class MemmingenZipValidator implements IValidator<Integer> {

    private static final int ZIP_MEMMINGEN = 87700;

    @Override
    public void validate(IValidatable<Integer> validatable) {
        int zip = validatable.getValue();
        if(!zipIsMemmingen(zip)){
            ValidationError error = new ValidationError(this);
            error.setVariable("zipTip", ZIP_MEMMINGEN);
            validatable.error(error);
        }
    }

    private boolean zipIsMemmingen(int zip){
        return (zip == ZIP_MEMMINGEN) ? true : false;
    }
}
