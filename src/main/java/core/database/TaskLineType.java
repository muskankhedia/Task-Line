package core.database;

import java.io.Serializable;
import java.sql.Timestamp;

public class TaskLineType implements Serializable {
    private Timestamp timestamp;
    private long createdAtTimestamp;
    String message;
    TaskLineType() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.createdAtTimestamp = this.timestamp.getTime();
        this.setGarbage();
    }

    private void setGarbage() {
        this.message = "some message";
    }
}
