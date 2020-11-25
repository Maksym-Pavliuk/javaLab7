package validation;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CategoryValidator.class)
public @interface CategoryAttribute {
	
	Class<? extends Enum<?>> enumClazz();
	String message() default "Invalid Input";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
