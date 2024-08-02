package tests.day13_TestNG_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    // 3 farklı test methodu oluşturup aşağıdaki işlemleri yapın
    // 1- testotomasyonu anasayfasına gidin logo göründüğünü test edin
    // 2- wisequarter.com anasayfasına gidin title'nin Wise içerdigini test edin
    //3- youtube anasayfasına gidip url'in youtube içerdiğini test edin

    /*
        1- TestNG test metod'ları oncelik belirtmez isek harf sırasına uygun olarak çalışır
        2- Eger test metod'larini çalışmasını isim sırası dışındaki bir sırayla yapmak istersek
           metod'lara küçükten büyüğe dogru priority degeri verebiliriz
     */

    @Test(priority = 3)
    public void testotomasyonuTesti(){
        driver.get("https://www.testotomasyonu.com");
        WebElement logoElementi = driver.findElement(By.xpath("(//*[@alt='Logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test(priority = 1)
    public void wisequarterTest(){
        driver.get("https://www.wisequarter.com");

        String expectedTitleIcerik = "Wise";
        String actualTitleIcerik = driver.getTitle();

        Assert.assertTrue(actualTitleIcerik.contains(expectedTitleIcerik));

    }

    @Test(priority = 2)
    public void youtubeTesti(){
        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }


}
