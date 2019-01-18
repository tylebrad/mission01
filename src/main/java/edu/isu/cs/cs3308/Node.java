/**
 * Class to create nodes for SinglyLinkedList
 *
 * @author Bradley Tyler
 * CS-3308 Mission 01
 */
package edu.isu.cs.cs3308.structures;

public class Node<E>{

    private E data;
    private Node<E> next;

    public Node(E data) {this.data = data;}

    public E getData(){return data;}

    public void setData(E data) {this.data = data;}
}