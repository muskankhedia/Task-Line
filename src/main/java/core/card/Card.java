package core.card;

public class Card {
    private Timer timer;
    private String name, description;

    Card(String name) {
        this.name = name;
        this.timer = new Timer();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
