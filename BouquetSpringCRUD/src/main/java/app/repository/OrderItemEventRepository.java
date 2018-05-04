package app.repository;

import app.model.OrderItem;

import java.util.List;

public interface OrderItemEventRepository {
    List<OrderItem> getItemsByEvent(int eventId);
}
