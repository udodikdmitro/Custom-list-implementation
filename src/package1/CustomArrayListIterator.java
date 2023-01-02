package package1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayListIterator implements Iterator<String> {
        private int currentElement = -1;
        private final CustomArrayList customArrayList;

        public CustomArrayListIterator(CustomArrayList customArrayList) {
            this.customArrayList = customArrayList;
        }

        @Override
        public boolean hasNext() {
            return currentElement != customArrayList.size() - 1;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            currentElement++;
            return customArrayList.get(currentElement);
        }
    }
