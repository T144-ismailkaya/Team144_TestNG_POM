package tests.day14_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C02_PageClassDuzenleme {

    public void aramaTest(){

        // Testotomasyonu anasayfassına gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        // phone için arama yapın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // arama sonucunda urun bulunabildiğini test edin
        int actualSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(actualSonucSayisi>0);
        // Sayfayı kapatın

    }

}
