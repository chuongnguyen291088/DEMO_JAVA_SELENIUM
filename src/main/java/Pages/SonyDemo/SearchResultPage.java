package Pages.SonyDemo;

import WebElement.ListOfElements;
import WebElement.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchResultPage extends BaseSonyDemoPage {

    private final static By by = new By.ByXPath("//h1[contains(text(),'Tìm kiếm')]");
    private final static String name = "Sony Search Result Page";

    //locators
    private final String xpath_listItems = "//h3[contains(@class,'product-item')]/a[not (@aria-label)]";
    private final String xpath_lblItemName = "//a[contains(text(),'%s')]";
    private final String xpath_btnAddToCart = "//a[contains(text(),'%s')]/parent::h3/following-sibling::div//form[@action='/cart/add']/div/button";

    //elements
    private final ListOfElements listItems = new ListOfElements(By.xpath(xpath_listItems), "List Items");

    public SearchResultPage() {
        super(by, name);
    }

    public ArrayList<String> getListItemName() {
        ArrayList<String> arrList = new ArrayList<>();
        arrList = (ArrayList<String>) listItems.getListOfElement().stream().map(WebElement::getText).collect(Collectors.toList());
        return arrList;
    }

    public void addProductToCart(String productName) {
        final Button btnAddToCart = new Button(By.xpath(String.format(xpath_btnAddToCart, productName)), String.format("Add [%s] to cart", productName));
        btnAddToCart.waitForClickable();
        btnAddToCart.click();
        waitForJSToComplete();
    }
}
