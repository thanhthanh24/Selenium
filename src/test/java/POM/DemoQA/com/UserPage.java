package POM.DemoQA.com;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.StringReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class UserPage {
    private WebDriver webDriver;

    //Khai báo biến
    private static final String urlDemoQA = "https://demoqa.com/";

    private static final String Test1234 = "http://test.rubywatir.com/radios.php";
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/p/input[2]")
    private WebElement test;



    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']")
    private WebElement txtElement;

     private static final String itemMenu = "//div[@class='card-body']//h5[text()='%s']";


    //@FindBy(xpath = "//span[@class='text'and text() ='Web Tables']")
    //private WebElement txtWebTable;

    private static final String itemElements = "//span[@class='text'and text() ='%s']";

    @FindBy(id = "addNewRecordButton")
    private WebElement btnAdd;

/*    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    @FindBy(id = "age")
    private WebElement age;
    @FindBy(id = "salary")
    private WebElement salary;
    @FindBy(id = "department")
    private WebElement department;*/


    private static final String itemAdd = "//div[@class='modal-body']//input[@id='%s']";

    @FindBy(id = "submit")
    private WebElement btnSubmit;
    //div[@class='rt-resizable-header-content' and text() ='Email']";
    // private static final String userTable = "//div[@class='rt-resizable-header-content' and text() ='%s']";
    @FindBy(xpath = "(//div[@role='rowgroup']//div[@role='row' and not(contains(@class, '-padRow '))])[last()]")
    //@FindBy(xpath = "(//div[@role='rowgroup']//div[@role='row' and not(contains(@class, '-padRow '))])[1]
    private WebElement rows;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    private WebElement table;

    @FindBy(xpath = "(//div[@role='rowgroup']//div[@role='row' and not(contains(@class, '-padRow '))])[last()]//span[contains(@id, 'edit-record')]")
    private WebElement iconEdit;

    @FindBy(xpath = "(//div[@role='rowgroup']//div[@role='row' and not(contains(@class, '-padRow '))])[last()]//span[contains(@id, 'delete-record')]")
    private WebElement iconDelete;

    @FindBy(xpath = "//input[@id='yesRadio']")
    private WebElement radioButtonYes;

    //Bước 1: truy cập trang demoQA
    public void openDemoQA() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
        //webDriver.get(Test1234);
        webDriver.get(urlDemoQA);

    }
    public void testRadio() {
        test.click();
    }



    //Bước 2:  Click tab Elements
    public void clickElement(String menuName) {
       // txtElement.click();
         WebElement element = webDriver.findElement(By.xpath(itemMenu.formatted(menuName)));
        element.click();
    }

    //Bước 3:  Click tab Web Tables
    public void clickSubElements(String menuElements) {
        //txtWebTable.click();
        WebElement element = webDriver.findElement(By.xpath(itemElements.formatted(menuElements)));
        element.click();
    }

    //Bước 4: Click btn Add
    public void clickBTNAdd() {
        btnAdd.click();
    }

    //Radio Button
    public void clíckRadioButtonYes() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(radioButtonYes));
        radioButtonYes.click();
    }


    //Bước 5 : Add new user
    public void inputRegistrationForm(String inputFirstName, String inputLastName, String inputUserEmail, String inputAge, String inputSalary, String inputDepartment) throws InterruptedException {
        //WebElement element = webDriver.findElement(By.xpath(itemAdd.formatted(inputFirstName)));
        /*firstName.sendKeys(inputFirstName);
        lastName.sendKeys(inputLastName);
        userEmail.sendKeys(inputUserEmail);
        age.sendKeys(inputAge);
        salary.sendKeys(inputSalary);
        department.sendKeys(inputDepartment);*/
        fillInput("firstName",inputFirstName);
        fillInput("lastName",inputLastName);
        fillInput("userEmail",inputUserEmail);
        fillInput("age",inputAge);
        fillInput("salary",inputSalary);
        fillInput("department",inputDepartment);



        Thread.sleep(3000);
        btnSubmit.click();

        // verifyUser(inputFirstName, inputLastName, inputUserEmail);
        verifyUser2(inputFirstName, inputLastName, inputUserEmail);

    }

    public void fillInput(String idAdd, String value){
        WebElement element = webDriver.findElement(By.xpath(String.format(itemAdd, idAdd)));
        element.clear();
        element.sendKeys(value);
    }

    //Bước 6: Verify user in table
    public void verifyUser(String expectedFirstName, String expectedLastName, String expectedEmail) {
        String lastRowText = rows.getText();

        boolean isUserInTable = lastRowText.contains(expectedFirstName) &&
                lastRowText.contains(expectedLastName) &&
                lastRowText.contains(expectedEmail);
        //chuyển assert
       /* if (isUserInTable) {
            System.out.println("Người dùng có trong bảng.");
        } else {
            System.out.println("Người dùng KHÔNG có trong bảng.");
        }*/
        Assert.assertTrue("Người dùng KHÔNG có trong bảng.",isUserInTable);
    }

    public void verifyUser2(String expectedFirstName, String expectedLastName, String expectedEmail) {
        String data = table.getText();
        var rows = data.split("\n");
        List<String> x = Arrays.asList(rows);
        List<String> input = new ArrayList<>();
        input.add(expectedFirstName);
        input.add(expectedLastName);
        input.add(expectedEmail);
       /* if (x.containsAll(input)) {
            System.out.println("Người dùng có trong bảng.");
        } else {
            System.out.println("Người dùng KHÔNG có trong bảng.");
        }*/
        Assert.assertTrue("Người dùng KHÔNG có trong bảng.",x.containsAll(input));
    }

    //Bước 7 : Edit user vừa thêm và verify thông tin user đc update
    public void editUser(String editFirstName) throws InterruptedException {
        iconEdit.click();
        fillInput("firstName",editFirstName);
        /*firstName.clear();
        firstName.sendKeys(editFirstName);*/
        Thread.sleep(3000);
        btnSubmit.click();

        verifyEditUser(editFirstName);

    }

    public void verifyEditUser(String expectedEditFirstName){
        String lastRowText = rows.getText();

        boolean isUserInTable = lastRowText.contains(expectedEditFirstName) ;

        /*if (isUserInTable) {
            System.out.println("Người dùng đã được chỉnh sửa.");
        } else {
            System.out.println("Người dùng KHÔNG được chỉnh sửa.");
        }*/
        Assert.assertTrue("Người dùng KHÔNG được chỉnh sửa.",isUserInTable);
    }
    //Bước 8. Xóa user và verify user đc xóa khỏi bảng
    public void deleteUser(String expectedFirstName, String expectedLastName, String expectedEmail){
        iconDelete.click();
        verifyUserInTable(expectedFirstName,expectedLastName,expectedEmail);

    }
    public void  verifyUserInTable(String expectedFirstName, String expectedLastName, String expectedEmail){
        String data = table.getText();
        var rows = data.split("\n");
        List<String> x = Arrays.asList(rows);
        List<String> input = new ArrayList<>();
        input.add((expectedFirstName));
        input.add(expectedLastName);
        input.add(expectedEmail);
       /* if (!x.containsAll(input)) {
            System.out.println("Người dùng đã được xóa khỏi bảng.");
        } else {
            System.out.println("Người dùng KHÔNG được xóa khỏi bảng.");
        }*/
        Assert.assertTrue("Người dùng KHÔNG được xóa khỏi bảng.",!x.containsAll(input));
    }
    public void mouseAndKeyboard(String inputValue) throws InterruptedException {
         webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com.vn/?hl=vi");

        Actions actions = new Actions(webDriver);

        WebElement inputText = webDriver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        inputText.click();

        //Nhập giá trị
        actions.sendKeys(inputValue).perform();

        //Ctrl+A
        Thread.sleep(2000);
        inputText.sendKeys(Keys.chord(Keys.CONTROL, "a"));

        //Thực hiện nhấn ENTER
        Thread.sleep(2000);
        actions.sendKeys(Keys.ENTER).perform();

        //Click
        Thread.sleep(2000);
        WebElement linkDeMoQA = webDriver.findElement(By.xpath("//span[@class='VuuXrf' and text()='DEMOQA']"));
        actions.click(linkDeMoQA).perform();

        //DoubleClick
        Thread.sleep(5000);
        WebElement doubleClick = webDriver.findElement(By.xpath("//div[@class='home-banner']"));
        actions.doubleClick().perform();
        Thread.sleep(3000);
    }

    public void clickMouseRight(){
        Actions actions = new Actions(webDriver);
        WebElement mouseRightClick = webDriver.findElement(By.id("rightClickBtn"));
        actions.contextClick(mouseRightClick).perform();

    }

    //Di chuyển chuột và nhấp chuột
    public void moveToElement(String menuName){
        Actions actions = new Actions(webDriver);
        WebElement menuElement = webDriver.findElement(By.xpath(itemMenu.formatted(menuName)));
        actions.moveToElement(menuElement).click().perform();
    }
    //Kéo và thả


    public void alertsConfirm (){
        WebElement buttonConfirmAction = webDriver.findElement(By.id("confirmButton"));
        buttonConfirmAction.click();
    }
    public void alertsOK(){
        Alert alert = webDriver.switchTo().alert();
        //Store the alert text in a variable and verify it
        String text = alert.getText();
        assertEquals(text, "Do you confirm action?");
        //Press the OK button
        alert.accept();
        WebElement textOK = webDriver.findElement(By.id("confirmResult"));
        String resultText = textOK.getText();
        assertEquals(resultText,"You selected Ok");

    }
    public void alertsCancel(){
        Alert alert = webDriver.switchTo().alert();
        //Store the alert text in a variable and verify it
        String text = alert.getText();
        assertEquals(text, "Do you confirm action?");
        //Press the OK button
        alert.dismiss();
        WebElement textOK = webDriver.findElement(By.id("confirmResult"));
        String resultText = textOK.getText();
        assertEquals(resultText,"You selected Cancel");

    }

    public void alertsPrompt  (){
        WebElement buttonConfirmAction = webDriver.findElement(By.id("promtButton"));
        buttonConfirmAction.click();
        Alert alert = webDriver.switchTo().alert();
        //Store the alert text in a variable and verify it
        String text = alert.getText();
        assertEquals(text, "Please enter your name");
        //Type your message
        String nameInput = "Thanh";
        alert.sendKeys(nameInput);
        alert.accept();
        //Press the OK button
        WebElement textOK = webDriver.findElement(By.id("promptResult"));
        String resultText = textOK.getText();
        assertEquals(resultText,"You entered %s".formatted(nameInput));

    }







    public void closeBrower(){
        webDriver.quit();
    }
}





