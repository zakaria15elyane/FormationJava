package org.sid.repository;

import java.util.List;

import org.sid.entities.FormationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<FormationEntity,Long>{
	
	/**
	 * get all formation by titre
	 * @param titre
	 * @return
	 */
	
	  @Query("SELECT f FROM FormationEntity f WHERE f.titreFormation = :titreFormation")
	  List<FormationEntity> getFormationByTitre(@Param("titreFormation") String titreFormation);
	 
}
