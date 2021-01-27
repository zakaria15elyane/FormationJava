package org.sid.service;

import java.util.ArrayList;
import java.util.List;

import org.sid.entities.FormationEntity;
import org.sid.repository.FormationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormationService implements IFormationService {
	
	private static  Logger logger = LoggerFactory.getLogger(FormationService.class);
	
	@Autowired
	private FormationRepository formationRepository;
	
	@Override
	public List<FormationEntity> getAllFormation() {
		List<FormationEntity> formations=new ArrayList<FormationEntity>();
		try {
			formations=formationRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if(logger.isInfoEnabled()) {
			logger.info("[ GET ALL FORMATION FOR ENTITY FormationEntity ]");
		}
		
		return formations;
	}
	@Override
	public FormationEntity getOneFormation(Long idFormation) {
		FormationEntity formations=new FormationEntity();
		try {
			formations=formationRepository.findById(idFormation).get();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if(logger.isInfoEnabled()) {
			logger.info("[ GET One FORMATION FOR ENTITY FormationEntity ]");
		}
		return formations;
	}
	@Override
	public void deleteFormation(Long idFormation) {
		 	
		try {
			formationRepository.deleteById(idFormation);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if(logger.isInfoEnabled()) {
			logger.info("[ DELETE FORMATION FOR ENTITY FormationEntity ]");
		}
		
	}
		
	
	@Override
	public FormationEntity saveFormation(FormationEntity f) {
		FormationEntity formations=null;
		//FormationEntity
		try {
			//if(formationRepository.getFormationByTitre(f.getTitreFormation()) == null) 
			{
				formations=formationRepository.save(f);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if(logger.isInfoEnabled()) {
			logger.info("[ SAVE FORMATION FOR ENTITY FormationEntity ]");
		}
		return formations;
	}
	@Override
	public FormationEntity updateFormation(FormationEntity f) {
		FormationEntity formations=new FormationEntity();
		try {
			formations=formationRepository.save(f);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if(logger.isInfoEnabled()) {
			logger.info("[ UPDATE FORMATION FOR ENTITY FormationEntity ]");
		}
		return formations;
	}
	
	  @Override 
	 public List<FormationEntity> getAllFormationByTitre(String titreFormation) {
	  List<FormationEntity> formations=new ArrayList<FormationEntity>(); 
	  try {
	  formations=formationRepository.getFormationByTitre(titreFormation); } 
	  catch (Exception e) 
	  { 
		  logger.error(e.getMessage()); 
		  }
	  if(logger.isInfoEnabled()) {
	  logger.info("[ GET ALL FORMATION FOR ENTITY FormationEntity ]"); }
	  
	  return formations; 
	  }
	 }
