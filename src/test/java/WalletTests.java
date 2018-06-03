import org.junit.Assert;
import org.junit.Test;

public class WalletTests {

    @Test
    public void addMoneyTest(){
        Wallet wallet = new Wallet();
        wallet.addMoney("RUB", 100);
        Assert.assertEquals("{ RUB : 100 }", wallet.toString());
    }
}
