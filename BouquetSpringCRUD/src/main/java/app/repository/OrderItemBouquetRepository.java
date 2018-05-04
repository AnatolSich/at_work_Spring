package app.repository;

import app.model.OrderItem;

import java.util.List;

public interface OrderItemBouquetRepository {
    List<OrderItem> getItemsByBouquet(int bouquetId);
}
