import cs1302.adt.StringList;
import cs1302.adt.Node;

/**
 * Represents a {@code LinkedStringList} object that uses nodes to store strings.
 */
public class LinkedStringList extends BaseStringList implements StringList {
    private Node head;

    /**
     * Constructss a {@code LinkedStringList} object with initial size of 0.
     */
    public LinkedStringList() {
        head = null;
    } // LinkedStringList

    /**
     * Appends the list by adding {@code item} at a specified {@code index}.
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException();
        } else if (item.equals("")) {
            throw new IllegalArgumentException();
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } // if
        Node newNode = new Node(item);
        if (index == 0) {
            newNode.setNext(head); // Store head as new node
            head = newNode;
        } else {
            Node temp = head; // Temporary pointer
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            } // for
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        } // if
        size++;
        return true;
    } // add

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        head = null;
    } // clear

    /**
     * Returns an item at a specified {@code index}.
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } // if
        Node temp = head; // Temporary pointer
        for (int i = 0; i < index; i++) {
            temp = temp.getNext(); // Searches for correct index by moving to the next node
        } // for
        return temp.getItem(); // Finds the item stored at the index
    } // get

    /**
     * Removes an item at a specified {@code index}.
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } // if
        Node temp = head; // Temporary pointer
        if (index == 0) {
            head = head.getNext(); // If removing node at index 0, shift head to one node behind
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext(); // Searches for correct index by moving to the next node
            } // for
            temp.setNext(temp.getNext().getNext()); // New temporary pointer location set
        } // if
        size--;
        return temp.getItem(); // Finds the item stored at the index
    } // remove

    /**
     * Reverses the list.
     */
    @Override
    public StringList reverse() {
        LinkedStringList itemList = new LinkedStringList();
        Node current = head; // Current pointer
        while (current != null) {
            itemList.add(0, current.getItem()); // Adds the item at current pointer onto the list
            current = current.getNext(); // Moves to the next node until current pointer is not null
        } // while
        return itemList;
    } // reverse

    /**
     * Slices a portion of the list from {@code start} to {@code stop}.
     */
    @Override
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException();
        } // if
        LinkedStringList slicedList = new LinkedStringList();
        Node current = head; // Current pointer
        int index = 0;
        while (index < start) {
            current = current.getNext(); // Moves to the next node
            index++;
        } // while
        while (index < stop) {
            slicedList.add(slicedList.size(), current.getItem()); // Adds the item at current
                                                                  // pointer to a new list
            current = current.getNext(); // Moves to the next node
            index++;
        } // while
        return slicedList;
    } // slice

} // LinkedStringList
