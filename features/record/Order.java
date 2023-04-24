package usts.pycro.features.record;

import java.util.Objects;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-10 11:04 AM
 */
public class Order {
    //字段：private final 修饰
    private final int orderId;
    private final String orderName;

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int orderId() {
        return orderId;
    }

    public String orderName() {
        return orderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Objects.equals(orderName, order.orderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
