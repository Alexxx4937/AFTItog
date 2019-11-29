package autotest.pages;

import autotest.steps.BaseStep;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

        WebDriver driver = BaseStep.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, 15);

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
        Thread.sleep(1000);
         wait
                .until(ExpectedConditions.elementToBeClickable(field)).click();
        String selectAll = Keys.chord(Keys.CONTROL, "a");

        field.sendKeys(selectAll);
        field.sendKeys(Keys.BACK_SPACE);

        field.sendKeys(value+"\n");

    }

    public void click(WebElement element)  {

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
  /*      Wait<WebDriver> wait = new WebDriverWait(driver, 15);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));*/
        element.click();



    }

}

