package SimbirsoftTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private By loginBtnLocator = By.xpath("//*[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc']");

    @FindBy(id = "identifierId")
    private WebElement loginField;

    @FindBy(xpath = "//*[@name='password']")
    private WebElement passwdField;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickNextBtn() {
        try {
            WebElement nextBtn = driver.findElement(loginBtnLocator);
            nextBtn.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement nextBtn = driver.findElement(loginBtnLocator);
            nextBtn.click();
        }
    }
}
