package myclasses;

import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.ArrayList;
import java.util.List;

public class Copil {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private Double niceScore;
    private List<Category> giftsPreferences = new ArrayList<>();
    private double averageScore;
    private List<Double> niceScoreHistory = new ArrayList<>();
    private double assignedBudget;
    private List<Cadou> receivedGifts = new ArrayList<>();
    private Double niceScoreBonus;
    private ElvesType elf;
    private double niceScoreCity;

    /**
     *
     */
    public Copil() {
    }

    /**
     * @param id
     * @param lastName
     * @param firstName
     * @param city
     * @param age
     * @param giftsPreferences
     * @param niceScore
     * @param niceScoreBonus
     * @param elf
     * @param niceScoreCity
     */
    public Copil(final int id, final String lastName, final String firstName, final Cities city,
                 final int age, final List<Category> giftsPreferences, final double niceScore,
                 final double niceScoreBonus, final ElvesType elf, final double niceScoreCity) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.niceScore = niceScore;
        this.niceScoreBonus = niceScoreBonus;
        this.elf = elf;
        this.niceScoreCity = niceScoreCity;
    }

    /**
     * @param copilBuilder
     */
    public Copil(final CopilBuilder copilBuilder) {
        this.id = copilBuilder.id;
        this.lastName = copilBuilder.lastName;
        this.firstName = copilBuilder.firstName;
        this.city = copilBuilder.city;
        this.age = copilBuilder.age;
        this.niceScore = copilBuilder.niceScore;
        this.giftsPreferences = copilBuilder.giftsPreferences;
        this.averageScore = copilBuilder.averageScore;
        this.niceScoreHistory = copilBuilder.niceScoreHistory;
        this.assignedBudget = copilBuilder.budget;
        this.receivedGifts = copilBuilder.receivedGifts;
        this.niceScoreBonus = copilBuilder.niceScoreBonus;
        this.elf = copilBuilder.elf;
        this.niceScoreCity = copilBuilder.niceScoreCity;
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
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public Cities getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(final int age) {
        this.age = age;
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
    public void setNiceScore(final double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * @return
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * @param giftsPreferences
     */
    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * @return
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * @param averageScore
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * @return
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * @param niceScoreHistory
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * @return
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * @param assignedBudget
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * @return
     */
    public List<Cadou> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * @param receivedGifts
     */
    public void setReceivedGifts(final List<Cadou> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    /**
     * @return
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * @param niceScoreBonus
     */
    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
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
     * @return
     */
    public double getniceScoreCity() {
        return niceScoreCity;
    }

    /**
     * @param niceScoreCity
     */
    public void setniceScoreCity(final double niceScoreCity) {
        this.niceScoreCity = niceScoreCity;
    }

    /**
     * @param o
     * @return
     */
    public int compareTo(final Copil o) {
        return Integer.compare(this.getId(), o.getId());
    }

    /**
     */
    public static class CopilBuilder {
        private Integer id;
        private Double niceScore;
        private List<Category> giftsPreferences;
        private ElvesType elf;
        private Cities city;
        private String lastName;
        private String firstName;
        private int age;
        private List<Double> niceScoreHistory;
        private double averageScore;
        private double budget;
        private List<Cadou> receivedGifts;
        private double niceScoreCity;
        private Double niceScoreBonus = 0.0;

        public CopilBuilder(final Integer id, final Double niceScore,
                            final List<Category> giftsPreferences, final ElvesType elf,
                            final Cities city, final String lastName, final String firstName,
                            final int age, final List<Double> niceScoreHistory,
                            final double averageScore, final double budget,
                            final List<Cadou> receivedGifts, final double niceScoreCity) {
            this.id = id;
            this.niceScore = niceScore;
            this.giftsPreferences = giftsPreferences;
            this.elf = elf;
            this.city = city;
            this.lastName = lastName;
            this.firstName = firstName;
            this.age = age;
            this.niceScoreHistory = niceScoreHistory;
            this.averageScore = averageScore;
            this.budget = budget;
            this.receivedGifts = receivedGifts;
            this.niceScoreCity = niceScoreCity;
        }

        /**
         * @param niceScoreBonus
         * @return
         */
        public CopilBuilder bonusScore(final Double niceScoreBonus) {
            this.niceScoreBonus = niceScoreBonus;
            return this;
        }

        /**
         * @return
         */
        public Copil build() {
            return new Copil(this);
        }
    }

}
