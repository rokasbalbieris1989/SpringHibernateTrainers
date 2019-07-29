package com.mycompany.springmvc.service;

import com.mycompany.springmvc.dao.TrainerDao;
import com.mycompany.springmvc.entities.Trainer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("trainerService")
@Transactional
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerDao dao;

    public Trainer findById(int id) {
        return dao.findById(id);
    }

    public void saveTrainer(Trainer trainer) {
        String username = trainer.getLast_name().substring(0, 3) 
                + trainer.getFirst_name().substring(0, 1) 
                + trainer.getDateOfBirth().getYear();
        trainer.setUsername(username);
        dao.saveTrainer(trainer);
    }

    /*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
     */
    public void updateTrainer(Trainer trainer) {
        Trainer entity = dao.findById(trainer.getId());
        if (entity != null) {
            entity.setFirst_name(trainer.getFirst_name());
            entity.setLast_name(trainer.getLast_name());
            entity.setDateOfBirth(trainer.getDateOfBirth());
            entity.setSubject(trainer.getSubject());
            String username = trainer.getLast_name().substring(0, 3) + trainer.getFirst_name().substring(0, 1) + trainer.getDateOfBirth().getYear();
            entity.setUsername(username);
        }
    }

    public void deleteTrainerById(int id) {
        dao.deleteTrainerById(id);
    }

    public List<Trainer> findAllTrainers() {
        return dao.findAllTrainers();
    }

}
