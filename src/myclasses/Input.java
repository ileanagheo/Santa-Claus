package myclasses;

import java.util.List;

public class Input {
    private int numberOfYears;
    private double santaBudget;
    private InitialData initialData;
    private List<AnnualChange> annualChanges;

    public Input() {
    }

    /**
     * @param numberOfYears : The number of years Santa is going to bring gifts to children
     * @param santaBudget : Santa's budget for the current year
     * @param initialData : Initial data that doesn't change from last year
     * @param annualChanges : The updates that happen the current year
     */
    public Input(final int numberOfYears, final double santaBudget, final InitialData initialData,
                 final List<AnnualChange> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    /**
     * @return numberOfYears
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * @param numberOfYears Sets number of years
     */
    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * @return santaBudget
     */
    public double getSantaBudget() {
        return santaBudget;
    }

    /**
     * @param santaBudget sets Santa's budget
     */
    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * @return initialData
     */
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     * @param initialData sets the initial data
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    /**
     * @return annualChanges
     */
    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    /**
     * @param annualChanges sets the annual changes
     */
    public void setAnnualChanges(final List<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }
}
