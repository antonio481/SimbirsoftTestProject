package SimbirsoftTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        ChromeOptions capability = new ChromeOptions();
        driver = new RemoteWebDriver(
                new URL("http://localhost:5566/wd/hub"), capability);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickNextBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickNextBtn();
        profilePage.clickWriteButton();
        profilePage.inputRecipientField("farit.valiahmetov@simbirsoft.com");
        profilePage.inputTextLetter();
        profilePage.inputTextTopicLetter(ConfProperties.getProperty("surname"),"Тестовое задание. ");
        //profilePage.clickSendingBtn();
        //profilePage.getSendingMessage();
    }
}
