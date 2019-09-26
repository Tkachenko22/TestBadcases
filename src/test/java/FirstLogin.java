import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class FirstLogin extends   {
    private  static final By USER_LOGIN_INPUT = By.id("email-form1");
    private  static  final By USER_PASSWORD_INPUT = By.id("password-form1");
    private static final By USER_CLICK_BUTTON = By.id("submit-form1");
    private static final String PASSWORD = "Pikachu1995";
    private   WebDriver driver;





    @Test
    public void WriteCorrectLoginAndPassword() {
        driver.get("https://www.tradeltd.com");
        Login("2019.9.10.21.42.47.10@mailinator.com", "pikachu1995");
        TimeOut(10);

        String result = driver.findElement(By.cssSelector(".ma-tab-heading.ma-tab-heading_accounts")).getText();
        System.out.println(" The Result is " + result);
        boolean actual = result.contains("Personal Information");
        Assert.assertTrue(actual);
        driver.close();
    }



    @Test
    public void WrongEnterEmailAdress() {
        driver.get("https://www.tradeltd.com");
        Login("2019.9.10.21.4247.10@mailinator.com", "pikachu1995");
        TimeOut(5);

        String result = driver.findElement(By.cssSelector(".error-passwordLogin")).getText();
        System.out.println(" The Result is " + result);
        boolean actual = result.contains("Wrong credentials");
        Assert.assertFalse(actual);
        driver.close();
    }

    @Test (priority = 1, description = "Login with wrong password", dataProvider = "InvalidPassword")
    public void WrongEnterPasswordInTheLoginForm(String PASSWORD) {
        driver.get("https://www.tradeltd.com");
        Login("2019.9.10.21.42.47.10@mailinator.com", "pikachu199");
        TimeOut(5);


        String result = driver.findElement(By.cssSelector(".error-passwordLogin")).getText();
        System.out.println(" The Result is " + result);
        boolean actual = result.contains("Wrong credentials");
        Assert.assertFalse(actual);
        //driver.close();
    }

    @Test
    public void WrongEnterLoginAndPasswordInTheLoginForm() {
        driver.get("https://www.tradeltd.com");
        Login("2019.9.10.21.4247.10@mailinator.com", "pikachu199");
        TimeOut(5);

        String result = driver.findElement(By.cssSelector(".error-passwordLogin")).getText();
        System.out.println(" The Result is " + result);
        boolean actual = result.contains("Wrong credentials");
        Assert.assertFalse(actual);
    }




     @BeforeSuite
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    private void TimeOut(int i) {
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }
    private void Login(String s, String PASSWORD) {
        driver.findElement(By.cssSelector(".main-login-form-container")).click();
        driver.findElement(USER_LOGIN_INPUT).sendKeys(s);
        driver.findElement(USER_PASSWORD_INPUT).sendKeys("Pikachu199");
        driver.findElement(USER_CLICK_BUTTON).click();
    }
    @DataProvider
    private Object [] [] InvalidPassword(){
        return  new   Object[][]{
                {"rtyrty"},
                {" "},
                {"325454"}

        };
    }
}