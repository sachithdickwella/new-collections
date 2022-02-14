package io.insight.collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.function.ThrowingSupplier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Sachith Dickwella
 * @since 1.0.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("LinkedList functionality unit tests")
public class LinkedListTest {

    /**
     * Elements count to insert to new {@link LinkedList}.
     */
    private static final int INIT_ELEMENT_COUNT = 10;
    /**
     * New {@link LinkedList} instance to use across this test class.
     */
    private static LinkedList<Integer> list;

    /**
     * Init method invoke before unit test begins. Annotated with {@link BeforeAll}
     * annotation achieve the requirement.
     */
    @BeforeAll
    public static void init() {
        list = new LinkedList<>();
    }

    /**
     * Common assertion for almost all test cases.
     */
    @BeforeEach
    private void commonAssert() {
        assertNotNull(list, "LinkedList instance is null");
    }

    @Order(1)
    @Test
    @DisplayName("add(T) function test")
    void addTest() {
        assertTrue(list.isEmpty(), "LinkedList is not empty before add(T) invoke first time");

        for (int i = 0; i <= INIT_ELEMENT_COUNT; i++) {
            assertTrue(list.add(i), "Invalid return value (false)");
        }

        assertFalse(list.isEmpty(), "LinkedList is empty after add(T) invoke first time");

        assertEquals(INIT_ELEMENT_COUNT + 1, list.size(), "LinkedList size is invalid");
        assertDoesNotThrow((ThrowingSupplier<ClassCastException>) ClassCastException::new, "Invalid value type provided");
        assertDoesNotThrow((ThrowingSupplier<IllegalArgumentException>) IllegalArgumentException::new);

        for (int i = 0; i < list.size(); i++) {
            assertEquals(i, list.get(i), "Elements are not matching");
        }

        list.add(4, 50);

        list.clear();
    }
}
