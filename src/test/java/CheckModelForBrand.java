import data.enums.BrandAndMarks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тест для поиска модели по марки автомобиля")
@Tags({@Tag("regression"), @Tag("smoke")})
public class CheckModelForBrand extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @EnumSource(value = BrandAndMarks.class)
    @ParameterizedTest(name = "Для бренда {0} в списке присутствуют модели авто")
    void searchMarksAndBrand(BrandAndMarks brandAndMarks) {
        open("/");
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage
                .clickBrandAuto(brandAndMarks.getTypeName())
                .checkTitleModel(brandAndMarks.getTypeName(), List.of(brandAndMarks.getTypeValue()));
    }

}