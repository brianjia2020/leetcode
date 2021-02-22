package company_questions.amazon.OOD.parkingLot;


import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 4 main actors: Admin, Customer, ParkingLot, ParkingAttendant
 */
public class ParkingLot {
//    private String id;
//    private String address;
//
//    private List<ParkingFloor> parkingFloorsList;


}

class ParkingFloor{
    private List<ParkingSpot> parkingSports;
}

abstract class ParkingSpot{
    private String number;
    private boolean status;
    private Vehicle vechile;
    private final ParkingSpotType type;

    public ParkingSpot(ParkingSpotType type){
        this.type = type;
    }

    public boolean isFree(){
        return status;
    }

}

abstract class Vehicle{
    private String plateNumber;
    private final VehicleType type;
    private ParkingTicket parkingTicket;

    public Vehicle(VehicleType type){
        this.type = type;
    }

}


class ParkingTicket {
    private String ticketNumber;
    private double hourlyRate;
    private GregorianCalendar entryTime;
    private GregorianCalendar leaveTime;
    private double cost;


    //method to get cost
    public double getCost(){
        return hourlyRate*Math.abs(entryTime.getTimeInMillis() - leaveTime.getTimeInMillis())/(1000*3600);
    }
}

enum VehicleType {
    CAR,
    TRUCK,
    ELECTRIC,
    MOTORBIKE,
    VAN
}

enum ParkingSpotType{
    HANDICAPPED,
    COMPACT,
    LARGE,
    MOTORBIKE,
    ELECTRIC
}