class Stock {
    private String symbol, name;
    private double price;

    // Constructors
    Stock() {
        this.symbol = "";
        this.name = "";
        this.price = 0.0;
    }

    Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    // Getters
    String getSymbol() {
        return symbol;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    // Setters
    void setPrice(double price) {
        this.price = price;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    void display() {
        System.out.printf("Symbol: %s | Name: %s | Price: %.2f$\n", symbol, name, price);
    }
}