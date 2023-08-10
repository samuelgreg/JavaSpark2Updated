package ke.co.safaricom.model;

public class Hero {
    private String name;
    private int age;
    private int powerId;
    private  int weaknessId;
    private int squadId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    public int getWeaknessId() {
        return weaknessId;
    }

    public void setWeaknessId(int weaknessId) {
        this.weaknessId = weaknessId;
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public Hero() {

    }
}