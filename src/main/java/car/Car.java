package car;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class Car {
    private CarSize carSize;
    private boolean isElectric;

    public Car() {
        this.carSize = CarSize.MEDIUM;
        this.isElectric = false;
    }

    public Car(CarSize carSize, boolean isElectric) {
        this.carSize = carSize;
        this.isElectric = isElectric;
    }

    public CarSize getSize() {
        return carSize;
    }

    public void setSize(CarSize carSize) {
        this.carSize = carSize;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        // TODO figure out how to print car size
        String size = "";

        return (!isElectric) ? StringUtils.capitalize(size) + " Gasoline Car" : StringUtils.capitalize(size) + " Electric Car";
    }
}
