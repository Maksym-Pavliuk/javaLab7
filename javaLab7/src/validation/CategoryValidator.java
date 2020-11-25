package validation;

import java.util.List;
import java.util.ArrayList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<CategoryAttribute, String>{
	
	List<String> valueList = null;

	public boolean isValid(String category, ConstraintValidatorContext context) {
		return valueList.contains(category.toUpperCase());
	}
	
	 public void initialize(CategoryAttribute constraintAnnotation) {
		 valueList = new ArrayList<String>();
	     Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz();
	     Enum[] enumArr = enumClass.getEnumConstants();
	     for (Enum enumVal : enumArr) {
	        valueList.add(enumVal.toString().toUpperCase());
	     }
	 }
}
