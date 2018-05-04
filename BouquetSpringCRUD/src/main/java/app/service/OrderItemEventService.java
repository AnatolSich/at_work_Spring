package app.service;

import app.model.OrderItem;

import java.util.List;

public interface OrderItemEventService {
    List<OrderItem> getItemsByEvent(int eventId);
}
