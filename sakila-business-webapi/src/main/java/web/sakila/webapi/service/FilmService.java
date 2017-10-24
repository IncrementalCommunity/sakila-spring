package web.sakila.webapi.service;

import java.util.List;

import web.sakila.webapi.model.FilmWO;

public interface FilmService {
	FilmWO findById(int id);

	void saveFilm(FilmWO filmWO);

	void updateFilm(FilmWO filmWO);

	void deleteFilmById(int id);

	List<FilmWO> findAllFilms();

}