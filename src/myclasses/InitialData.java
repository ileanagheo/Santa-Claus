package myclasses;

import java.util.List;

public class InitialData {
    private List<Copil> children;
    private List<Cadou> santaGiftsList;

    /**
     */
    public InitialData() {
    }

    /**
     * @param children
     * @param santaGiftsList
     */
    public InitialData(final List<Copil> children, final List<Cadou> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
    }

    /**
     * @return
     */
    public List<Copil> getChildren() {
        return children;
    }

    /**
     * @param children
     */
    public void setChildren(final List<Copil> children) {
        this.children = children;
    }

    /**
     * @return
     */
    public List<Cadou> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     * @param santaGiftsList
     */
    public void setSantaGiftsList(final List<Cadou> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
