package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ToFormPage {

    public ToFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@class='form-control'])[3]")
    public WebElement gunDropdownElementi;

    @FindBy(xpath = "(//*[@class='form-control'])[4]")
    public WebElement ayDropdownElementi;

    @FindBy(xpath = "(//*[@class='form-control'])[5]")
    public WebElement yilDropdownElementi;

    @FindBy(xpath = "//*[@for='gridCheck5']")
    public WebElement sirtAgrisiYaziElementi;

    @FindBy(id = "gridCheck5")
    public WebElement sirtAgrisiCheckbox;

    @FindBy(id = "gridCheck4")
    public WebElement carpintiCheckbox;

    @FindBy(id = "hastalikCheck2")
    public WebElement sekerCheckbox;

    @FindBy(id = "hastalikCheck7")
    public WebElement epilepsiCheckbox;
}
