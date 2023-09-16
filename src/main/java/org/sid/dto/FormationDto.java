package org.sid.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sid.entities.FormationEntity;
import org.springframework.util.CollectionUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * FormationDto.java
 *
 * @author EL AYANE ZAKARIA
 * @see zakaria@gmail.com
 * @date 21 nov. 2020 - 20:44:18
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FormationDto {

	private Long idFormation;

	private String titreFormation;

	private String description;

	private String prix;

	private Date dateDebut;

	private Date dateFin;

	/**
	 * 
	 * @param formationEntity
	 * @return entityToDto
	 */
	public static FormationDto entityToDto(FormationEntity formationEntity) {
		FormationDto formationDto = new FormationDto();
		if (formationEntity != null) {
			
			
			
			
			formationDto.setIdFormation(formationEntity.getIdFormation());
			formationDto.setTitreFormation(formationEntity.getTitreFormation());
			formationDto.setDescription(formationEntity.getDescription());
			formationDto.setPrix(formationEntity.getPrix());
			formationDto.setDateDebut(formationEntity.getDateDebut());
			formationDto.setDateFin(formationEntity.getDateFin());
		}
		return formationDto;
	}

	/**
	 * 
	 * @param listFormationentity
	 * @return entitiesToDtos
	 */
	public static List<FormationDto> entitiesToDtos(List<FormationEntity> listFormationentity) {
		List<FormationDto> listFormationDto = new ArrayList<>();
		if (!CollectionUtils.isEmpty(listFormationentity)) {
			for (FormationEntity entity : listFormationentity) {
				listFormationDto.add(entityToDto(entity));
				// System.out.println(listFormationDto);
			}
		}
		return listFormationDto;
	}

	/**
	 * 
	 * @param formationDto
	 * @return dtoToEntity
	 */
	public static FormationEntity dtoToEntity(FormationDto formationDto) {
		FormationEntity formationEntity = new FormationEntity();
		if (formationDto != null) {
			formationEntity.setIdFormation(formationDto.getIdFormation());
			formationEntity.setTitreFormation(formationDto.getTitreFormation());
			formationEntity.setDescription(formationDto.getDescription());
			formationEntity.setPrix(formationDto.getPrix());
			formationEntity.setDateDebut(formationDto.getDateDebut());
			formationEntity.setDateFin(formationDto.getDateFin());
		}
		return formationEntity;
	}

	/**
	 * 
	 * @param listFormationDto
	 * @return dtosToEntities
	 */
	public static List<FormationEntity> dtosToEntities(List<FormationDto> listFormationDto) {
		List<FormationEntity> listFormationEntity = new ArrayList<>();
		if (!CollectionUtils.isEmpty(listFormationDto)) {
			for (FormationDto dto : listFormationDto) {
				listFormationEntity.add(dtoToEntity(dto));
			}
		}
		return listFormationEntity;
	}

}
