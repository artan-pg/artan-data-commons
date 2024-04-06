package com.github.artanpg.data.commons.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * A rules for ordering a query result set.
 *
 * @author Mohammad Yazdian
 */
public class Orders implements Iterable<Orders.Order>, Serializable {
    @Serial
    private static final long serialVersionUID = 7485594271474331329L;

    private static final Direction ASC = Direction.ASC;
    private static final Direction DESC = Direction.DESC;

    private final List<Order> orderList;

    private Orders(List<Order> orders) {
        if (Objects.isNull(orders) || orders.isEmpty()) {
            throw new IllegalArgumentException("The Orders must not be null or empty.");
        }
        this.orderList = Collections.unmodifiableList(orders);
    }

    /**
     * Create an instance of the {@link Orders}.
     *
     * @param orders must not be null or empty
     * @return instance of the {@link Orders}
     */
    public static Orders of(List<Order> orders) {
        return new Orders(orders);
    }

    /**
     * Create an instance of the {@link Orders}.
     *
     * @param orders must not be null or empty
     * @return instance of the {@link Orders}
     */
    public static Orders of(Order... orders) {
        return new Orders(Arrays.asList(orders));
    }

    /**
     * Create an instance of the {@link Orders} where all
     * {@code attributeNames} are sorted in {@code ascending} order.
     *
     * @param attributeNames most not be null or empty
     * @return instance of the {@link Orders}
     */
    public static Orders asc(String... attributeNames) {
        if (Objects.isNull(attributeNames) || Arrays.asList(attributeNames).isEmpty()) {
            throw new IllegalArgumentException("The attributeNames must not be null or empty.");
        }
        return of(Arrays.stream(attributeNames)
                .map(attributeName -> new Order(attributeName, ASC))
                .toList());
    }

    /**
     * Create an instance of the {@link Orders} where all
     * {@code attributeNames} are sorted in {@code descending} order.
     *
     * @param attributeNames most not be null or empty
     * @return instance of the {@link Orders}
     */
    public static Orders desc(String... attributeNames) {
        if (Objects.isNull(attributeNames) || Arrays.asList(attributeNames).isEmpty()) {
            throw new IllegalArgumentException("The attributeNames must not be null or empty.");
        }
        return of(Arrays.stream(attributeNames)
                .map(attributeName -> new Order(attributeName, DESC))
                .toList());
    }

    @Override
    public Iterator<Order> iterator() {
        return orderList.iterator();
    }

    /**
     * Creates a non-parallel {@link Stream} of the underlying
     * {@link Iterable}.
     *
     * @return will never be {@literal null}.
     */
    public Stream<Order> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(orderList, orders.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Orders.class.getSimpleName() + "[", "]")
                .add("orderList=" + orderList)
                .toString();
    }

    public static class Order implements Serializable {
        @Serial
        private static final long serialVersionUID = -6589694927453737644L;

        private final String attributeName;
        private final Direction direction;
        private final NullHandling nullHandling;

        private Order(String attributeName, Direction direction) {
            this(attributeName, direction, NullHandling.NONE);
        }

        private Order(String attributeName, Direction direction, NullHandling nullHandling) {
            this.attributeName = attributeName;
            this.direction = direction;
            this.nullHandling = nullHandling;
        }

        /**
         * Create an instance of the {@link Order}.
         *
         * @param attributeName must not be null or empty
         * @param direction     must not be null or empty
         * @return instance of the {@link Order}
         */
        public static Order of(String attributeName, Direction direction) {
            return new Order(attributeName, direction, NullHandling.NONE);
        }

        /**
         * Create an instance of the {@link Order}.
         *
         * @param attributeName must not be null or empty
         * @param direction     must not be null or empty
         * @param nullHandling  must not be null or empty
         * @return instance of the {@link Order}
         */
        public static Order of(String attributeName, Direction direction, NullHandling nullHandling) {
            return new Order(attributeName, direction, nullHandling);
        }

        /**
         * Create an instance of the {@link Order} where all
         * {@code attributeName} are sorted in {@code ascending}
         * order.
         *
         * @param attributeName most not be null or empty
         * @return instance of the {@link Order}
         */
        public static Order asc(String attributeName) {
            return asc(attributeName, NullHandling.NONE);
        }

        /**
         * Create an instance of the {@link Order} where all
         * {@code attributeName} are sorted in {@code ascending}
         * order.
         *
         * @param attributeName most not be null or empty
         * @param nullHandling  most not be null or empty
         * @return instance of the {@link Order}
         */
        public static Order asc(String attributeName, NullHandling nullHandling) {
            return new Order(attributeName, Direction.ASC, nullHandling);
        }

        /**
         * Create an instance of the {@link Order} where all
         * {@code attributeName} are sorted in {@code descending}
         * order.
         *
         * @param attributeName most not be null or empty
         * @return instance of the {@link Order}
         */
        public static Order desc(String attributeName) {
            return desc(attributeName, NullHandling.NONE);
        }

        /**
         * Create an instance of the {@link Order} where all
         * {@code attributeName} are sorted in {@code descending}
         * order.
         *
         * @param attributeName most not be null or empty
         * @param nullHandling  most not be null or empty
         * @return instance of the {@link Order}
         */
        public static Order desc(String attributeName, NullHandling nullHandling) {
            return new Order(attributeName, Direction.DESC, nullHandling);
        }

        /**
         * Checks that the {@link Direction} type is ascending.
         *
         * @return true, if a direction type is ascending
         */
        public boolean isAscending() {
            return direction.isAscending();
        }

        /**
         * Checks that the {@link Direction} type is descending.
         *
         * @return true, if a direction type is descending
         */
        public boolean isDescending() {
            return direction.isDescending();
        }

        public String getAttributeName() {
            return attributeName;
        }

        public Direction getDirection() {
            return direction;
        }

        public NullHandling getNullHandling() {
            return nullHandling;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Order order = (Order) o;
            return Objects.equals(attributeName, order.attributeName) &&
                    direction == order.direction &&
                    nullHandling == order.nullHandling;
        }

        @Override
        public int hashCode() {
            return Objects.hash(attributeName, direction, nullHandling);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                    .add("attributeName='" + attributeName + "'")
                    .add("direction=" + direction)
                    .add("nullHandling=" + nullHandling)
                    .toString();
        }
    }
}
