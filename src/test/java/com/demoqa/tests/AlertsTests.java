package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod

    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectAlerts();

    }

    @Test
    public void sendMessageToAlertTest() {
        new AlertsPage(driver).sendMessageToAlert("Hello world!")
                .assertMessage("Hello world!");
    }

    @Test
    public void seeAlertTest() {
        new AlertsPage(driver).seeAlertButton();

    }

    @Test
    public void alertWillAppearAfter5SecondsTest() {
        new AlertsPage(driver).alertAfter5SecondsButton();
    }

    @Test
    public void confirmBoxWillAppearTest(){
        //new AlertsPage(driver).confirmBox().assertConfirmMessage("You selected Ok");
        new AlertsPage(driver).selectAlertConfirm("Cancel").assertConfirmMessage("Cancel");
    }
}
