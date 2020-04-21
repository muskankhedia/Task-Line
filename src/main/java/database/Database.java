package database;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;

public class Database {
    private String name;
    private Timestamp timestamp;
    private long createdAt;
    private TaskLineType tl;

    public Database(String name) {
        this.name = name;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.tl = new TaskLineType();

        this.initialize();
        this.commit(this.tl);
    }

    private void initialize() {
        this.createdAt = this.timestamp.getTime();
    }

    public void commit(Object o) {
        try {
            FileOutputStream fos = new FileOutputStream("./" + this.name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
