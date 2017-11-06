package iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
//import static org.hamcrest.MatcherAssert.assertThat;

public class JaggedArrayIteratorTest {

    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new MatrixIterator(new int[][]{{10}, {30, 40, 99}, {28, 66}});
    }

    @Test(expected = NoSuchElementException.class)
    public void testsThatNextMethodDoesntDependOnPriorHasNextInvocation() {
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(30));
        assertThat(it.next(), is(40));
        assertThat(it.next(), is(99));
        assertThat(it.next(), is(28));
        assertThat(it.next(), is(66));
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(30));
        assertThat(it.next(), is(40));
        assertThat(it.next(), is(99));
        assertThat(it.next(), is(28));
        assertThat(it.next(), is(66));
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(30));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(40));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(99));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(28));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(66));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}