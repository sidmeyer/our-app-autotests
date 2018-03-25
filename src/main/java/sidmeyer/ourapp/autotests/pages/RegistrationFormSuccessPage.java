package sidmeyer.ourapp.autotests.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import sidmeyer.ourapp.autotests.common.Settings;

/**
 * класс, описывающий страницу после отправки формы
 */
@At(Settings.REGISTRATION_FORM_SUCCESS_PAGE_URL)
public class RegistrationFormSuccessPage extends PageObject {

	public RegistrationFormSuccessPage(WebDriver driver) {
		super(driver, 20000);
	}

	@FindBy(css = ".freebirdFormviewerViewResponsePageTitle")
	private WebElementFacade formTitle;

	@FindBy(css = ".freebirdFormviewerViewResponseConfirmationMessage")
	private WebElementFacade message;

	@FindBy(css = ".freebirdFormviewerViewResponseLinksContainer > a")
	private WebElementFacade sendOneMoreResponseLink;

	public String getFormTitle() {
		return formTitle.getText();
	}

	public String getMessage() {
		return message.waitUntilVisible().getText();
	}

	public WebElementFacade getMessageElement() {
		return message.waitUntilVisible();
	}

	public void clickSendOneMoreResponseLink() {
		clickOn(sendOneMoreResponseLink);
	}

}
