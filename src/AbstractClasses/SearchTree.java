package AbstractClasses;

public class SearchTree implements NodeList {

    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem listItem) {

        if (this.root == null) {
            this.root = listItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = (currentItem.compareTo(listItem));
            if(comparison < 0){
                // new added item is larger, move to the right
                if (currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    // no node to right, add here
                    currentItem.setNext(listItem);
                    return true;
                }
            } else if (comparison > 0){
                // new item is less, move left if possible
                if (currentItem.previous() != null){
                    currentItem = currentItem.previous();

                } else {
                    currentItem.setPrevious(listItem);
                    return true;
                }
            } else {
                // equal so don't add
                System.out.println(listItem.getValue() + " is already present!");
                return false;
            }
        }


        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        if ( listItem != null){
            System.out.println("Deleting Item " +  listItem.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null){
            int comparison = (currentItem.compareTo(listItem));
            if (comparison <0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0){
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                // equal : we found the item so remove it
                performRemoval(currentItem, parentItem);
                return true;
            }

        }

        return false;
    }

    private void performRemoval(ListItem item, ListItem parent){
        if (item.next() == null){
            // no right tree so make parent point left.
            if (parent.next() == item){
                // item is right child of parent
                parent.setNext(item.previous());
            } else if ( parent.previous() ==  item){
                // item is left child of parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item which means were looking at the root
                this.root = item.previous();
            }
        } else if (item.previous() ==  null){
            // no tree left so make parent point right;
            if (parent.next() == item){
                // item is right child of parent
                parent.setNext(item.next());
            } else if ( parent.previous() == item){
                // item is right child
                parent.setPrevious(item.next());
            } else {
                // again deleting the root
                this.root= item.next();
            }
        } else {
            // neither left nor right are null, deletion is difficult now
            // from right subtree find smallest value
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while(current.previous() != null){
                leftmostParent = current;
                current = current.previous();
            }
            // now put the smallest value into our node to be deleted.
            item.setValue(current.getValue());
            // and delete the smallest
            if (leftmostParent == item){
                // there was no left most node so current points to smallest node (one to be deleted)
                item.setNext(current.next());
            } else {
                // set the smallest node's parent to point to the smallest node's right child (might be null)
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {

        // recursive

        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }

}
