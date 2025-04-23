import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberTest {

    /*
    НАПИСАТЬ МЕТОД, КОТОРЫЙ ПРИНИМАЕТ ЧИСЛО И ВОЗВРАЩВЕТ СТРОКУ
    УСЛОВИЕ:
    ЕСЛИ ЧИСЛО КРАТНО 3, ТО ВЕРНУТЬ T
    ЕСЛИ ЧИСЛО КРАТНО 5, ТО ВЕРНУТЬ М,
    ЕСЛИ ЧИСЛО КРАТНО и 3 и 5, ТО ВЕРНУТЬ TMS
     */

    public static String checkNumber(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "TMS";
        }
        else if (number % 3 == 0) {
            return "T";
        }
        else if (number % 5 == 0) {
            return "M";
        }
        else {
            return "blablabla";
        }
    }

@Test
public void test1() {
        String result = checkNumber(3);
        Assert.assertEquals(result,"T");
}
    @Test
    public void test2() {
        String result = checkNumber(5);
        Assert.assertEquals(result,"M");
    }
    @Test
    public void test3() {
        String result = checkNumber(15);
        Assert.assertEquals(result,"TMS");
    }
    @Test
    public void test4() {
        String result = checkNumber(4);
        Assert.assertEquals(result,"blablabla");
    }
    @Test
    public void test5() {
        String result = checkNumber(-3);
        Assert.assertEquals(result, "blablabla");
    }
}