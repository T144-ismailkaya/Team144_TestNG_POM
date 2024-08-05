package tests.day14_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverClassDuzenleme {

    @Test(groups = "smoke")
    public void test01(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        Driver.quitDriver();

    }

}
