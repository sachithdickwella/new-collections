package io.insight.collections;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

import static java.lang.String.format;

/**
 * @author Sachith Dickwella
 * @since 1.0
 */
public class LinkedList<T> implements List<T> {

    /**
     *
     */
    private Node<T> head;
    /**
     *
     */
    private Node<T> tail;
    /**
     * Keep the current index of the latest value.
     */
    private int size;

    /**
     *
     */
    public LinkedList() {
    }

    /**
     *
     */
    public LinkedList(Collection<T> collection) {

    }

    /**
     * Appends the specified element to the end of this list (optional operation).
     * Lists that support this operation may place limitations on what elements may
     * be added to this list. In particular, some lists will refuse to add null elements,
     * and others will impose restrictions on the type of elements that may be added.
     * List classes should clearly specify in their documentation any restrictions on
     * what elements may be added.
     *
     * @param element element to be appended to this list
     * @return {@code true} if append success
     * @throws UnsupportedOperationException if the add operation is not supported by
     *                                       this list
     * @throws ClassCastException            if the class of the specified element prevents it from
     *                                       being added to this list
     * @throws NullPointerException          if the specified element is null and this list does
     *                                       not permit null elements
     * @throws IllegalArgumentException      if some property of this element prevents it from
     *                                       being added to this list.
     */
    @Override
    public boolean add(T element) {
        Node<T> t = tail;
        Node<T> newNode = new Node<>(t, element, null);
        tail = newNode;

        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list (optional operation).
     * Shifts the element currently at that position (if any) and any subsequent elements to the
     * right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws UnsupportedOperationException if the add operation is not supported by this
     *                                       list
     * @throws ClassCastException            if the class of the specified element prevents
     *                                       it from being added to this list
     * @throws NullPointerException          if the specified element is null and this list
     *                                       does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified element prevents
     *                                       it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range, {@code (index < 0 || index > size())}
     */
    @Override
    public boolean add(int index, T element) {
        if (!isIndexValid(index))
            throw new IndexOutOfBoundsException(format("LinkedList index is out of bound: %d", index));

        Node<T> node = node(index);
        node.previous = new Node<>(node.previous, element, node);

        size++; // TODO - Complete the method.
        return true;
    }

    /**
     * Appends all the elements in the specified collection to the end of this list, in the order that
     * they are returned by the specified collection's iterator (optional operation). The behavior of this
     * operation is undefined if the specified collection is modified while the operation is in progress.
     * (Note that this will occur if the specified collection is this list, and it's nonempty.)
     *
     * @param elements collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the addAll operation is not supported by this list
     * @throws ClassCastException            if the class of an element of the specified collection prevents
     *                                       it from being added to this list
     * @throws NullPointerException          if the specified collection contains one or more null elements and
     *                                       this list does not permit null elements, or if the specified collection
     *                                       is null
     * @throws IllegalArgumentException      if some property of an element of the specified collection prevents
     *                                       it from being added to this list.
     */
    @Override
    public boolean addAll(Collection<? extends T> elements) {
        return false;
    }

    /**
     * Inserts all the elements in the specified collection into this list at the specified position
     * (optional operation). Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (increases their indices). The new elements will appear in this list in
     * the order that they are returned by the specified collection's iterator. The behavior of this
     * operation is undefined if the specified collection is modified while the operation is in progress.
     * (Note that this will occur if the specified collection is this list, and it's nonempty.)
     *
     * @param index    index at which to insert the first element from the specified collection
     * @param elements collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the addAll operation is not supported by this list
     * @throws ClassCastException            if the class of an element of the specified collection
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified collection contains one or more null
     *                                       elements and this list does not permit null elements, or
     *                                       if the specified collection is null
     * @throws IllegalArgumentException      if some property of an element of the specified collection
     *                                       prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range, {@code (index < 0 || index > size())}
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> elements) {
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range, {@code (index < 0 || index > size())}
     */
    @Override
    public T get(int index) {
        if (!isIndexValid(index))
            throw new IndexOutOfBoundsException(format("LinkedList index is out of bound: %d", index));
        return node(index).value;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or {@code -1} if
     * this list does not contain the element. More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))}, or {@code -1} if there is no such index.
     *
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this
     * list does not contain the element
     * @throws ClassCastException   if the type of the specified element is incompatible with this
     *                              list (optional)
     * @throws NullPointerException if the specified element is null and this list does not permit
     *                              null elements (optional)
     */
    @Override
    public int indexOf(T element) {
        return 0;
    }

    /**
     * Removes the element at the specified position in this list (optional operation).
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the remove operation is not supported
     *                                       by this list
     * @throws IndexOutOfBoundsException     if the index is out of range, {@code (index < 0 || index > size())}
     */
    @Override
    public T remove(int index) {
        return null;
    }

    /**
     * Removes the matching instances in this list (optional operation). Shifts any
     * subsequent elements to the left (subtracts one from their indices). Returns the
     * element that was removed from the list.
     *
     * @param element the index of the element to be removed
     * @return number of elements removed
     * @throws UnsupportedOperationException if the remove operation is not supported
     *                                       by this list
     * @throws IndexOutOfBoundsException     if the index is out of range, {@code (index < 0 || index > size())}
     */
    @Override
    public int remove(T element) {
        return 0;
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection
     * (optional operation).
     *
     * @param elements collection containing elements to be removed from this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the removeAll operation is not supported by this
     *                                       list
     * @throws ClassCastException            if the class of an element of this list is incompatible
     *                                       with the specified collection (optional)
     * @throws NullPointerException          if this list contains a null element and the specified
     *                                       collection does not permit null elements (optional), or
     *                                       if the specified collection is null.
     */
    @Override
    public boolean removeAll(Collection<? extends T> elements) {
        return false;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element
     * (optional operation).
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the set operation is not supported by this list
     * @throws ClassCastException            if the class of the specified element prevents it
     *                                       from being added to this list
     * @throws NullPointerException          if the specified element is null and this list does
     *                                       not permit null elements
     * @throws IllegalArgumentException      if some property of the specified element prevents
     *                                       it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range, {@code (index < 0 || index > size())}
     */
    @Override
    public T set(int index, T element) {
        return null;
    }

    /**
     * Removes all the elements from this collection (optional operation).
     * The collection will be empty after this method returns.
     *
     * @throws UnsupportedOperationException if the clear operation is not
     *                                       supported by this collection.
     */
    @SuppressWarnings("java:S127")
    @Override
    public void clear() {
        for (Node<T> node = head; node != null;) {
            Node<T> n = node.next;
            node.value = null;
            node.next = null;
            node.previous = null;

            node = n;
        }

        head = tail = null;
        size = 0;
    }

    /**
     * Returns true if this collection contains the specified element. More formally,
     * returns true if and only if this collection contains at least one element e such
     * that Objects.equals(o, e).
     *
     * @param element whose presence in this collection is to be tested
     * @return {@code true} if this collection contains the specified element
     * @throws ClassCastException   if the type of the specified element is incompatible
     *                              with this collection (optional)
     * @throws NullPointerException if the specified element is null and this collection
     *                              does not permit null elements (optional)
     */
    @Override
    public boolean contains(T element) {
        return false;
    }

    /**
     * Returns true if this collection contains all the elements in the specified collection.
     *
     * @param elements collection to be checked for containment in this collection
     * @return {@code true} if this collection contains all the elements in the specified collection
     * @throws ClassCastException   if the types of one or more elements in the specified
     *                              collection are incompatible with this collection (optional)
     * @throws NullPointerException if the specified collection contains one or more null
     *                              elements and this collection does not permit null elements
     *                              (optional), or if the specified collection is null.
     * @see #contains(T)
     */
    @Override
    public boolean containsAll(Collection<T> elements) {
        return false;
    }

    /**
     * Return an exact copy of this {@link Collection<T>} with new reference details.
     *
     * @return a new instance of this {@link Collection<T>}.
     */
    @Override
    public Collection<T> copy() {
        return null;
    }

    /**
     * Returns {@code true} if this collection contains no elements.
     *
     * @return {@code true} if this collection contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this collection. If this collection
     * contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this collection.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an array containing all the elements in this collection. If this collection
     * makes any guarantees as to what order its elements are returned by its iterator, this
     * method must return the elements in the same order. The returned array's runtime component
     * type is Object.
     * <p>
     * The returned array will be "safe" in that no references to it are maintained by this
     * collection. (In other words, this method must allocate a new array even if this collection
     * is backed by an array). The caller is thus free to modify the returned array.
     *
     * @return an array, whose runtime component type is Object, containing all the elements in
     * this collection
     * @apiNote This method acts as a bridge between array-based and collection-based APIs. It
     * returns an array whose runtime type is {@link Object[]}. Use {@code toArray(T[])} to reuse an
     * existing array.
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * Returns an array containing all the elements in this collection; the runtime type of the
     * returned array is that of the specified array. If the collection fits in the specified array,
     * it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified
     * array and the size of this collection.
     * <p>
     * If this collection fits in the specified array with room to spare (i.e., the array has more elements
     * than this collection), the element in the array immediately following the end of the collection is set
     * to null. (This is useful in determining the length of this collection only if the caller knows that this
     * collection does not contain any null elements.)
     * <p>
     * If this collection makes any guarantees as to what order its elements are returned by its iterator,
     * this method must return the elements in the same order.
     *
     * @param collector the array into which the elements of this collection are to be stored, if it is big
     *                  enough; otherwise, a new array of the same runtime type is allocated for this purpose.
     * @return an array containing all the elements in this collection
     * @throws ArrayStoreException  if the runtime type of any element in this collection is not assignable
     *                              to the runtime component type of the specified array
     * @throws NullPointerException if the specified array is null.
     * @apiNote This method acts as a bridge between array-based and collection-based APIs. It allows an
     * existing array to be reused under certain circumstances. Use {@link #toArray()} to create an array whose
     * runtime type is {@code T[]}. Suppose x is a collection known to contain only strings. The following code
     * can be used to dump the collection into a previously allocated String array:
     *
     * <pre>{@code
     *      String[] y = new String[SIZE];
     *      ...
     *      y = x.toArray(y);
     * }</pre>
     * <p>
     * The return value is reassigned to the variable y, because a new array will be allocated and returned if
     * the collection x has too many elements to fit into the existing array y.
     * <p>
     * Note that toArray(new Object[0]) is identical in function to toArray().
     * <p>
     */
    @Override
    public <E> E[] toArray(E[] collector) {
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     *
     */
    private static class Node<T> {

        /**
         *
         */
        private T value;

        /**
         *
         */
        private Node<T> previous;

        /**
         *
         */
        private Node<T> next;

        /**
         *
         */
        public Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    /**
     *
     */
    private boolean isIndexValid(int index) {
        return index < size;
    }

    /**
     *
     */
    private Node<T> node(int index) {
        if (index > (size >> 1)) {
            Node<T> t = tail;
            for (int i = size - 1; i > index; i--)
                t = t.previous;
            return t;
        } else {
            Node<T> h = head;
            for (int i = 0; i < index; i++)
                h = h.next;
            return h;
        }
    }
}
