package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntPredicate;

import java.util.Iterator;


/**
 * Created by Dell on 08.01.2017.
 */
public class FilterIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private IntPredicate pred;
    private Integer next;

    public FilterIterator(Iterator<Integer> iter, IntPredicate pred) {
        this.iter = iter;
        this.pred = pred;
    }

    @Override
    public boolean hasNext() {
        while(iter.hasNext()){
            next = iter.next();
            if(pred.test(next)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return next;
    }

    public static Iterable<Integer> filter(final Iterable<Integer> seq, IntPredicate pred) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new FilterIterator(seq.iterator(), pred);
            }
        };
    }
}
