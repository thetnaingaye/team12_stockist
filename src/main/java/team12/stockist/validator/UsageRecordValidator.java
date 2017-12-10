package team12.stockist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import team12.stockist.controller.Cart;

@Component
public class UsageRecordValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object object, Errors errors) {
		Cart cart = (Cart) object;
		
	}
	
	

}
