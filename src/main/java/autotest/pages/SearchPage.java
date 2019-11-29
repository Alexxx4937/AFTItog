package autotest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'widget-search-result-container')]//button[@data-test-id]")
    List<WebElement> addCart;

    @FindBy(xpath = "//a[@class='tile-wrapper']")
    List<WebElement> productCollectoin;


    @FindBy(xpath = "//input[@placeholder='Искать на Ozon']")
    WebElement search;



    @FindBy(xpath = "//form//input[@class and contains(@id,'to')]")
    WebElement maxPrice;


    @FindBy(xpath = "//div[@class='five-dots']")
    WebElement pageLoad;


    @FindBy(xpath = "//span[@data-test-id='filter-block-brand-show-all']")
    WebElement brandAll;
    @FindBy(xpath = "//a[@class='tile-wrapper']//div[contains(text(),'В корзину')]")
    WebElement addCarts;



    public void setSearch(String nameProduct) {
        field(search, nameProduct);

    }


    public void setMaxPrice(String nameMaxPrice) throws InterruptedException {
        problemField(maxPrice, nameMaxPrice);

    }


    public void setCheckBox(String nameCheckBox) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//span[contains(text(), '" + nameCheckBox + "')]")));
        driver.findElement(By.xpath("//label//span[contains(text(), '" + nameCheckBox + "')]")).click();
    }

    public void setCheckBoxBrand(String nameCheckBoxBrand) throws InterruptedException {
        if (brandAll.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(brandAll)).click();
        }
        Thread.sleep(1000);
        setCheckBox(nameCheckBoxBrand);
    }




    public void waitLoad() {

        wait.until(ExpectedConditions.stalenessOf(pageLoad));
    }

    private void waitAndClick(int i) {


        click(driver.findElement(By.xpath("(//div[contains(text(), 'В корзину')])[" + i + "]")));
    }


    public void addToBasket(String count, String string){
        for (WebElement item:productCollectoin
             ) {if(item.findElement(By.xpath("(.//div[contains(text(),'В корзину')])["+1+"]")).isEnabled()){

        }

        }
    }


    /*public void addToBasket(String count, String string) {
        int i = 1;



        int countLocal = Integer.parseInt(count);

        switch (string){
            case ("четных"):

                while (countLocal > 0) {
                    if (i % 2 == 0) {

                        waitAndClick(i);
                        countLocal--;
                    }
                    i++;
                }
                break;

            case ("нечетных"):
                while (countLocal > 0) {
                    if (i %2 !=0) {
                        waitAndClick(i);
                        countLocal--;
                    }
                    i++;
                }
                break;
        }}*/



    }


