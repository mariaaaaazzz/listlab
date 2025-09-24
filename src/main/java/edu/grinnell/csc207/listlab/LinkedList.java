package edu.grinnell.csc207.listlab;

/**
 * A linked implementation of the list ADT.
 */
public class LinkedList {
    private static class Node{
        int value;
        Node next;
        
        public Node(int value, Node next){
            this.value = value;
            this.next = next;        }
    }

    private Node first;

    public LinkedList(){
        first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {

        Node lastNode = new Node(value, null);
        Node temp = first;

        if(temp == null){
            first = lastNode;
        } else {
            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = lastNode;
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int ret = 0;
        Node cur = this.first;
        while(cur!= null){
            ret += 1;
            cur = cur.next;
        }

        return ret;

        //throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        int i = 0;
        Node cur = this.first;
        while(i<index){
            if(cur==null){
                return -1;
            }
            i++;
            cur = cur.next;
        }
        return cur.value;
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        Node cur = first;
        int i = 0;
        int ret;
        //Check if index is beyond size of our linked list
        if(index >= size()){
            return -1;
        }

        while(i < index -1){
            cur = cur.next;
            i++;
        }

        ret = cur.next.value;
        cur.next = cur.next.next;

        return ret;

        //throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
}
