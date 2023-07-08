package com.demoqa.tests;

import com.demoqa.pages.DroppablePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DrugDropTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable();
        new DroppablePage(driver).hideAd();
    }

    @Test
    public void actionDrugMeTest() {


        new DroppablePage(driver).actionDragMe();
    }

    @Test
    public void actionDragMeByTest() {
       new DroppablePage(driver).dragMeBy(20,50);
    }
}
