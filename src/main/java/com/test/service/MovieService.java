package com.test.service;

import java.util.List;

import com.test.dto.GenreMoviesWithSubtotals;
import com.test.dto.MovieDto;
import com.test.dto.TopRatedMoviesDto;
import com.test.entity.Movies;

public interface MovieService {
	
	List<MovieDto> topTenLongestDurationMovies();
	
	String addMovie(Movies mov);
	
	List<TopRatedMoviesDto> topRatedMovies();
	
	List<GenreMoviesWithSubtotals> genreMoviesWithSubtotals();
	
	String changeRuntimeMinutes();
	
	List<Movies> findAllMovies();
	
	

}
