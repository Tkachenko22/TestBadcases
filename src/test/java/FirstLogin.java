import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class FirstLogin {
    private  static final By USER_LOGIN_INPUT = By.id("email-form1");
    private  static  final By USER_PASSWORD_INPUT = By.id("password-form1");
    private static final By USER_CLICK_BUTTON = By.id("submit-form1");
    private   WebDriver driver;





    @Test
    public void WriteCorectLoginAndPassword() {
        setSistemVariable();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tradeltd.com");
        driver.findElement(By.cssSelector(".main-login-form-container")).click();
        driver.findElement(USER_LOGIN_INPUT).sendKeys("2019.9.10.21.42.47.10@mailinator.com");
        driver.findElement(USER_PASSWORD_INPUT).sendKeys("pikachu1995");
        driver.findElement(USER_CLICK_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String result = driver.findElement(By.cssSelector(".ma-tab-heading.ma-tab-heading_accounts")).getText();
        System.out.println(" The Result is " + result);
        boolean actual = result.contains("Personal Information");
        Assert.assertTrue(actual);
        driver.close();
    }



    @Test
    public void WrongEnterEmailAdress() {
        setSistemVariable();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tradeltd.com");
        driver.findElement(By.cssSelector(".main-login-form-container")).click();
        driver.findElement(USER_LOGIN_INPUT).sendKeys("2019.9.10.21.4247.10@mailinator.com");
        driver.findElement(USER_PASSWORD_INPUT).sendKeys("pikachu1995");
        driver.findElement(USER_CLICK_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String result = driver.findElement(By.cssSelector(".error-passwordLogin")).getText();
        System.out.println(" The Result is " + result);
        boolean actual = result.contains("Wrong credentials");
        Assert.assertFalse(actual);
        driver.close();
    }
    @Test
    public void WrongEnterPasswordInTheLoginForm() {
        setSistemVariable();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tradeltd.com");
        driver.findElement(By.cssSelector(".main-login-form-container")).click();
        driver.findElement(USER_LOGIN_INPUT).sendKeys("2019.9.10.21.42.47.10@mailinator.com");
        driver.findElement(USER_PASSWORD_INPUT).sendKeys("pikachu199");
        driver.findElement(USER_CLICK_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String result = driver.findElement(By.cssSelector(".error-passwordLogin")).getText();
        System.out.println(" The Result is " + result);
        boolean actual = result.contains("Wrong credentials");
        Assert.assertFalse(actual);
        driver.close();
    }
    @Test
    public void WrongEnterLoginAndPasswordInTheLoginForm() {
        setSistemVariable();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tradeltd.com");
        driver.findElement(By.cssSelector(".main-login-form-container")).click();
        driver.findElement(USER_LOGIN_INPUT).sendKeys("2019.9.10.21.4247.10@mailinator.com");
        driver.findElement(USER_PASSWORD_INPUT).sendKeys("pikachu199");
        driver.findElement(USER_CLICK_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String result = driver.findElement(By.cssSelector(".error-passwordLogin")).getText();
        System.out.println(" The Result is " + result);
        boolean actual = result.contains("Wrong credentials");
        Assert.assertFalse(actual);
    }

    private void setSistemVariable() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
    }
}