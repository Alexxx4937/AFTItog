package autotest.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends BasePage{


    @FindBy(xpath = "//div//span[text()]")
    List<WebElement> menu;

    public void clickMenu(String nameMenu){
        for (WebElement item:menu
             ) if (item.getText().equalsIgnoreCase(nameMenu)) {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(item)).click();
            return;
        }


        Assert.fail("Не найден пункт меню- " + nameMenu);

        }


    }

