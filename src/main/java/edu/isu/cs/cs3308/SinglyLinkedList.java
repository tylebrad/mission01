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
    }

    //Instance variables
    protected Node<E> head;
    protected Node<E> tail;
    protected int size;

    // Access methods
    @Override
    public E first() {
        if(isEmpty()) return null;
            return head.getData();
    }

    @Override
    public E last() {
        if(isEmpty()) return null;
            return tail.getData();
    }

    // Update Methods
    @Override
    public void addFirst(E item) {
        if (item == null)
            return;

        Node<E> newNode = new Node<>(item);
        newNode.setNext(head);
        head = newNode;
    }

    @Override
    public void addLast(E item) {
        
    }
    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
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




