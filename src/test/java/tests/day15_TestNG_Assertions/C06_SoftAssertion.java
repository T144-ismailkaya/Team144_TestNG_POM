package tests.day15_TestNG_Assertions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C06_SoftAssertion {

    @Test
    public void test01(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zerourl"));
        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        String expectedAnasayfaUrl = "zero.webappsecurity";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expectedAnasayfaUrl));
        // 3. Sign in butonuna basin
        ZeroWebPage zeroWebPage = new ZeroWebPage();
        zeroWebPage.signinButonu.click();
        // 4. Login kutusuna “username” yazin
        zeroWebPage.loginKutusu.sendKeys(ConfigReader.getProperty("webAppGecerliUsername"));
        // 5. Password kutusuna “password” yazin
        zeroWebPage.passwordKutusu.sendKeys(ConfigReader.getProperty("webAppGecerliPassword"));
        // 6. Sign in tusuna basin
        zeroWebPage.submitButonu.click();
        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();
        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroWebPage.girisYapilanKullanici.isDisplayed());
        // 9. Online banking menusunu tiklayin
        zeroWebPage.onlineBakingButonu.click();
        //10. Pay Bills sayfasina gidin
        zeroWebPage.payBillsLink.click();
        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebPage.foreignCurrencyButonu.click();
        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebPage.currencyDopdownMenu.isEnabled());
        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select =new Select (zeroWebPage.currencyDopdownMenu);
        select.selectByValue("EUR");
        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSecilenOption = "Eurozone (euro)";
        String actualSecilenOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSecilenOption,expectedSecilenOption);
        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedOpcionSayisi = 16;
        int actualOptionSayisi = select.getOptions().size();
        softAssert.assertEquals(actualOptionSayisi,expectedOpcionSayisi);
        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        String expectedOptionsIcerik = "Canada (dollar)";

        List<WebElement> optionsElementList = select.getOptions();
        List<String> optionsYaziList = ReusableMethods.getStringList(optionsElementList);

        softAssert.assertTrue(optionsYaziList.contains(expectedOptionsIcerik));

        //17. Sayfayi kapatin
        softAssert.assertAll();
        Driver.quitDriver();
    }

}
