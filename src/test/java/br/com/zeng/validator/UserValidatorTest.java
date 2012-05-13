package br.com.zeng.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.util.test.JSR303MockValidator;
import br.com.caelum.vraptor.validator.ValidationException;

public class UserValidatorTest {

	private JSR303MockValidator validator;
	private UserValidator userValidator;
	
	@Before
	public void setUp(){
		validator = new JSR303MockValidator();
		userValidator = new UserValidator(validator);
	}
	
	@Test
	public void shouldReturnValidationErrorForNullUser() {
		try {
            userValidator.validate(null);
            fail("Não deveria validar");
        } catch (ValidationException e) {
            assertEquals(1, e.getErrors().size());
        }
	}
	
}
