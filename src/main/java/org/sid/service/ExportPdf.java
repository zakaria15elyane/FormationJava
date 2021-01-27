package org.sid.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.sid.entities.FormationEntity;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportPdf {

	public static ByteArrayInputStream employeesReport(List<FormationEntity> formationEntities) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(110);
			table.setWidths(new int[] { 4, 4, 4 ,4 ,4,4});

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Id", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Titre", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Description", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Prix", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			
			
			  hcell = new PdfPCell(new Phrase("Date de début", headFont));
			  hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
			  
			  hcell = new PdfPCell(new Phrase("Date de fin", headFont));
			  hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
			 
			for (FormationEntity formationEntity  :formationEntities ) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(String.valueOf(formationEntity.getIdFormation())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(formationEntity.getTitreFormation()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(formationEntity.getDescription()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(formationEntity.getPrix()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				
				  cell = new PdfPCell(new Phrase(String.valueOf(formationEntity.getDateDebut())));
				  cell.setPaddingLeft(5); cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase(String.valueOf(formationEntity.getDateFin())));
				  cell.setPaddingLeft(5); cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(cell);
				 
				 
			}

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);

			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}