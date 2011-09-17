package com.habuma.spitter.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

@Component("spitterDao")
public class SpitterDaoImpl implements SpitterDao {

	@Override
	public void addSpitter(Spitter spitter) {


	}

	@Override
	public void saveSpitter(Spitter spitter) {
		// TODO Auto-generated method stub

	}

	@Override
	public Spitter getSpitterById(long id) {
		return new Spitter("gvpinto", "password", "Glenn Pinto", "gvpinto@gmail.com", true);
	}

	@Override
	public List<Spittle> getRecentSpittle() {
		
		List<Spittle> spittles = new ArrayList<Spittle>();
		Spitter spitter = new Spitter("gvpinto", "password", "Glenn Pinto", "gvpinto@gmail.com", true);
		
		for (int i = 0; i < 40; i++) {
			spittles.add(new Spittle("Spittle[" + i + "]", new Date(), spitter));
		}
		
		return spittles;

	}

	@Override
	public void saveSpittle(Spittle spittle) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spitter getSpitterByUsername(String username) {
		// TODO Auto-generated method stub
		return new Spitter(username, "password", username + " Pinto", username + "@gmail.com", true);
	}

	@Override
	public void deleteSpittle(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Spittle getSpittleById(long id) {
		Spitter spitter = new Spitter("gvpinto", "password", "Glenn Pinto", "gvpinto@gmail.com", true);
		return new Spittle("Spittle[" + id + "]", new Date(), spitter);
	}

	@Override
	public List<Spitter> findAllSpitters() {
		return null;
	}

}
