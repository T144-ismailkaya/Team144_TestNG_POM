package tests.day14_TestNGFramework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ToFormPage;
import utilities.Driver;

public class C05_FormDoldurma {

    @Test
    public void test01(){

        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");
        //2- Sirt Agrisi ve Carpinti checkbox’larini secin
        ToFormPage toFormPage = new ToFormPage();

        // Eger web elementler sayfada görünmüyorsa once olara scrool yapalım
        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.PAGE_DOWN)
        .keyDown(Keys.PAGE_DOWN).perform();


        toFormPage.sirtAgrisiYaziElementi.click();
        toFormPage.carpintiCheckbox.click();
        //3- Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        //4- Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        //5- sayfayi kapatin

    }

}
