package thanhtester.com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestLogin {
    public static  void  inputText(WebElement element, String txtInput) throws InterruptedException {
        element.clear();
        element.sendKeys(txtInput);
        Thread.sleep(2000L);
    }

    public static void main(String[] args) throws InterruptedException {
       WebDriver webDriver = new ChromeDriver();
       webDriver.manage().window().maximize();
       Thread.sleep(2000);

       webDriver.get("https://www.studyphim.vn/");
        WebElement txt_LogIn = webDriver.findElement(By.xpath("//li[div[@class='btn-group auth-btn-group']/a[@class='btn navbar-btn btn-default cd-signin']]"));
        txt_LogIn.click();

        /*WebElement input_Email = webDriver.findElement(By.xpath("//div[@id='cd-login']/form/p[@class='fieldset']/input[@id='signin-email' and @name='email']"));
        input_Email.sendKeys("thanhqtksnb@gmail.com");

        WebElement input_PassWord = webDriver.findElement(By.xpath("//div[@id='cd-login']/form/p/input[@id='signin-password']"));
        input_PassWord.sendKeys("studyphim123");*/

        inputText(
                webDriver.findElement(By.xpath("//div[@id='cd-login']/form/p[@class='fieldset']/input[@id='signin-email' and @name='email']")),"thanhqtksnb@gmail.com"
        );

        inputText(
                webDriver.findElement(By.xpath("//div[@id='cd-login']/form/p/input[@id='signin-password']")),"studyphim123"
        );

        Thread.sleep(2000);

        WebElement show_Pass = webDriver.findElement(By.xpath("//div[@id ='cd-login']/form/p/a[@class='hide-password']"));
        show_Pass.click();
        Thread.sleep(2000);

        WebElement submit_Login = webDriver.findElement(By.xpath("//input[@type='submit' and @value='Đăng nhập']"));
        submit_Login.click();

        WebElement button_Name = webDriver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li/button[@class='btn navbar-btn btn-link dropdown-toggle']"));
        Assert.assertEquals(button_Name.getText(),"Tranthithanh");

        /*if (button_Name.getText().equals("Tranthithanh")){
            System.out.println("Đã hiển thị đúng tên người dùng");
        }else {
            System.out.println("Sai rùi bạn eiii");
        }*/
        webDriver.quit();


    }

}

