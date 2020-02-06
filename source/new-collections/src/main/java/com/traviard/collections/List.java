package com.traviard.collections;

/**
 * @author Sachith Dickwella
 * @since 1.0
 */
public interface List<T> extends Collection<T> {

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
    boolean add(T element);

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
    boolean add(int index, T element);

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
    boolean addAll(Collection<? extends T> elements);

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
    boolean addAll(int index, Collection<? extends T> elements);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range, {@code (index < 0 || index > size())}
     */
    T get(int index);

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
    int indexOf(T element);

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
    T remove(int index);

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
    int remove(T element);

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
    boolean removeAll(Collection<? extends T> elements);

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
    T set(int index, T element);
}
