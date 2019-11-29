package autotest.steps;

import autotest.pages.MainPage;
import cucumber.api.java.it.Ma;
import ru.yandex.qatools.allure.annotations.Step;

public class MainStep {

    MainPage mainPage=new MainPage();

    @Step("Выбираем пункт меню {0}")
    public void stepClickMenu(String nameMenu){
        mainPage.clickMenu(nameMenu);
    }
}
