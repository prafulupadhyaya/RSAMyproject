package com.example.rsa_rental_service_application;

public class returnn {

//    public static void main (String[] args) throws java.lang.Exception
//    {
//
//        System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506) + " Kilometers\n");
//
//    }

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;

            dist = dist * 1.609344;
            return (dist);
        }
    }

}
