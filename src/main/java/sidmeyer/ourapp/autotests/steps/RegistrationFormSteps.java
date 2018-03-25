package sidmeyer.ourapp.autotests.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import sidmeyer.ourapp.autotests.common.Settings;
import sidmeyer.ourapp.autotests.pages.RegistrationFormPage;
import sidmeyer.ourapp.autotests.pages.RegistrationFormSuccessPage;

import static org.junit.Assert.*;

/**
 * класс, содержащий шаги, возможные на форме регистрации
 */
public class RegistrationFormSteps extends ScenarioSteps {

	public RegistrationFormSteps(Pages pages) {
		super(pages);
	}

	private RegistrationFormPage onRegistartionForm() {
		return pages().currentPageAt(RegistrationFormPage.class);
	}

	private RegistrationFormSuccessPage onRegistartionFormSuccessPage() {
		return pages().currentPageAt(RegistrationFormSuccessPage.class);
	}

	@Step
	public void goToRegistrationForm() {
		getDriver().navigate().to(Settings.REGISTRATION_FORM_URL);
	}

	@Step
	public void checkRegistartionFormTitle(final String title) {
		assertEquals(title, onRegistartionForm().getFormTitle());
	}

	@Step
	public void shouldBeAtRegistrationFormPage() {
		onRegistartionForm().getTitle();
	}

	@Step
	public void shouldBeAtRegistrationFormSuccessPage() {
		onRegistartionFormSuccessPage().getTitle();
	}

	@Step
	public void enterEmail(final String email) {
		onRegistartionForm().enterEmail(email);
	}

	@Step
	public void setBirthday(final String birthday) {
		onRegistartionForm().setBirthdayField(birthday);
	}

	@Step
	public void enterName(final String name) {
		onRegistartionForm().enterName(name);
	}

	@Step
	public void setGender(final RegistrationFormPage.Genders gender) {
		onRegistartionForm().setGender(gender);
	}

	@Step
	public void setMood(final String customOption, final String... moods) {
		onRegistartionForm().setMood(customOption, moods);
	}

	@Step
	public void sendForm() {
		onRegistartionForm().clickSendFormButton();
	}

	@Step
	public void formShouldBeSent() {
		shouldBeAtRegistrationFormSuccessPage();
		onRegistartionFormSuccessPage().shouldBeVisible(onRegistartionFormSuccessPage().getMessageElement());
	}

	@Step
	public void errorMessageForEmailShouldBeDisplayed() {
		onRegistartionForm().shouldBeVisible(onRegistartionForm().getErrorMessageForEmailFieldElement());
		assertFalse(onRegistartionForm().getErrorMessageForEmailFieldElement().getText().isEmpty());
	}

	@Step
	public void errorMessageForEmailShouldNotBeDisplayed() {
		onRegistartionForm().shouldNotBeVisible(onRegistartionForm().getErrorMessageForEmailFieldElement());
	}

	@Step
	public void errorMessageForBirthdayShouldBeDisplayed() {
		onRegistartionForm().shouldBeVisible(onRegistartionForm().getErrorMessageForBirthdayFieldElement());
		assertFalse(onRegistartionForm().getErrorMessageForBirthdayFieldElement().getText().isEmpty());
	}

	@Step
	public void errorMessageForBirthdayShouldNotBeDisplayed() {
		onRegistartionForm().shouldNotBeVisible(onRegistartionForm().getErrorMessageForBirthdayFieldElement());
	}

	@Step
	public void errorMessageForNameShouldBeDisplayed() {
		onRegistartionForm().shouldBeVisible(onRegistartionForm().getErrorMessageForNameFieldElement());
		assertFalse(onRegistartionForm().getErrorMessageForNameFieldElement().getText().isEmpty());
	}

	@Step
	public void errorMessageForNameShouldNotBeDisplayed() {
		onRegistartionForm().shouldNotBeVisible(onRegistartionForm().getErrorMessageForNameFieldElement());
	}

	@Step
	public void errorMessageForGenderShouldBeDisplayed() {
		onRegistartionForm().shouldBeVisible(onRegistartionForm().getErrorMessageForGenderFieldElement());
		assertFalse(onRegistartionForm().getErrorMessageForGenderFieldElement().getText().isEmpty());
	}

	@Step
	public void errorMessageForGenderShouldNotBeDisplayed() {
		onRegistartionForm().shouldNotBeVisible(onRegistartionForm().getErrorMessageForGenderFieldElement());
	}

	@Step
	public void errorMessageForMoodShouldBeDisplayed() {
		onRegistartionForm().shouldBeVisible(onRegistartionForm().getErrorMessageForMoodFieldElement());
		assertFalse(onRegistartionForm().getErrorMessageForMoodFieldElement().getText().isEmpty());
	}

	@Step
	public void errorMessageForMoodShouldNotBeDisplayed() {
		onRegistartionForm().shouldNotBeVisible(onRegistartionForm().getErrorMessageForMoodFieldElement());
	}

}
