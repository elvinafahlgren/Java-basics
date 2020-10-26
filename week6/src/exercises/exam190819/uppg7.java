package exercises.exam190819;

import javafx.scene.control.Tab;

import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.List;

public class uppg7 {
    public static void main(String[] args) {
        new uppg7().program();
    }

    private void program() {

    }

    public class Customer {
        private final String name;
        private final String phone;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
        // Ssetters/getters, equals/hashCode ommited
    }

    class TimeSlot {
        boolean overlaps(TimeSlot other) {
            // True if this and other overlaps in time
            return false;
        }
        // Setters/getters, equals/hashCode ommited
    }


    class Table{
        private final int id;
        private final int places;

        Table(int id, int places) {
            this.id = id;
            this.places = places;
        }

        public int getId(){
            return id;
        }

        public int getPlaces(){
            return places;
        }
    }

    class Booking{
        private final TimeSlot timeSlot;
        private final Customer customer;
        private final Table table;

        Booking(TimeSlot timeSlot, Customer customer, Table table) {
            this.timeSlot = timeSlot;
            this.customer = customer;
            this.table = table;
        }

        TimeSlot getTimeSlot(){
            return timeSlot;
        }

        Customer getCustomer() {
            return customer;
        }

        Table getTable(){
            return table;
        }
    }

    class Restaurant{
        private final List<Table> tables = new ArrayList<>();
        private final List<Booking> bookings = new ArrayList<>();

        boolean bookTable(Customer customer, int people, TimeSlot timeSlot){

            for(Booking booking : bookings){
                //en kund får bara göra en bokning
                if(booking.getCustomer().equals(customer))
                    return false;
            }

            //bordet som bokas måste vara ledigt
            //bordet som bokas måste rymma alla
            for(Table table : tables){
                if(!booked(table, timeSlot) && table.getPlaces() >= people){
                    bookings.add(new Booking(timeSlot, customer, table));
                    return true;
                }
            }
            return false;
        }

        private boolean booked(Table table, TimeSlot timeSlot){
            for(Booking booking : bookings){
                if(booking.getTable().equals(table) && booking.getTimeSlot().overlaps(timeSlot)){
                        return true;
                    }
                }

            return false;
        }

    }

}
