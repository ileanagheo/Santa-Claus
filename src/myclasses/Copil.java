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

    public Copil() {
    }

    /**
     * @param id : ID of the child
     * @param lastName : Child's last name
     * @param firstName : Child's first name
     * @param city : City the child lives in
     * @param age : Child's age
     * @param giftsPreferences : Child's gift preferences
     * @param niceScore : Child's nice score
     * @param niceScoreBonus : The bonus nice score Santa gives to the child
     * @param elf : The elf that is helping (more of less) the child
     * @param niceScoreCity : The nice score the city that the child lives in has
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
     * @param copilBuilder Let's build a child! (Design pattern that I used)
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
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id sets id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName sets last name
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName sets first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return city
     */
    public Cities getCity() {
        return city;
    }

    /**
     * @param city sets city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age sets age
     */
    public void setAge(final int age) {
        this.age = age;
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
    public void setNiceScore(final double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * @return giftsPreferences
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * @param giftsPreferences sets the list of gifts preferences
     */
    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * @return averageScore
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * @param averageScore sets the average score of child's niceness
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * @return niceScoreHistory
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * @param niceScoreHistory sets the child's nice score history
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * @return assignedBudget
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * @param assignedBudget sets assigned budget
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * @return receivedGifts
     */
    public List<Cadou> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * @param receivedGifts sets the gifts the child has received
     */
    public void setReceivedGifts(final List<Cadou> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    /**
     * @return niceScoreBonus
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * @param niceScoreBonus sets the nice score bonus Santa has given the child
     */
    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    /**
     * @return elf
     */
    public ElvesType getElf() {
        return elf;
    }

    /**
     * @param elf sets the elf
     */
    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }

    /**
     * @return niceScoreCity
     */
    public double getniceScoreCity() {
        return niceScoreCity;
    }

    /**
     * @param niceScoreCity sets the nice score of the city
     */
    public void setniceScoreCity(final double niceScoreCity) {
        this.niceScoreCity = niceScoreCity;
    }

    /**
     * @param o compares two children according to their ID and
     * @return returns the child with the lower ID
     */
    public int compareTo(final Copil o) {
        return Integer.compare(this.getId(), o.getId());
    }

    public static class CopilBuilder {
        private final Integer id;
        private final Double niceScore;
        private final List<Category> giftsPreferences;
        private final ElvesType elf;
        private final Cities city;
        private final String lastName;
        private final String firstName;
        private final int age;
        private final List<Double> niceScoreHistory;
        private final double averageScore;
        private final double budget;
        private final List<Cadou> receivedGifts;
        private final double niceScoreCity;
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
         * @param niceScoreBonus nice score bonus
         * @return nice score bonus
         */
        public CopilBuilder bonusScore(final Double niceScoreBonus) {
            this.niceScoreBonus = niceScoreBonus;
            return this;
        }

        /**
         * @return the child that has been built
         */
        public Copil build() {
            return new Copil(this);
        }
    }

}
