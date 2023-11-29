package car;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class Car {
    private String size;
    private boolean isElectric;

    public Car() {
        this.size = "medium";
        this.isElectric = false;
    }

    public Car(String size, boolean isElectric) {
        this.size = size;
        this.isElectric = isElectric;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return (!isElectric) ? StringUtils.capitalize(size) + " Gasoline Car" : StringUtils.capitalize(size) + " Electric Car";
    }
}
