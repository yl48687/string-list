import cs1302.adt.StringList;

/**
 * Represents a class that extends {@code BaseStringList} and fully implements
 * {@code StringList} and uses arrays to store strings.
 */
public class ArrayStringList extends BaseStringList implements StringList {
    private String[] items;

    /**
     * Constructs a {@code ArrayStringList} object with initial array size of 0.
     */
    public ArrayStringList() {
        items = new String[0];
    } // ArrayStringList

    /**
     * Appends the list by adding {@code item} at a specified {@code index}.
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException();
        } else if (item.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } // if
        String[] array = new String[size + 1];
        for (int i = 0; i < index; i++) {
            array[i] = items[i]; // Until desired index, copy the elements onto new array
        } // for
        array[index] = item; // Adds item at index
        for (int i = index; i < size; i++) {
            array[i + 1] = items[i]; // After added item, continue to copy the elements
        } // for
        items = array; // Reinitialize items array to be copied array with new item
        size++;
        return true;
    } // add

    /**
     * Returns an item at a specified {@code index}.
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } // if
        return items[index];
    } // get

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        items = new String[0];
        size = 0;
    } // clear

    /**
     * Removes an item at a specified {@code index}.
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } // if
        String[] array = new String[size - 1];
        String removed = items[index]; // Store item at index which is removed
        for (int i = 0, j = 0; i < size; i++) {
            array[j++] = items[i]; // Shift the elements forward after removing
        } // for
        items = array; // Reinitialize items array to be adjusted array
        size--;
        return removed;
    } // remove

    /**
     * Reverses the list.
     */
    @Override
    public StringList reverse() {
        StringList itemList = new ArrayStringList();
        for (int i = size() - 1; i >= 0; i--) {
            itemList.add(i, get(i)); // Reverse the items on the list
        } // for
        return itemList;
    } // reverse

    /**
     * Slices a portion of the list from {@code start} to {@code stop}.
     */
    @Override
    public StringList slice(int start, int stop) {
        StringList itemList = new ArrayStringList();
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException();
        } // if
        for (int i = start; i < stop; i++) {
            itemList.add(i, get(i)); // Adds the item onto a new list after slicing
        } // for
        return itemList;
    } // slice

} // ArrayStringList
