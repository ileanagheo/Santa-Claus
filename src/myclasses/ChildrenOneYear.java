package myclasses;

import java.util.List;

public class ChildrenOneYear {
    private List<ChildOut> children;

    /**
     */
    public ChildrenOneYear() {
    }

    /**
     * @param children
     */
    public ChildrenOneYear(final List<ChildOut> children) {
        this.children = children;
    }

    /**
     * @return
     */
    public List<ChildOut> getChildren() {
        return children;
    }

    /**
     * @param children
     */
    public void setChildren(final List<ChildOut> children) {
        this.children = children;
    }
}
