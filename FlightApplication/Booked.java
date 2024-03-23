package BookingApplication;
import java.util.*;
class Booked {

private static void cancel(int pid, Flight currentFlight) {
    currentFlight.cancelPassenger(pid);
}

private static void book(Flight currentFlight, int tickets, int passengerId)
{
   String passengerDetail;
   passengerDetail="No of Tickets is "+tickets+"   " +
   " TotalCost is"+currentFlight.price*tickets+"   "+"Passenger id"+passengerId;
   currentFlight.addPassenger(tickets,passengerId,passengerDetail);
   currentFlight.flightSummary();
   currentFlight.printDetails();
}
    
public static void main(String[] args) 
{
    
ArrayList<Flight> flights= new ArrayList<>();
for(int i=0;i<=2;i++)
{
    flights.add(new Flight());
} 
int passengerId =1;
Scanner in =new Scanner(System.in);
try{
   while(true)
{
   System.out.println(" Warm Welcome To All from AIR INDIA ");
   System.out.println("Please Start your Booking..");
   System.out.println("Enter 1.BOOK  2.CANCEL 3.PRINT 4.EXIT");

    int choice =in.nextInt();
  switch (choice){
    case 1:{
     System.out.println("Enter the Flight Id: ");
     int fid=in.nextInt();
     if(fid>flights.size())
     {
        System.out.println("Invalid Entered Flight Id");
        break;
     }
    Flight currentFlight= null;
    for (Flight f : flights)
    {
       if(f.flightId==fid){
        currentFlight=f;
        f.flightSummary();
        break;
       } 
    }
    System.out.println("Enter the tickets ");
    int tickets=in.nextInt();
    if(tickets>currentFlight.tickets)
    {
        System.out.println("Invalid ticket");
        break;
    }
    
    book(currentFlight,tickets,passengerId);
    passengerId=passengerId+1;
     break;
    }
   case 2:
   {
     System.out.println("Enter the Flight Id, passenger Id  to cancel.."); 
     int fid=in.nextInt();
     if(fid>flights.size())
     {
        System.out.println("Invalid Enter Flight Id");
        break;
     }
    Flight currentFlight= null;
    for (Flight f : flights)
    {
       if(f.flightId==fid){
        currentFlight=f;
        break;
       } 
    }
   int pid=in.nextInt();
    cancel(pid,currentFlight);
    break;
   }
   case 3:
   {
     for (Flight f : flights) 
     {
         if (f.passengerDetails.isEmpty())
        {
                 System.out.println("Not found");
        } else 
        {
                  f.printDetails();
        }
    }
    break;
   }
   case 4:
   {
        System.exit(0);
        break;
   }
} 
}
}
finally{
   in.close();
}
}
}
