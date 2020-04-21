package core.card;

import java.sql.Timestamp;

public class Timer {
    String name;
    Timestamp timestamp;
    long previousMarkedTime, lapse, created;

    Timer() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.created = this.timestamp.getTime();
    }

    public long createdAt() {
        return this.created;
    }

    public void start() {
        this.previousMarkedTime = this.timestamp.getTime();
    }

    public long mark() {
        this.lapse = this.timestamp.getTime() - this.previousMarkedTime;
        return this.lapse;
    }

    public long getRecentLapse() {
        return this.lapse;
    }
}
