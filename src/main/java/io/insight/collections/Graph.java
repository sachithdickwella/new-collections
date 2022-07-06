package io.insight.collections;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

/**
 * @author Sachith Dickwella
 */
public interface Graph<V> extends Collection<V> {

    Map.Entry<V, Set<V>> addVertex(@NotNull V label);

    void addEdge(@NotNull V from, @NotNull V to);

    V removeVertex(@NotNull V label);

    V[] removeEdge(@NotNull V from, @NotNull V to);

    @SuppressWarnings("java:S6206")
    class Vertex<V> {

        private final V label;

        public Vertex(@NotNull V label) {
            this.label = label;
        }

        public V getLabel() {
            return label;
        }
    }
}
