package edu.grinnell.csc207.listlab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class LinkedListTests {
    @Test
    public void emptyListTest() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
    }

    @Test
    public void listAddSize10() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
    }

    @Test
    public void removeFromEmptyList() {
        LinkedList list = new LinkedList();
        assertEquals(-1, list.remove(5));
    }

    @Test
    public void getElementFiveFromList() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(5, list.get(5));
    }

    @Test
    public void removeFromNonEmptyList() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(7, list.remove(7));
    }    


    @Test
    public void getListSize10() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
    }    

    @Property
    public boolean listAddSize(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }
        return list.size() == sz;
    }

    @Property
    public boolean removeElements(@ForAll @IntRange(min = 100, max = 1000) int sz, @ForAll @IntRange(min =0, max = 99) int rem){
        LinkedList list = new LinkedList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }
        for (int i = rem; i > 0; i--){
            list.remove(i);
        }

        return list.size() == sz - rem;
    }

    @Property 
    public boolean getElement(@ForAll @IntRange(min = 100, max = 1000) int sz, 
                              @ForAll @IntRange(min = 0, max = 99) int index,
                              @ForAll @IntRange(min = 0, max = 1000) int val){
        LinkedList list = new LinkedList();
        for (int i = 0; i < sz; i++) {
            list.add(val);
        }
        return list.get(index) == val;
    }
}
