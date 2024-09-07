package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestDate.*;

public class PracticFormFakerTest {

   /* String firstName = "Aslan",
    lastName="Kardanov",
    userEmail="Askarda@test.com";*/

  /*  String  firstName,
            lastName,
            userEmail;
    */
   /* @BeforeEach
    void prepareTestDate(){
        firstName = "Aslan";
                lastName="Kardanov";
                userEmail="Askarda@test.com";
    }
*/
    @BeforeAll
    static  void beforeAll(){
        Configuration.browserSize="1928x1080";
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
    @AfterAll
    static  void afterAll(){
        closeWebDriver();
    }
    @AfterEach
    public   void afterEach(){
        closeWebDriver();
    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(".custom-control-label").click();
        $("#userNumber").setValue("89280000000");
        $("#dateOfBirthInput").click();
        $(by("aria-label","Choose Tuesday, September 24th, 2024")).click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        File file = new File("src/test/resources/Toka.png");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Kabardino_Balkaria, Baksan");
        // здесь нужен скролл
        $("#submit").scrollTo();
        $("#state").click();
       // $("#state").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();
        $("tbody > tr:nth-child(1) > td:nth-child(2)").shouldHave(text("Aslan"));
        $("tr:nth-child(2) > td:nth-child(2)").shouldHave(text("Askarda@test.com"));
        $("tbody > tr:nth-child(3) > td:nth-child(2)").shouldHave(text("Male"));
        $("tbody > tr:nth-child(4) > td:nth-child(2)").shouldHave(text("8928000000"));
        $("tbody > tr:nth-child(5) > td:nth-child(2)").shouldHave(text("24 September,2024"));
        $("tbody > tr:nth-child(6) > td:nth-child(2)").shouldHave(text("Commerce"));
        $("tbody > tr:nth-child(7) > td:nth-child(2)").shouldHave(text("Sports"));
        $("tbody > tr:nth-child(8) > td:nth-child(2)").shouldHave(text("Toka.png"));
        $("tbody > tr:nth-child(9) > td:nth-child(2)").shouldHave(text("Kabardino_Balkaria, Baksan"));
        $("tbody > tr:nth-child(10) > td:nth-child(2)").shouldHave(text("NCR Noida"));
        $("#closeLargeModal").click();

    }
}
