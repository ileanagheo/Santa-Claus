package myclasses;

import java.util.List;

public class InitialData {
    private List<Copil> children;
    private List<Cadou> santaGiftsList;

    public InitialData() {
    }

    /**
     * @param children : List of children that get to see Santa coming
     * @param santaGiftsList : List of gifts that Santa has prepared for this year
     */
    public InitialData(final List<Copil> children, final List<Cadou> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
    }

    /**
     * @return Children
     */
    public List<Copil> getChildren() {
        return children;
    }

    /**
     * @param children sets the children
     */
    public void setChildren(final List<Copil> children) {
        this.children = children;
    }

    /**
     * @return SantaGiftsList
     */
    public List<Cadou> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     * @param santaGiftsList sets Santa's gifts list
     */
    public void setSantaGiftsList(final List<Cadou> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
