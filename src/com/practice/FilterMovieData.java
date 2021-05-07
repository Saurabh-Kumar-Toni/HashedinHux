package com.practice;

import java.util.Date;
import java.util.List;

public class FilterMovieData {

    public static void filterByTypeTvShow(List<Movie> movie, int n, Date startDate, Date endDate)
    {
        movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getType().equals("TV Show")).limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
    }

    public static void findListedHorrorMovie(List<Movie> movie, int n, Date startDate, Date endDate)
    {
        movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getListed_in().contains("Horror Movies")).limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
    }

    public static void filterIndianMovie(List<Movie> movie, int n, Date startDate, Date endDate)
    {
        movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getType().equals("Movie") && m.getCountry().contains("India"))
                .limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
    }
}
