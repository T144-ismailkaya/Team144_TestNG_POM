package tests.day16_HTMLReports_DataProvider;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test
    public void positiveLoginTesti() {

        extentTest = extentReports.createTest("Pozitif Login Testi",
                "Kulanıcı geçerli bilgilerle giriş yapabilmeli");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanıcı https://www.testotomasyonu.com/ anasayfasina gider");
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("Kullanıcı account linkine basar");
        // 3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.loginEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanıcı geçerli e-mail girer");
        // 4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.loginPasswordKutusu.
                sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanıcı geçerli password girer");
        // 5- Login butonuna basarak login olun
        testOtomasyonuPage.loginSignInButonu.click();
        extentTest.info("Kullanıcı login olur");
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("Kullanıcı giriş yapabildiğini tes eder");

    }

}
