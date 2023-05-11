package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Movies;
import com.test.service.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
	
	@Autowired
	private MovieService movService;
	
	@GetMapping("/movies")
	public ResponseEntity<?> findAllMovies(){
		return new ResponseEntity<>(movService.findAllMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/longest-duration-movies")
	public ResponseEntity<?> getLongestMoviesList(){
		
		return new ResponseEntity<>(movService.topTenLongestDurationMovies(), HttpStatus.OK);
	}
	
	@PostMapping("/new-movie")
	public ResponseEntity<?> addMovie(@RequestBody Movies mov){
		
		return new ResponseEntity<>(movService.addMovie(mov), HttpStatus.CREATED);
	}
	
	@GetMapping("/top-rated-movies")
	public ResponseEntity<?> getTopRatedMoviesList(){
		
		return new ResponseEntity<>(movService.topRatedMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/genre-movies-with-subtotals")
	public ResponseEntity<?> getgenreMoviesWithSubtotals(){
		
		return new ResponseEntity<>(movService.genreMoviesWithSubtotals(), HttpStatus.OK);
	}
	
	@PostMapping("/update-runtime-minutes")
	public ResponseEntity<?> increaseRuntimeMinutes(){
		
		return new ResponseEntity<>(movService.changeRuntimeMinutes(), HttpStatus.OK);
	}

}
