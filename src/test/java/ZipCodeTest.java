import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ZipCodeTest {

    @Test
    public void checkZipCode4Digits() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // запуск в браузере теста на проверку элементов UI без показа самого UI
        // options.addArguments("--start-maximized"); // запуск теста в большом окне
        // options.addArguments("--incognito"); // инкогнито
        // options.addArguments("--disable-gpu"); // используется при больших нагрузках, в тч с jenkins
        // options.addArguments("--disable-notifications"); // запрет нотификаций при прогоне теста
        // options.setBinary("/path/opera"); // путь для рана других браузеров (опера), для которых нет своего драйвера
        // Код Жени для решения проблем с паролем
        // HashMap<String, Object> chromePrefs = new HashMap<>();
        // chromePrefs.put("credentials_enable_service", false);
        // chromePrefs.put("profile.password_manager_enabled", false);
        // options.setExperimentalOption("prefs", chromePrefs);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        // browser.manage().window().maximize(); // открывает окно на максимальный размер = start-maximized
        // browser.manage().window().setSize(new Dimension(900, 500)); // размер окна
        // browser.manage().window().setPosition(new Point(900, 300)); // открывает окно в разных местах
        // Set<Cookie> cookies = browser.manage().getCookies(); // получить множество cookies
        // Cookie cookie = new Cookie("tokken", "13123213123"); // создать новую cookie
        // browser.manage().getCookienamed("tokken"); // получить cookie, это используется часто !!!

        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1234");
        String zipCode = browser.findElement(By.name("zip_code")).getAttribute("value");
        System.out.println(zipCode);
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        String actualErrorMessage = browser.findElement(By.className("error_message")).getText();
        Assert.assertEquals(actualErrorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }

    @Test
    public void checkZipCodeEmpty() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        String actualErrorMessage = browser.findElement(By.className("error_message")).getText();
        Assert.assertEquals(actualErrorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }
}
