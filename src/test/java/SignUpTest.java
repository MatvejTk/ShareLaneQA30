import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    @Test
    public void checkSignUpValidData() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        driver.findElement(By.name("first_name")).sendKeys("John");
        driver.findElement(By.name("last_name")).sendKeys("Doe");
        driver.findElement(By.name("email")).sendKeys("jd@1.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String actualSuccessMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(actualSuccessMessage, "Account is created!");
        driver.quit();
    }
}

//Account is created!
// /*
//1. Ввести валидное значение zip code
//2. Проверить, что мы оказались на странице с форомой регистрации
//3. Заполнить форму регистрации
//4. Нажать кнопку Register
//5. Проверить, что регистрация выполнена успешно
// */
