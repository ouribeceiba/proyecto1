package co.ceiba.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import co.ceiba.domains.Person;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;

@RunWith(MockitoJUnitRunner.class)
public class NotifyPersonServiceTest {	
	
	@Mock
	private EmailService emailService;
	
	@InjectMocks
	private NotifyPersonService notifyPersonService;
	
	@Before
	public void setUp() {
		
		//Con anotaciones esto no es necesario porque el @InjectMonck hace la inyección
		//emailService = Mockito.mock(EmailService.class);
		//notifyPersonService = new NotifyPersonService(emailService);		
	}

	@Test
	public void notifyTest() {
		//Arrange
		Person person = new PersonTestDataBuilder().build();
		//Act
		Mockito.when(emailService.sendMail(Mockito.anyString())).thenReturn("Hola mundo");
		String message = notifyPersonService.notify(person);
		//Assert
		Assert.assertNotNull(message);
	}

}
