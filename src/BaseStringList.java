import cs1302.adt.StringList;

/**
 * Represents an abstract class that implements a subset of abstract methods
 * of {@code StringList} by using a {@code BaseStringList} object.
 */
public abstract class BaseStringList implements StringList {
    protected int size;

    /**
     * Constructs a {@code BaseStringList} object with initial size equal to 0.
     */
    public BaseStringList() {
        size = 0;
    } // BaseStringList;

    /**
     * Returns the number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    } // size

    /**
     * Returns {@code true} if the list is empty. Otherwise, returns {@code false}.
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } // if
        return false;
    } // isEmpty

    /**
     * Returns a string representation that begins with {@code start} and ends with
     * {@code end} separated by {@code sep}.
     */
    @Override
    public String makeString(String start, String sep, String end) {
        if (isEmpty()) {
            return start + end;
        } // if
        StringBuilder string = new StringBuilder();
        string.append(start);
        for (int i = 0; i < size; i++) {
            string.append(get(i));
            if (i < size - 1) {
                string.append(sep);
            } // if
        } // for
        string.append(end);
        return string.toString();
    } // makeString

    /**
     * Returns {@code makeString}.
     */
    @Override
    public String toString() {
        return makeString("[", ", ", "]");
    } // toString

    /**
     * Returns {@code true} if the list contains {@code target}.
     */
    @Override
    public boolean contains(int start, String target) {
        if (start >= 0 && start <= size) {
            for (int i = start; i < size(); i++) {
                if (get(i).equals(target)) {
                    return true;
                } // if
            } // for
        } // if
        return false;
    } // contains

    /**
     * Appends the list by adding {@code itemList} at a specified {@code index}.
     */
    @Override
    public boolean add(int index, StringList itemList) {
        if (itemList == null) {
            throw new NullPointerException();
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } // if
        for (int i = 0; i < itemList.size(); i++) {
            add(index + i, itemList.get(i));
        } // for
        return !itemList.isEmpty(); // Returns whether itemList is empty or not
    } // add
} // BaseStringList
