package pages.web;

import org.openqa.selenium.By;

import static helper.Utility.driver;
import static helper.Utility.explicitWaitClickable;

public class SignPage {

    By linkSignUp = By.id("signin2");
    By usernameSign = By.id("sign-username");
    By passwordSign = By.id("sign-password");
    By signUpButton = By.xpath("//button[text()='Sign up']");


    public void clickSignUp(){
        explicitWaitClickable(linkSignUp);
        driver.findElement(linkSignUp).click();
        explicitWaitClickable(usernameSign);
    }

    public void inputUsernameAndPassword(String username,String password){
        explicitWaitClickable(usernameSign);
        driver.findElement(usernameSign).sendKeys(username);
        explicitWaitClickable(passwordSign);
        driver.findElement(passwordSign).sendKeys(password);
        explicitWaitClickable(signUpButton);
    }

    public void clickButtonSignUp(){
        explicitWaitClickable(signUpButton);
        driver.findElement(signUpButton).click();
    }
}
