public class SeatCutter extends Subscriber {
    public SeatCutter(String name) {
        super(name);
    }

    public void publish(ChairInProgress chair) {
        chair.setSeat(this);
        notify(chair);
    }
}
