package thanhtester.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TryTestClass2 {
    //Khai báo biến để các hàm có thể gọi vào

    ChromeDriver driver;
    //biến toàn cục
    String input = "Thanh123";

    String expect = "123";

    @BeforeMethod
    public void SetUp(){
        //để tương thích version các trình duyệt

        WebDriverManager.chromedriver().setup();

        //khởi tạo biến driver

        driver = new ChromeDriver();
    }

    @Test
    public void Run(){
        //trỏ tới trang web mong muốn
        //lấy biến đã khởi tạo và dùng hàm get để get giá trị

        driver.get("https://auto.fresher.dev/lessons/lession7/index.html");

        //sau khi đã truy cập đc trang web thì tìm phần tử

        WebElement textbox = driver.findElement(By.id("txtInput3"));

        //1.Clear giá trị đã có ở textbox đi
        //2.Nhập giá trị mới vào
        //3.So sánh giá trị mới nhập và giá trị trên web sau khi đã nhập

        ClearAndSend(textbox,input);

        //để so sánh giá trị thì phải get được giá trị ở ô textbox sau khi nhập ra
        //để get được sử dụng Attribute với thuộc tính trên web lấy value

        String actual = textbox.getAttribute("value");

        Assert.assertEquals(actual,expect);

    }
    //biến cục bộ
    public void ClearAndSend(WebElement element, String input2){
        element.clear();
        element.sendKeys(input2);

    }
}
