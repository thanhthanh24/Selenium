package thanhtester.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestNG {

    WebDriver driver;

    @Test
    public void Test01() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://mvnrepository.com/artifact/org.testng/testng/7.10.2");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));

        driver.quit();
    }

    @Test
    public void Test02() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://anhtester.com/blog/selenium-java/tao-project-selenium-java-va-testng-framework-voi-maven-tren-intellij-ide");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.quit();
    }



}
