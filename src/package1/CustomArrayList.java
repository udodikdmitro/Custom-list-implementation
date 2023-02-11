package package1;

import java.util.*;

public class CustomArrayList implements List<String> {

    private String[] elements;
    private int size = 0;

    public CustomArrayList() {
        this.elements = new String[10];
    }

    public CustomArrayList(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity cannot be less than 1");
        }
        this.elements = new String[capacity];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (String s : this) {
            if (s.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomArrayListIterator(this);
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
            elements = Arrays.copyOf(elements, (int) (elements.length * 1.5 + 1));
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {

            if (elements[i].equals(o)) {
                String[] newElements = new String[elements.length];
                int newLastPosition = size - i - 1;

                System.arraycopy(elements, 0, newElements, 0, i);
                System.arraycopy(elements, i + 1, newElements, i, newLastPosition);
                elements = newElements;
                size--;
                return true;
            }
        }
        return false;
    }

    //    Перевизначити метод Iterator.
//    Використовувати метод contains().
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object s : c) {
            if (!this.contains(s)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        if (c.size() < elements.length - size) {
            String[] a = Arrays.copyOf(elements, (int) (elements.length + c.size() * 1.5));
            elements = a;
        }
        Object[] arrayC = c.toArray();
        System.arraycopy(arrayC, 0, elements, size, c.size());
        size = size + c.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        if (c.size() < elements.length - size) {
            String[] a = Arrays.copyOf(elements, (int) (elements.length + c.size() * 1.5));
            elements = a;
        }
        System.arraycopy(elements, index, elements,
                index + c.size(), size - index);
        Object[] arrayC = c.toArray();
        System.arraycopy(arrayC, 0, elements, index, c.size());
        size = size + c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int arrayIndex = 0;

        for (String str : this) {
            if (!c.contains(str)) {
                elements[arrayIndex] = str;
                arrayIndex++;
            }
        }
        size = arrayIndex;
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int arrayIndex = 0;
//        1. Цикл, в якому перевіряється, чи є збіги взагалі і ведеться лічильник,
//        з якого почати роботу.
//        2. Вести два лічильника, один куди присвоювати, другий звідки присвоювати.
//        3. Використовувати метод contains(Object).
//        4. В іншому циклі перевіряти на збіги і переприсвоювати елемент,
//        провіряючи його на предмет збігу.
        for (int i = 0; i < size; i++) {
            // Examination for containing of elements
            // and getting a start index of appropriation.
            if (c.contains(elements[i])) {
                arrayIndex = i;
                break;
            }
        //Examination of ending and exit of method.
            // It means that collection hasn't coincidences.
            // Create an empty array.
            if (i == size - 1) {
                elements = new String[size];
                size = 0;
                return true;
            }
        }
        //If the method comes here, we create a new array and appropriate his first element.
        //Create a new counter of a new array.
        String[] newArray = new String[elements.length];
        newArray[0] = elements[arrayIndex];
        int newArrayIndex = 1;

        //By using a counter "i" we're going into a remainder of our array.
        //The elements which are contained in a collection we appropriate for a new array.
        for (int i = arrayIndex + 1; i < size; i++) {
            if (c.contains(elements[i])) {
                newArray[newArrayIndex] = elements[i];
                newArrayIndex++;
            }
        }
        //Make a new array to our array and define a quantity of elements for output.
        elements = newArray;
        size = newArrayIndex;
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
        String[] a = new String[elements.length];
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

    /*
e1 = "JAva"
e2 = "is"
e3 ="cool"
e4 = null
...

toString()
["Java", "is", "cool"]

Використовувати println без toString. Переглянути клас StringBuilder.
     */
    @Override
    public String toString() {
        return "";
    }
}
