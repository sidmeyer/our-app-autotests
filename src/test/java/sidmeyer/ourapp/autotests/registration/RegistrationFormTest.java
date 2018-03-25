package sidmeyer.ourapp.autotests.registration;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Story;
import org.junit.Test;
import sidmeyer.ourapp.autotests.OurApp;
import sidmeyer.ourapp.autotests.common.OurAppTest;
import sidmeyer.ourapp.autotests.pages.RegistrationFormPage;

/**
 * Тесты формы регистрации
 * имяена_тестовых_методов написаны с подчеркиваниями в соответствии с принятой для Thucydides практикой
 */
@Story(OurApp.Registration.Form.class)
public class RegistrationFormTest extends OurAppTest {

	@Test
	public void registration_form_should_be_available() {
		registrationFormSteps.goToRegistrationForm();
		registrationFormSteps.shouldBeAtRegistrationFormPage();
		registrationFormSteps.checkRegistartionFormTitle("Форма регистрации");
	}

	@Test
	public void it_should_be_possible_to_send_form_with_correct_data() {
		registrationFormSteps.goToRegistrationForm();
		registrationFormSteps.enterEmail("test.email@example.com");
		registrationFormSteps.setBirthday("02.12.1956");
		registrationFormSteps.enterName("Barry Seal");
		registrationFormSteps.setGender(RegistrationFormPage.Genders.MALE);
		registrationFormSteps.setMood("Not bad", "Хорошо", "Удовлетворительно");
		registrationFormSteps.sendForm();
		registrationFormSteps.formShouldBeSent();
	}

	@Test
	public void it_should_not_be_possible_to_send_form_when_error_message_is_displayed() {
//		check bad email
		registrationFormSteps.goToRegistrationForm();
		registrationFormSteps.enterEmail("test.emailexample.com"); // bad email
		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();
		registrationFormSteps.setBirthday("02.12.1956");
		registrationFormSteps.enterName("Barry Seal");
		registrationFormSteps.setGender(RegistrationFormPage.Genders.MALE);
		registrationFormSteps.setMood("Not bad", "Хорошо", "Удовлетворительно");
		registrationFormSteps.sendForm();
		registrationFormSteps.shouldBeAtRegistrationFormPage();

//		check bad name
		registrationFormSteps.enterEmail("test.email@example.com");
		registrationFormSteps.enterName("   ");
		registrationFormSteps.errorMessageForNameShouldBeDisplayed();
		registrationFormSteps.sendForm();
		registrationFormSteps.shouldBeAtRegistrationFormPage();

//		check bad mood
		registrationFormSteps.enterName("Barry Seal");
		registrationFormSteps.setMood("   ");
		registrationFormSteps.sendForm();
		registrationFormSteps.errorMessageForMoodShouldBeDisplayed();
		registrationFormSteps.sendForm();
		registrationFormSteps.shouldBeAtRegistrationFormPage();
	}

	@Test
	public void it_should_not_be_possible_to_send_form_with_empty_required_fields() {
		registrationFormSteps.goToRegistrationForm();
		registrationFormSteps.sendForm();
		registrationFormSteps.shouldBeAtRegistrationFormPage();
		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();
		registrationFormSteps.errorMessageForBirthdayShouldBeDisplayed();
		registrationFormSteps.errorMessageForNameShouldBeDisplayed();
		registrationFormSteps.errorMessageForGenderShouldBeDisplayed();
		registrationFormSteps.errorMessageForMoodShouldBeDisplayed();
	}

	@Test
	public void email_should_be_checked_properly() {
		registrationFormSteps.goToRegistrationForm();

		registrationFormSteps.enterEmail("test email@example.com");
		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();

		registrationFormSteps.enterEmail(" test.email@example.com ");
		registrationFormSteps.errorMessageForEmailShouldNotBeDisplayed();

		registrationFormSteps.enterEmail("test.email@examplecom");
		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();

		registrationFormSteps.enterEmail("<test.email@example.com");
		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();

		registrationFormSteps.enterEmail("test.email@example.com'");
		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();

//		registrationFormSteps.enterEmail("'test.email@example.com");
//		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();

		registrationFormSteps.enterEmail("тест.email@example.com");
		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();

		registrationFormSteps.enterEmail("test.email@example.com/");
		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();

//		registrationFormSteps.enterEmail("test.email@example.69");
//		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();

		registrationFormSteps.enterEmail("");
		registrationFormSteps.errorMessageForEmailShouldBeDisplayed();

		registrationFormSteps.enterEmail("123@example.com");
		registrationFormSteps.errorMessageForEmailShouldNotBeDisplayed();

		registrationFormSteps.enterEmail("Test_email@123.com");
		registrationFormSteps.errorMessageForEmailShouldNotBeDisplayed();

		registrationFormSteps.enterEmail("one.hundred.symbols.correct.email.address@very.very.very.very.very.very.very.long.domain.example.com");
		registrationFormSteps.errorMessageForEmailShouldNotBeDisplayed();
	}

	@Test
	@Pending
	public void birthday_should_be_checked_properly() {
	}

	@Test
	@Pending
	public void name_should_be_checked_properly() {
	}

	@Test
	@Pending
	public void custom_mood_should_be_checked_properly() {
	}

}
