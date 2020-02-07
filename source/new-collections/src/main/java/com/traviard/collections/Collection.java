package com.traviard.collections;

/**
 * @author Sachith Dickwella
 * @since 1.0
 */
public interface Collection<E> extends Iterable<E> {

    /**
     * Removes all the elements from this collection (optional operation).
     * The collection will be empty after this method returns.
     *
     * @throws UnsupportedOperationException if the clear operation is not
     *                                       supported by this collection.
     */
    void clear();

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
    boolean contains(E element);

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
     * @see #contains(E)
     */
    boolean containsAll(Collection<E> elements);

    /**
     * Return an exact copy of this {@link Collection<E>} with new reference details.
     *
     * @return a new instance of this {@link Collection<E>}.
     */
    Collection<E> copy();

    /**
     * Returns {@code true} if this collection contains no elements.
     *
     * @return {@code true} if this collection contains no elements.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this collection. If this collection
     * contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this collection.
     */
    int size();

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
     * returns an array whose runtime type is {@link E[]}. Use {@code toArray(T[])} to reuse an
     * existing array.
     */
    E[] toArray();

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
     * @param <T>       the component type of the array to contain the collection
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
    <T> T[] toArray(T[] collector);
}
