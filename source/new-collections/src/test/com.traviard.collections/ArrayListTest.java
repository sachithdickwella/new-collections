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
    private static final int INIT_ELEMENT_COUNT = 1_000;
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
     *
     */
    @Order(1)
    @Test
    @DisplayName("add(T) function test")
    public void addTest() {
        assertNotNull(list, "ArrayList instance is null");
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
    @DisplayName("get(int) function test")
    public void getTest() {
        assertNotNull(list, "ArrayList instance is null");
        assertEquals(INIT_ELEMENT_COUNT + 1, list.size(), "ArrayList size() is invalid");
        assertEquals(1000, list.get(list.size() - 1), "last index value is invalid");
        assertEquals(640, list.get(640), "640th index value is invalid");
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
    @Order(3)
    @Test
    @DisplayName("add(int, T) function test")
    public void insertTest() {
        assertNotNull(list, "ArrayList instance is null");
        assertEquals(INIT_ELEMENT_COUNT + 1, list.size(), "ArrayList size() is invalid");

        assertTrue(list.add(100, -456));
    }
}
