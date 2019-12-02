package autotest.steps;

import autotest.pages.CartPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class CartStep {
    CartPage cartPage=new CartPage();

    @Step("все добавленные товары находятся в корзине")
    public void stepCheckProductCart() {

        Assert.assertTrue(cartPage.checkProductCart());
    }

    @Step("проверяем что корзина пуста")
    public void stepCheckCartEmpty() {

cartPage.checkEmptyCart();
    }

    @Step("удаляем все товары из корзины")
    public void stepRemoveAll(){
        cartPage.deleteAllProducts();

    }
}
