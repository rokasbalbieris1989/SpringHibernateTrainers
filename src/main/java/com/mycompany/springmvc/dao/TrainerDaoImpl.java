package com.mycompany.springmvc.dao;

import com.mycompany.springmvc.entities.Trainer;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



@Repository("trainerDao")
public class TrainerDaoImpl extends AbstractDao<Integer, Trainer> implements TrainerDao {

	public Trainer findById(int id) {
		return getByKey(id);
	}

	public void saveTrainer(Trainer trainer) {
		persist(trainer);
	}

	public void deleteTrainerById(int id) {
		Query query = getSession().createSQLQuery("delete from Trainer where id = :id");
		query.setString("id", ""+id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Trainer> findAllTrainers() {
		Criteria criteria = createEntityCriteria();
		return (List<Trainer>) criteria.list();
	}

	public Trainer findTrainerById(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", ""+id));
		return (Trainer) criteria.uniqueResult();
	}

    
}
