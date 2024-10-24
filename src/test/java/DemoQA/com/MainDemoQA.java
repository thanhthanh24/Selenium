package DemoQA.com;

import POM.DemoQA.com.UserPage;
import org.testng.annotations.Test;

public class MainDemoQA {
   /* @Test
    public void test() throws InterruptedException {
        UserPage userPage = new UserPage();
        userPage.openDemoQA();
        userPage.clickElement("Elements");
        //pom.clickElement();
        userPage.clickSubElements("Web Tables");
        userPage.clickBTNAdd();
        userPage.inputRegistrationForm("Thanhhhh", "Tran", "thanh123@gmail.com", "18", "1000000", "HN");
        userPage.editUser("Tui Là Thanh nè");
        Thread.sleep(2000);
        userPage.deleteUser("Thanhhhh", "Tran", "thanh123@gmail.com");
        userPage.closeBrower();
    }

    @Test
    public void testRadioButton() {
        UserPage userPage = new UserPage();
        userPage.openDemoQA();
        userPage.clickElement("Elements");
        userPage.clickSubElements("Radio Button");
        userPage.clíckRadioButtonYes();
        userPage.closeBrower();
    }

    // test thử radioButton
    @Test
    public void testRadio() {
        UserPage userPage = new UserPage();
        userPage.openDemoQA();
        userPage.testRadio();
    }

    @Test
    public void thaoTac() throws InterruptedException {
        UserPage userPage = new UserPage();
        userPage.mouseAndKeyboard("demoqa");
        Thread.sleep(3000);
        userPage.clickElement("Elements");
        userPage.clickSubElements("Buttons");
        userPage.clickMouseRight();
    }
    @Test
    public void thaoTac1() throws InterruptedException {
        UserPage userPage = new UserPage();
        userPage.openDemoQA();
        userPage.clickElement("Elements");
        userPage.clickSubElements("Buttons");
        userPage.clickMouseRight();
    }
    @Test
    public void thaoTac2() throws InterruptedException {
        UserPage userPage = new UserPage();
        userPage.openDemoQA();
        userPage.moveToElement("Elements");
    }*/

    @Test
    public void alertsActionOK(){
        UserPage userPage = new UserPage();
        userPage.openDemoQA();
        userPage.clickElement("Alerts, Frame & Windows");
        userPage.clickSubElements("Alerts");
        userPage.alertsConfirm();
        userPage.alertsOK();
        userPage.closeBrower();
    }
    @Test
    public void alertsActionCancel(){
        UserPage userPage = new UserPage();
        userPage.openDemoQA();
        userPage.clickElement("Alerts, Frame & Windows");
        userPage.clickSubElements("Alerts");
        userPage.alertsConfirm();
        userPage.alertsCancel();
        userPage.closeBrower();
    }

    @Test
    public void alertsActionPromt(){
        UserPage userPage = new UserPage();
        userPage.openDemoQA();
        userPage.clickElement("Alerts, Frame & Windows");
        userPage.clickSubElements("Alerts");
        userPage.alertsPrompt();
        userPage.closeBrower();
    }
}