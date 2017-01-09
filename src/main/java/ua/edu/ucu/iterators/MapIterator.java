package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntPredicate;
import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

/**
 * Created by Dell on 08.01.2017.
 */
public class MapIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private IntUnaryOperator mapper;

    public MapIterator(Iterator<Integer> iter, IntUnaryOperator mapper) {
        this.iter = iter;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Integer next() {
        return mapper.apply(iter.next());
    }

    public static Iterable<Integer> map(final Iterable<Integer> seq, IntUnaryOperator mapper) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new MapIterator(seq.iterator(), mapper);
            }
        };
    }
}
