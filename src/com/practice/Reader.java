package com.practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Reader {

    public static List<Movie> ParseCSVandRead() throws FileNotFoundException, IOException, ParseException {
        String fileToParse = "G:\\Hashedin\\src\\com\\practice\\netflix_titles.csv";
        BufferedReader fileReader = null;


        //Delimiter used in CSV file
        final String DELIMITER = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        List<Movie> MovieList = new ArrayList<>();


            String line = "";
            fileReader = new BufferedReader(new FileReader(fileToParse));
            int count = 0;
            //Read the file line by line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                line.trim();
                String[] tokens = line.split(DELIMITER);
                if(count == 0)
                {
                    count++;
                    continue;
                }
                String show_id = tokens[0];
                String type = tokens[1];
                String title = tokens[2];
                Set<String> director = new HashSet<>(Arrays.asList(tokens[3].split(",")));
                Set<String> cast = new HashSet<>(Arrays.asList(tokens[4].split(",")));
                Set<String> country = new HashSet<>(Arrays.asList(tokens[5].split(",")));
                String release_year = tokens[7];
                String rating = tokens[8];
                String duration = tokens[9];
                Set<String> listed_in = new HashSet<>(Arrays.asList(tokens[10].split(",")));
                String description = tokens[11];
                //System.out.println("id is = " + tokens[0]);
                DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                Date date;
                date = !tokens[6].isEmpty() ? format.parse(tokens[6].replaceAll("\"","").trim()) : null;

                Movie movie = new Movie(show_id, type, title, director, cast, country,
                        date,release_year,rating, duration, listed_in,description);
                MovieList.add(movie);


            }
        return MovieList;
    }

}
