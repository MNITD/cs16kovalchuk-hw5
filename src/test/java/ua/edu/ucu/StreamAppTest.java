package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */
public class StreamAppTest {
    
    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }
    
    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);        
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testStreamMax() {
        System.out.println("streamMax");
        int expResult = 3;

        int result = StreamApp.streamMax(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamMin() {
        System.out.println("streamMin");
        int expResult = -1;

        int result = StreamApp.streamMin(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamSum() {
        System.out.println("streamSum");
        int expResult = 5;

        int result = StreamApp.streamSum(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamReduce() {
        System.out.println("streamReduce");
        int expResult = 5;

        int result = StreamApp.streamReduce(intStream, 0, (x, sum) -> sum+=x);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamFilter() {
        System.out.println("streamFilter");
        int [] expResult = {2,3};

        int [] result = StreamApp.streamFilter(intStream, (x -> x > 1)).toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testStreamMap() {
        System.out.println("streamMap");
        int [] expResult = {1, 0, 1, 4, 9};

        int [] result = StreamApp.streamMap(intStream, (x -> x * x)).toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testStreamFlatMap() {
        System.out.println("streamFlatMap");
        int [] expResult = {- 1, 0,1, 0, 1,2, 1, 2,3, 2, 3,4, 3, 4,5};

        int [] result = StreamApp.streamFlatMap(intStream, (x -> AsIntStream.of(x, x + 1, x + 2 ))).toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testStreamCount() {
        System.out.println("streamCount");
        long expResult = 5;

        long result = StreamApp.streamCount(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamAverage() {
        System.out.println("streamAverage");
        Double expResult = 1.0;

        Double result = StreamApp.streamAverage(intStream);
        assertEquals(expResult, result);
    }

}
