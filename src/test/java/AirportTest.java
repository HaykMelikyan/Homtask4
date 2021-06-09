import Planes.ExperimentalPlane;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import models.Planes;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static final List<Plane> planes = Arrays.asList(
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
            new MilitaryPlane(Planes.C_130_HERCULES, MilitaryType.TRANSPORT),
            new ExperimentalPlane(Planes.BELL_X_14, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane(Planes.RYAN_X_13_VERTIJET, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static final PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane(
            Planes.BOEING_747, 242);

    private static final Airport airport = new Airport(planes);

    @Test
    public void getTransportMilitaryPlanesTest() {
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            Assert.assertEquals(militaryPlane.getType(), MilitaryType.TRANSPORT);
        }
    }

    @Test
    public void getPassengerPlaneWithMaxCapacityTest() {
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void sortByMaxLoadCapacityTest() {
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Assert.assertTrue(planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() <= planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity());
        }
    }

    @Test
    public void getBomberMilitaryPlanesTest() {
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            Assert.assertEquals(militaryPlane.getType(), MilitaryType.BOMBER);
        }

    }

    @Test
    public void experimentalPlanesAreClassifiedTest() {
        List<ExperimentalPlane> experimentalPlanes = new Airport(planes).getExperimentalPlanes();
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            Assert.assertNotEquals(experimentalPlane.getClassificationLevel(), ClassificationLevel.UNCLASSIFIED);
        }

    }
}
