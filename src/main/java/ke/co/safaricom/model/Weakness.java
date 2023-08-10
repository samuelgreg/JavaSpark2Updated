package ke.co.safaricom.model;

public class Weakness {
    private int id;
    private String name;
    private int score;
    private boolean deleted;

    @Override
    public String toString() {
        return "weakness{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", deleted=" + deleted +
                '}';
    }

    public Weakness() {
        this.deleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}