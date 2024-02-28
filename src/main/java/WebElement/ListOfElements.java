package WebElement;

import Utils.IntegerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListOfElements extends BaseElement {
    private static String type = "List of Element";
    private int attempts = 0;
    private int time = 2;

    public ListOfElements(By by, String name) {
        super(by, type, name);
    }

    public List<WebElement> getListOfElement() {
        List<WebElement> returnedList = null;
        while (attempts < time) {
            try {
                returnedList = driver.findElements(super.getBy());
                break;
            } catch (StaleElementReferenceException e) {
                e.getMessage();
            }
            attempts++;
        }
        return returnedList;
    }

    public int getNumberOfElement() {
        return getListOfElement().size();
    }

    public void selectAnyItemInList() {
        if (getNumberOfElement() == 1) {
            getListOfElement().get(0).click();
        } else if (getNumberOfElement() > 1) {
            getListOfElement().get(IntegerUtil.randomIntegerInRange(0, getNumberOfElement() - 1)).click();
        } else {
            throw new IndexOutOfBoundsException(">>>>>> Item List Is Empty");
        }
    }

    public void selectFirstItemInList() {
        try {
            getListOfElement().get(0).click();
        } catch (StaleElementReferenceException e) {
            getListOfElement().get(0).click();
        }
    }
}
