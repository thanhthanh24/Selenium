package DemoQA.com;

import POM.DemoQA.com.POM;
import org.testng.annotations.Test;

public class MainDemoQA {
    @Test
    public void test() throws InterruptedException {
        POM pom = new POM();
        pom.openDemoQA();
        pom.clickElement("Elements");
        //pom.clickElement();
        pom.clickWebTables();
        pom.clickBTNAdd();
        pom.inputRegistrationForm("Thanhhhh", "Tran", "thanh123@gmail.com", "18", "1000000", "HN");
        pom.editUser("Tui Là Thanh nè");
        Thread.sleep(2000);
        pom.deleteUser("Thanhhhh", "Tran", "thanh123@gmail.com");
        pom.closeBrower();
    }
}