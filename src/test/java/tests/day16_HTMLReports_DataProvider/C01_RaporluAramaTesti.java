package tests.day16_HTMLReports_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluAramaTesti extends TestBaseRapor {



    @Test
    public void aramaTesti(){

        extentTest = extentReports.createTest("arama testi",
                "Kullanıcı belirlenen kelimeyi aratıp sonuç görmelidir");

        // testotomasyonu sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanıcı testotomasyonu anasayfa'sına gider");
        // URL testotomasyonu içerdiğini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        extentTest.pass("url'in test otomasyonu içerdiğini test eder");
        // belirlenmiş arama kelimesini yapın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("belirlenmiş arama kelimesi için arama yapar");
        // bulunan urun sayısının 3'ten fazla olduğunu test edin
        int minimmumUrunSayisi = 3;
        int actualBulunanUrunSayisi  = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(actualBulunanUrunSayisi>minimmumUrunSayisi);
        extentTest.pass("bulunan urun sayısının 3'ten fazla olduğunu test eder");
        // ilk ürüne tıklayın
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("ilk ürüne tıklar");

        String actualUrunIsmi = testOtomasyonuPage.ilkUrunSayfasiIsimElementi.getText().toLowerCase();
        Assert.assertTrue(actualUrunIsmi.contains(ConfigReader.getProperty("toAranacakKelime")));


    }

}
