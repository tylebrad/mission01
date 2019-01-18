/**
 * Class to create nodes for SinglyLinkedList
 *
 * @author Bradley Tyler
 * CS-3308 Mission 01
 */
package edu.isu.cs.cs3308;

public class Node<E>{
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
    // returning previous node
    public Node<E> getPrev(){
        return prev;
    }
    // returning next node
    public Node<E> getNext(){
        return next;
    }
    // setting data to previous node
    public void setPrev(Node<E> prev){
        this.prev = prev;
    }
    // setting data to next node
    public void setNext(Node<E> next){
        this.next = next;
    }
}