package br.com.zeng.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.vraptor.util.test.JSR303MockValidator;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.zeng.model.User;

public class UserValidatorTest {

	private JSR303MockValidator validator;
	private UserValidator userValidator;
	
	@Before
	public void setUp(){
		validator = new JSR303MockValidator();
		CPFValidator cpfValidator = new CPFValidator();
		userValidator = new UserValidator(validator, cpfValidator);
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
	
	@Test
	public void shouldReturnValidationErrorForInvalidCpf() {
		try {
			User leonardo = new User("Leonardo", "leo@leo.com", "123", "123.123.123-12");
			userValidator.validate(leonardo);
			fail("Não deveria validar");
		} catch (ValidationException e) {
			assertEquals(1, e.getErrors().size());
		}
	}
	
	@Test
	public void shouldNotReturnValidationErrorForValidCpf() {
		try {
			User leonardo = new User("Leonardo", "leo@leo.com", "123", "346.198.228-84");
			userValidator.validate(leonardo);
		} catch (ValidationException e) {
			fail("Deveria validar");
		}
	}
	
}
