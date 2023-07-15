package ru.netology.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardWithDeliveryTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void firstPlanMeetValid() {

        $("[data-test-id='city'] input").setValue(DataGenerator.genCity());
        String firstDate = DataGenerator.genDate(DataGenerator.random(), "dd.MM.yyyy");
        String secondDate = DataGenerator.genDate(DataGenerator.random(), "dd.MM.yyyy");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").sendKeys(firstDate);
        $("[data-test-id='name'] input").setValue(DataGenerator.genName("ru"));
        $("[data-test-id='phone'] input").setValue(DataGenerator.genPhone("ru"));
        $("[data-test-id='agreement']").click();
        $("button.button").click();

        $(byText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldHave(Condition.exactText("Встреча успешно запланирована на " + firstDate));

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(secondDate);
        $(byText("Запланировать")).click();

        $("[data-test-id='replan-notification'] .notification__content").shouldBe(visible);
        $("[data-test-id='replan-notification'] .notification__content") .shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $(byText("Перепланировать")).click();

        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на " + secondDate));

    }

}
