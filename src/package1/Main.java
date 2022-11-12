package package1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> l1 = new CustomArrayList();
        l1.add("Hello");
        l1.add("world!");

        List<String> l2 = new CustomArrayList();
        l2.add("Good");
        l2.add("bye");
        l2.add("!");

        l1.size();
        System.out.println(l1.size());

        System.out.println(l2);
    }

}
