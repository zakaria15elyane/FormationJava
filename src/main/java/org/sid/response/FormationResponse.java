package org.sid.response;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
public class FormationResponse extends org.springframework.http.ResponseEntity<Object>{

	public FormationResponse() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	public FormationResponse(HttpStatus status) {
		super(status);
		// TODO Auto-generated constructor stub
	}


	public FormationResponse(Object object, HttpStatus status) {
		super(object, status);
		// TODO Auto-generated constructor stub
	}

}
