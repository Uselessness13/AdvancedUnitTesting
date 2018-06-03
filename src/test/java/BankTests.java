import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTests{
    private Bank bank;
    @Before
    public void before(){
        bank = new Bank();
    }
    @Test
    public void convertTest(){
        int converted = bank.convert(100, "USD", "EUR");
        Assert.assertTrue(converted >= 69 && converted <= 105);
    }
}
