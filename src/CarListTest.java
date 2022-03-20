import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {
    public CarList carList;

    @org.junit.Before
    public void setUp() throws Exception {
        //init
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {

        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovebByIndexThenSizeMustBeDecreased() {

        assertTrue(carList.removeAt(1));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("test", 2);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistElementRemovedThenReturnFalse() {
        Car car = new Car("fake", 123);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrovExeptions() {
        carList.get(100);
    }

    @Test
    public void getReturnRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());

    }
}
