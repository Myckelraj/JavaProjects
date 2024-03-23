package Taxi_BookingApplication;
import java.util.*;
public class Booking
{
    public static void main(String[] args)
    {
        List<Taxi> taxis=createTaxi();
    int id=1;
        try (Scanner in = new Scanner(System.in))
         {
            while(true)
            {
                System.out.println("Enter do You Want: ");
                System.out.println("1.Book   2.PrintDetails");
                int choice=in.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter your Pickup Point: ");
                        char pickupPoint = in.next().charAt(0);
                        System.out.println("Enter your Drop Point");
                        char dropUpPoint = in.next().charAt(0);
                        System.out.println("Enter  your Pickup Time ");
                        int pickupTime = in.nextInt();
                        if (pickupPoint < 'A' || dropUpPoint < 'A' || dropUpPoint > 'F' || pickupPoint > 'F')
                        {
                            System.out.println("InValid Pickup and drop are A,B,C,D,E,F");
                            return;
                        }
                        //get all free taxis that can reach customer on before pickup time
                        List<Taxi> freeTaxis = getFreeTaxis(taxis, pickupTime, pickupPoint);

                        if (freeTaxis.isEmpty())
                        {
                            System.out.println("No taxi can be allowed");
                            return;
                        }
                        freeTaxis.sort(Comparator.comparingInt(a -> a.totalEarnings));
                        bookTaxi(id, pickupPoint, dropUpPoint, pickupTime, freeTaxis);
                        id++;
                    }
                    case 2 -> {
                        for (Taxi t : taxis) t.printTaxiDetails();
                        for (Taxi T : taxis) T.printDetails();
                    }
                    default -> {
                        return;
                    }
                }
            }
        } 
           
    }

    private static void bookTaxi(int id, char pickupPoint, char dropUpPoint, int pickupTime, List<Taxi> freeTaxis)
    {
        int min = 999;

        //distance between pickup and drop
        int distanceBetweenpickUpandDrop;

        //this trip earning
        int earning = 0;

        //when taxi will be free next
        int nextfreeTime = 0;

        //where taxi is after trip is over
        char nextSpot = 'Z';

        //booked taxi
        Taxi bookedTaxi = null;

        //all details of current trip as string
        String tripDetail = "";

        for(Taxi t : freeTaxis)
        {
            int distanceBetweenCustomerAndTaxi = Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) * 15;
            if(distanceBetweenCustomerAndTaxi < min)
            {
                bookedTaxi = t;
                //distance between pickup and drop = (drop - pickup) * 15KM
                distanceBetweenpickUpandDrop = Math.abs((dropUpPoint - '0') - (pickupPoint - '0')) * 15;
                //trip earning = 100 + (distanceBetweenpickUpandDrop-5) * 10
                earning = (distanceBetweenpickUpandDrop-5) * 10 + 100;

                //drop time calculation
                int dropTime  = pickupTime + distanceBetweenpickUpandDrop/15;

                //when taxi will be free next
                nextfreeTime = dropTime;

                //taxi will be at drop point after trip
                nextSpot = dropUpPoint;

                // creating trip detail
                tripDetail =id + "               " + id + "          " + pickupPoint +  "      " + dropUpPoint + "       " + pickupTime + "          " +dropTime + "           " + earning;
                min = distanceBetweenCustomerAndTaxi;
            }

        }

        //setting corresponding details to allotted taxi
        assert bookedTaxi != null;
        bookedTaxi.setDetails(true,nextSpot,nextfreeTime,bookedTaxi.totalEarnings + earning,tripDetail);
        //BOOKED SUCCESSFULLY
        System.out.println("Taxi " + bookedTaxi.id + " booked");


    }

    private static List<Taxi> getFreeTaxis(List<Taxi> taxis, int pickupTime, char pickupPoint) {

        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi t : taxis)
        {
            //taxi should be free
            //taxi should have enough time to reach before pickUptime
            if (t.freeTime <= pickupTime && (Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) <= pickupTime - t.freeTime))
                freeTaxis.add(t);
        }
        return freeTaxis;
    }

    private static List<Taxi> createTaxi()
    {
        List<Taxi> taxis=new ArrayList<>();
        for (int i = 1; i<= 4; i++)
        {
          Taxi t=new Taxi();
          taxis.add(t);
        }
    return taxis;
    }
}
