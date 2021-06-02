// import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class datastructure {

    public static void main(String[] args) {

        System.out.println(
                "Hello World. Below are the tests you can uncomment in order to see the behaviours of various data structure that we have defined in this project!");

        // comment the code below to test for doubly linked list
        testDoublyLinkedList();

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
}