import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class StockTradingPlatform {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Stock> market = new HashMap<>();
    static User user;

    public static void main(String[] args) {
        addSampleStocks();
        user = new User("John Doe", 10000.0);

        System.out.println("--- Welcome to the Stock Trading Platform ---");

        while (true) {
            showMenu();
            int ch = sc.nextInt();
            sc.nextLine(); // Clear buffer
            switch (ch) {
                case 1 -> viewMarket();
                case 2 -> buyStock();
                case 3 -> sellStock();
                case 4 -> user.displayPortfolio(market);
                case 5 -> System.out.printf("Current Balance: %.2f$\n", user.getBalance());
                case 0 -> {
                    System.out.println("Exiting platform. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void showMenu() {
        System.out.println("\nSelect an option:\n" +
                "1. View Market\n" +
                "2. Buy Stock\n" +
                "3. Sell Stock\n" +
                "4. View Portfolio\n" +
                "5. Check Balance\n" +
                "0. Exit");
    }

    static void addSampleStocks() {
        market.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.0));
        market.put("GOOG", new Stock("GOOG", "Alphabet Inc.", 2800.0));
        market.put("TSLA", new Stock("TSLA", "Tesla Inc.", 700.0));
        market.put("MSFT", new Stock("MSFT", "Microsoft Corp.", 300.0));
    }

    static void viewMarket() {
        System.out.println("--- Market Stocks ---");
        for (Stock s : market.values()) {
            s.display();
        }
    }

    static void buyStock() {
        System.out.print("Enter stock symbol to buy: ");
        String symbol = sc.nextLine().toUpperCase();
        if (!market.containsKey(symbol)) {
            System.out.println("Stock not found.");
            return;
        }
        Stock stock = market.get(symbol);
        System.out.print("Enter quantity to buy: ");
        int qty = sc.nextInt();
        double total = qty * stock.getPrice();

        if (user.getBalance() >= total) {
            user.setBalance(user.getBalance() - total);
            user.buyStock(symbol, qty);
            System.out.printf("Bought %d shares of %s for %.2f$.\n", qty, symbol, total);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    static void sellStock() {
        System.out.print("Enter stock symbol to sell: ");
        String symbol = sc.nextLine().toUpperCase();
        if (!market.containsKey(symbol)) {
            System.out.println("Stock not found.");
            return;
        }
        Stock stock = market.get(symbol);
        System.out.print("Enter quantity to sell: ");
        int qty = sc.nextInt();

        Map<String, Integer> portfolio = new HashMap<>(user.portfolio);
        int owned = portfolio.getOrDefault(symbol, 0);

        if (owned >= qty) {
            double total = qty * stock.getPrice();
            user.setBalance(user.getBalance() + total);
            user.sellStock(symbol, qty);
            System.out.printf("Sold %d shares of %s for %.2f$.\n", qty, symbol, total);
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }
}
