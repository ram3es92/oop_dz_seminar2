package seminar2;

import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {
    private final List<Actor> queue;
    private final List<Actor> inMarket;
    private int totalEntered;

    public Market() {
        this.queue = new ArrayList<>();
        this.inMarket = new ArrayList<>();
        this.totalEntered = 0;
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        this.inMarket.add(actor);
        totalEntered++;
    }

    @Override
    public void takeInQueue(Actor actor) {
        this.queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал свой заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releasedActors = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                releasedActors.add(actor);
            }
        }
        releaseFromMarket(releasedActors);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        System.out.println("");
        System.out.println("Обновление состояния магазина:");
        System.out.println("Количество людей в магазине: " + (inMarket.size() + queue.size()));
        System.out.println("Всего зашло людей: " + totalEntered);
        System.out.println("");

        for (Actor actor : inMarket) {
            takeInQueue(actor);
        }
        inMarket.clear();

        takeOrders();
        giveOrders();
        releaseFromQueue();
    }
}