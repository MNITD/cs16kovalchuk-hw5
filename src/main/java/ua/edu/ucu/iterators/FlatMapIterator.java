package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.stream.IntStream;

import java.util.Iterator;

/**
 * Created by Dell on 08.01.2017.
 */
public class FlatMapIterator implements Iterator<Integer>{

    private Iterator<Integer> iter;
    private IntToIntStreamFunction func;
    private int [] intStreamArray;
    private int intStreamLen = 0;

    public FlatMapIterator(Iterator<Integer> iter, IntToIntStreamFunction func) {
        this.iter = iter;
        this.func = func;
    }

    @Override
    public boolean hasNext() {
       return ( intStreamLen != 0  || iter.hasNext());
    }

    @Override
    public Integer next() {
        if(intStreamLen == 0){
            intStreamArray = func.applyAsIntStream(iter.next()).toArray();
            intStreamLen = intStreamArray.length;
        }
        int i =  intStreamArray[intStreamArray.length - intStreamLen];
        intStreamLen -= 1;
        return i;
    }

    public static Iterable<Integer> flatmap(final Iterable<Integer> seq, IntToIntStreamFunction func) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new FlatMapIterator(seq.iterator(), func);
            }
        };
    }
}
