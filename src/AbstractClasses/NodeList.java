package AbstractClasses;

public interface NodeList {
    abstract ListItem getRoot();
    abstract boolean addItem(ListItem listItem);
    abstract boolean removeItem(ListItem listItem);
    abstract void traverse(ListItem listItem);
}
