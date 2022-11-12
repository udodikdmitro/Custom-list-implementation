package package1;

import java.util.*;

public class CustomArrayList implements List<String> {

    String [] element;

    public CustomArrayList() {
        this.element = new String [10];
    }

    @Override
    public int size() {
        int i = 0;

        for (String s : element) {
            i++;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {

        for (String s : element) {
            if (element != null) {
                return false;
            }
        }

        return  true;
    }

    @Override
    public boolean contains(Object o) {

        for (String s : element) {
            if (s.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        return Arrays.copyOf(element, element.length);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        String [] a = new String[element.length + 1];

        for (int i = 0; i < element.length; i++) {
            a[i] = element[i];
        }
        a[element.length] = s;
// Array "a" is a new array, and I must use array "element".
// Also, I must do a part of the method, which defines condition "false".
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < element.length; i++) {

            if (element[i].equals(o)) {
                String [] a = new String[element.length - 1];

                for (int j = 0; j < i; j++) {
                    a[j] = element[j];
                }

                for (int k = i + 1; k < element.length; k++) {
                    a[k] = element[k];
                }
                return true;
            }
        }
//        There is a problem as in a method "add".
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (int i = 0; i < element.length; i++) {
            for (Object s : c) {
//         How to make this method with objects??
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public String set(int index, String element) {
        return null;
    }

    @Override
    public void add(int index, String element) {

    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<String> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }
}
