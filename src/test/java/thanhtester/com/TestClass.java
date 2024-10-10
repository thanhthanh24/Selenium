package thanhtester.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass {

    //Khai báo biến toàn cục , hay trong lap trinh huong doi tuong gọi là thuộc tính
    //Khai báo bên ngoài để có thể truy cập các phương thức

    ChromeDriver chromeDriver;

    String input2 = "abc@#123.12b";
    String expect = "123.12";


    @BeforeMethod
    public void SetUp() {
        //khởi tạo ra 1 trình duyệt chorm

        WebDriverManager.chromedriver().setup();

        chromeDriver = new ChromeDriver();

    }

    @Test
    public void Run() {
        //body: di chuyển vào trang gg
        chromeDriver.get("https://auto.fresher.dev/lessons/lession7/index.html");
        //Sleep(5000);

        WebElement button1 = chromeDriver.findElement(By.id("btnExample1"));
        button1.click();

        /*List<WebElement> buttons = chromeDriver.findElements(By.className("btn-success"));

        for (int i = 0 ; i <buttons.size(); i++){
           buttons.get(i).click();
           Sleep(3000);
        }*/

        WebElement label1 = chromeDriver.findElement(By.id("lbStatusButton"));
        String labelvalue1 = label1.getText();

        Assert.assertEquals(labelvalue1,"Click on Button 1");


        //tìm kiếm đến giá trị bằng id
        WebElement input = chromeDriver.findElement(By.id("txtInput1"));

        //tạo 1 biến để get giá trị của textbox với kiểu String
        String inputvalue = input.getAttribute("value");

        //Sử dụng khẳng định để so sánh giá trị get được với giá trị mong muốn
        Assert.assertEquals(inputvalue,"Default value of input");


        //Clear giá trị của textbox đi
        input.clear();

        //khởi tạo 1 biến mới
        String inputnew = "Tran Thanh Thanh ";

        //Nhập giá trị vào Textbox

        input.sendKeys(inputnew);
        String inputvalunew = input.getAttribute("value");

        //So sánh giá trị vừa nhập với giá trị vừa nhập trên Textbox

        Assert.assertEquals(inputvalunew,"Tran Thanh Thanh ");












    }

    @AfterMethod
    public void CleadUp() {
        //tắt trình duyệt
       // chromeDriver.quit();

    }

    private void Sleep(long time){
        try{

            /* Bạn muốn tạm dừng hoặc "ngủ" trong một khoảng thời gian cụ thể được xác định bởi biến time.
             Phương thức Thread.sleep() gây ra việc ngừng thực thi của luồng hiện tại trong khoảng thời gian nhất định.*/

            /*Phương thức Thread.sleep() có thể gây ra ngoại lệ InterruptedException nếu luồng bị ngắt khi đang ngủ.
            Đây là một ngoại lệ kiểm tra (checked exception), có nghĩa là bạn phải xử lý nó hoặc khai báo rằng phương thức của bạn có thể ném ngoại lệ này.*/

                // // Thử tạm dừng luồng hiện tại trong thời gian 'time' mili giây


            Thread.sleep(time);
        }catch (Exception ex){
            /*Mục đích: Khi một ngoại lệ InterruptedException xảy ra trong khối try,
            chương trình sẽ nhảy đến khối catch. Tại đây, bạn xử lý ngoại lệ bằng cách in ra thông điệp lỗi.
        Xử lý: ex.getMessage() trả về thông điệp mô tả lỗi, giúp bạn hiểu lý do tại sao ngoại lệ xảy ra.
        Việc in thông điệp lỗi giúp bạn gỡ lỗi và biết rằng có sự cố xảy ra trong quá trình thực thi.*/

            // Nếu một InterruptedException xảy ra, xử lý lỗi bằng cách in ra thông điệp lỗi

            System.out.println(ex.getMessage());
        }
    }
}
