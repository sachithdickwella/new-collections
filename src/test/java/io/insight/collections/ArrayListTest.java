package io.insight.collections;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingSupplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sachith Dickwella
 * @since 1.0.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("ArrayList functionality unit tests")
public class ArrayListTest {

    /**
     * Elements count to insert to new {@link ArrayList}.
     */
    private static final int INIT_ELEMENT_COUNT = 10;
    /**
     * New {@link ArrayList} instance to use across this test class.
     */
    private static ArrayList<Integer> list;

    /**
     * Init method invoke before unit test begins. Annotated with {@link BeforeAll}
     * annotation achieve the requirement.
     */
    @BeforeAll
    public static void init() {
        list = new ArrayList<>();
    }

    /**
     * Common assertion for almost all test cases.
     */
    @BeforeEach
    private void commonAssert() {
        assertNotNull(list, "ArrayList instance is null");
    }

    @Order(1)
    @Test
    @DisplayName("add(T) function test")
    void addTest() {
        assertTrue(list.isEmpty(), "ArrayList is not empty before add(T) invoke first time");

        for (int i = 0; i <= INIT_ELEMENT_COUNT; i++) {
            assertTrue(list.add(i), "Invalid return value (false)");
        }

        assertFalse(list.isEmpty(), "ArrayList is empty after add(T) invoke first time");

        assertEquals(INIT_ELEMENT_COUNT + 1, list.size(), "ArrayList size is invalid");
        assertDoesNotThrow((ThrowingSupplier<ClassCastException>) ClassCastException::new, "Invalid value type provided");
        assertDoesNotThrow((ThrowingSupplier<IllegalArgumentException>) IllegalArgumentException::new);

        for (int i = 0; i < list.size(); i++) {
            assertEquals(i, list.get(i), "Elements are not matching");
        }
    }

