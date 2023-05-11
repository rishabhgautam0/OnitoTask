package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dto.GenreMoviesWithSubtotals;
import com.test.dto.MovieDto;
import com.test.dto.TopRatedMoviesDto;
import com.test.entity.Movies;
import com.test.exception.IdAlreadyExist;
import com.test.repository.MoviesRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MoviesRepository movieRep;
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public List<MovieDto> topTenLongestDurationMovies() {
		List<MovieDto> movieList = movieRep.findLongestDurationMovies();
		return movieList;
	}

	@Override
	public String addMovie(Movies mov) {
		
		if(movieRep.existsByTconst(mov.getTconst())) {
			throw new IdAlreadyExist("tconst id already exists!");
		}
		movieRep.save(mov);
		return "success";
	}

	@Override
	public List<Movies> findAllMovies() {
		List<Movies> movieList = movieRep.findAll();
		return movieList;
	}

	@Override
	public List<TopRatedMoviesDto> topRatedMovies() {
		List<TopRatedMoviesDto> movieList = movieRep.findTopRatedMovies();
		return movieList;
	}

	@Override
	public List<GenreMoviesWithSubtotals> genreMoviesWithSubtotals() {
		List<GenreMoviesWithSubtotals> movieList = movieRep.findGenreMoviesWithSubtotals();
		return movieList;
	}
	
	public String changeRuntimeMinutes() {
		movieRep.updateRuntimeMinutes();
		return "Success!";
		
	}

}
