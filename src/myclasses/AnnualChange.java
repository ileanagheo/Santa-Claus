package myclasses;

import java.util.List;

public class AnnualChange {
    private double newSantaBudget;
    private List<Cadou> newGifts;
    private List<Copil> newChildren;
    private List<ChildUpdate> childrenUpdates;

    /**
     */
    public AnnualChange() {
    }

    /**
     * @param newSantaBudget
     * @param newGifts
     * @param newChildren
     * @param childrenUpdates
     */
    public AnnualChange(final double newSantaBudget, final List<Cadou> newGifts,
                        final List<Copil> newChildren, final List<ChildUpdate> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    /**
     * @return
     */
    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     * @param newSantaBudget
     */
    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     * @return
     */
    public List<Cadou> getNewGifts() {
        return newGifts;
    }

    /**
     * @param newGifts
     */
    public void setNewGifts(final List<Cadou> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * @return
     */
    public List<Copil> getNewChildren() {
        return newChildren;
    }

    /**
     * @param newChildren
     */
    public void setNewChildren(final List<Copil> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * @return
     */
    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * @param childrenUpdates
     */
    public void setChildrenUpdates(final List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
