package core;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.List;

public class CustomConditions {

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

    public static ExpectedCondition<Boolean> textsOf(final List<WebElement> elements, final String... texts) {
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            private List<String> currentTexts;

            public Boolean apply(WebDriver webDriver) {
                listSize = elements.size();
                currentTexts = new ArrayList<String>();
                for (int a = 0; a < listSize; ++a) {
                    currentTexts.add(a, elements.get(a).getText());
                }
                if (listSize != texts.length) {
                    return false;
                } else {
                    for (int i = 0; i < texts.length; ++i) {
                        WebElement element = elements.get(i);
                        String text = texts[i];
                        if (!element.getText().contains(text)) {
                            return false;
                        }
                    }
                    return true;
                }
            }


            public String toString() {
                return String.format("\ntext of list: %s\n should be: %s\n while actual text is: %s\n", texts);

            }
        };
    }


    public static ExpectedCondition<Boolean> listNthElementHasText(final List<WebElement> elements,
                                                                   final int index, final String text) {
        return new ExpectedCondition<Boolean>() {
            String e;

            public Boolean apply(WebDriver webDriver) {
                try {
                    e = elements.get(index).getText();
                    return (e.contains(text)) ? true : false;
                } catch (StaleElementReferenceException var3) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\ntext of element should be: %s\n while actual text is: %s\n", text, e);

            }
        };
    }

}
