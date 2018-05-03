package repository;

import model.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    OrderItem getItemById(int id);
    List<OrderItem> getAllItems();
    List<OrderItem> getItemsByEvent(int id);
    List<OrderItem> getItemsByBouquet(int id);
     void addItem(OrderItem item);
     void updateItem(OrderItem item);
     void deleteItem(int id);

}
