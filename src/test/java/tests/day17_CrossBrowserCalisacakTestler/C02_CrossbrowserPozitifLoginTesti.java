package tests.day17_CrossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C02_CrossbrowserPozitifLoginTesti extends TestBaseCross {

    @Test
    public void pozitifLoginTesti(){

        driver.get(ConfigReader.getProperty("toUrl"));

        WebElement accountLinki = driver.findElement(By.xpath("(//*[text()='Account'])[1]"));
        accountLinki.click();

        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        WebElement submitButonu = driver.findElement(By.id("submitlogin"));
        submitButonu.click();

        WebElement logoutButonu = driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));
        Assert.assertTrue(logoutButonu.isDisplayed());

    }

}
