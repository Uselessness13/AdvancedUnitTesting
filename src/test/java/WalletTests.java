import static org.mockito.Mockito.*;

import Exceptions.NotEnoughMoneyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WalletTests {

    private Bank bank;

    @Before
    public void before() {
        bank = mock(Bank.class);
    }

    @Test
    public void addMoneyTest() {
        Wallet wallet = new Wallet(bank);
        wallet.addMoney("RUB", 100);
        Assert.assertEquals("{ RUB : 100 }", wallet.toString());
    }

    @Test
    public void removeMoneyTest() {
        Wallet wallet = new Wallet(bank);
        wallet.addMoney("RUB", 100);
        try {
            wallet.removeMoney("RUB", 100);
            Assert.assertEquals("{  }", wallet.toString());
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTotalMoney() {
        Wallet wallet = new Wallet(bank);
        wallet.addMoney("RUB", 100);
        wallet.addMoney("RUB", 150);
        when(wallet.getTotalMoney("RUB")).thenReturn(250);
        Assert.assertEquals(250, wallet.getTotalMoney("RUB"));
    }
}
