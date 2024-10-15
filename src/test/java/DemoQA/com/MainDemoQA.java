package DemoQA.com;

import POM.DemoQA.com.UserPage;
import org.testng.annotations.Test;

public class MainDemoQA {
    @Test
    public void test() throws InterruptedException {
        UserPage userPage = new UserPage();
        userPage.openDemoQA();
        userPage.clickElement("Elements");
        //pom.clickElement();
        userPage.clickWebTables("Web Tables");
        userPage.clickBTNAdd();
        userPage.inputRegistrationForm("Thanhhhh", "Tran", "thanh123@gmail.com", "18", "1000000", "HN");
        userPage.editUser("Tui Là Thanh nè");
        Thread.sleep(2000);
        userPage.deleteUser("Thanhhhh", "Tran", "thanh123@gmail.com");
        userPage.closeBrower();
    }
}