import Exceptions.NotEnoughMoneyException;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.*;

public class Wallet {

    private Map<String,Integer> values;

    Wallet() {
        values = new HashMap<>();
    }

    void addMoney(String currency, int value){
        values.put(currency, values.containsKey(currency) ? values.get(currency) + value : value);
    }

    public void removeMoney(String currency, int value) throws NotEnoughMoneyException {
        if (values.get(currency) < 0)
            throw new NotEnoughMoneyException();
        values.put(currency, values.containsKey(currency) ? values.get(currency) - value : value);
    }

    public String getTotalMoney(String currency){

        return "";
    }

    @Override
    public String toString() {
        StringBuilder kek = new StringBuilder();
        kek.append("{ ");
        boolean isFirst = true;
        for (String i : values.keySet()) {
            if (!isFirst)
                kek.append(" , ");
            kek.append(String.format(" %s : %d ",i, values.get(i) ));
            isFirst = false;
        }
        kek.append(" }");
        return kek.toString();
    }
}
