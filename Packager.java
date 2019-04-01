public class Packager extends Subscriber {
    public Packager(String name) {
        super(name);
    }

    @Override
    public void publish(ChairInProgress chair) {
        chair.pack(this);
        notify(chair);
    }
}
