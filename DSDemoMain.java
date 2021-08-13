// import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class DSDemoMain {

    public static void main(String[] args) {
        // testDoublyLinkedList();
        testBinarySearchTree();

    }

    public static void testDoublyLinkedList() {
        DoublyLinkedList<String> myFamilyList = new DoublyLinkedList<>();
        myFamilyList.add("Chunyue");
        myFamilyList.add("Tim");
        myFamilyList.add("Bobby");
        myFamilyList.add("Roy");

        System.out
                .println("current family has " + myFamilyList.size() + " people, they are " + myFamilyList.toString());
        System.out.println(myFamilyList.contains("Chunyue"));
        System.out.println(myFamilyList.contains("Roby"));
        System.out.println("finding tim in the list:" + myFamilyList.indexOf("Tim"));

        myFamilyList.addFirst("Scarlet");
        System.out.println("family after adding scarlet has " + myFamilyList.size() + " people, they are "
                + myFamilyList.toString());

    }

    public static void testBinarySearchTree(){
        BinarySearchTreeNoNode bst = new BinarySearchTreeNoNode(4);
        bst.insert(2);
        bst.insert(45);
        bst.insert(66);
        bst.insert(3);
        bst.remove(66);
        System.out.println(bst.contains(3));
        bst.printTree();
    }
}