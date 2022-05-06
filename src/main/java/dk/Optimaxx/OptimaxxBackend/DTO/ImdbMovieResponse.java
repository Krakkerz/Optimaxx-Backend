package dk.Optimaxx.OptimaxxBackend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    // private List<StarShort> directorList;
    private String writers;
    // private List<StarShort> writerList;
    private String stars;
    // private List<StarShort> starList;
    // private List<ActorShort> actorList;
    // private FullCastData fullCast;
    private String genres;
    // private List<KeyValueItem> genreList;
    private String companies;
    // private List<CompanyShort> companyList;
    private String countries;
    // private List<KeyValueItem> countryList;
    private String languages;
    // private List<KeyValueItem> languageList;
    private String contentRating;
    private String imdbRating;
    private String imdbRatingVotes;
    private String metacriticRating;
    // private RatingData ratings;
    // private WikipediaData wikipedia;
    // private PosterData posters;
    // private ImageData images;
    // private TrailerData trailer;
    // private BoxOfficeShort boxOffice;
    private String tagline;
    private String keywords;
    private List<String> keywordList;
    // private List<SimilarShort> similars;
    // private TvSeriesInfo tvSeriesInfo;
    // private TvEpisodeInfo tvEpisodeInfo;
    private String errorMessage;
}

// TODO: Define more custom properties if needed

//@NoArgsConstructor
//@Data
//class PosterDataItem {
//    public string Id { get; set; }
//    public string Link { get; set; }
//    public double AspectRatio { get; set; }
//    public string Language { get; set; }
//    public int Width { get; set; }
//    public int Height { get; set; }
//}
//
//public class TvSeriesInfo
//{
//    public string YearEnd { set; get; }
//    public string Creators { set; get; }
//    public List<StarShort> CreatorList { get; set; }
//    public List<string> Seasons { get; set; }
//}
//
//public class TvEpisodeInfo
//{
//    public string SeriesId { get; set; }
//    public string SeriesTitle { get; set; }
//    public string SeriesFullTitle { get; set; }
//    public string SeriesYear { get; set; }
//    public string SeriesYearEnd { get; set; }
//
//    public string SeasonNumber { get; set; }
//    public string EpisodeNumber { get; set; }
//
//    public string PreviousEpisodeId { get; set; }
//    public string NextEpisodeId { get; set; }
//}
//
//public class SimilarShort
//{
//    public string Id { get; set; }
//    public string Title { get; set; }
//    public string Image { get; set; }
//    public string IMDbRating { get; set; }
//}
//
//public class StarShort
//{
//    public string Id { get; set; }
//    public string Name { get; set; }
//}
//
//public class BoxOfficeShort
//{
//    public string Budget { get; set; }
//    public string OpeningWeekendUSA { get; set; }
//    public string GrossUSA { get; set; }
//    public string CumulativeWorldwideGross { get; set; }
//}
//
//public class CompanyShort
//{
//    public string Id { get; set; }
//    public string Name { get; set; }
//}
//}
