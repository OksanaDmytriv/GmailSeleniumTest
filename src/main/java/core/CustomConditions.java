package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class CustomConditions {

    public static ExpectedCondition<Boolean> minimumSizeOf(final By elementsLocator, final int minimumSize) {
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            private List<WebElement> results;

            public Boolean apply(WebDriver webDriver) {
                results = webDriver.findElements(elementsLocator);
                listSize = results.size();
                return listSize >= minimumSize;
            }

            public String toString() {
                return String.format("\nsize of list: %s\n minimum size should be: %s\n while actual size is: %s\n", results, minimumSize, listSize);

            }
        };
    }

    public static ExpectedCondition<Boolean> emailContainText(final By elementsLocator, final String text) {
        return new ExpectedCondition<Boolean>() {
            private String listText;
            private WebElement result;

            public Boolean apply(WebDriver webDriver) {
                result = webDriver.findElement(elementsLocator);
                listText = result.getText();
                if (listText.contains(text)) return true;
                else return false;
            }

            public String toString() {
                return String.format("\ntext of list: %s\n should be: %s\n while actual text is: %s\n", result, text, listText);

            }
        };
    }

    public static ExpectedCondition<Boolean> emailsContainText(final By elementsLocator, final String text) {
        return new ExpectedCondition<Boolean>() {
            private String listText;
            private List<WebElement> results;

            public Boolean apply(WebDriver webDriver) {
                results = webDriver.findElements(elementsLocator);
                listText = results.toString();
                if (listText.contains(text)) return true;
                else return false;
            }

            public String toString() {
                return String.format("\ntexts of list: %s\n should be: %s\n while actual text is: %s\n", results, text, listText);

            }
        };
    }
}
