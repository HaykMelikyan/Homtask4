package Planes;

import models.ClassificationLevel;
import models.ExperimentalType;
import models.Planes;

public class ExperimentalPlane extends Plane {

    ExperimentalType type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(Planes plane, ExperimentalType type, ClassificationLevel classificationLevel) {
        super(plane);
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
