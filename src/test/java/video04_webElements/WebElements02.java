package video04_webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements02 {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.facebook.com adresine gidin
        driver.get("https:www.facebook.com");

        // cookies cikarsa kabul et butonuna basin
        //driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();

        // cookies cikarsa kabul et butonuna basin - almanca facebook´a güncelledim. Otomatik click yapacak.
        driver.findElement(By.xpath("//button[@title='Erforderliche und optionale Cookies erlauben']")).click();

        // e-posta kutusuna rastgele bir mail girin
        WebElement epostaKutusu= driver.findElement(By.xpath("//input[@id='email']"));
        epostaKutusu.sendKeys("Hlkiujhgtrf");

        // sifre kismina rastgele bir sifre girin
        WebElement passKutusu= driver.findElement(By.xpath("//input[@id='pass']"));
        passKutusu.sendKeys("ydgfkshd");

        // giris yap butonuna basin
        driver.findElement(By.xpath("//button[@name='login']")).click();

        /*
        // uyari olarak "The email or mobile number you entered isn’t connected to an account.
        // Find your account and log in."  mesajinin ciktigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedSonucYazisi="The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
        String actualSonucYazisi=sonucYaziElementi.getText();
        if (expectedSonucYazisi.equals(actualSonucYazisi)){
            System.out.println("girilemedi testi passed");
        } else {
            System.out.println("girilemedi testi failed");
        }
        */

        //uyari olarak "Die eingegebenen E-Mail-Adresse ist mit keinem Konto verknüpft.
        // Konto finden und anmelden."  mesajinin ciktigini test edin.
        //expected olmasini istedigin sonuc! actuel ise olan sonuc! birbiri ile örtüsüyorsa ve örtüsmüyorsa...sout
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedSonucYazisi="Die eingegebene E-Mail-Adresse oder Handynummer ist mit keinem Konto verknüpft. Konto finden und anmelden.";
        String actualSonucYazisi=sonucYaziElementi.getText();
        if (expectedSonucYazisi.equals(actualSonucYazisi)){
            System.out.println("girilemedi testi passed");
        } else {
            System.out.println("girilemedi testi failed");
        }

        // sayfayi kapatin
        driver.close();
    }
}