    @Order(2)
    @Test
    @DisplayName("add(int, T) function test")
    void insertTest() {
        assertTrue(list.add(5, -456));
        assertEquals(INIT_ELEMENT_COUNT + 2, list.size(), "ArrayList size() is invalid");
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 100));
    }

    @Order(3)
    @Test
    @DisplayName("remove(int) function test")
    void removeTest() {
        // Reset the dataset by removing the element added in the previous step.
        assertEquals(INIT_ELEMENT_COUNT + 2, list.size(), "Before 'remove()' ArrayList size() is invalid");
        assertEquals(-456, list.remove(5));
        assertEquals(INIT_ELEMENT_COUNT + 1, list.size(), "After 'remove()' ArrayList size() is invalid");

        for (int i = 0; i < list.size(); i++) {
            assertEquals(i, list.get(i), "Elements are not matching");
        }
    }

    @Order(4)
    @Test
    @DisplayName("get(int) function test")
    void getTest() {
        int size = list.size();

        assertEquals(10, list.get(size - 1), "last index value is invalid");
        assertEquals(6, list.get(6), "640th index value is invalid");
        assertEquals(0, list.get(0), "0th index value is invalid");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1), "-1th index not throws IndexOutOfBoundException");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(size),
                "Index larger than size of the list not throws IndexOutOfBoundException");

        /*
         * Check iterator functionality.
         */
        int idx = 0;
        for (int i : list) {
            assertEquals(idx++, i, "Iterated value is invalid");
        }
    }

    @Order(5)
    @Test
    @DisplayName("toArray() function test")
    void toArrayTest() {
        final Object[] newArray = list.toArray();

        assertNotNull(newArray, "The new array returned, is null");
        assertEquals(list.size(), newArray.length, "Invalid array size");

        /*
         * Check iterator functionality.
         */
        int idx = 0;
        for (Object i : newArray) {
            assertEquals(idx++, i, "Iterated value is invalid");
        }
    }

    @Order(6)
    @Test
    @DisplayName("toArray(T[]) function test")
    void toArrayGenericTest() {
        int size = list.size();
        /*
         * Small array size provided.
         */
        Integer[] newArray = list.toArray(new Integer[5]);

        assertNotNull(newArray, "The new array returned, is null");
        assertEquals(size, newArray.length, "Invalid array size");

        /*
         * Larger array size provided.
         */
        newArray = list.toArray(new Integer[12]);

        assertNotNull(newArray, "The new array returned, is null");

        /*
         * Check iterator functionality.
         */
        for (int idx = 0; idx < newArray.length; idx++) {
            if (idx < size) {
                assertEquals(idx, newArray[idx], "Iterated value is invalid");
            } else {
                assertNull(newArray[idx]);
            }
        }

        /*
         * Different compatible type array provided.
         */
        final Number[] newLongArray = list.toArray(new Number[size]);

        assertNotNull(newLongArray, "The new array returned, is null");
        assertEquals(size, newLongArray.length, "Invalid array size");

        int idx = 0;
        for (Number l : newLongArray) {
            assertEquals(idx++, l, "Iterated value is invalid");
        }

        /*
         * Different non-compatible type array provided.
         */
        assertThrows(ArrayStoreException.class, () -> list.toArray(new Long[size]));
    }

    @Order(7)
    @Test
    @DisplayName("copy() function test")
    void copyTest() {
        final List<Integer> copy = list.copy();

        assertEquals(list.size(), copy.size(), "Copied list size is invalid");

        copy.remove(2);
        assertEquals(list.size() - 1, copy.size(), """
                Copied list size is invalid, after one element removed
                """);

        copy.add(20);
        copy.add(21);
        assertEquals(list.size() + 1, copy.size(), """
                Copied list size is invalid, after two elements added
                """);
    }

    @Order(8)
    @Test
    @DisplayName("ArrayList(Collection<>T constructor test")
    void constructor1Test() {
        List<Integer> preInitList = new ArrayList<>(list);

        assertNotNull(preInitList, "New list instance is null");
        assertEquals(list.size(), preInitList.size(), "preInitList size is invalid");

        preInitList.add(20);
        preInitList.add(30);
        assertEquals(list.size() + 2, preInitList.size(), """
                preInitList size is invalid, after two elements added
                """);

        preInitList.remove(5);
        assertEquals(list.size() + 1, preInitList.size(), """
                preInitList size is invalid, after one element removed
                """);

        preInitList = new ArrayList<>(null);

        assertEquals(0, preInitList.size(), """
                preInitList size is invalid, on null initial collection
                """);
    }

    @Order(9)
    @Test
    @DisplayName("addAll(Collection<T> function test)")
    void addAll1Test() {
        List<Integer> preInitList = new ArrayList<>(20);

        assertEquals(0, preInitList.size(), """
                preInitList size is invalid, with initial size constructor
                """);

        assertTrue(preInitList.addAll(list), """
                addAll with not empty Collection, hasn't made any effect on preInitList
                """);
        assertFalse(preInitList.addAll(new ArrayList<>()), """
                addAll with empty Collection, has made an effect on preInitList
                """);
        assertEquals(list.size(), preInitList.size(), """
                preInitList size is invalid, after addAll from main 'list'
                """);
        assertTrue(preInitList.addAll(list), """
                addAll with not empty Collection (again), hasn't made any effect on preInitList
                """);
        assertEquals(list.size() * 2, preInitList.size(), """
                preInitList size is invalid, after addAll from main 'list' again
                """);

        assertEquals(3, preInitList.remove(3), "Remove by an index, returns an invalid value");
        assertEquals((list.size() * 2) - 1, preInitList.size(), """
                preInitList size is invalid, after 'remove()' a one element
                """);

        preInitList.add(3, 3);
        assertEquals(list.size() * 2, preInitList.size(), """
                preInitList size is invalid, after add(int, T) again
                """);

        //for (int i = 1; i <= 2; i++) {
            for (int idx = 0; idx < preInitList.size(); idx++) {
                System.out.println(preInitList.get(idx));
                //assertEquals(idx * i, preInitList.get(idx * i), "Iterated value is invalid");
            }
        //}

    }
}
