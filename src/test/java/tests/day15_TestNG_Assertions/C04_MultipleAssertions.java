package tests.day15_TestNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_MultipleAssertions {

    /*
        TestNG'deki Assert class'indan kullanilan
        assertion method'lari JUnit'deki Assertions gibi
        ilk failed olan Assertion'da kodun calismasini durdurur
        kodun geriye kalaninda hata olup olmadigi bilemeyiz

        kodun geriye kalanini kontrol etmedigi icin,
        bulunan hata duzeltiltikdikten sonra
        test method'u calistirildiginda
        testin PASSED olacagini garanti edemeyiz
     */

    @Test
    public void aramaTesti(){
        // testotomasyonu sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // URL testotomasyonu içerdiğini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        // belirlenmiş arama kelimesini yapın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        // bulunan urun sayısının 3'ten fazla olduğunu test edin
        int minimmumUrunSayisi = 3;
        int actualBulunanUrunSayisi  = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(actualBulunanUrunSayisi>minimmumUrunSayisi);
        // ilk ürüne tıklayın
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        String actualUrunIsmi = testOtomasyonuPage.ilkUrunSayfasiIsimElementi.getText().toLowerCase();
        Assert.assertTrue(actualUrunIsmi.contains(ConfigReader.getProperty("toAranacakKelime")));
        Driver.quitDriver();

    }

}
