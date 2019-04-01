public class BackrestAssembler extends Subscriber {
    public BackrestAssembler(String name) {
        super(name);
    }

    @Override
    public void publish(ChairInProgress chair) {
        chair.setBackRest(this);
        notify(chair);
    }
}
