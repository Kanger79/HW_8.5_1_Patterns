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

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardWithDeliveryTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void firstPlanMeetValid() throws InterruptedException {

        $("[data-test-id='city'] input").setValue(DataGenerator.genCity());
        String firstDate = DataGenerator.genDate(DataGenerator.random(), "dd.MM.yyyy");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").sendKeys(firstDate);
        $("[data-test-id='name'] input").setValue("Смирнов Николай");
        $("[data-test-id='phone'] input").setValue(("+78002008002"));
//        $("[data-test-id='agreement']").click();
//        $("button.button").click();
//
//        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15));
//        $(".notification__content").shouldHave(Condition.exactText("Встреча успешно запланирована на " + firstDate));
        Thread.sleep(5000);

    }

}
