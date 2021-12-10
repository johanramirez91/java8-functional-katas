package katas;

import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/

public class Kata2 {
    public static List<ImmutableMap<String, Integer>> execute() {

        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .filter(getMoviePredicate())
                .map(getId())
                .collect(Collectors.toList());
    }

    private static Predicate<? super Movie> getMoviePredicate() {
        return movie -> movie.getRating() == 5.0;
    }

    private static Function<Movie, ImmutableMap<String, Integer>> getId() {
        return movie -> ImmutableMap.of("id", movie.getId());
    }
}
