package AbstractClasses;

public class Demo {
    public static void main(String[] args) {
//        System.out.println("Here's the abstract!");
//
//        Parrot parrot = new Parrot("Australian Longneck");
//
//        parrot.eat();
//        parrot.fly();
//
//        Penguin penguin = new Penguin("emporrer");
//        penguin.fly();

//        MyLinkedList list = new MyLinkedList(null);
//        list.traverse(list.getRoot());
//
//        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
//
//        String[] data = stringData.split(" ");
//        for (String s : data){
//            list.addItem(new Node(s));
//        }
//        list.traverse(list.getRoot());

        MyLinkedList list2 = new MyLinkedList(null);
        String strData = "5 7 3 9 8 2 1 0 4 0";

        String[] data2 = strData.split(" ");
        for(String s: data2){
            list2.addItem(new Node(s));
        }
        list2.traverse(list2.getRoot());
        list2.removeItem(new Node("3"));
        list2.traverse(list2.getRoot());
    }
}
