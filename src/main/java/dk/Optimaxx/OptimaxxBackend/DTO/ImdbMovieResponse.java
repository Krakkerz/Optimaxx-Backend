package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.List;

@NoArgsConstructor
@Data
public class ImdbMovieResponse {
    private String id;
    private String title;
    private String originalTitle;
    private String fullTitle;
    private String year;
    private String releaseDate;
    private String runtimeMins;
    private String runtimeStr;
    private String plot;
    private String plotLocal;
    private Boolean plotLocalIsRtl;
    private String awards;
    private String image;
    private String type;
    private String directors;
    private List<StarShort> directorList;
    private String writers;
    private List<StarShort> writerList;
    private String stars;
    private List<StarShort> starList;
    // private List<ActorShort> actorList;
    // private FullCastData fullCast;
    private String genres;
    // private List<KeyValueItem> genreList;
    private String companies;
    private List<CompanyShort> companyList;
    private String countries;
    // private List<KeyValueItem> countryList;
    private String languages;
    // private List<KeyValueItem> languageList;
    private String contentRating;
    private Double imDbRating;
    private String imDbRatingVotes;
    private String metacriticRating;
    private RatingData ratings;
    // private WikipediaData wikipedia;
    // private PosterData posters;
    // private ImageData images;
    private TrailerData trailer;
    private BoxOfficeShort boxOffice;
    private String tagline;
    private String keywords;
    private List<String> keywordList;
    private List<SimilarShort> similars;
    private TvSeriesInfo tvSeriesInfo;
    // private TvEpisodeInfo tvEpisodeInfo;
    private String errorMessage;

    // TODO: Make this converter more complete
    public Movie toMovie() {
        return Movie.builder()
                .id(this.id)
                .title(this.title)
                .picture(this.image)
                .category(this.genres)
                .trailer(this.trailer.linkEmbed)
                .rating(this.imDbRating)
                .duration(this.runtimeStr)//(Duration.ZERO.plusMinutes(Long.parseLong(this.runtimeMins)))
                .plot(this.plot)
                .build();
    }
}

// TODO: Define more custom properties if needed

@NoArgsConstructor
@Data
class PosterDataItem {
    public String id;
    public String link;
    public Double aspectRatio;
    public String language;
    public Integer width;
    public Integer height;
}

@NoArgsConstructor
@Data
class TvSeriesInfo {
    public String yearEnd;
    public String creators;
    public List<StarShort> creatorList;
    public List<String> seasons;
}

@NoArgsConstructor
@Data
class SimilarShort {
    public String id;
    public String title;
    public String image;
    public String imDbRating;
}

@NoArgsConstructor
@Data
class StarShort {
    private String id;
    private String name;
}

@NoArgsConstructor
@Data
class BoxOfficeShort {
    public String budget;
    public String openingWeekendUSA;
    public String grossUSA;
    public String cumulativeWorldwideGross;
}

@NoArgsConstructor
@Data
class CompanyShort {
    public String id;
    public String name;
}

@NoArgsConstructor
@Data
class RatingData {
    public String imDbId;
    public String title;
    public String fullTitle;
    public String type;

    public String year;
    public String imDb;
    public String metacritic;
    public String theMovieDb;
    public String rottenTomatoes;

    public String filmAffinity;
    public String errorMessage;
}

@NoArgsConstructor
@Data
class TrailerData
{
    public String imDbId;
    public String title;
    public String fullTitle;
    public String type;
    public String year ;
    public String videoId;
    public String videoTitle;
    public String videoDescription;
    public String thumbnailUrl;
    public String uploadDate;
    public String link;
    public String linkEmbed ;
    public String errorMessage;
}

