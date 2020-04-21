import core.card.Card;
import database.Database;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");
        Database tasklistDB = new Database("tasklist.json");
        tasklistDB.commit();
    }

}
