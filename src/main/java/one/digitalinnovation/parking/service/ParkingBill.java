package one.digitalinnovation.parking.service;

import one.digitalinnovation.parking.model.Parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingBill {
    public static final int ONE_HOUR = 60;
    public static final int TWENTY_FOUR_HOUR = ONE_HOUR *24;
    public static final double ONE_HOUR_VALUE = 5.00;
    public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
    public static final double DAY_VALUE = 20.00;


    public static Double getBill(Parking parking){
        return getBill(parking.getEntryDate(), parking.getExitDate());
    }

    private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
        long minutes_parked = entryDate.until(exitDate, ChronoUnit.MINUTES);
        Double bill = 0.0;
        if (minutes_parked<= ONE_HOUR){
            return ONE_HOUR_VALUE;
        }
        if (minutes_parked <= TWENTY_FOUR_HOUR){
            bill = ONE_HOUR_VALUE;
            int hours_parked =  (int) (minutes_parked/ONE_HOUR);
            bill *= hours_parked;
            return bill;
        }

        int days = (int) minutes_parked/TWENTY_FOUR_HOUR;
        bill *= DAY_VALUE;
        return bill;
    }
}
