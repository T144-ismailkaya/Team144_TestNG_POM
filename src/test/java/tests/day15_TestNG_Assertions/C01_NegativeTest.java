package tests.day15_TestNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_NegativeTest {

    @Test
    public void test01(){
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        //NegativeTest
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        testOtomasyonuPage.accountLinki.click();
        //3- 3 farkli test method’u olusturun.
        //- gecerli email, gecersiz password
        testOtomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginEmailKutusu.isDisplayed());
    }

    @Test
    public void test02(){
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        //3- 3 farkli test method’u olusturun.
        //- gecersiz email, gecerli password
        testOtomasyonuPage.loginEmailKutusu.clear();
        testOtomasyonuPage.loginPasswordKutusu.clear();
        testOtomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginEmailKutusu.isDisplayed());

    }

    @Test
    public void test03(){
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        //3- 3 farkli test method’u olusturun.
        //- gecersiz email, gecersiz password.
        testOtomasyonuPage.loginEmailKutusu.clear();
        testOtomasyonuPage.loginPasswordKutusu.clear();
        testOtomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginEmailKutusu.isDisplayed());
        Driver.quitDriver();
    }

}
