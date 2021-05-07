package com.practice;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        List<Movie> movies = Reader.ParseCSVandRead();
        Scanner sc =  new Scanner(System.in);
        System.out.println("Please Input the number of movies you want to list out");
        int n = sc.nextInt();
        System.out.println("Please Enter the start date in dd-mm-yyyy format");
        String sDate = sc.next();
        Date startDate = !sDate.equals("") ? new SimpleDateFormat("dd-mm-yyyy").parse(sDate) : null;
        System.out.println("Please Enter the end date in dd-mm-yyyy format");
        String eDate = sc.next();
        Date endDate = !sDate.equals("") ? new SimpleDateFormat("dd-mm-yyyy").parse(eDate) : null;

        System.out.println("Please Enter from below option to see the results");
        System.out.println("Please Enter 1 to Search for TV Show");
        System.out.println("Please Enter 2 to Search for Horror Movies");
        System.out.println("Please Enter 3 to Search for Indian Movies");

        int userInput = sc.nextInt();
        if(userInput == 1)
            FilterMovieData.filterByTypeTvShow(movies, n, startDate, endDate);
        else if(userInput == 2)
            FilterMovieData.findListedHorrorMovie(movies, n, startDate, endDate);
        else if(userInput == 3)
            FilterMovieData.filterIndianMovie(movies, n, startDate, endDate);
        else
            System.out.println("Please Enter a valid option to see the results");
    }
}
