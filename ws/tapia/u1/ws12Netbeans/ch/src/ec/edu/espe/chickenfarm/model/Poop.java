package ec.edu.espe.chickenfarm.model;

public class Poop {
    int id;
    String color;
    char consistency;

    public Poop(int id, String color, char consistency) {
        this.id = id;
        this.color = color;
        this.consistency = consistency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsistency() {
        return consistency;
    }

    public void setConsistency(char consistency) {
        this.consistency = consistency;
    }
    @Override
    public String toString() {
        return "Poop{" +
                "id=" + id +
                ", color=" + color +
                ", consistency=" + consistency +
                '}';
    }
}
