# our-app-autotests

## Quick start
1. Specify path to chromedriver in `webdriver.chrome.driver` property in `pom.xml`.
2. `mvn clean verify thucydides:aggregate -Dmaven.test.failure.ignore=true`
3. See test reports in `target/site/thucydides/index.html`.

## Tested with
* Google Chrome 65.0.3325.181 64-bit
* ChromeDriver 2.37.544315
