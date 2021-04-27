import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ringostat.LoginPage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        String firefoxDriverPath = System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
        String chromeDriverPath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://app.ringostat.com/users/login");
        WebElement submitButtonElement = driver.findElement(By.xpath("//a[@id='ev_forgot_password_form']/preceding::button"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].removeAttribute('disabled')", submitButtonElement);
        //id: ev_login_button
        System.out.println("azzaa");

      /*  System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
        System.out.println("To run tests at Chrome, enter 1");
        System.out.println("To run tests at Firefox, enter 2");

        int driverPick = 0;
        try {
            driverPick = s.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("You should write a number");
        }

        WebDriver driver;

        switch (driverPick){
            case 2:
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("You didn't pick a browser");
                return;
        }*/

    }
}
