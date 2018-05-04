package app.service;

import app.model.OrderItem;

import java.util.List;

public interface OrderItemBouquetService {
    List<OrderItem> getItemsByBouquet(int bouquetId);
}
