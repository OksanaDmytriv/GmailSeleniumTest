package core;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomConditions {

    public static ExpectedCondition<Boolean> textsOf(final List<WebElement> elements, final String... texts) {
        return new ExpectedCondition<Boolean>() {
            private List<String> currentTexts;

            public Boolean apply(WebDriver webDriver) {
                currentTexts = new ArrayList<String>();
                for (int i = 0; i < elements.size(); ++i) {
                    currentTexts.add(i, elements.get(i).getText());
                }
                if (currentTexts.size() != texts.length) {
                    return false;
                } else {
                    for (int i = 0; i < texts.length; ++i) {
                        if (!currentTexts.get(i).contains(texts[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            public String toString() {
                return String.format("\ntext of list: %s\n should be: %s\n while actual text is: %s\n", Arrays.toString(texts), Arrays.toString(currentTexts.toArray()));
            }
        };
    }

    public static ExpectedCondition<Boolean> listNthElementHasText(final List<WebElement> elements,
                                                                   final int index, final String text) {
        return new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver webDriver) {
                try {
                    return (elements.get(index).getText().contains(text)) ? true : false;
                } catch (StaleElementReferenceException var3) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\ntext of element should be: %s\n while actual text is: %s\n", text, elements.get(index).getText());

            }
        };
    }

}
