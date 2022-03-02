import lab01.tdd.CircularList;
import lab01.tdd.SelectStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    void createList(int n){
        for (int i = 1; i<=n; i++){
            list.add(i);
        }
    }

    @BeforeEach
    void beforeEach(){
        list = new CircularListImpl();
    }

    @Test
    void testIsEmpty(){
        assertTrue(this.list.isEmpty());
    }

    @Test
    void testAdd(){
        createList(3);
        assertEquals(3,this.list.size());
    }

    @Test
    void testSize(){
        createList(3);
        assertEquals(3,this.list.size());
    }

    @Test
    void testNext(){
        createList(3);
        assertEquals(1,this.list.next().get());
        assertEquals(2,this.list.next().get());
        assertEquals(3,this.list.next().get());
        assertEquals(1,this.list.next().get());
        assertEquals(2,this.list.next().get());
    }

    @Test
    void testReset(){
        createList(3);
        this.list.next();
        this.list.next();
        this.list.next();
        assertEquals(1,this.list.next().get());
    }

    @Test
    void testPrevious(){
        createList(3);
        assertEquals(3,this.list.previous().get());
        assertEquals(2,this.list.previous().get());
        assertEquals(1,this.list.previous().get());
        assertEquals(3,this.list.previous().get());
        assertEquals(2,this.list.previous().get());
    }

    @Test
    void testStrategy(){
        createList(4);
        SelectStrategy strategy = element -> element%2 == 0;
        assertEquals(2, list.next(strategy).get());
        assertEquals(4, list.next(strategy).get());
    }

}
