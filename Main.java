
public class Main {
    public static void main(String[] args) {
        EventBus bus = EventBus.getEventBus();

        bus.addChairs(10);
        bus.subscribe(new SeatCutter("Gigi"));
        bus.subscribe(new FeetAssembler("Alin"));
        //bus.subscribe(new BackrestAssembler("Vasile"));
        bus.subscribe(new BarAssembler("Mihai"));
        bus.subscribe(new Packager("Rodin"));

        bus.start();
    }
}
