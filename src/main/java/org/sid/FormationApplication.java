package org.sid;

import java.util.Date;

import org.sid.entities.FormationEntity;
import org.sid.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class FormationApplication implements CommandLineRunner {
	@Autowired
	private FormationRepository formationRepository;
	
	/*
	 * @Value("${formation.provider.url}") private String url;
	 */
	public static void main(String[] args) {
		SpringApplication.run(FormationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		 	
		formationRepository
				.save(new FormationEntity(null, "Angular", "Formation en Angular", "300DH", new Date(), new Date()));
		formationRepository
				.save(new FormationEntity(null, "node js", "Formation en node js", "200DH", new Date(), new Date()));
		formationRepository
				.save(new FormationEntity(null, ".net core", "Formation en c#", "300DH", new Date(), new Date()));
		formationRepository.save(
				new FormationEntity(null, "javascript", "Formation en javascript", "200DH", new Date(), new Date()));
		formationRepository
				.save(new FormationEntity(null, "java", "Formation en java", "300DH", new Date(), new Date()));
		formationRepository
				.save(new FormationEntity(null, "React", "Formation en React", "200DH", new Date(), new Date()));
		formationRepository
				.save(new FormationEntity(null, "Angular", "Formation en Angular", "300DH", new Date(), new Date()));
		formationRepository
				.save(new FormationEntity(null, "React", "Formation en React", "200DH", new Date(), new Date()));
		formationRepository
				.save(new FormationEntity(null, "Angular", "Formation en Angular", "300DH", new Date(), new Date()));
			 
	
		  
	formationRepository.findAll().forEach(f->{
		System.out.println(f.toString());
	});
	}

}
