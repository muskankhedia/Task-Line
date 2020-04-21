package database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;

public class Database {
    private String name;
    private Timestamp timestamp;
    private long createdAt;

    public Database(String name) {
        this.name = name;
        this.timestamp = new Timestamp(System.currentTimeMillis());

        this.initialize();
    }

    private void initialize() {
        this.createdAt = this.timestamp.getTime();
    }

    public void commit() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("./" + this.name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
    }
}
