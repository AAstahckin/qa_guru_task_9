package pages.components;

import com.codeborne.selenide.SelenideElement;
import data.enums.DamageType;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class DamageTypePtsComponents {

    String elementDamage = ".DamageDot_index_%s";

    SelenideElement
            damagePopup = $(".DamagePopup"),
            damagesScheme = $(".VehicleBodyDamagesSchemeFrame__scheme div");

    @Step("Заполняем повреждения автомобиля")
    public DamageTypePtsComponents clickDamageType(String damageType, String damageValue) {
        step("Проверяем отображение схемы автомобиля", () ->
                damagesScheme.shouldHave(visible));
        step("Выбираем " + damageType, () ->
                $(String.format(elementDamage, DamageType.getNumber(damageType) - 1)).hover().click());
        step("Выбираем " + damageValue, () ->
                damagePopup.$(byText(damageValue)).hover().click());
        step("Нажимем Сохранить", () ->
                damagePopup.$(byText("Сохранить")).hover().click());
        return this;
    }

}
