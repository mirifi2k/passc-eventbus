public class FeetAssembler extends Subscriber {
    public FeetAssembler(String name) {
        super(name);
    }

    @Override
    public void publish(ChairInProgress chair) {
        chair.setFeet(this);
        notify(chair);
    }
}
