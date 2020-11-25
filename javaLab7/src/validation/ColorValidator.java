package validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ColorValidator implements ConstraintValidator<ColorAttribute, String>{
		
	List<String> valueList = null;


	public boolean isValid(String category, ConstraintValidatorContext context) {
		return valueList.contains(category.toUpperCase());
	}
		

	public void initialize(ColorAttribute constraintAnnotation) {
		 valueList = new ArrayList<String>();
		 Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz();
		 Enum[] enumArr = enumClass.getEnumConstants();
		 for (Enum enumVal : enumArr) {
		 	valueList.add(enumVal.toString().toUpperCase());
		 }
	}
}
