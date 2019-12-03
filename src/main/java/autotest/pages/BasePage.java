package autotest.pages;

import autotest.steps.BaseStep;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BasePage {

        WebDriver driver = BaseStep.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, 5);
    private static Map<String, String> productMap = new HashMap<>();

        public BasePage(){
            PageFactory.initElements(driver, this);
        }


        public void field(WebElement field, String value){
           wait
                    .until(ExpectedConditions.elementToBeClickable(field)).click();

            field.clear();
            field.sendKeys(value+"\n");

    }
    public void problemField(WebElement field, String value) throws InterruptedException {

         wait
                .until(ExpectedConditions.elementToBeClickable(field)).click();
        String selectAll = Keys.chord(Keys.CONTROL, "a");

        field.sendKeys(selectAll);
        field.sendKeys(Keys.BACK_SPACE);

        field.sendKeys(value+"\n");

    }


    public static Map<String, String> getProductMap() {
        return productMap;
    }

    public void click(WebElement element)  {

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();



    }

}

