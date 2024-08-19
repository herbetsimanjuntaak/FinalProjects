package pages.web;

import org.openqa.selenium.By;

import static helper.Utility.*;
import static org.junit.Assert.assertTrue;

public class ContactPage {

    By contactEmail = By.id("recipient-email");
    By contactName = By.id("recipient-name");
    By contactMessage = By.id("message-text");
    By buttonSend = By.xpath("//button[text()='Send message']");
    By buttonClose = By.xpath("//button[text()='Close']");

    public void fillEmail(String email){
        explicitWaitPresence(contactEmail);
        driver.findElement(contactEmail).sendKeys(email);
    }
    public void fillName(String name){
        explicitWaitPresence(contactName);
        driver.findElement(contactName).sendKeys(name);
    }
    public void fillMessage(String message){
        explicitWaitPresence(contactMessage);
        driver.findElement(contactMessage).sendKeys(message);
    }

    public void clickButtonSend(){
        explicitWaitClickable(buttonSend);
        driver.findElement(buttonSend).click();
    }

    public void clickButtonClose(){
        explicitWaitClickable(buttonClose);
        driver.findElement(buttonClose).click();
        assertTrue(driver.findElement(By.linkText("CATEGORIES")).isDisplayed());
    }

}
