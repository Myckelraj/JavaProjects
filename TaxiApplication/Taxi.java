package Taxi_BookingApplication;

import java.util.ArrayList;
import java.util.List;

public class Taxi
{
    static  int taxiCount =0;//Taxi number
    int id;
    boolean booked; //Taxi booked or not
    char currentSpot; //Where taxi is now
    int totalEarnings; //total earnings of taxi
    List<String> trips; // all details of all trips by this taxi
    int freeTime;// when taxi  become free

    public Taxi() {
        taxiCount +=1;
        id= taxiCount;
        booked=false;
        currentSpot ='A';
        totalEarnings=0;
        freeTime =6;
        trips=new ArrayList<>();

    }

    public void printTaxiDetails()
    {
        System.out.println("Taxi: "+this.id+"       "+"Total Earning:  "+this.totalEarnings+"       "+
                "Current Spot:  "+this.currentSpot + "     "+
                "FreeTime: "+this.freeTime);
    }
public void printDetails()
{
    System.out.println("Taxi: "+this.id+"         "+"Total Earning: "+this.totalEarnings);
    System.out.println("TaxiID       BookingID       CustomerID      FROM     TO     PickUp    DropUp     Amount");
    for (String  trip:trips)
    {
        System.out.println(id+"                    "+trip);
    }
    System.out.println("------------------------------------------------------------------------------------------------------");
}

public void setDetails(boolean booked,char currentSpots,int freeTime,int totalEarnings,String tripDetail)
{
this.booked=booked;
this.freeTime =freeTime;
this.totalEarnings=totalEarnings;
this.currentSpot =currentSpots;
this.trips.add(tripDetail);
}


}
