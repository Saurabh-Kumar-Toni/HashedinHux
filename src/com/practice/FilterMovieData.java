package com.practice;

import java.util.Date;
import java.util.List;

public class FilterMovieData {

    public static void filterByTypeTvShow(List<Movie> movie, int n, Date startDate, Date endDate)
    {
        long startTime = System.currentTimeMillis();
        movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getType().equals("TV Show")).limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for the Process to complete is " + (endTime - startTime) + "ms");
    }

    public static void findListedHorrorMovie(List<Movie> movie, int n, Date startDate, Date endDate)
    {
        long startTime = System.currentTimeMillis();
        movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getListed_in().contains("Horror Movies")).limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for the Process to complete is " + (endTime - startTime) + "ms");
    }

    public static void filterIndianMovie(List<Movie> movie, int n, Date startDate, Date endDate)
    {
        long startTime = System.currentTimeMillis();
        movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getType().equals("Movie") && m.getCountry().contains("India"))
                .limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for the Process to complete is " + (endTime - startTime) + "ms");
    }
}
