package SimbirsoftTest;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='yW']/span[@class='bA4']/span[@email='farit.valiahmetov@simbirsoft.com']")
    private List<WebElement> letters;

    private By messageAboutSending = By.xpath("//span[@class='aT']/span[text()='Письмо отправлено.']");

    @FindBy(id = ":a7")
    private WebElement textLetterField;

    @FindBy(id = ":8s")
    private WebElement sendingBtn;

    @FindBy(id = ":92")
    private WebElement textTopicField;

    @FindBy(xpath = "//*[@class='T-I T-I-KE L3']")
    private WebElement writeButton;

    @FindBy(id = ":9k")
    private WebElement recipientField;
    @Step
    public void inputRecipientField(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(recipientField));
        recipientField.sendKeys(email);
    }
    @Step
    public void clickWriteButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(writeButton));
        writeButton.click();
    }
    @Step
    public int getCountLetters() {
        return letters.size();
    }
    @Step
    public void inputTextLetter()
    {
        textLetterField.sendKeys(String.valueOf(getCountLetters()));
    }

    public void inputTextTopicLetter(String surname, String otherText) {
        textTopicField.sendKeys(otherText + surname);
    }
    @Step
    public void clickSendingBtn() {
        sendingBtn.click();
    }
    @Step
    public void waitSendingMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageAboutSending));
    }
}

