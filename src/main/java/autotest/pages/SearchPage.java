package autotest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'widget-search-result-container y')]//div[@class='tile m-list m-border']")
    List<WebElement> productCollection;


    @FindBy(xpath = "//input[@placeholder='Искать на Ozon']")
    WebElement search;


    @FindBy(xpath = "//form//input[@class and contains(@id,'to')]")
    WebElement maxPrice;


    @FindBy(xpath = "//span[@data-test-id='filter-block-brand-show-all']")
    WebElement brandAll;




    @FindBy(xpath ="//input[@type='text' and @class='input']")
    WebElement brandMenu;

    public void setSearch(String nameProduct) {
        field(search, nameProduct);

    }


    public void setMaxPrice(String nameMaxPrice) throws InterruptedException {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='five-dots']")));
        problemField(maxPrice, nameMaxPrice);

    }


    public void setCheckBox(String nameCheckBox) throws InterruptedException {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElement(By.xpath("//span[contains(text(), '" + nameCheckBox + "')]")));
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(), '" + nameCheckBox + "')]"))));
        driver.findElement(By.xpath("//label//span[contains(text(), '" + nameCheckBox + "')]")).click();
    }

    public void setCheckBoxBrand(String nameCheckBoxBrand) throws InterruptedException {



        try {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",brandAll);
            brandAll.click();
            wait.until(ExpectedConditions.visibilityOf(brandMenu));

        } catch (Exception e) {
        }
        setCheckBox(nameCheckBoxBrand);

    }


    public void addToBasket(String count, String string) throws InterruptedException {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='five-dots']")));

        int i = 1;
        int countLocal = Integer.parseInt(count);
        Map<String, String> selectProduct = BasePage.getProductMap();
        for (WebElement item : productCollection) {

            switch (string) {
                case ("четных"):
                    if (i % 2 == 0 && i <= countLocal * 2) {
                        String name = item.findElement(By.xpath(".//span[@data-test-id='tile-name']")).getText();
                        String price = item.findElement(By.xpath(".//span[@data-test-id='tile-price']")).getText();
                        selectProduct.put(name, price);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item.findElement(By.xpath(".//button[@data-test-id='tile-buy-button']")));
                        item.findElement(By.xpath(".//button[@data-test-id='tile-buy-button']")).click();
                    }
                    i++;
                    break;
                case ("нечетных"):
                    if (i % 2 != 0 && i <= countLocal * 2) {
                        String name = item.findElement(By.xpath(".//span[@data-test-id='tile-name']")).getText();
                        String price = item.findElement(By.xpath(".//span[@data-test-id='tile-price']")).getText();
                        selectProduct.put(name, price);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item.findElement(By.xpath(".//button[@data-test-id='tile-buy-button']")));
                        item.findElement(By.xpath(".//button[@data-test-id='tile-buy-button']")).click();

                    }
                    i++;
                    break;
            }
        }


    }


    public void addToBasket( String string) throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='five-dots']")));
        int i = 1;

        Map<String, String> selectProduct = BasePage.getProductMap();
        for (WebElement item : productCollection) {

            switch (string) {
                case ("четных"):
                    if (i % 2 == 0 ) {
                        String name = item.findElement(By.xpath(".//span[@data-test-id='tile-name']")).getText();
                        String price = item.findElement(By.xpath(".//span[@data-test-id='tile-price']")).getText();
                        selectProduct.put(name, price);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item.findElement(By.xpath(".//button[@data-test-id='tile-buy-button']")));
                        item.findElement(By.xpath(".//button[@data-test-id='tile-buy-button']")).click();
                    }
                    i++;
                    break;
                case ("нечетных"):
                    if (i % 2 != 0 ) {
                        String name = item.findElement(By.xpath(".//span[@data-test-id='tile-name']")).getText();
                        String price = item.findElement(By.xpath(".//span[@data-test-id='tile-price']")).getText();
                        selectProduct.put(name, price);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item.findElement(By.xpath(".//button[@data-test-id='tile-buy-button']")));
                        item.findElement(By.xpath(".//button[@data-test-id='tile-buy-button']")).click();

                    }
                    i++;
                    break;
            }
        }


    }



    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("", resourceName));
    }


    public void productFile() throws IOException {

        Map<String, String> product = BasePage.getProductMap();
        File file = new File("product.txt");

        for (int i = 1; file.exists(); i++) {
            file = new File(String.format("product%d.txt", i));
        }
        try (FileWriter writer = new FileWriter(file)) {
            for (Map.Entry<String, String> entry : product.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue().replaceAll("\\D", "") + " руб" + System.lineSeparator());


            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        getBytes(file.getName());
        file.delete();

    }
}


