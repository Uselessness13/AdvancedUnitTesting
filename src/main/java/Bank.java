import java.util.*;

class Bank {
    private Map<String, Double> currencies;
    private Random random;

    Bank() {
        random = new Random();
        currencies = new HashMap<>();
        currencies.put("RUB", 0.01d);
        currencies.put("EUR", 1.3659710d);
        currencies.put("USD", 1.0d);
    }

    Integer convert(int value, String from, String to) {
        if (from.equals(to))
            return value;
        return Math.toIntExact(Math.round(((value * currencies.get(from)) / currencies.get(to)) / 100) * (80 + random.nextInt(40)));
    }
}
