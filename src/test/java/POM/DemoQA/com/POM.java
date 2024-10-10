package POM.DemoQA.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class POM {
    private WebDriver webDriver;

    //Khai báo biến
    private static final String urlDemoQA = "https://demoqa.com/";


    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']")
    private WebElement txtElement;
    // private static final String itemMenu = "//div[@class='card-body']/h5[text()='%s";


    @FindBy(xpath = "//span[@class='text'and text() ='Web Tables']")
    private WebElement txtWebTable;

    @FindBy(id = "addNewRecordButton")
    private WebElement btnAdd;

    @FindBy(id = "firstName")
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
    private WebElement department;
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
    public void clickElement() {
        txtElement.click();
        // WebElement element = webDriver.findElement(By.xpath(itemMenu.formatted(menuNameElements)));
    }

    //Bước 3:  Click tab Web Tables
    public void clickWebTables() {
        txtWebTable.click();
    }

    //Bước 4: Click btn Add
    public void clickBTNAdd() {
        btnAdd.click();
    }

    //Bước 5 : Add new user
    public void inputRegistrationForm(String inputFirstName, String inputLastName, String inputUserEmail, String inputAge, String inputSalary, String inputDepartment) throws InterruptedException {
        firstName.sendKeys(inputFirstName);
        lastName.sendKeys(inputLastName);
        userEmail.sendKeys(inputUserEmail);
        age.sendKeys(inputAge);
        salary.sendKeys(inputSalary);
        department.sendKeys(inputDepartment);
        Thread.sleep(3000);
        btnSubmit.click();

        // verifyUser(inputFirstName, inputLastName, inputUserEmail);
        verifyUser2(inputFirstName, inputLastName, inputUserEmail);

    }

    //Bước 6: Verify user in table
    public void verifyUser(String expectedFirstName, String expectedLastName, String expectedEmail) {
        String lastRowText = rows.getText();

        boolean isUserInTable = lastRowText.contains(expectedFirstName) &&
                lastRowText.contains(expectedLastName) &&
                lastRowText.contains(expectedEmail);

        if (isUserInTable) {
            System.out.println("Người dùng có trong bảng.");
        } else {
            System.out.println("Người dùng KHÔNG có trong bảng.");
        }
    }

    public void verifyUser2(String expectedFirstName, String expectedLastName, String expectedEmail) {
        String data = table.getText();
        var rows = data.split("\n");
        List<String> x = Arrays.asList(rows);
        List<String> input = new ArrayList<>();
        input.add(expectedFirstName);
        input.add(expectedLastName);
        input.add(expectedEmail);
        if (x.containsAll(input)) {
            System.out.println("Người dùng có trong bảng.");
        } else {
            System.out.println("Người dùng KHÔNG có trong bảng.");
        }
    }

    //Bước 7 : Edit user vừa thêm và verify thông tin user đc update
    public void editUser(String editFirstName) throws InterruptedException {
        iconEdit.click();
        firstName.clear();
        firstName.sendKeys(editFirstName);
        Thread.sleep(3000);
        btnSubmit.click();

        verifyEditUser(editFirstName);

    }

    public void verifyEditUser(String expectedEditFirstName){
        String lastRowText = rows.getText();

        boolean isUserInTable = lastRowText.contains(expectedEditFirstName) ;

        if (isUserInTable) {
            System.out.println("Người dùng đã được chỉnh sửa.");
        } else {
            System.out.println("Người dùng KHÔNG được chỉnh sửa.");
        }
    }
    //Bước 8. Xóa user và verify user đc xóa khỏi bảng
    public void deleteUser(){
        iconDelete.click();

    }
    }





