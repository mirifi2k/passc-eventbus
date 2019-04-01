public class ChairInProgress {
    private boolean hasSeat, hasFeet, hasBackRest, hasBar, isPacked;
    private int id;

    protected static final int NO_SEAT = 0x0;
    protected static final int NO_FEET = 0x1;
    protected static final int NO_BACKREST = 0x2;
    protected static final int NO_BAR = 0x3;
    protected static final int NOT_PACKED = 0x4;
    protected static final int DONE = 0x5;

    private static int counter = 0;

    public ChairInProgress() {
        hasSeat = hasFeet = hasBackRest = hasBar = isPacked = false;
        id = counter ++;
    }

    public void setSeat(Subscriber s) {
        hasSeat = true;
        System.out.println(this + "'s seat was cut by " + s);
    }

    public void setFeet(Subscriber s) {
        hasFeet = true;
        System.out.println(this + "'s feet was assembled by " + s);
    }

    public void setBackRest(Subscriber s) {
        hasBackRest = true;
        System.out.println(this + "'s backrest was assembled by " + s);
    }

    public void setBar(Subscriber s) {
        hasBar = true;
        System.out.println(this + "'s stabilizer bar was assembled by " + s);
    }

    public void pack(Subscriber s) {
        isPacked = true;
        System.out.println(this + " was packed by " + s);
    }

    //public boolean isDone() {
       // return hasSeat && hasFeet && hasBackRest && hasBar && isPacked;
    //}

    public int getStatus() {
        if (!hasSeat)
            return NO_SEAT;

        else if (!hasFeet)
            return NO_FEET;

        else if (!hasBackRest)
            return NO_BACKREST;

        else if (!hasBar)
            return NO_BAR;

        else if (!isPacked)
            return NOT_PACKED;

        return DONE;
    }

    public String toString() {
        return "Chair ID " + this.id;
    }
}
