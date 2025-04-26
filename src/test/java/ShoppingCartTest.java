import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ShoppingCartTest {

    @Test
    public void checkDiscount0() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&" +
                "last_name=test&email=test%40test.test&password1=12345&password2=12345");

        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "0", "Discount percentage isn't equal to 0");
        softAssert.assertEquals(discount$, "0.0", "Discount amount isn't equal to 0.0");
        softAssert.assertEquals(total$, "190.00", "Total amount isn't equal to 190.00");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount2() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&" +
                "last_name=test&email=test%40test.test&password1=12345&password2=12345");

        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("20");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "2", "Discount percentage isn't equal to 2");
        softAssert.assertEquals(discount$, "4.0", "Discount amount isn't equal to 4.0");
        softAssert.assertEquals(total$, "196.00", "Total amount isn't equal to 196.00");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount3() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&" +
                "last_name=test&email=test%40test.test&password1=12345&password2=12345");

        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("50");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "3", "Discount percentage isn't equal to 3");
        softAssert.assertEquals(discount$, "15.0", "Discount amount isn't equal to 15.0");
        softAssert.assertEquals(total$, "485.00", "Total amount isn't equal to 485.00");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount4() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&" +
                "last_name=test&email=test%40test.test&password1=12345&password2=12345");

        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("100");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "4", "Discount percentage isn't equal to 4");
        softAssert.assertEquals(discount$, "40.0", "Discount amount isn't equal to 40.0");
        softAssert.assertEquals(total$, "960.00", "Total amount isn't equal to 960.00");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount5() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&" +
                "last_name=test&email=test%40test.test&password1=12345&password2=12345");

        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("500");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "5", "Discount percentage isn't equal to 5");
        softAssert.assertEquals(discount$, "250.0", "Discount amount isn't equal to 250.0");
        softAssert.assertEquals(total$, "4750.00", "Total amount isn't equal to 4750.00");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount6() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&" +
                "last_name=test&email=test%40test.test&password1=12345&password2=12345");

        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("1000");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "6", "Discount percentage isn't equal to 6");
        softAssert.assertEquals(discount$, "600.0", "Discount amount isn't equal to 600.0");
        softAssert.assertEquals(total$, "9400.00", "Total amount isn't equal to 9400.00");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount7() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&" +
                "last_name=test&email=test%40test.test&password1=12345&password2=12345");

        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("5000");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "7", "Discount percentage isn't equal to 7");
        softAssert.assertEquals(discount$, "3500.0", "Discount amount isn't equal to 3500.0");
        softAssert.assertEquals(total$, "46500.00", "Total amount isn't equal to 46500.00");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount8() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&" +
                "last_name=test&email=test%40test.test&password1=12345&password2=12345");

        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("10000");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "8", "Discount percentage isn't equal to 8");
        softAssert.assertEquals(discount$, "8000.0", "Discount amount isn't equal to 8000.0");
        softAssert.assertEquals(total$, "92000.00", "Total amount isn't equal to 92000.00");

        driver.quit();
        softAssert.assertAll();
    }
}