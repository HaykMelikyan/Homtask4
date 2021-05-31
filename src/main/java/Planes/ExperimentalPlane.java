package Planes;

import models.ClassificationLevel;
import models.ExperimentalType;

public class ExperimentalPlane extends Plane {

    ExperimentalType type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(Plane plane, ExperimentalType type, ClassificationLevel classificationLevel) {
        super(plane.getModel(),
                plane.getMaxSpeed(),
                plane.getMaxFlightDistance(),
                plane.getMaxLoadCapacity()
        );
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
