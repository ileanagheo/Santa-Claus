package myclasses;

import enums.CityStrategyEnum;

import java.util.List;

public class AnnualChange {
    private double newSantaBudget;
    private List<Cadou> newGifts;
    private List<Copil> newChildren;
    private List<ChildUpdate> childrenUpdates;
    private CityStrategyEnum strategy;

    public AnnualChange() {
    }

    /**
     * @param newSantaBudget : Santa's new budget
     * @param newGifts : Santa's new gifts list
     * @param newChildren : Santa's new list of children
     * @param childrenUpdates : Santa's list of updates of the previous children
     * @param strategy : Santa's strategy of gift giving
     */
    public AnnualChange(final double newSantaBudget, final List<Cadou> newGifts, final List<Copil>
            newChildren, final List<ChildUpdate> childrenUpdates, final CityStrategyEnum strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategy = strategy;
    }

    /**
     * @return newSantaBudget
     */
    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     * @param newSantaBudget sets the new budget of Santa
     */
    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     * @return newGifts
     */
    public List<Cadou> getNewGifts() {
        return newGifts;
    }

    /**
     * @param newGifts sets the new gifts
     */
    public void setNewGifts(final List<Cadou> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * @return new Children
     */
    public List<Copil> getNewChildren() {
        return newChildren;
    }

    /**
     * @param newChildren sets the new children list
     */
    public void setNewChildren(final List<Copil> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * @return childrenUpdates
     */
    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * @param childrenUpdates sets the children updates
     */
    public void setChildrenUpdates(final List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    /**
     * @return strategy
     */
    public CityStrategyEnum getStrategy() {
        return strategy;
    }

    /**
     * @param strategy sets the strategy
     */
    public void setStrategy(final CityStrategyEnum strategy) {
        this.strategy = strategy;
    }
}
