package BookingApplication;
import java.util.*;
public class Flight
{
  static int id=0;
  int flightId;
  int tickets;
  int price;
  ArrayList<String> passengerDetails;
  ArrayList<Integer> passengerCost;
  ArrayList<Integer> passengerId;
  ArrayList<Integer> ticketsBooked;
public Flight()
{
    tickets=100;
    price=1000;
    id=id+1;
    flightId=id;
    passengerDetails = new ArrayList<>();
    passengerCost= new ArrayList<>();
    passengerId= new ArrayList<>();
    ticketsBooked= new ArrayList<>();
}
public void printDetails()
{
  System.out.println("Flight Details:");
  System.out.println("Flight id "+ flightId);
  for(String det:passengerDetails){

    System.out.println(det);
  }

}
public void flightSummary()
{
  System.out.println();
  System.out.println("Tickets Available now "+tickets+"  "+"Current Price is"+price);
}

public void addPassenger(int noOfTickets, int passengerid, 
String passengerDet) 
{
  passengerDetails.add(passengerDet);
  passengerId.add(passengerid);
  passengerCost.add(noOfTickets*price);
  price=price+noOfTickets*200;
  tickets-=noOfTickets;
  ticketsBooked.add(noOfTickets);
  System.out.println("Booked Successfully..");
}
public void cancelPassenger(int pid)
{
int index=passengerId.indexOf(pid);
if(index<0)
{
  System.out.println("Id not Found ");
   return;
}

int ticketCancel=ticketsBooked.get(index);
tickets+=ticketCancel;
price+=200*ticketCancel;
System.out.println("Refund amount "+passengerCost.get(index));
ticketsBooked.remove(index);
passengerCost.remove(index);
passengerDetails.remove(index);
passengerId.remove(Integer.valueOf(pid));
System.out.println("Cancelled Successfully..");
}  
}
