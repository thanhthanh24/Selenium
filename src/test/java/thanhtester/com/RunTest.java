package thanhtester.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunTest {
    /*public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup(); //gọi phiên bản brower

        driver = new EdgeDriver(); //khởi tạo giá trị cho brower

        driver.get("https://anhtester.com/blog/selenium-java/tao-project-selenium-java-va-testng-framework-voi-maven-tren-intellij-ide");
    }*/

    @Test
    public void Run(){
        System.out.println("Thanh nè");

        Assert.assertEquals(1,3,"1 not equal 2");
        Assert.assertNotEquals("a","A");
      //  Assert.assertTrue("true",);
        //Assert.assertFalse("true");
    }
}










