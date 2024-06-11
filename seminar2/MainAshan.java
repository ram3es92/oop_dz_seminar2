package seminar2;

public class MainAshan {
    public static void main(String[] args) {
        Market market = new Market();

        Human pokupatel1 = new Human("Иван");
        Human pokupatel2 = new Human("Инна");
        Human pokupatel3 = new Human("Махмед");
        market.acceptToMarket(pokupatel1);
        market.acceptToMarket(pokupatel2);
        market.acceptToMarket(pokupatel3);
        market.update();

        Human pokupatel4 = new Human("Рахмон");
        Human pokupatel5 = new Human("Джигурда");
        market.acceptToMarket(pokupatel4);
        market.acceptToMarket(pokupatel5);
        market.update();

        Human pokupatel6 = new Human("Николай");
        market.acceptToMarket(pokupatel6);
        market.update();
        market.update();
    }
}