package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends AbstractPage {

    @FindBy(className="to_basket_btn")
    private WebElement button;

    @FindBy(className="round_icon_wrp")
    private WebElement basket;

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    public void add() {
        this.button.click();
        this.basket.click();
    }
}
