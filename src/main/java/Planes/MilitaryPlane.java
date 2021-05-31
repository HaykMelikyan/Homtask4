package Planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private final MilitaryType type;

    public MilitaryPlane(Plane plane, MilitaryType type) {
        super(plane.getModel(),
                plane.getMaxSpeed(),
                plane.getMaxFlightDistance(),
                plane.getMaxLoadCapacity()
        );
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().replace(
                "}",
                ", type=" + type + '}'
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MilitaryPlane && super.equals(o))) {
            return false;
        }
        return type == ((MilitaryPlane) o).type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
