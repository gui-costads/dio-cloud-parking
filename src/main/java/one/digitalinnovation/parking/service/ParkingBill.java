package one.digitalinnovation.parking.service;

import one.digitalinnovation.parking.model.Parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingBill {
    public static final int ONE_HOUR = 60;
    public static final int TWENTY_FOUR_HOUR = ONE_HOUR * 24;
    public static final double ONE_HOUR_VALUE = 5.00;
    public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
    public static final double DAY_VALUE = 70.00;


    public static Double calculateBill(Parking parking) {
        return calculateBill(parking.getEntryDate(), parking.getExitDate());
    }

    private static Double calculateBill(LocalDateTime entryDate, LocalDateTime exitDate) {
        long minutes_parked = entryDate.until(exitDate, ChronoUnit.MINUTES);
        Double bill = 0.0;
        if (minutes_parked <= ONE_HOUR) {
            return ONE_HOUR_VALUE;
        }

        if (minutes_parked > ONE_HOUR && minutes_parked < TWENTY_FOUR_HOUR) {
            bill = ONE_HOUR_VALUE;
            int hours_parked = (int) (minutes_parked / ONE_HOUR);
            bill += (hours_parked - 1)* ADDITIONAL_PER_HOUR_VALUE;
            return bill;
        }

        int days = (int) minutes_parked / TWENTY_FOUR_HOUR;
        bill = days * DAY_VALUE;
        return bill;
    }
}
