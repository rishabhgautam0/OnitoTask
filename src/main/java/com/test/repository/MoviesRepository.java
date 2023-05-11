package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.test.dto.GenreMoviesWithSubtotals;
import com.test.dto.MovieDto;
import com.test.dto.TopRatedMoviesDto;
import com.test.entity.Movies;


public interface MoviesRepository extends JpaRepository<Movies, String>{
	
	boolean existsByTconst(String tconst);
	
	@Query("select new com.test.dto.MovieDto(m.tconst, m.primaryTitle, m.runtimeMinutes, m.genres) from Movies m ORDER BY m.runtimeMinutes DESC LIMIT 10")
	List<MovieDto> findLongestDurationMovies();
	
	@Query("select new com.test.dto.TopRatedMoviesDto(m.tconst, m.primaryTitle, m.genres, r.averageRating) FROM Movies m JOIN m.ratings r WHERE r.averageRating > 6.0 ORDER BY r.averageRating DESC")
	List<TopRatedMoviesDto> findTopRatedMovies();
	
	@Query("select new com.test.dto.GenreMoviesWithSubtotals(m.genres, m.primaryTitle, r.numVotes, SUM(r.numVotes)) FROM Movies m JOIN m.ratings r GROUP BY m.genres")
	List<GenreMoviesWithSubtotals> findGenreMoviesWithSubtotals();
	
	@Modifying
	@Query(value = "update movies m set runtime_minutes = \r\n"
			+ "case \r\n"
			+ "when genres = \"Documentary\" then runtime_minutes + 15\r\n"
			+ "when genres = \"Action\" then runtime_minutes + 30\r\n"
			+ "else runtime_minutes + 45\r\n"
			+ "end ;", nativeQuery = true)
	void updateRuntimeMinutes();
	

}
