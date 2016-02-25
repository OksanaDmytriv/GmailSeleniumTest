package v2402;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
    static WebDriver driver;

    public void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(driver, 6)).until(condition);
    }

    public WebElement $(By locator) {
        return driver.findElement(locator);
    }

    public WebElement $(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public static String getUniqueText(String prefix) {
        return (prefix + " " + System.currentTimeMillis());
    }
}
