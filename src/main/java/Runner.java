import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import models.MilitaryType;
import models.Planes;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<Plane> planes = Arrays.asList(
            new PassengerPlane(Planes.BOEING_737, 164),
            new PassengerPlane(Planes.BOEING_737_800, 192),
            new PassengerPlane(Planes.BOEING_747, 242),
            new PassengerPlane(Planes.AIRBUS_A320, 188),
            new PassengerPlane(Planes.AIRBUS_A330, 222),
            new PassengerPlane(Planes.EMBRAER_190, 64),
            new PassengerPlane(Planes.SUKHOI_SUPERJET_100, 140),
            new PassengerPlane(Planes.BOMBARDIER_CS300, 196),
            new MilitaryPlane(Planes.B_1B_LANCER, MilitaryType.BOMBER),
            new MilitaryPlane(Planes.B_2_SPIRIT, MilitaryType.BOMBER),
            new MilitaryPlane(Planes.B_52_STRATOFORTRESS, MilitaryType.BOMBER),
            new MilitaryPlane(Planes.F_15, MilitaryType.FIGHTER),
            new MilitaryPlane(Planes.F_22, MilitaryType.FIGHTER),
            new MilitaryPlane(Planes.C_130_HERCULES, MilitaryType.TRANSPORT)
    );

    public static void main(String[] args) {
        Airport airport = new Airport(planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        System.out.println("Military airport sorted by max distance: " +
                militaryAirport.sortByMaxDistance().toString());
        System.out.println("Passenger airport sorted by max speed: " +
                passengerAirport.sortByMaxSpeed().toString());

        System.out.println("Plane with max passenger capacity: " +
                passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
