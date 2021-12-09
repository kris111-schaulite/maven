package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage{

    @FindBy(className="to_basket_btn")
    private WebElement button;

    @FindBy(className="round_icon_wrp")
    private WebElement basket;


    @FindBy(id="ORDER_PROP_2")
    private WebElement name;

    @FindBy(id="ORDER_PROP_4")
    private WebElement telephone;

    @FindBy(id="ORDER_PROP_3")
    private WebElement mail;


    @FindBy(className="jq-selectbox__select-text")
    private WebElement town;

    @FindBy(xpath="//input[@type='search']")
    private WebElement list;

    @FindBy(xpath="//li[896]")
    private WebElement listItem;


    @FindBy(name="ORDER_PROP_5")
    private WebElement address;



    @FindBy(xpath="//*[@id=\"ORDER_FORM\"]/div[2]/div[2]/input")
    private WebElement arrange;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void order(String name, String telephone, String mail, String list,String address) {
        this.button.click();
        this.basket.click();

        this.name.sendKeys(name);
        this.telephone.sendKeys(telephone);
        this.mail.sendKeys(mail);

        this.town.click();
        this.list.sendKeys(list);
        this.listItem.click();

        this.address.sendKeys(address);

        this.arrange.click();

    }

}
