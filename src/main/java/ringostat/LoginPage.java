package ringostat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
        private WebDriver driver;

        public LoginPage(WebDriver driver){this.driver = driver;}

        //Here we find all fields we want to test
        //Most of them can be found by id, but for promo I use more complex solutions
        private By loginField = By.xpath("//input[@id='UserUsername']"); //example of simple xpath
        private By passwordField = By.xpath("//div[@class='form-group'][2]/child::input");  //example of axes usage
        private By offerCheckbox = By.id("ev_offer"); //just id
        private By offerLink = By.xpath("//div[@id='ev_gdpr']//*[contains(text(),'offer')]"); //example of contains function
        private By privacyCheckbox = By.id("ev_privacy");
        private By privacyLink = By.xpath("//span[starts-with(text(),'privacy')]"); //example of starts-with function
        private By submitButton = By.xpath("//a[@id='ev_forgot_password_form']/preceding::button"); //example of preceding axis
        private By restorePasswordLink = By.xpath("//form[@id='ev_login_form']/button/following::a"); //text after button on some form
        private By registerLink = By.xpath("//a/child::small[starts-with(text(),\"Don't\")]/.."); //uplevel and apostrophe escape

        public String getTitle(){
                return driver.getTitle();
        }


        public void setLoginFieldText(String login){
            driver.findElement(loginField).sendKeys(login);
        }
        public String getLoginFieldText(){
            return driver.findElement(loginField).getAttribute("value");
        }

        public void setPasswordFieldText(String password){
                driver.findElement(passwordField).sendKeys(password);
        }
        public String getPasswordFieldText(){
                return driver.findElement(passwordField).getAttribute("value");
        }


        public void clickLoginButton(){
                driver.findElement(submitButton).click();
        }
        //Enables login button as if user removed the "disabled" tag via browser devtools
        public void enableLoginButton(){
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].removeAttribute('disabled')", driver.findElement(submitButton));
        }

}
