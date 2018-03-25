package sidmeyer.ourapp.autotests.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import sidmeyer.ourapp.autotests.common.Settings;

/**
 * класс, описывающий страницу с формой регистрации
 */
@At(Settings.REGISTRATION_FORM_URL)
public class RegistrationFormPage extends PageObject {

	public RegistrationFormPage(WebDriver driver) {
		super(driver, 8000);
	}

	private static final String BIRTHDAY_DATA_ID = "1236342938";
	private static final String NAME_DATA_ID = "1645109785";
	private static final String GENDER_DATA_ID = "454110266";
	private static final String MOOD_DATA_ID = "1001784558";

	@FindBy(css = ".freebirdFormviewerViewHeaderTitle")
	private WebElementFacade formTitle;

	@FindBy(css = ".freebirdFormviewerViewItemsTextEmail input")
	private WebElementFacade emailField;

	@FindBy(css = "div[data-item-id='" + BIRTHDAY_DATA_ID + "'] input.quantumWizTextinputPaperinputInput")
	private WebElementFacade birthdayField;

	@FindBy(css = "div[data-item-id='" + NAME_DATA_ID + "'] input.quantumWizTextinputPaperinputInput")
	private WebElementFacade nameField;

	@FindBy(css = "div[data-item-id='" + GENDER_DATA_ID + "'] .quantumWizMenuPaperselectOptionList")
	private WebElementFacade genderField;

	@FindBy(css = "div[data-item-id='1001784558'] > div:nth-child(3)")
	private WebElementFacade moodField;

	@FindBy(css = ".quantumWizButtonPaperbuttonEl")
	private WebElementFacade sendFormButton;

	@FindBy(css = ".freebirdFormviewerViewEmailCollectionField div.freebirdFormviewerViewItemsItemErrorMessage")
	private WebElementFacade errorMessageForEmailField;

	@FindBy(id = "i.err." + BIRTHDAY_DATA_ID)
	private WebElementFacade errorMessageForBirthdayField;

	@FindBy(id = "i.err." + NAME_DATA_ID)
	private WebElementFacade errorMessageForNameField;

	@FindBy(id = "i.err." + GENDER_DATA_ID)
	private WebElementFacade errorMessageForGenderField;

	@FindBy(id = "i.err." + MOOD_DATA_ID)
	private WebElementFacade errorMessageForMoodField;

	public String getFormTitle() {
		return formTitle.getText();
	}

	public void enterEmail(final String email) {
		enter(email).into(emailField);
	}

	/**
	 * @param birthday use format depends on browser locale: DD.MM.YYYY or MM.DD.YYYY
	 */
	public void setBirthdayField(final String birthday) {
		birthdayField.sendKeys(birthday.replaceAll("\\.", ""));
	}

	public void enterName(final String name) {
		enter(name).into(nameField);
	}

	public void setGender(final Genders gender) {
		clickOn(genderField);
		waitFor("(//content[text()='Женский'])[2]");
		switch(gender) {
			case MALE:
				clickOn(find(By.xpath("(//content[text()='Мужской'])[2]")));
				break;
			case FEMALE:
				clickOn(find(By.xpath("(//content[text()='Женский'])[2]")));
				break;
			case NOT_SET:
				clickOn(find(By.xpath("(//content[contains(@class,'quantumWizMenuPaperselectContent')])[1]")));
				break;
		}
	}

	public void setMood(final String customOption, final String... moods) {
		for (String mood : moods) {
			clickOn(moodField.findElement(By.xpath("//span[text()='" + mood + "']")));
		}

		if (null != customOption) {
			enter(customOption).into(moodField.findElement(By.cssSelector("input.quantumWizTextinputSimpleinputInput")));
		}
	}

	public void clickSendFormButton() {
		clickOn(sendFormButton);
	}

	public WebElementFacade getErrorMessageForEmailFieldElement() {
		return errorMessageForEmailField.waitUntilPresent();
	}

	public WebElementFacade getErrorMessageForBirthdayFieldElement() {
		return errorMessageForBirthdayField.waitUntilPresent();
	}

	public WebElementFacade getErrorMessageForNameFieldElement() {
		return errorMessageForNameField.waitUntilPresent();
	}

	public WebElementFacade getErrorMessageForGenderFieldElement() {
		return errorMessageForGenderField.waitUntilPresent();
	}

	public WebElementFacade getErrorMessageForMoodFieldElement() {
		return errorMessageForMoodField.waitUntilPresent();
	}

	public enum Genders {
		MALE, FEMALE, NOT_SET
	}

}
