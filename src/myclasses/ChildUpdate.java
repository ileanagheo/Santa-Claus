package myclasses;

import enums.Category;
import enums.ElvesType;

import java.util.List;

public class ChildUpdate {
    private int id;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private ElvesType elf;

    public ChildUpdate() {
    }

    /**
     * @param id : ID of the child
     * @param niceScore : new nice score of the child
     * @param giftsPreferences : new list of gifts preferences for the child
     * @param elf : new elf for the child
     */
    public ChildUpdate(final int id, final Double niceScore, final List<Category> giftsPreferences,
                       final ElvesType elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
    }

    /**
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * @param id sets ID
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return niceScore
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * @param niceScore sets nice score
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * @return giftsPreferences
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * @param giftsPreferences sets gifts preferences
     */
    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * @param elf sets elf
     */
    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }

    /**
     * @return sets elf type
     */
    public ElvesType getElf() {
        return elf;
    }
}
