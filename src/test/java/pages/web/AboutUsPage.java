package pages.web;

import org.openqa.selenium.By;
import static helper.Utility.*;
import static org.junit.Assert.assertTrue;

public class AboutUsPage {

    By aboutUsLink = By.linkText("About us");
    By play_button = By.xpath("//button[@title='Play Video']");
    By video = By.id("example-video_html5_api");


    public void clickLinkAboutUs() {
        explicitWaitClickable(aboutUsLink);
        driver.findElement(aboutUsLink).click();
    }

    public void clickPlayVideo() throws InterruptedException {
        explicitWaitClickable(play_button);
        driver.findElement(play_button).click();
        Thread.sleep(2000);
        assertTrue(driver.findElement(video).isDisplayed());
    }

}
