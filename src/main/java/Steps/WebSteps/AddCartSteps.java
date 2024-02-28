package Steps.WebSteps;

import Core.Support.Waiter;
import Pages.SonyDemo.Popup.SonyMiniCartPopup;
import Pages.SonyDemo.SearchResultPage;
import io.cucumber.java.en.And;

public class AddCartSteps {
    @And("sony - adding {string} into cart")
    public void addingProductIntoCart(String productName) {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.addProductToCart(productName);
    }

    @And("^sony - select (continue shopping|proceed with payment)")
    public void selectProcessPayment(String type) throws Exception {
        Waiter.wait(1);
        SonyMiniCartPopup sonyMiniCartPopup = new SonyMiniCartPopup();
        switch (type.toLowerCase()) {
            case "continue shopping":
                sonyMiniCartPopup.selectContinueShopping();
                break;
            case "proceed with payment":
                sonyMiniCartPopup.selectProceedWithPayment();
                break;
            default:
                throw new Exception("Unexpected value: " + type);
        }
    }
}
