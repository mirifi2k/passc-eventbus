public abstract class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    abstract void publish(ChairInProgress chair);

    void notify(ChairInProgress chair) {
        EventBus.getEventBus().getNotification(chair);
    }

    public String toString() {
        return name;
    }
}