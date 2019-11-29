package autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage  extends BasePage{
    @FindBy(xpath = "//label[contains(text(), 'Выбрать все')]")
    public WebElement checkAll;

    @FindBy(xpath = "//span[contains(text(), 'Удалить выбранные')]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[contains(text(), 'Удалить')]")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//div[@class='container']//h1")
    public WebElement isBasketEmpty;


    public void deleteAllProducts() {
        if (checkAll.isSelected()) {
            click(checkAll);
        }
        click(deleteButton);
        click(confirmDeleteButton);}
}
