package tests.day13_TestNG_Framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C04_PageClassiKullanma {

    WebDriver driver;

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // phone için arama yapın
        // TestNG POM'de pages class'lari altindaki locate edilmis
        // WEbElement'leri kullanmak icin ilgili class'dan obje olustururuz
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // ilk ürüne tıklayın
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        // acılan sayfadaki urun isminde case sensitive olmadan phone bulunduğunu test edin
        String expectedIsimIcerik = "phone";
        String actualIsim = testOtomasyonuPage.ilkUrunSayfasiIsimElementi
                                                .getText()
                                                .toLowerCase();
        Assert.assertTrue(actualIsim.contains(expectedIsimIcerik));
        Driver.quitDriver();
    }

}
