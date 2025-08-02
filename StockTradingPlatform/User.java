import java.util.HashMap;
import java.util.Map;

class User {
    private String userName;
    private double balance;
    Map<String, Integer> portfolio = new HashMap<>();

    User(String userName, double balance) {
        this.userName = userName;
        this.balance = balance;
    }

    String getUserName() {
        return userName;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    void buyStock(String symbol, int quantity) {
        portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);
    }

    void sellStock(String symbol, int quantity) {
        if (portfolio.containsKey(symbol)) {
            int current = portfolio.get(symbol);
            if (quantity >= current) {
                portfolio.remove(symbol);
            } else {
                portfolio.put(symbol, current - quantity);
            }
        }
    }

    void displayPortfolio(Map<String, Stock> market) {
        System.out.println("--- Portfolio ---");
        for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
            String sym = entry.getKey();
            int qty = entry.getValue();
            Stock s = market.get(sym);
            System.out.printf("%s (%s): %d shares @ %.2f$ each\n", s.getName(), sym, qty, s.getPrice());
        }
    }
}





