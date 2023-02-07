package video06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C2_AssertionMethodlariIleTest {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {

        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https:www.amazon.com");

        //2- arama cubuguna “Nutella” yazdirin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");

        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin
        aramaKutusu.submit();

        //4- Bulunan sonuc yazisinin "Nutella" icerdigini test edelim
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualYaziStr= sonucYaziElementi.getText();
        // 1-48 of 105 results for "Nutella"
        String expectedBulunacakKelime="Kutella";

        Assert.assertTrue(actualYaziStr.contains(expectedBulunacakKelime));

        /*
        int aliYas=56;     Alinin emekli olamayacagini test edin:
                            Assert.assertFalse(aliYas > emeklilikYasi) --> false / false  (PASSED)

        int veliYas=68;     velinin emekli olabilecegini test edin:
                            Assert.assertTrue(veliYas > emeklilikYasi)  --> true / true   (PASSED)

        int emeklilikYasi=65;   emekli yasinin 65 oldugunu test edin:
                                Assert.assertEqual(65, emeklilikYasi)  --> equal / equal  (PASSED)


        => test ne zaman FAILED olur. beklentin ile test sonucu farkli olursa failed olur.

        Alinin emekli olabilecegini test edin. beklentimiz emekli olmasi:assertTrue , kosul:false  (FAILED)
        Velinin emekli olamayacagini test edin.  (FAILED)
        Emeklilik yasinin 63 oldugunu test edin. (FAILED)

         */

        }

    }

