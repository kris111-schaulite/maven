package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage{
    @FindBy(name="q")
    private WebElement line;

    @FindBy(className="btn_search")
    private WebElement findButton;

    @FindBy(className="flag_wrp")
    private WebElement product;

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void search(String line){
            this.line.sendKeys(line);
            this.findButton.click();
            this.product.click();
        }
}
