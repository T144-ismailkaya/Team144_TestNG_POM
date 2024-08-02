package tests.day15_TestNG_Assertions;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_SingletonPattern {

    /*
            POM de, Driver class'indan obje olusturulmasini engellemek
            ve POM de belirlendigi gibi
            direkt Driver.getDriver() kullanilmasini saglamak icin
            Driver class'dan obje olusturulmasini
            Singleton Pattern ile engellemislerdir

            Singleton Pattern,
            Herhangi bir class'dan obje olusturulmasini engellemek icin
            constructor'i gorunur hale getirip
            access modifier'i private yapmak demektir.
         */

    @Test
    public void aramaTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


    }

}
