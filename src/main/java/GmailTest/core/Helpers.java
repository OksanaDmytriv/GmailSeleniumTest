package GmailTest.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Helpers {

    public abstract WebDriver getWebDriver();

    public void assertThis(ExpectedCondition<Boolean> condition) {
       (new WebDriverWait(getWebDriver(), 6)).until(condition);
    }

    public void assertThat(ExpectedCondition<WebElement> condition) {
        (new WebDriverWait(getWebDriver(), 6)).until(condition);
    }

    public WebElement $(By locator) {
        return getWebDriver().findElement(locator);
    }

    public WebElement $(String cssSelector) {
        return getWebDriver().findElement(By.cssSelector(cssSelector));
    }

    public static String getUniqueText(String prefix) {
        return (prefix + " " + System.currentTimeMillis());
    }
}
