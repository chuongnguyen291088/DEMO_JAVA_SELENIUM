package Pages.SonyDemo;

import WebElement.ListOfElements;
import WebElement.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SonyCartPage extends BaseSonyDemoPage {

    private final static By by = new By.ByXPath("//div[@class='cart']");
    private final static String name = "Sony Cart Page";

    //locators
    private final String xpath_cartItemList = "//div/h3[contains(@class,'cart-item') and not (contains(@class,'mini'))]";
    private final String xpath_lblCartItem = "//div/h3[contains(@class,'cart-item') and not (contains(@class,'mini'))]/a[contains(text(),'%s')]";

    //elements
    private final ListOfElements cartItemList = new ListOfElements(By.xpath(xpath_cartItemList), "Cart Item List");

    public SonyCartPage() {
        super(by, name);
    }

    public ArrayList<String> getCartItemNameList() {
        ArrayList<String> arrList = new ArrayList<>();
        arrList = (ArrayList<String>) cartItemList.getListOfElement().stream().map(WebElement::getText).collect(Collectors.toList());
        return arrList;
    }

    public boolean isProductDisplayedIntoCart(String productName) {
        final Label lblCartItem = new Label(By.xpath(String.format(xpath_lblCartItem, productName)), String.format("Cart Item [%s]", productName));
        return lblCartItem.isElementDisplay();
    }

}
