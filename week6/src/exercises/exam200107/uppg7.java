package exercises.exam200107;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class uppg7 {
    public static void main(String[] args) {
        new uppg7().program();
    }

    private void program() {
    }

    class Customer {
        private String id;
        private String name;
        // Constructor, setter/getter, equals omitted but
        // available, also for classes below
    }
    class Item { // Something the customer can buy
        private String id;
        private String description;
        private double price;
    }
    class OrderItem { // How many items to order
        private Item item; // The item
        private int qty; // Number of items (quantity)
        public OrderItem(Item item, int qty) {
            this.item = item;
            this.qty = qty;
        }

        Item getItem(){
            return item;
        }

        int getQty(){
            return qty;
        }
    }

    class Order {
        private final Customer customer;
        private final List<OrderItem> orderItems;

        Order(Customer customer, List<OrderItem> orderItems){
            this.customer = customer;
            this.orderItems = orderItems;
        }
    }

    class ItemQuantity {
        private Item item;
        private int qty;

        public ItemQuantity(Item item, int qty){
            this.item = item;
            this.qty = qty;
        }

        public int getQty(){
            return qty;
        }

        public void decQuantityOfItem(int n) {
            qty -= n;
        }
    }

    class Store {
        private final List<ItemQuantity> itemQuantities = new ArrayList<>();
        private final List<Order> orderings = new ArrayList<>();
        private final List<Order> backorder = new ArrayList<>();

        void newOrder(Customer customer, List<OrderItem> orderItems){
            List<OrderItem> backorders = new ArrayList<>();
            List<OrderItem> confirmed = new ArrayList<>();

            for(OrderItem orderItem : orderItems){
                for(ItemQuantity itemQty : itemQuantities)
                    if(itemQty.item.equals(orderItem.item)){
                        if(itemQty.getQty() >= orderItem.getQty()){
                            confirmed.add(orderItem);
                            itemQty.decQuantityOfItem(itemQty.qty);
                        }
                        else
                            backorders.add(orderItem);
                    }
            }

            if(confirmed.size() > 0) {
                orderings.add(new Order(customer, confirmed));
            }
            if(backorders.size() > 0) {
                backorder.add(new Order(customer, backorders));
            }

        }


    }

}
