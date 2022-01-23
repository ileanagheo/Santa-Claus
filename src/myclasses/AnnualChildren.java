package myclasses;

import java.util.List;

public class AnnualChildren {
    private List<ChildrenOneYear> annualChildren;

    public AnnualChildren() {
    }

    /**
     * @param annualChildren children that get to see Santa coming again
     */
    public AnnualChildren(final List<ChildrenOneYear> annualChildren) {
        this.annualChildren = annualChildren;
    }

    /**
     * @return annualChildren
     */
    public List<ChildrenOneYear> getAnnualChildren() {
        return annualChildren;
    }

    /**
     * @param annualChildren sets annual children
     */
    public void setAnnualChildren(final List<ChildrenOneYear> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
