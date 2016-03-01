package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    public <V> void assertThat(ExpectedCondition<V> condition) {
        (new WebDriverWait(getWebDriver(), Configuration.timeout)).until(condition);
    }

    public WebElement $(By locator) {
        assertThat(visibilityOfElementLocated(locator));
        return getWebDriver().findElement(locator);
    }

    public WebElement $(String cssSelector) {
        return getWebDriver().findElement(By.cssSelector(cssSelector));
    }

    public void open(String URL) {
        getWebDriver().get(URL);
    }
}