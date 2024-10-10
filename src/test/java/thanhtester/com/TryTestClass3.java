package thanhtester.com;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TryTestClass3 {
    ChromeDriver chromeDriver;
    String input = "Thanh24082000";
    String expect ="24082000";

    @BeforeMethod
    public void SetUp(){
        //thực hiện cài đặt version tương thích
        ChromeDriverManager.chromedriver().setup();


        //khởi tạo biến mới rỗng
        chromeDriver =new ChromeDriver();
    }

    @Test
    public void Run(){

        //trỏ tới trang web mong muốn : nằm trong test thì mới được
        chromeDriver.get("https://auto.fresher.dev/lessons/lession7/index.html");
        //tìm kiếm chính xác giá trị phần tử trên trang web

        WebElement textbox = chromeDriver.findElement(By.id("txtInput3"));

        ClearAndSend(textbox,input);

        String actual = textbox.getAttribute("value");
        Assert.assertEquals(expect,actual);

    }

    public void ClearAndSend(WebElement element, String Thanh){
        element.clear();
        element.sendKeys(Thanh);
    }

}
