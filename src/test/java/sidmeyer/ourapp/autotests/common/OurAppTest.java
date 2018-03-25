package sidmeyer.ourapp.autotests.common;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import sidmeyer.ourapp.autotests.steps.RegistrationFormSteps;

/**
 * Родительский класс для тестовых классов. Содержит общие ресурсы всех тестовых классов
 * @author Sid Meyer
 */
@RunWith(ThucydidesRunner.class)
@Concurrent(threads = "1")
public abstract class OurAppTest {

	@Managed(uniqueSession = true)
	private WebDriver driver;

	@ManagedPages(defaultUrl = Settings.APP_BASE_URL)
	public Pages pages;

	@Steps
	protected RegistrationFormSteps registrationFormSteps;

	@Before
	public void beforeTest() {
		driver.manage().window().maximize();
	}

	@After
	public void afterTest() {
		driver.close();
	}

}
