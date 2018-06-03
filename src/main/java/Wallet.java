import Exceptions.NotEnoughMoneyException;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.*;

public class Wallet {

    private Map<String,Integer> values;
    private Bank bank;
    private List<String> story;

    Wallet(Bank bank) {
        values = new HashMap<>();
        story = new ArrayList<>();
        this.bank = bank;
    }

    public List<String> getStory() {
        return story;
    }

    void addMoney(String currency, int value){
        values.put(currency, values.containsKey(currency) ? values.get(currency) + value : value);
        story.add(String.format("Add %s : %d", currency, value));
    }

    public void removeMoney(String currency, int value) throws NotEnoughMoneyException {
        if (values.get(currency) < 0)
            throw new NotEnoughMoneyException();
        values.put(currency, values.containsKey(currency) ? values.get(currency) - value : value);
        if (values.get(currency) == 0)
            values.remove(currency);
        story.add(String.format("Removed %s : %d", currency, value));
    }

    public int getTotalMoney(String currency){
        int kek = 0;
        for (String i : values.keySet()){
            kek += bank.convert(values.get(i), i, currency);
        }
        return kek;
    }

    @Override
    public String toString() {
        StringBuilder kek = new StringBuilder();
        kek.append("{ ");
        boolean isFirst = true;
        for (String i : values.keySet()) {
            if (!isFirst)
                kek.append(" , ");
            kek.append(String.format("%s : %d",i, values.get(i) ));
            isFirst = false;
        }
        kek.append(" }");
        return kek.toString();
    }
}
