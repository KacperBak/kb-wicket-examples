package de.kacperbak.chapter10;

import de.kacperbak.beans.Address;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

/**
 * User: bakka
 * Date: 30.06.13
 */
public class MemmingenCityValidator implements IValidator<String> {

    private static final String CITY_MEMMINGEN = "memmingen";

    @Override
    public void validate(IValidatable<String> validatable) {
        String city = validatable.getValue();
        if(!cityIsMemmingen(city)){
            validatable.error(new ValidationError(this));
        }
    }

    private boolean cityIsMemmingen(String city){
        return (city.equalsIgnoreCase(CITY_MEMMINGEN)) ? true : false;
    }

}
