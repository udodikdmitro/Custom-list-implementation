package package1;

import java.util.*;

public class CustomArrayList implements List<String> {

    String[] elements;

    public CustomArrayList() {
        this.elements = new String [10];
    }

    @Override
    public int size() {
        int i = 0;

        for (String s : elements) {
            i++;
        }
        return i;
    }

//    Считать size в методе add.

    @Override
    public boolean isEmpty() {

        for (String s : elements) {
            if (s != null) {
                return false;
            }
        }
// Определять через size.
        return true;
    }

    @Override
    public boolean contains(Object o) {

        for (String s : elements) {
            if (s.equals(o)) {
                return true;
            }
        }
        return false;
//        Перебирать в цикле только элементы-обьекты.
    }

    @Override
    public Iterator<String> iterator() {
        throw new UnsupportedOperationException();
    }

//    Скопировать только объекты
    public Object[] toArray() {
        return Arrays.copyOf(elements, elements.length);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {

        for (int i = 0; i < elements.length; i++) {

            if (elements[i] == null) {
                elements[i] = s;
                return elements[i].equals(s);
            }
        }

        String[] a = new String[(int) (elements.length * 1.5)];

        a[elements.length + 1] = s;

        elements = a;

//        Добавлять элементы через size+1
// Создать новый массив тогда, когда не будет места в старом.
        // Array "a" is a new array, and I must use array "el".
        return a[elements.length + 1].equals(s);
    }

//    Використовувати size замість length
//    Елементи мають переміщуватись вліво в сторону видаленого елемента.
    @Override
    public boolean remove(Object o) {

        for (int i = 0; i < elements.length; i++) {

            if (elements[i].equals(o)) {
                elements[i] = null;
                return true;
            }
        }

        return false;
    }

    //Використовувати size.
    @Override
    public boolean containsAll(Collection<?> c) {

        int j = 0;

        for (Object s : c) {

            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(s)) {
                    j++;
                }
            }
        }

        if (j == c.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {

        int i = 0;
        // Capacity - size = кількість вільних комірок. Якщо їх менше, ніж c.size,
        // потрібно збільшувати масив.
        for (String s : elements) {

            if (s == null) {
                i++;
            }
        }

        if (i >= c.size()) {

            int j = 0;

            // додавання елементів колекції в масив можна так. Отримуємо масив із
            // колекції через toArray, отриманий масив копіюємо System.arraycopy
            // (як опиcано в main)
            for (Object o : c) {
                elements[elements.length - i + j] = (String) o;
                j++;
            }

        } else {

//            String[] a = new String[(int) (el.length + c.size() * 1.5)];

            String[] a = Arrays.copyOf(elements, (int) (elements.length + c.size() * 1.5));

//            for (int j = 0; j < el.length; j++) {
//                a[j] = el[j];
//            }

            int j = 0;

            for (Object o : c) {
                a[elements.length - i + j] = (String) o;
                j++;
            }

        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {

        String[] a = new String[elements.length + c.size()];

//        По аналогії, як addAll.

        for (int i = 0; i < index; i++) {
            a[i] = elements[i];
        }

        for (String s : c) {
            add(s);
        }

        for (int i = index; i < elements.length; i++) {
            a[i + c.size()] = elements[i];
        }

        for (String s : a) {

            if (s == null) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

//        size!!!! Потрібно створии новий масив без видаляємих елементів.

        for (Object s : c) {

            for (int i = 0; i < elements.length; i++) {

                if (elements[i].equals(s)){
                    remove(elements[i]);
                }
            }
         }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        elements = new String[10];
    }

    @Override
    public String get(int index) {
        return elements[index];
    }

    @Override
    public String set(int index, String element) {
        return null;
    }

//    Використовувати System.arraycopy.
    @Override
    public void add(int index, String element) {

        String[] a = new String[elements.length + 1];

        for (int i = 0; i < index; i++) {
            a[i] = elements[i];
        }

        a[index] = element;

        for (int i = index; i < elements.length; i++) {
            a[index + 1] = elements[i];
        }
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
