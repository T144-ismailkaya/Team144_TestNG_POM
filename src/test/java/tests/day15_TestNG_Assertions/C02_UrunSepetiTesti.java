package tests.day15_TestNG_Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_UrunSepetiTesti {

    @Test
    public void test01() {

        // Urun sepeti testi
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // 2- phone arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // 3- Listelenen sonuclardan ilkini tiklayin
        testOtomasyonuPage.ilkUrunElementi.click();

        // 4- urun ismini kaydedin ve urunu sepete ekleyin
        String urunIsmi = testOtomasyonuPage.ilkUrunSayfasiIsimElementi.getText();
        System.out.println(urunIsmi);
        // "Add to Cart" düğmesine kaydırarak tıklayın
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", testOtomasyonuPage.addToCardButonu);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(testOtomasyonuPage.addToCardButonu).perform();
        testOtomasyonuPage.addToCardButonu.click();

        ReusableMethods.bekle(2);

        // 5- your cart linkine tiklayin
        js.executeScript("window.scrollTo(0, 0);"); // Sayfanın en üstüne kaydır
        actions.moveToElement(testOtomasyonuPage.yourCardLinki).perform();
        ReusableMethods.bekle(2);
        testOtomasyonuPage.yourCardLinki.click();

        ReusableMethods.bekle(2);

        // 6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String actualYazi = "APPLEL iPhone 13 (Starlight, 128 GB)";
        String sepetUrunYazisi = Driver.getDriver().findElement(By.xpath("//*[text()='APPLEL iPhone 13 (Starlight, 128 GB)']")).getText();
        ReusableMethods.bekle(2);
        Assert.assertEquals(sepetUrunYazisi, actualYazi, "Sepetteki ürün ismi ile kaydedilen ürün ismi eşleşmiyor.");


        // 7- sayfayi kapatin
        Driver.quitDriver();
    }
}
