package package1;

import java.util.*;

public class CustomArrayList implements List<String> {

    String[] elements;
    int size = 0;

    public CustomArrayList() {
        this.elements = new String [10];
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        if (size == 0) {
            return true;
        }

        return true;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
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
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {

        elements[size] = s;
        size++;

        if (size == elements.length) {
            String[] a = Arrays.copyOf(elements, (int) (elements.length * 1.5 + 1));
            // Fragment "+ 1" was added because if size = 1
            // then (int)1.5 = 1 and array shan't be bigger.
            elements = a;
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {

        for (int i = 0; i < size; i++) {

            if (elements[i].equals(o)) {
                String a [] = new String[elements.length];

                System.arraycopy(elements, 0, a, 0, i);
                System.arraycopy(elements, i + 1, a, i, size - i -1);
                elements = a;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        int amountOfMatch = 0;

        for (Object s : c) {

            for (int i = 0; i < size; i++) {
                if (elements[i].equals(s)) {
                    amountOfMatch++;
                }
            }
        }

        if (amountOfMatch == c.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {

        if (c.size() < elements.length - size) {
            String[] a = Arrays.copyOf(elements, (int) (elements.length + c.size() * 1.5));
            elements = a;
        }

        System.arraycopy(elements, size, c, 0, c.size() - 1);
        size=+c.size();

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {

        if (c.size() < elements.length - size) {
            String[] a = Arrays.copyOf(elements, (int) (elements.length + c.size() * 1.5));
            elements = a;
        }

        System.arraycopy(elements, index, c, 0, c.size());
        size=+c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        int arrayIndex = 0;
        String [] a = new String[elements.length];

        for (String sElements : elements) {
            int counter = 0;

            for (Object sCollection : c) {
                if (!sElements.equals(sCollection)){
                  counter++;
                }
            }

            if(counter != c.size()){
                a[arrayIndex] = sElements;
                arrayIndex++;
            }
         }
        elements = a;
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int arrayIndex = 0;
        String [] a = new String[elements.length];

        for (String sElements : elements) {

            for (Object sCollection : c) {
                if (sElements.equals(sCollection)){
                    a[arrayIndex] = sElements;
                    arrayIndex++;
                }
            }
        }
        elements = a;
        return true;
    }

    @Override
    public void clear() {

        elements = new String[size];
        size = 0;
    }

    @Override
    public String get(int index) {

        return elements[index];
    }

    @Override
    public String set(int index, String element) {

        String el = elements[index];
        elements[index] = element;
        return el;
    }

    @Override
    public void add(int index, String element) {

        System.arraycopy(elements, index, elements, index + 1,
                size - index);
        elements[index] = element;
        size++;

        if (size == elements.length) {
            String[] a = Arrays.copyOf(elements, (int) (elements.length * 1.5 + 1));
            elements = a;
        }
    }

    @Override
    public String remove(int index) {

        String [] a = new String[elements.length];
        String el = elements[index];
        System.arraycopy(elements, 0, a, 0, index);
        System.arraycopy(elements, index + 1, a, index, size - index - 1);
        elements = a;
        size--;
        return el;
    }

    @Override
    public int indexOf(Object o) {

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {

        int index = 0;

         for (int i = 0; i < size; i++) {

             if (elements[i].equals(o)) {
                 index = i;
             }
         }
        return index;
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
