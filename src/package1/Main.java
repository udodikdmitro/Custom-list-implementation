package package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> l1 = new CustomArrayList();
        l1.add("Good");
        l1.add("!");

        List<String> l2 = new CustomArrayList();
        l2.add("Good");
        l2.add("bye");
        l2.add("!");

        System.out.println("Size: " + l2.size());

        System.out.println("Is empty: " + l2.isEmpty());

        System.out.println("Contains object 'o': " + l2.contains("Good"));

        System.out.println("To array: " + Arrays.toString(l2.toArray()));

        l2.remove("bye");
        System.out.println("Remove: " + Arrays.toString(l2.toArray()));

        l2.add("bye");
        System.out.println("Contains c: " + l2.containsAll(l1));

        l2.addAll(l1);
        System.out.println("Add collection: " + Arrays.toString(l2.toArray()));

//        l2.addAll(1, l1);
//        System.out.println("Add collection in position: " + Arrays.toString(l2.toArray()));

//        l2.removeAll(l1);
//        System.out.println("Remove elements from a list, which collection have: "
//                + Arrays.toString(l2.toArray()));

//        l2.retainAll(l1);
//        System.out.println("Remove elements from a list, which collection haven't: "
//            + Arrays.toString(l2.toArray()));

        l2.clear();
        System.out.println("Clear list: " + Arrays.toString(l2.toArray()));

        l2.add("Good");
        l2.add("bye");
        l2.add("!");
        System.out.println("Get element in index: " + l2.get(1));

        l2.set(1, "night");
        System.out.println("Set new element: " + Arrays.toString(l2.toArray()));

        l2.add(2,"boys");
        System.out.println("Add new string: " + Arrays.toString(l2.toArray()));

        l2.remove(2);
        System.out.println("Remove element in index: " + Arrays.toString(l2.toArray()));

        l2.add("!");
        System.out.println("Add element '!': " + Arrays.toString(l2.toArray()));
        System.out.println("Index of element: " + l2.indexOf("!"));

        System.out.println("Last index of element: " + l2.lastIndexOf("!"));



    }

}
