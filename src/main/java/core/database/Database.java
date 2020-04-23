package core.database;

import java.io.*;
import java.sql.Timestamp;

public class Database {
    private String name;
    private Timestamp timestamp;
    private long createdAt;
    private TaskLineType tl;

    public Database(String name) {
        this.name = name;
        this.timestamp = new Timestamp(System.currentTimeMillis());

        this.initialize();
        this.commit(this.tl);
    }

    /**
     * Initializes the database by checking previous enteries into the database.
     * It restores the data if found else creates a fresh data-store
     * with a .tsln extension.
     */
    private void initialize() {
        File f = new File(this.name);
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(this.name);
                ObjectInputStream ois = new ObjectInputStream(fis);
                System.out.printf("serialized tsln object found!\n");
                System.out.println(ois.toString());
                this.tl = (TaskLineType) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        System.out.printf("Serialized object not found. Seems like a first start."
            + "Creating new one."
        );
        this.tl = new TaskLineType();
        this.createdAt = this.timestamp.getTime();
    }

    /**
     * Commits makes a non-rollback able write to the secondary storage.
     * @param o any object that aims to get written into the secondary
     *          storage as a serialized stream.
     */
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
