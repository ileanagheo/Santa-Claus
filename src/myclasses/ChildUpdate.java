package myclasses;

import enums.Category;
import enums.ElvesType;

import java.util.List;

public class ChildUpdate {
    private int id;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private ElvesType elf;

    /**
     */
    public ChildUpdate() {
    }

    /**
     * @param id
     * @param niceScore
     * @param giftsPreferences
     * @param elf
     */
    public ChildUpdate(final int id, final Double niceScore, final List<Category> giftsPreferences,
                       final ElvesType elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * @param niceScore
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * @return
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * @return
     */
    public ElvesType getElf() {
        return elf;
    }

    /**
     * @param elf
     */
    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }

    /**
     * @param giftsPreferences
     */
    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}
