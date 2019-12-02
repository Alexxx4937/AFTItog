package autotest.pages;

import autotest.steps.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class CartPage  extends BasePage{
    @FindBy(xpath = "//label[contains(text(), 'Выбрать все')]")
    public WebElement checkAll;

    @FindBy(xpath = "//span[contains(text(), 'Удалить выбранные')]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[contains(text(), 'Удалить')]")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//div[contains(@class,'container')]//h1")
    public WebElement isBasketEmpty;

    @FindBy(xpath = "//a[@class='a5c8']/span")
    List<WebElement> productInCart;

    public boolean checkProductCart() {
        Map<String, String> productCart = BasePage.getProductMap();
        for (WebElement good : productInCart) {
            if (!productCart.containsKey(good.getText())) {
                return false;
            }
        }
        return true;
    }



    public void deleteAllProducts() {
        if (checkAll.isSelected()) {
            click(checkAll);
        }
        click(deleteButton);
        click(confirmDeleteButton);}

    public void checkEmptyCart() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",isBasketEmpty);
        new WebDriverWait(BaseStep.getDriver(), 10)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(isBasketEmpty));
        assertEquals("Корзина не пуста", "Корзина пуста",isBasketEmpty.getText());
}}
