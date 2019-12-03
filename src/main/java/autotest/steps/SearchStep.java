package autotest.steps;

import autotest.pages.BasePage;
import autotest.pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

public class SearchStep {
    SearchPage searchPage=new SearchPage();

    @Step("выполнен поиск по товару с именем {0}")
    public void stepSearchProduct(String nameProduct){
        searchPage.setSearch(nameProduct);
    }

    @Step("выставлена максимальная цена товара {0}")
    public void stepMaxPrice(String nameMaxPrice) throws InterruptedException {
        searchPage.setMaxPrice(nameMaxPrice);
        Thread.sleep(1000);
    }
    @Step("выбиран чекбокс {0}")
    public void stepCheckBox(String nameCheckBox) throws InterruptedException {
        searchPage.setCheckBox(nameCheckBox);


    }
    @Step("выбираем чекбокс бренда {0}")
    public void stepCheckBoxBrand(String nameCheckBoxBrand) throws InterruptedException {
        searchPage.setCheckBoxBrand(nameCheckBoxBrand);

    }


    @Step("добавлены в корзину первые {0} {1} товаров")
    public void  stepAddCart(String number,String evenOrOdd) throws InterruptedException {


        searchPage.addToBasket(number,evenOrOdd);
    }
    @Step("добавлены в корзину первые {0} товаров")
    public void  stepAddCart(String evenOrOdd) throws InterruptedException {


        searchPage.addToBasket(evenOrOdd);
    }

    @Step("в Allure отчет добавляет файл с информацией от товарах product.txt")
    public void stepProductFile() throws IOException {

       searchPage.productFile();
    }

}
