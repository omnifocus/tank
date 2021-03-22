package com.shilei.dp.iterator;

public class ArrayList_<T> implements List<T> {

    private T[] es = (T[])new Object[10];
    private int index ;
    private int size ;
    @Override
    public void add(T e) {
        if (size == es.length) {
            T[] es_ = (T[])new Object[es.length * 2];
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
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                //卡住index
                return i < index;
            }

            @Override
            public T next() {
                return es[i++];
            }
        };
    }

    public static void main(String[] args) {
        List<String> list_ = new ArrayList_();
        list_.add("a");
        list_.add("b");
        list_.add("1");
       Iterator<String> it =  list_.iterator();
       while (it.hasNext()) {
           String v = it.next();
           System.out.println(v);
       }
    }


}
