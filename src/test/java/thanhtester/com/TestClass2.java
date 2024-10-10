package thanhtester.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass2 {

    //khai báo biến driver
    ChromeDriver driver;

    //khai báo 1 số phần tử mong muốn

    String input = "Thanh123.23";
    String expect = "123.23";


    @BeforeMethod
    public void SetUp(){
        //Sử dụng để drive mình chạy sẽ tương thích với phiên bản web mình đang dùng mà không cần tải xuống

        WebDriverManager.chromedriver().setup();

        //khởi tạo
        driver = new ChromeDriver();

    }
    @Test
    public void  Run(){

        //truy cập tới 1 trang web bất kỳ

        driver.get("https://auto.fresher.dev/lessons/lession7/index.html");

        //trỏ tới phần tử id mong muốn
        WebElement textbox = driver.findElement(By.id("txtInput3"));

        //nhập giá trị input vào
       // textbox.sendKeys(input);
        ClearData(textbox, input);

        //tạo ra 1 biến để get text sau khi nhập về
        String actual = FindValue(textbox);



        //so sánh text đã nhập với text mong muốn
        Assert.assertEquals(actual,expect);


    }
    //tạo 1 hàm để tìm kiếm đến thuộc tính value
    public  String FindValue(WebElement element ){
        return  element.getAttribute("value");

    }

    //tạo 1 hàm để clear data

    public  void ClearData(WebElement element,String input){
        element.clear();
        element.sendKeys(input);
    }
}
