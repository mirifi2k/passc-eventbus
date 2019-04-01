public class BarAssembler extends Subscriber {
    public BarAssembler(String name) {
        super(name);
    }

    @Override
    public void publish(ChairInProgress chair) {
        chair.setBar(this);
        notify(chair);
    }
}
