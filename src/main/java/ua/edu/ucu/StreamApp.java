package ua.edu.ucu;

import ua.edu.ucu.function.IntBinaryOperator;
import ua.edu.ucu.function.IntPredicate;
import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.function.IntUnaryOperator;
import ua.edu.ucu.stream.*;

public class StreamApp {

    public static int streamOperations(IntStream intStream) {
        //IntStream intStream = AsIntStream.of(-1, 0, 1, 2, 3); // input values
        int res = intStream
                .filter(x -> x > 0) // 1, 2, 3
                .map(x -> x * x) // 1, 4, 9
                .flatMap(x -> AsIntStream.of(x - 1, x, x + 1)) // 0, 1, 2, 3, 4, 5, 8, 9, 10
                .reduce(0, (sum, x) -> sum += x); // 42
        return res;
    }

    public static int[] streamToArray(IntStream intStream) {        
        int[] intArr = intStream.toArray();
        return intArr;
    }

    public static String streamForEach(IntStream intStream) {        
        StringBuilder str = new StringBuilder();
        intStream.forEach(x -> str.append(x));
        return str.toString();
    }

    public static int streamMax(IntStream intStream) {
        int max = intStream.max();
        return max;
    }

    public static int streamMin(IntStream intStream) {
        int min = intStream.min();
        return min;
    }
    public static int streamSum(IntStream intStream) {
        int sum = intStream.sum();
        return sum;
    }

    public static int streamReduce(IntStream intStream,int identity, IntBinaryOperator op) {
        int reduce = intStream.reduce(identity, op);
        return reduce;
    }

    public static IntStream streamFilter(IntStream intStream, IntPredicate intPredicate) {
        IntStream intStream1 = intStream.filter(intPredicate);
        return intStream1;
    }

    public static IntStream streamMap(IntStream intStream, IntUnaryOperator intUnaryOperator) {
        IntStream intStream1= intStream.map(intUnaryOperator);
        return intStream1;
    }

    public static IntStream streamFlatMap(IntStream intStream, IntToIntStreamFunction toIntStreamFunction) {
        IntStream intStream1 = intStream.flatMap(toIntStreamFunction);
        return intStream1;
    }

    public static long streamCount(IntStream intStream) {
        long count = intStream.count();
        return count;
    }

    public static Double streamAverage(IntStream intStream) {
        Double average = intStream.average();
        return average;
    }
}
