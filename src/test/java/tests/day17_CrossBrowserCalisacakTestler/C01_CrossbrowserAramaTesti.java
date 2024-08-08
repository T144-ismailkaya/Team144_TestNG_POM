package tests.day17_CrossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.DriverCross;
import utilities.TestBaseCross;

public class C01_CrossbrowserAramaTesti extends TestBaseCross {

    @Test
    public void aramaTesti(){

        driver.get(ConfigReader.getProperty("toUrl"));

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        String unexpectedSonucYazisi = "0 Products Found";
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String actualSonucYazisi = aramaSonucElementi.getText();
        Assert.assertNotEquals(actualSonucYazisi,unexpectedSonucYazisi);




    }

}
