package edu.isu.cs.cs3308;


import edu.isu.cs.cs3308.structures.List;

/**
 * Class to Implement a Singly Linked List
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
        // public variable for node data
        // public Node(E data) {this.data = data;}
        // new call for Node
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

    //Instance variables
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
    //Adds item to beginning of the list
    @Override
    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item, head);
        head.setNext(newNode);
        head = newNode;
        size ++;
    }
    //Adds item to the end of the list
    @Override
    public void addLast(E item) {
        Node<E> newNode = new Node<>(item, null);
        if(isEmpty())
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        size ++;
    }
    //Removes first item from the list
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
    //Removes last item from the list
    //If i run into issues, its probably the initial logic
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
    // Removes a node at a given index of the list
    // reference from examples.lecture03
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            return null;

        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.getNext();

        Node<E> toRemove = current.getNext();
        current.setNext(toRemove.getNext());
        toRemove.setNext(null);
        return toRemove.getData();
    }
    // returns size variable (number of variables in the list)
    @Override
    public int size() {
        return size;
    }

    // returns boolean using logic with size variable
    // (could be done better?)
    @Override
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }

    /**
     * Inserts the given element into the list at the provided index. The
     * element will not be inserted if either the element provided is null or if
     * the index provided is less than 0. If the index is greater than or equal
     * to the current size of the list, the element will be added to the end of
     * the list.
     *
     * @param item Item to be added (as long as it is not null).
     * @param index Index in the list where the element is to be inserted.
     */
    @Override
    public void insert(E item, int index) {
        Node<E> current = head;
        if (index >= 0 || item != null)
            for (int i = 0; i < index; i++)
                current = current.getNext();
            Node<E> newTemp = current.getNext();
            Node<E> newNode = new Node<>(item, newTemp);
            current.setNext(newNode);


    }
    // prints list using system.out
    @Override
    public void printList(){

    }

}




