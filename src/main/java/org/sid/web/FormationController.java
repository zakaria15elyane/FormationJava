package org.sid.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.sid.configuration.ConstantsConfig;
import org.sid.dto.FormationDto;
import org.sid.entities.FormationEntity;
import org.sid.repository.FormationRepository;
import org.sid.response.FormationResponse;

import org.sid.service.ExportPdf;
import org.sid.service.FormationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v0")
public class FormationController {
	private static Logger logger = LoggerFactory.getLogger(FormationController.class);
	@Autowired
	private FormationService formationService;
	//@Autowired
	//private ExportFormationService exportFormationService;
	
	  @Autowired private FormationRepository formationRepository;
	 

	/**
	 * 
	 * @return listFormation
	 */
	@GetMapping(value = "/formations/titre", headers = ConstantsConfig.HEADERS)

	public FormationResponse getAllFormation() {
		if (logger.isInfoEnabled()) {

			logger.info("[ INFO - FormationController - get all formation ]");

		}
		return new FormationResponse(FormationDto.entitiesToDtos(formationService.getAllFormation()), HttpStatus.OK);
	}
	@GetMapping(value = "/exportpdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {

		List<FormationEntity> allEmployees = formationRepository.findAll();

		ByteArrayInputStream bis = ExportPdf.employeesReport(allEmployees);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "attachment;filename=formations.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	


	/**
	 * 
	 * @param id
	 * @return deleteFormations
	 */
	@DeleteMapping(value = "/formations/{id}", headers = ConstantsConfig.HEADERS)
	public FormationResponse deleteFormation(@PathVariable Long id) {
		if (logger.isInfoEnabled()) {
			logger.info("[ INFO - Formation Controller - delete formation ]");
		}

		formationService.deleteFormation((id));
		return new FormationResponse(id, HttpStatus.OK);
	}

	/**
	 * 
	 * @param formationDto
	 * @return addFormation
	 */
	@PostMapping(value = "/formations", headers = ConstantsConfig.HEADERS)
	public FormationResponse saveFormation(@RequestBody FormationDto formationDto) {
		if (logger.isInfoEnabled()) {
			logger.info("[ INFO - Formation Controller - save formation ]");
		}
		/*FormationResponse formationResponse=null;
		FormationEntity formationResponse2=formationService.saveFormation(FormationDto.dtoToEntity(formationDto));
		if (formationResponse2!=null) {
			formationResponse=new FormationResponse(FormationDto.entityToDto(formationResponse2),HttpStatus.OK);
		}else {
			formationResponse=new FormationResponse(null,HttpStatus.BAD_REQUEST);
		}return formationResponse;*/
		return new FormationResponse(
				FormationDto.entityToDto(formationService.saveFormation(FormationDto.dtoToEntity(formationDto))),
				HttpStatus.OK);
	}

	/**
	 * 
	 * @param formationDto
	 * @return updateFormation
	 */

	@PutMapping(value = "/formations/{idFormation}", headers = ConstantsConfig.HEADERS)
	public FormationResponse updateFormation(@PathVariable("idFormation") Long idFormation, @RequestBody FormationDto formationDto) {
		if (logger.isInfoEnabled()) {
			logger.info("[ INFO - Formation Controller - update formation ]");
		}
		formationDto.setIdFormation(idFormation);
		return new FormationResponse(
				FormationDto.entityToDto(formationService.updateFormation(FormationDto.dtoToEntity(formationDto))),
				HttpStatus.OK);

	}
	/**
	 * 
	 * @param id
	 * @return getFormationById
	 */
	@GetMapping(value = "/formations/{id}", headers = ConstantsConfig.HEADERS)
	public FormationResponse getFormationById(@PathVariable Long id) {
		if (logger.isInfoEnabled()) {
			logger.info("[ INFO - Formation Controller - get formation by id ]");
		}
		return new FormationResponse(FormationDto.entityToDto(formationService.getOneFormation(id)), HttpStatus.OK);
	}
	/**
	 * 
	 * @return listFormation
	 */
	  @GetMapping(value = "/formations/titre/{titreFormation}", headers = ConstantsConfig.HEADERS)
	  public FormationResponse getAllFormationByTitre(@PathVariable("titreFormation") String titreFormation) {
		  if (logger.isInfoEnabled()) {
				logger.info("[ INFO - Formation Controller - get formation by titre ]");
			}
		  return new FormationResponse(FormationDto.entitiesToDtos(formationService.getAllFormationByTitre(titreFormation)), HttpStatus.OK); }
	  	
	  
}

	


