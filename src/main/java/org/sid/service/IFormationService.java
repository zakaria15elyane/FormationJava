package org.sid.service;

import java.util.List;

import org.sid.entities.FormationEntity;

public interface IFormationService {
	
	public List<FormationEntity> getAllFormation();
	public FormationEntity getOneFormation(Long id);
	public void deleteFormation(Long id);
	public FormationEntity saveFormation(FormationEntity f);
	public FormationEntity updateFormation(FormationEntity f);
	
	public List<FormationEntity> getAllFormationByTitre(String titreFormation);
}
