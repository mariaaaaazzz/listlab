package edu.grinnell.csc207.listlab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class ArrayListTests {
    @Test
    public void emptyListTest() {
        ArrayList list = new ArrayList();
        assertEquals(0, list.size());
    }

    @Test
    public void listAddSize10() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
    }

    @Test
    public void removeLastElement() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(9, list.remove(list.size()-1));
        assertEquals(9, list.size());
    }

    @Test
    public void removeFifthElement() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(4, list.remove(4));
        assertEquals(9, list.size());

        for (int i = 0; i < 9; i++) {
            if(i >= 4){
                assertEquals(i+1, list.get(i));
            }
            else{
                assertEquals(i, list.get(i));
            }
        }
    }



    @Property
    public boolean listAddSize(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }
        return list.size() == sz;
    }

    @Property
    public boolean removeElements(@ForAll @IntRange(min = 100, max = 1000) int sz,
                                  @ForAll @IntRange(min = 0, max = 99) int rem){
        ArrayList list = new ArrayList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }
        for (int i = rem; i > 0; i--){
            list.remove(i);
        }

        return list.size() == sz - rem;
    }

    @Property
    public boolean addSameElements(@ForAll @IntRange(min = 100, max = 1000) int sz,
                                   @ForAll @IntRange(min = -100, max = 100) int add,
                                    @ForAll @IntRange(min = 0, max = 99) int index){
       ArrayList list = new ArrayList();
       for (int i = 0; i < sz; i++) {
            list.add(add);
       }
       return list.get(index) == add;
    }  


}