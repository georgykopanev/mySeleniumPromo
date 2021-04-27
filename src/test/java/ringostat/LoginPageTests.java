package ringostat;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LoginPageTests {
    static WebDriver driver;
    static LoginPage loginPage;
    static String realLogin = "mytestacc2741@gmail.com";
    static String realPassword = "asAS1234";

    @BeforeClass
    public static void setupDriver(){
        String firefoxDriverPath = System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        String chromeDriverPath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }
    @Before
    public void setupTest(){
        //Here we pick the driver. Please, uncomment the driver you want to use and comment others
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://app.ringostat.com/users/login");

    }

    @After
    public void finishTest(){
        driver.close();
    }

    @Test
    public void loginFieldTextEnter(){
        LoginPage loginPage = new LoginPage(driver);
        var loginFieldText = "test@gmail.com"; //viable email address
        loginPage.setLoginFieldText(loginFieldText);
        var checkedLogin = loginPage.getLoginFieldText();

        Assert.assertEquals(loginFieldText, checkedLogin);
    }

    @Test
    public void passwordFieldTextEnter(){
        LoginPage loginPage = new LoginPage(driver);
        var passwordFieldText = "testTest";
        loginPage.setPasswordFieldText(passwordFieldText);
        var checkedPassword = loginPage.getPasswordFieldText();

        Assert.assertEquals(passwordFieldText, checkedPassword);
    }

    @Test
    public void loginWithUncheckedCheckboxes(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginFieldText(realLogin);
        loginPage.setPasswordFieldText(realPassword);
        loginPage.enableLoginButton();
        loginPage.clickLoginButton();

        Assert.assertEquals("Log in | Ringostat", loginPage.getTitle());
    }

}
