package com.shilei.dp.iterator;

import java.util.Arrays;
import java.util.function.Supplier;

public class ArrayList_ implements List {

    private Object[] es = new Object[10];
    private int index ;
    private int size ;
    @Override
    public void add(Object e) {
        if (size == es.length) {
            Object[] es_ = new Object[es.length * 2];
            System.arraycopy(es,0,es_,0,es.length);
            es = es_;
        }
        es[index++] = e;
        size++;

    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int i = 0;
            @Override
            public boolean hasNext() {
                //卡住index
                return i < index;
            }

            @Override
            public Object next() {
                return es[i++];
            }
        };
    }

    public static void main(String[] args) {
        List list_ = new ArrayList_();
        list_.add(1);
        list_.add(1);
        list_.add(1);
        list_.add(1);
        list_.add(1);
        list_.add(1);
        list_.add(1);
        list_.add(1);
        list_.add(1);
        list_.add(1);
        list_.add(1);
        list_.add(1);
       Iterator it =  list_.iterator();
       while (it.hasNext()) {
           System.out.println(it.next());
       }
    }


}
