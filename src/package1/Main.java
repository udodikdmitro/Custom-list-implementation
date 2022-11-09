package package1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> l1 = new ArrayList<>();
        l1.add("Hello");
        l1.add("world!");

        List<String> l2 = new ArrayList<>();
        l2.add("Good");
        l2.add("bye");
        l2.add("!");

        CustomArrayList.toArray(l2);
        CustomArrayList.size(l1);

        System.out.println(l2);
    }

}
