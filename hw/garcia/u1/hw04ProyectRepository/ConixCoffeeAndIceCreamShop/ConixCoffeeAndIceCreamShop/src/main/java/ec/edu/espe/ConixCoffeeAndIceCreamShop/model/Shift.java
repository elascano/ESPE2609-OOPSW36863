
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

import java.time.Duration;
import java.time.LocalTime;

public class Shift {

    private LocalTime startTime;
    private LocalTime endTime;

    public Shift(LocalTime startTime, LocalTime endTime) {
        setStartTime(startTime);
        setEndTime(endTime);
    }

    public double calculateShiftHours() {
        long minutes = Duration.between(startTime, endTime).toMinutes();

        if (minutes < 0) {
            minutes += 24 * 60;
        }

        return minutes / 60.0;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        if (startTime == null) {
            throw new IllegalArgumentException(
                    "La hora de entrada no puede ser nula."
            );
        }

        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        if (endTime == null) {
            throw new IllegalArgumentException(
                    "La hora de salida no puede ser nula."
            );
        }

        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Start time: " + startTime
                + " | End time: " + endTime
                + " | Total hours: " + calculateShiftHours();
    }
}
