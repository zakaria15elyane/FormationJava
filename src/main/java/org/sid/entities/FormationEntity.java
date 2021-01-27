package org.sid.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * 
 * FormationEntity.java
 *
 * @author EL AYANE ZAKARIA
 * @see zakaria@gmail.com
 * @date 20 nov. 2020 - 19:25:51
 * @version 1.0
 */
@Entity
@Table(name = "formation")
@Data 
@AllArgsConstructor @NoArgsConstructor
 @ToString
public class FormationEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFormation")
	private Long idFormation;
	@Column(name = "titreFormation")
	private String titreFormation;
	@Column(name = "description")
	private String description;
	@Column(name = "prix")
	private String prix;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut")
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin")
	private Date dateFin;


	

	
}
