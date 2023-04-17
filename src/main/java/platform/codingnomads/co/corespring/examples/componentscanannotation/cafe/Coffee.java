package platform.codingnomads.co.corespring.examples.componentscanannotation.cafe;

public class Coffee implements Drink {

    public Coffee() {
    }

    @Override
    public void orderDrink(String name) {
        System.out.println("Ordering a coffee: " + name);
    }
}
