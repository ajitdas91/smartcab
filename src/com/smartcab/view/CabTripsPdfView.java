package com.smartcab.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.smartcab.command.TripCommand;

public class CabTripsPdfView extends AbstractPdfView {

	private final String[] header = new String[] { "Cab Id", "Source",
			"Destination" };

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter pdfWriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<TripCommand> trips = null;

		trips = (List<TripCommand>) model.get("trips");

		Table table = new Table(3);
		// add header row
		for (String h : header) {
			table.addCell(h);
		}

		// add data rows
		for (TripCommand trip : trips) {
			table.addCell(String.valueOf(trip.getCabId()));
			table.addCell(trip.getSource());
			table.addCell(trip.getDest());
		}
		document.add(table);
	}

}
