package ke.co.safaricom.dto;

import ke.co.safaricom.model.Hero;
import ke.co.safaricom.model.Squad;

import java.util.List;

public class SquadInformation {
    private Squad squad;
    private List<Hero> heroes;
    private int weaknessScore;
    private int strengthScore;

    public SquadInformation() {
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public int getWeaknessScore() {
        return weaknessScore;
    }

    public void setWeaknessScore(int weaknessScore) {
        this.weaknessScore = weaknessScore;
    }

    public int getStrengthScore() {
        return strengthScore;
    }

    public void setStrengthScore(int strengthScore) {
        this.strengthScore = strengthScore;
    }

    @Override
    public String toString() {
        return "SquadInfo{" +
                "squad=" + squad +
                ", heroes=" + heroes +
                ", weaknessScore=" + weaknessScore +
                ", strengthScore=" + strengthScore +
                '}';
    }
}


