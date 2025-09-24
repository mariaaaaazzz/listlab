package edu.grinnell.csc207.listlab;
import java.util.Arrays;

/**
 * An array-based implementation of the list ADT.
 */
public class ArrayList {
    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */

    private int[] data;
    private int size;

    public ArrayList(){
        data = new int[1];
    }



    public void add(int value) {
        //throw new UnsupportedOperationException("Unimplemented method 'add'");
        ensureCapacity();
        data[size] = value;
        size++;
    }

    private void ensureCapacity(){
        if(size==data.length){
            data = Arrays.copyOf(data, data.length * 2);
        }
    }
    /**
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {

        if(index < 0 || index >= size){
            throw new IllegalArgumentException();
        }
        return data[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        if(index == size -1){
            size--;
            return data[size];
        } else if (index < 0 || index >= size){
            throw new IllegalArgumentException();
        } else if(size == 0){
            return 0;
        } else {
            int ret = data[index];
            for(int i = index; i < size-1; i++){
                data[i] = data[i+1];
            }
            size--;
            return ret;
        }
    }
}
