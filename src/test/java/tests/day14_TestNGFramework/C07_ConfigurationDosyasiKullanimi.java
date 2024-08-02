package tests.day14_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C07_ConfigurationDosyasiKullanimi {

    @Test
    public void positiveLoginTesti() {

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        // 3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.loginEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        // 4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.loginPasswordKutusu.
                sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        // 5- Login butonuna basarak login olun
        testOtomasyonuPage.loginSignInButonu.click();
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());
        Driver.quitDriver();

    }

}
