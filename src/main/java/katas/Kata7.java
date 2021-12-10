package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movie -> movie.getVideos()
                        .stream().map(video -> {
                            return ImmutableMap.of(
                                    "id", video.getId(),
                                    "title", video.getTitle(),
                                    "boxart", video.getBoxarts().stream().filter(el -> el.getWidth() > 150).findFirst().orElse(null).getUrl());
                        })).collect(Collectors.toList());
    }
}
