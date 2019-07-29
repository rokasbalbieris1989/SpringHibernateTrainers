package com.mycompany.springmvc.dao;

import com.mycompany.springmvc.entities.Trainer;
import java.util.List;


public interface TrainerDao {

	Trainer findById(int id);

	void saveTrainer(Trainer tainer);
	
	void deleteTrainerById(int id);
	
	List<Trainer> findAllTrainers();

	

}
