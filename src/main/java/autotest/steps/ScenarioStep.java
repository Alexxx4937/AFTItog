package autotest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.it.Ma;
import cucumber.api.java.ru.Когда;

public class ScenarioStep {
    MainStep mainStep=new MainStep();
    SearchStep searchStep=new SearchStep();
    CartStep cartStep=new CartStep();


    @Когда("^нажимаем на пункт меню \"([^\"]*)\"$")
    public void нажимаемНаПунктМеню(String nameMenu) {
        mainStep.stepClickMenu(nameMenu);

    }

    @Когда("^ищем в строке поиска товар с именем \"([^\"]*)\"$")
    public void ищемВСтрокеПоискаТоварСИменем(String nameProduct)  {

searchStep.stepSearchProduct(nameProduct);

    }

    @Когда("^выставлем в фильтре максимальную цену \"([^\"]*)\"$")
    public void выставлемВФильтреМаксимальнуюЦену(String nameMaxPrice) throws InterruptedException {
        searchStep.stepMaxPrice(nameMaxPrice);

    }

    @Когда("^добавляем в корзину первые \"([^\"]*)\" \"([^\"]*)\" товаров$")
    public void добавляемВКорзинуПервыеТоваров(String count, String evenOrOdd) throws InterruptedException {
        searchStep.stepAddCart(count,evenOrOdd);


    }

   /* @Когда("^выбираем в фильтре брэнд \"([^\"]*)\"$")
    public void выбираемВФильтреБрэндИ(String nameBrand1) throws InterruptedException {
        searchStep.stepBrandFilter(nameBrand1);


    }*/

    @Когда("^удаляем все товары из корзины$")
    public void удаляемВсеТоварыИзКорзины() {
        cartStep.stepRemoveAll();

    }

    @Когда("^выбираем чекбокс \"([^\"]*)\"$")
    public void выбираемЧекбокс(String nameChekbox) throws InterruptedException {
        searchStep.stepCheckBox(nameChekbox);
        Thread.sleep(1000);



    }

    @Когда("^выбираем чекбокс бренда \"([^\"]*)\"$")
    public void выбираемЧекбоксБренда(String nameBrand) throws InterruptedException {
        searchStep.stepCheckBoxBrand(nameBrand);

    }
}
