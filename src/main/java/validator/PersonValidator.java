package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import domain.Person;

public class PersonValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		
		return Person.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Person p = (Person) target;
        if (p.getAge() < 0) {
        	errors.rejectValue("age", "negativevalue");
        } else if (p.getAge() > 110) {
        	errors.rejectValue("age", "too.darn.old");
        }

	}

}
