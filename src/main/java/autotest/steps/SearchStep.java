package autotest.steps;

import autotest.pages.BasePage;
import autotest.pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchStep {
    SearchPage searchPage=new SearchPage();

    @Step("выполнен поиск по товару с именем {0}")
    public void stepSearchProduct(String nameProduct){
        searchPage.setSearch(nameProduct);
    }

    @Step("выставляем максимальную цену {0}")
    public void stepMaxPrice(String nameMaxPrice) throws InterruptedException {
        searchPage.setMaxPrice(nameMaxPrice);
    }
    @Step("выбираем чекбокс {0}")
    public void stepCheckBox(String nameCheckBox)  {
        searchPage.setCheckBox(nameCheckBox);

    }
    @Step("выбираем чекбокс бренда {0}")
    public void stepCheckBoxBrand(String nameCheckBoxBrand) throws InterruptedException {
        searchPage.setCheckBoxBrand(nameCheckBoxBrand);

    }



    /* @Step("выбираем бренд {0}")
    public void stepBrandFilter(String nameBrand1) throws InterruptedException {
        searchPage.setBrand(nameBrand1);


    }*/
    @Step("добавляем в корзину первые {0} {1} товаров")
    public void  stepAddCart(String number,String evenOrOdd) throws InterruptedException {


        searchPage.addToBasket(number,evenOrOdd);
    }

}
