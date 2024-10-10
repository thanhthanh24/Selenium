package nhasachFaHaSa.com;

import org.testng.annotations.Test;

import pageOjectModel.com.Login;


public class MainBook {
    @Test
    public void testSuccess() throws InterruptedException {
        Login login = new Login();
        login.openBrower();
        login.inputInfo("0964639446", "Thanhtran123");
        login.closeBrower();
        Thread.sleep(2000);
    }

    @Test
    public void testUsernameShort() throws InterruptedException {
        Login login = new Login();
        login.openBrower();

        login.inputInfo("123456767", "Thanhtran123");
        login.closeBrower();
        Thread.sleep(2000);

    }

    @Test
    public void testUserNameLong() throws InterruptedException {
        Login login = new Login();
        login.openBrower();
        login.inputInfo("12345678797564565", "Thanhtran123");
        login.closeBrower();
        Thread.sleep(2000);
    }

    @Test
    public void testUserNameFail() throws InterruptedException {
        Login login = new Login();
        login.openBrower();
        login.inputInfo("0964639456", "Thanhtran123");
        login.closeBrower();
        Thread.sleep(2000);
    }

    @Test
    public void testPasswordFail() throws InterruptedException {
        Login login = new Login();
        login.openBrower();
        login.inputInfo("0964639446", "Thanhtran1234");
        login.closeBrower();
        Thread.sleep(2000);
    }


}

