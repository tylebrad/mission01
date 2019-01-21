package edu.isu.cs.cs3308;


import edu.isu.cs.cs3308.structures.List;

/**
 * Class to Implement a Singly Linked List
 *
 * -Reference: Method comments provided by List interface
 *
 * @author Bradley Tyler
 * CS-3308 Mission 01
 */

public class SinglyLinkedList<E> implements List<E> {

    /**
     *Class to create Nodes for SinglyLinkedList
     *Nested Within SinglyLinkedList
     */
    private static class Node<E>{
        // declaring variables
        private E data;
        private Node<E> next;
        private Node<E> prev;

        // Node constructor
        public Node(E d, Node<E> n){
            this.data = d;
            this.next = n;
        }

        // gets data from node
        public E getData(){
            return data;
        }

        public void setData(E data) {this.data = data;}
        // returning next node
        private Node<E> getNext(){
            return next;
        }
        // setting data to next node
        private void setNext(Node<E> next){
            this.next = next;
        }
        private Node<E> getPrev(){return prev;}
        private void setPrev(Node<E> prev){
            this.prev = prev;
        }
    }

    //Instance variables for SinglyLinked List
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    //Creation of empty list
    public SinglyLinkedList(){}

    /**Access methods using getData to return desired Node Data*/
    //First
    @Override
    public E first() {
        if(isEmpty()) return null;
            return head.getData();
    }
    //Last
    @Override
    public E last() {
        if(isEmpty()) return null;
            return tail.getData();
    }

    /** Update Methods */

    /**
     * Adds the provided element to the front of the list, only if the element
     * is not null.
     *
     * @param item Item to be added to the front of the list.
     */
    @Override
    public void addFirst(E item) {
        if (item == null)
                return;
        Node<E> newNode = new Node<>(item, head);
        newNode.setNext(head);
        head = newNode;
        size ++;
    }
    /**
     * Adds the provided element to the end of the list, only if the element is
     * not null.
     *
     * @param item Item to be added to the end of the list.
     */
    @Override
    public void addLast(E item) {
        if (item == null)
            return;
        Node<E> newNode = new Node<>(item, null); //creates newNode pointing to null
        if(isEmpty())//if the list is empty, head becomes the first and only item in the list.
            head = newNode;
        else
            tail.setNext(newNode); // otherwise, we grab the current tail, and set its tail to the new new node
        tail = newNode;
        size ++;
    }


    // removes first item from the list, unless the list is empty
    // decrements size by 1
    @Override
    public E removeFirst() {
        if (isEmpty())
            return null;
        E answer = head.getData();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }
    //Removes last item from the list, unless list is empty
    //Decrements size by 1
    @Override
    public E removeLast() {
        if (isEmpty())
            return null;
        E answer = tail.getData();
        tail = tail.getPrev();
        size --;
        return answer;
    }
    /**
     * Retrieves the value at the specified index. Will return null if the index
     * provided is less than 0 or greater than or equal to the current size of
     * the list.
     *
     * @param index Index of the value to be retrieved.
     * @return Element at the given index, or null if the index is less than 0
     * or greater than or equal to the list size.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            return null;

        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.getNext();

        Node<E> toHold = current;
        return toHold.getData();
    }
    // Removes a node at a given index of the list, unless index given is below 0,
    // or below the size of the list
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            return null;

        Node<E> current = head;
        for (int i = 0; i < index - 1; i++)
            current = current.getNext();

        Node<E> toRemove = current.getNext();
        current.setNext(toRemove.getNext());
        toRemove.setNext(null);
        size --;
        return toRemove.getData();
    }
    // returns size variable (number of variables in the list)
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true if there are no items currently stored in the list, false
     * otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Inserts the given element into the list at the provided index. The
     * element will not be inserted if either the element provided is null or if
     * the index provided is less than 0. If the index is greater than or equal
     * to the current size of the list, the item will be added to the end of
     * the list.
     *
     * @param item Item to be added (as long as it is not null).
     * @param index Index in the list where the element is to be inserted.
     */
    @Override
    public void insert(E item, int index) {
        Node<E> newInsert = new Node(item, null); // declaring variable for new Insert
         Node<E> current = head;
         if(item == null || index < 0) // returns nothing if item is null or index is less than 0
         return;

         if(index >= this.size()) { //Inserts to end of the list if index>size
         this.tail.setNext(newInsert); // sets current tails next to newInsert
         this.tail = newInsert; // sets newInsert as new tail
         }
         else
         // setting head to current, and Climbing
         for (int i = 0; i < index - 1; i++)
         current = current.getNext();
         Node<E> newTemp = current.getNext(); // holding data previously stored at index
         current.setNext(newInsert); // setting index previous to desired location's TAIL to a new node
         newInsert.setNext(newTemp); // setting newInsert's tail to new temp
         size ++;
    }
    
    /**
     * Prints the contents of the list in a single line separating each element
     * by a space to the default System.out
     */
    @Override
    public void printList(){
         if(isEmpty())
             return;
         Node<E> newTemp = this.head;
         // while loop that prints each item in a list with a line separator
         // UNTIL an item in the list is null
         while (newTemp != null) {
             System.out.print(newTemp.data + System.lineSeparator());
             newTemp = newTemp.getNext();
         }

    }

}




