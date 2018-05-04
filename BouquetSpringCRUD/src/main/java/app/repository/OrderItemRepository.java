package app.repository;

import app.model.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    OrderItem getItemById(int id);
    List<OrderItem> getAllItems();
     void addItem(OrderItem item, int eventId, int bouquetId);
     void updateItem(OrderItem item);
     void deleteItem(int id);

}
