package autotest.steps;

import autotest.pages.CartPage;
import ru.yandex.qatools.allure.annotations.Step;

public class CartStep {
    CartPage cartPage=new CartPage();


    @Step("удаляем все товары из корзины")
    public void stepRemoveAll(){
        cartPage.deleteAllProducts();

    }
}
