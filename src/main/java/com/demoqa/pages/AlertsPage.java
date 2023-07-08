package com.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage sendMessageToAlert(String message) {
        clickWithJSExecutor(promtButton, 0, 200);
        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage assertMessage(String message) {
        Assert.assertTrue(promptResult.getText().contains(message));
        return this;
    }

    @FindBy(id = "alertButton")
    WebElement alertButton;

    public AlertsPage seeAlertButton() {
        clickWithJSExecutor(alertButton, 0, 300);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage alertAfter5SecondsButton() {
        clickWithJSExecutor(timerAlertButton, 0, 300);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        //new WebDriverWait(driver, Duration.ofSeconds(5))
        //                .until(ExpectedConditions.alertIsPresent()).accept();
       // pause(5000);
      //  driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage confirmBox() {
        clickWithJSExecutor(confirmButton, 0, 300);
        driver.switchTo().alert().accept();
        return this;

    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage assertConfirmMessage(String message) {
        Assert.assertTrue(confirmResult.getText().contains(message));
        return this;
    }

    public AlertsPage selectAlertConfirm(String text) {
        clickWithJSExecutor(confirmButton,0,100);
        if (text!=null&&text.equals("OK")){
            driver.switchTo().alert().accept();
        }else if (text!=null&&text.equals("Cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }
}
