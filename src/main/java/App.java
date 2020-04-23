import core.database.Database;

public class App {
    public static void main(String[] args) {
        System.out.println("initializing taskline ...");
        Database tasklistDB = new Database("taskline.tsln");
        System.out.printf("exiting taskline !\n");
    }
}
