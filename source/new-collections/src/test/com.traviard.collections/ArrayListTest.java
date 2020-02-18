package com.traviard.collections;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingSupplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sachith Dickwella
 * @since 1.0
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

    /**
     *
     */
    @Order(1)
    @Test
    @DisplayName("add(T) function test")
    public void addTest() {
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

    /**
     *
     */
    @Order(2)
    @Test
    @DisplayName("add(int, T) function test")
    public void insertTest() {
        assertTrue(list.add(5, -456));
        assertEquals(INIT_ELEMENT_COUNT + 2, list.size(), "ArrayList size() is invalid");
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(20, 100));
    }

    /**
     *
     */
    @Order(3)
    @Test
    @DisplayName("remove(int) function test")
    public void removeTest() {
        // Reset the dataset by removing the element added in the previous step.
        assertEquals(INIT_ELEMENT_COUNT + 2, list.size(), "Before 'remove()' ArrayList size() is invalid");
        assertEquals(-456, list.remove(5));
        assertEquals(INIT_ELEMENT_COUNT + 1, list.size(), "After 'remove()' ArrayList size() is invalid");

        for (int i = 0; i < list.size(); i++) {
            assertEquals(i, list.get(i), "Elements are not matching");
        }
    }

    /**
     *
     */
    @Order(4)
    @Test
    @DisplayName("get(int) function test")
    public void getTest() {
        assertEquals(10, list.get(list.size() - 1), "last index value is invalid");
        assertEquals(6, list.get(6), "640th index value is invalid");
        assertEquals(0, list.get(0), "0th index value is invalid");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1), "-1th index not throws IndexOutOfBoundException");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()),
                "Index larger than size of the list not throws IndexOutOfBoundException");

        /*
         * Check iterator functionality.
         */
        int idx = 0;
        for (int i : list) {
            assertEquals(idx++, i, "Iterated value is invalid");
        }
    }

    /**
     *
     */
    @Order(5)
    @Test
    @DisplayName("toArray() function test")
    public void toArrayTest() {
        final Object[] newArray = list.toArray();

        assertNotNull(newArray, "The new array returned, is null");
        assertEquals(list.size(), newArray.length, "Invalid array size");
    }
}
