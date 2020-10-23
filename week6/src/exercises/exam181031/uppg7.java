package exercises.exam181031;

import java.util.ArrayList;
import java.util.List;

public class uppg7 {
    public static void main(String[] args) {
        new uppg7().program();
    }

    private void program() {

    }

    enum Status { FREE, OCCUPIED, RESERVED }

    public class Seat {
        Status status;
        public Status getStatus() {
            return status;
        }
    }

    public class Passenger {
        private final String passport;
        private final String name;
        public Passenger(String passport, String name) {
            this.passport = passport;
            this.name = name;
        }
            // setters/getters omitted
    }

    class Flight{
        private final String origin;
        private final String destination;
        private final String depDate;
        private final List<Seat> seats = new ArrayList<>();
        //private final long unixTimestamp; - överkurs

        public Flight(String origin, String destination, String depDate) {
            this.origin = origin;
            this.destination = destination;
            this.depDate = depDate;
        }

        Seat getFreeSeat(){
            for(Seat seat : seats){
                if(seat.getStatus() == Status.FREE)
                    return seat;
            }
            return null;
        }
    }

    class Booking{
        private final Flight flight;
        private final Seat seat;
        private final Passenger passenger;

        public Booking(Flight flight, Seat seat, Passenger passenger) {
            this.flight = flight;
            this.seat = seat;
            this.passenger = passenger;
        }
    }

    class Broker{
        private final List<Flight> flights = new ArrayList<>();
        private final List<Booking> bookings = new ArrayList<>();

        boolean bookFlight(String origin, String destination, String depDate, Passenger passenger){

            for(Flight flight : flights){
                if(!flight.origin.equals(origin))
                    continue;

                if(!flight.destination.equals(destination))
                    continue;

                if(!flight.depDate.equals(depDate))
                    continue;

                Seat seat = flight.getFreeSeat();
                if(seat == null)
                    continue;

                // Everything correct and free seat!
                bookings.add(new Booking(flight, seat, passenger));

                return true;
            }

            return false;
        }
    }
}
