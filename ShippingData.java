package sample;

import java.awt.*;

public class ShippingData {
    String fromport;
    String toport;
    String vessel;
    Integer flow;
    String capacity;

    public ShippingData(String fromport, String toport, String vessel, Integer flow, String capacity) {
        this.fromport = fromport;
        this.toport = toport;
        this.vessel = vessel;
        this.flow = flow;
        this.capacity = capacity;
    }

    public ShippingData(String fromportname, String toportname, String capacityCount) {
        fromport = fromportname;
        toport = toportname;
        capacity = capacityCount;
    }

    public String getFromPortName() {
        return fromport;
    }

    public String getToPortName() {
        return toport;
    }

    @Override
    public String toString() {
        return fromport + " " + toport + " " + vessel + " " + flow + " " + capacity;
    }
}