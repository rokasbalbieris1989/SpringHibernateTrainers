package com.mycompany.springmvc.service;

import com.mycompany.springmvc.entities.Trainer;
import java.util.List;



public interface TrainerService {

	Trainer findById(int id);
	
	void saveTrainer(Trainer trainer);
	
	void updateTrainer(Trainer trainer);
	
	void deleteTrainerById(int id);

	List<Trainer> findAllTrainers(); 
	
	

	
}
