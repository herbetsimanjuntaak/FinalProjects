package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helper.Utility.*;
import static org.junit.Assert.assertTrue;

public class LoginPage {

    By linkLogin = By.linkText("Log in");
    By usernameLogin = By.id("loginusername");
    By passwordLogin = By.id("loginpassword");

    By linkLogOut = By.id("logout2");

    By buttonLogin = By.xpath("//button[text()='Log in']");

    public void clickLinkLogin() {
        explicitWaitClickable(linkLogin);
        driver.findElement(linkLogin).click();
        explicitWaitClickable(usernameLogin);
    }

    public void inputUsernameAndPassword(String username, String password) {
        explicitWaitClickable(usernameLogin);
        driver.findElement(usernameLogin).sendKeys(username);
        explicitWaitClickable(passwordLogin);
        driver.findElement(passwordLogin).sendKeys(password);
        explicitWaitClickable(buttonLogin);
    }

    public void clickButtonLogin() {
        explicitWaitClickable(buttonLogin);
        driver.findElement(buttonLogin).click();
    }

    public void validateLogin() {
        explicitWaitClickable(linkLogOut);
        WebElement logout = driver.findElement(linkLogOut);
        System.out.println(logout.getText());
        assertTrue(logout.isDisplayed());

    }

    public void validateUsername(String username) {
        WebElement userGreeting = driver.findElement(By.id("nameofuser"));
        assertTrue(userGreeting.isDisplayed());
        assertTrue(userGreeting.getText().contains(username));
    }

}
