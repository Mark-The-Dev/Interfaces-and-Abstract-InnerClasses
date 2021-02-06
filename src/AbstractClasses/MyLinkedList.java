package AbstractClasses;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem listItem){
        if (this.root == null){
            this.root = listItem;
            return true;
        }
        ListItem currentItem = this.root;

        while (currentItem != null){
            int comparison = (currentItem.compareTo(listItem));
            if(comparison <0){
                // new is greater, move right if possible

                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    // there is no next so insert at end of list
                    currentItem.setNext(listItem).setPrevious(currentItem);

                    // redundant because set next returns a value and can be chained.
                    //listItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0){
                // new item is less, insert before

                if (currentItem.previous() != null){
                    currentItem.previous().setNext(listItem).setPrevious(currentItem.previous());
                    listItem.setNext(currentItem).setPrevious(listItem);
                } else {
                    // the node with a previous is the root
                    listItem.setNext(this.root).setPrevious(listItem);
                    this.root = listItem;
                }
                return true;
            } else {
                System.out.println(listItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem){

        if (listItem != null){
            System.out.println("Deleting item " + listItem.getValue());
        }

        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(listItem);
            if (comparison == 0){
                // found item to delete
                if (currentItem == this.root){
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0){
                currentItem = currentItem.next();
            } else { // comparison > 0
                // we hit an item greater than the one to be deleted
                // so item is not in list

                return false;

            }
        }
        // hit end of list without finding value;
        return false;
    }

    @Override
    public void traverse(ListItem root) {

        if (root == null) System.out.println("The list is empty.");
        else{
            while(root != null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }

    }

}
