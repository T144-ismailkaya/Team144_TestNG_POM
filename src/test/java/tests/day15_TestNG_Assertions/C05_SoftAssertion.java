package tests.day15_TestNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SoftAssertion {

    /*
        TestNG coklu assertion bulunduran method'larda
        failed olan ilk assertion'da kodun calismasini durdurmadan
        testin sonuna kadar calismasini saglayacak bir ALTERNATIF sunar

        Soft assert kullanildiginda
        BIZ RAPORLA diyene kadar
        assertion'larin sonuclarini kaydeder ama calismayi durdurmaz

        biz ne zaman RAPORLA dersek
        failed olan assertion'lari rapor eder
        ve failed olan assertion varsa calismayi durdurur

        SoftAssert'un en buyuk artisi
        bize butun test method'undaki tum hatalari vermesidir

        SoftAssert'un eksileri
        1- Eger en sonda assertAll() calistirilmazsa
           failed olan assertion olsa bile Test PASSED der

        2- hatalari assertAll() ile verdiginden
           hata satiri olarak assertAll()'un bulundugu satiri verir

        3- hatalari toplu verdigi icin
           hangi hatanin hangi assertion'dan oldugunu belirten
           aciklama yazmamiz gerekir
     */

    @Test
    public void aramaTesti() {
        // testotomasyonu sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // URL testotomasyonu içerdiğini test edin
        String expectedUrlIcerik = "testotomasyonuKKK";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        // SoftAssert kullanmak için 3 adıma ihtiyac var

        // 1.adim softAssert objesi oluşturmak
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik),"URL testotomasyonu içermiyor!");

        // belirlenmiş arama kelimesini yapın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        // bulunan urun sayısının 3'ten fazla olduğunu test edin
        int minimmumUrunSayisi = 30;
        int actualBulunanUrunSayisi  = testOtomasyonuPage.bulunanUrunElementleriList.size();
        softAssert.assertTrue(actualBulunanUrunSayisi>minimmumUrunSayisi);
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        String actualUrunIsmi = testOtomasyonuPage.ilkUrunSayfasiIsimElementi.getText().toLowerCase();
        softAssert.assertTrue(actualUrunIsmi.contains(ConfigReader.getProperty("toAranacakKelime")));

        // 3.adım softAssert objesine yaptığı asserton'ları raporlamasını söyleyelim

        softAssert.assertAll();

    }
}
