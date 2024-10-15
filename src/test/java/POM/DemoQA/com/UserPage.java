package POM.DemoQA.com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserPage {
    private WebDriver webDriver;

    //Khai báo biến
    private static final String urlDemoQA = "https://demoqa.com/";


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

    //Bước 1: truy cập trang demoQA
    public void openDemoQA() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
        webDriver.get(urlDemoQA);

    }

    //Bước 2:  Click tab Elements
    public void clickElement(String menuName) {
       // txtElement.click();
         WebElement element = webDriver.findElement(By.xpath(itemMenu.formatted(menuName)));
        element.click();
    }

    //Bước 3:  Click tab Web Tables
    public void clickWebTables(String menuElements) {
        //txtWebTable.click();
        WebElement element = webDriver.findElement(By.xpath(itemElements.formatted(menuElements)));
        element.click();
    }

    //Bước 4: Click btn Add
    public void clickBTNAdd() {
        btnAdd.click();
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




    public void closeBrower(){
        webDriver.quit();
    }
}





