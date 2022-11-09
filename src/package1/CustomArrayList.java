package package1;

import java.util.*;

public class CustomArrayList implements List<String> {

    public static int size(List<String> name) {
        return name.size();
    }

    @Override
    public boolean isEmpty(List<String> name) {

        for (int i = 0; i < name.size(); i++ ) {
            if (name.get(i) != null) {
                return false;
            }
        }

        return  true;
    }

    @Override
    public boolean contains(List<String> name, Object o) {

        for (int i = 0; i < name.size(); i++ ) {
            if (name.get(i) != o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    public static Object[] toArray(List<String> name) {

        return name.toArray(new String[name.size()]);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(List<String> name, String s) {
        String [] a = new String[name.size() + 1];

        for (int i = 0; i < name.size(); i++) {
            a[i] = name.get(i);
        }
        a[name.size() + 1] = s;
        Arrays.asList(a);
        return true;
    }

    @Override
    public boolean remove(List<String> name, Object o) {
        for (int i = 0; i < name.size(); i++) {
            if (name.get(i).equals(o)) {
                name.remove(name.get(i));

                String [] a = new String[name.size() - 1];

                for (int j = 0; j < i; j++) {
                    a[j] = name.get(j);
                }

                for (int k = i + 1; k < name.size(); k++) {
                    a[k] = name.get(k);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(List<String> name, Collection<String> c) {
        for (int i = 0; i < name.size(); i++) {
            for (String s : c) {

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
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }
}
