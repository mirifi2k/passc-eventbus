import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private static EventBus instance = null;
    private List<ChairInProgress> chairs;
    private List<Subscriber> subscribers;

    private EventBus() {
        chairs = new ArrayList<ChairInProgress>();
        subscribers = new ArrayList<Subscriber>();
    }

    public void addChairs(int count) {
        for (int i = 0; i < count; i++)
            chairs.add(new ChairInProgress());
    }

    public static EventBus getEventBus() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void start() {
        for (ChairInProgress c : chairs) {
            for (Subscriber s : subscribers) {
                if (s instanceof SeatCutter) {
                    s.publish(c);
                }
            }
        }
    }

    public Subscriber getSubscriberForJob(int status) {
        Subscriber s = null;

        switch (status) {
            case ChairInProgress.NO_SEAT: {
                for (Subscriber sub : subscribers) {
                    if (sub instanceof SeatCutter) {
                        s = sub;
                        break;
                    }
                }
                break;
            }
            case ChairInProgress.NO_FEET: {
                for (Subscriber sub : subscribers) {
                    if (sub instanceof FeetAssembler) {
                        s = sub;
                        break;
                    }
                }
                break;
            }
            case ChairInProgress.NO_BACKREST: {
                for (Subscriber sub : subscribers) {
                    if (sub instanceof BackrestAssembler) {
                        s = sub;
                        break;
                    }
                }
                break;
            }
            case ChairInProgress.NO_BAR: {
                for (Subscriber sub : subscribers) {
                    if (sub instanceof BarAssembler) {
                        s = sub;
                        break;
                    }
                }
                break;
            }
            case ChairInProgress.NOT_PACKED: {
                for (Subscriber sub : subscribers) {
                    if (sub instanceof Packager) {
                        s = sub;
                        break;
                    }
                }
                break;
            }
        }
        return s;
    }

    public void getNotification(ChairInProgress chair) {
        if (chair.getStatus() != ChairInProgress.DONE) {
            Subscriber worker = getSubscriberForJob(chair.getStatus());

            if (worker == null) {
                System.out.println("There is no available worker for this chair at the moment.");
            } else {
                worker.publish(chair);
            }
        } else {
            System.out.println(chair + " is done!");
        }
    }
}
