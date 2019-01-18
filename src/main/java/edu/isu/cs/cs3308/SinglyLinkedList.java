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
        public Node(E data) {this.data = data;}

        // gets data from node
        public E getData(){
            return data;
        }

        public void setData(E data) {this.data = data;}
        // returning next node
        public Node<E> getNext(){
            return next;
        }
        // setting data to next node
        public void setNext(Node<E> next){
            this.next = next;
        }
        public Node<E> getPrev(){return prev;}
        public void setPrev(Node<E> prev){
            this.prev = prev;
        }
    }

    //Instance variables
    protected Node<E> head;
    protected Node<E> tail;
    protected int size;
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

        Node<E> newNode = new Node<>(item);
        head.setNext(newNode);
        head = newNode;
        size ++;
    }
    //Adds item to the end of the list
    @Override
    public void addLast(E item) {

        Node<E> newNode = new Node<>(item);
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
        if (isEmpty()) return null;
        E answer = head.getData();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }
    //Removes last item from the list
    @Override
    public E removeLast() {
        if (isEmpty()) return null;
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
        return null;
    }

    // returns size variable
    @Override
    public int size() {
        return size;
    }

    // isEmpty method using size variable
    // (could be done better?)
    @Override
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }

    @Override
    public void insert(E item, int index) {
    }

    @Override
    public void printList(){}
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
}




