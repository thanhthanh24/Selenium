package pageOjectModel.com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class Login {
    //khai báo webdriver
    private WebDriver webDriver;

    //khai báo các biến
    private static final String urlHome = "https://www.fahasa.com/";

    @FindBy(xpath = "//div[@class='icon_account_gray']")
    private WebElement txtLogin;
    @FindBy(xpath = "//input[@id='login_username']")
    private WebElement inputUser;
    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement inputPass;
    @FindBy(xpath = "//button[@class='fhs-btn-login']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//span[text()='Tài khoản']")
    private WebElement textAcc;

    @FindBy(xpath = "//div[@class='fhs-popup-msg fhs-login-msg']")
    private WebElement errorDisplayed;



    /*private static final String urlHome = "https://www.fahasa.com/";
    private static final String txtLogin = "//div[@class='icon_account_gray']";
    private static final String inputUser = "//input[@id='login_username']";
    private static final String inputPass = "//input[@id='login_password']";
    private static final String buttonLogin = "//button[@class='fhs-btn-login']";
    public static final String textAcc = "//span[text()='Tài khoản']";*/

    /*1.Đăng nhập --> tạo 1 hàm mở brower
2.Nhập username
3.Nhập mật khẩu
--> tạo 1 hàm nhập thông tin
 ---> tạo 1 hàm verify các trường hợp đăng nhập
4.Click Đăng nhập
--> tạo 1 hàm click đăng nhập

--> tạo 1 hàm đóng brower
*/
    //Bước 1 : Mở Brower và click button tài khoản
    public void openBrower() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //@Find
        PageFactory.initElements(webDriver, this);
        webDriver.get(urlHome);

        // WebElement txtLoginAcc = webDriver.findElement(By.xpath(txtLogin));
        txtLogin.click();


    }

    //Bước 2: Nhập các trường
    public void inputInfo(String username, String password) throws InterruptedException {
        //WebElement inputUsername = webDriver.findElement(By.xpath(inputUser));
        //inputUsername.sendKeys(username);
        inputUser.sendKeys(username);


        // WebElement inputPassword = webDriver.findElement(By.xpath(inputPass));
        //inputPassword.sendKeys(password);
        inputPass.sendKeys(password);
        checkLoginButton();
    }

    //Bước 3: Kiểm tra xem button có click được không
    private void checkLoginButton() throws InterruptedException {
        // WebElement loginButton = webDriver.findElement(By.xpath(buttonLogin));
        boolean isEnabled = buttonLogin.isEnabled();
        if (isEnabled) {
            System.out.println("Button có thể click.");
            buttonLogin.click();
            Thread.sleep(4000);
            verifyLogin();
        } else {
            System.out.println("Button đã bị vô hiệu hóa.");
        }
    }

    //Bước 4: Kiểm tra các trường hợp Login
    private void verifyLogin() throws InterruptedException {
        try {
            //webDriver.findElement(By.xpath(textAcc));
            textAcc.isDisplayed();
            Thread.sleep(2000);
            System.out.println("Đăng nhập thành công");
        } catch (Exception e) {
            /*Assert.fail("Tài khoản hoặc mật khẩu không đúng");
            //System.out.println("Tài khoản hoặc mật khẩu không đúng");*/
            if (isErrorDisplayed()) {
                System.out.println("Tài khoản hoặc mật khẩu không đúng");
            } else {
                Assert.fail("Đã xảy ra lỗi gì gì đó đó");
            }
        }
    }

    private boolean isErrorDisplayed() {
        try {
            return errorDisplayed.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }




    //Bước 6: Đóng Brower
    public void closeBrower() {
        webDriver.quit();
    }


}
