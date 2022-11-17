package package1;

import java.util.ArrayList;
import java.util.Arrays;
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

        for(int i = 0; i < 2; i++){
            System.out.println(l1.size());
        }

        String[] s1 = {"hello","world"};
        String[] s2 = {"привет","мир"};
        String[] s3 = new String[10];

        System.arraycopy(s1, 0, s3, 5, 1);
        System.out.println(Arrays.toString(s3));
    }

}
