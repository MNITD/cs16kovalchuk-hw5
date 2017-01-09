package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterators.FilterIterator;
import ua.edu.ucu.iterators.FlatMapIterator;
import ua.edu.ucu.iterators.MapIterator;

import java.util.ArrayList;
import java.util.List;

public class AsIntStream implements IntStream {

    //    private List<Integer> data;
    private Iterable<Integer> iterable;

    private AsIntStream(int... values) {
        List data = new ArrayList<Integer>();
        for (int i : values) {
            data.add(i);
        }
        iterable = data;

    }

    public static IntStream of(int... values) {
        IntStream intStream = new AsIntStream(values);
        return intStream;
    }

    @Override
    public Double average() {

        if(!iterable.iterator().hasNext()){
            throw new IllegalArgumentException();
        }
        long sum = 0;
        long size = 0;
        for (int i : iterable) {
            sum += i;
            size += 1;
        }
        return sum / (double) size;
    }

    @Override
    public Integer max() {

        if(!iterable.iterator().hasNext()){
            throw new IllegalArgumentException();
        }
        int max = Integer.MIN_VALUE;

        for (int i : iterable) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    @Override
    public Integer min() {

        if(!iterable.iterator().hasNext()){
            throw new IllegalArgumentException();
        }

        int min = Integer.MAX_VALUE;

        for (int i : iterable) {
            if (i < min) {
                min = i;
            }
        }

        return min;
    }

    @Override
    public long count() {
        long size = 0;
        for (int i : iterable) {
            size++;
        }
        return size;
    }

    @Override
    public Integer sum() {
        int sum = 0;
        for (int i : iterable) {
            sum += i;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        iterable = FilterIterator.filter(iterable, predicate);
        return this;
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int i : iterable) {
            action.accept(i);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        iterable = MapIterator.map(iterable, mapper);
        return this;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        iterable = FlatMapIterator.flatmap(iterable, func);
        return this;
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        for (int i : iterable) {
            identity = op.apply(identity, i);
        }
        return identity;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[(int) count()];
        int k = 0;
        for (int i : iterable) {
            array[k] = i;
            k++;
        }
        return array;
    }

}
