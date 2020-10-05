package com.smartcab.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.smartcab.command.TripCommand;

public class CabTripsExcelView extends AbstractExcelView {
	private final String[] header = new String[] { "Cab Id", "Source",
			"Destination" };

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workBook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HSSFSheet tripSheet = null;
		List<TripCommand> trips = null;

		tripSheet = workBook.createSheet("Trip Details");
		trips = (List<TripCommand>) model.get("trips");

		// add header
		HSSFRow headerRow = tripSheet.createRow(0);
		for (int i = 0; i < header.length; i++) {
			HSSFCell cell = headerRow.createCell(i);
			cell.setCellValue(header[i]);
		}

		for (int row = 1; row <= trips.size(); row++) {
			TripCommand trip = trips.get(row - 1);
			HSSFRow dataRow = tripSheet.createRow(row);

			// cab Id data Cell
			HSSFCell cell0 = dataRow.createCell(0);
			cell0.setCellValue(trip.getCabId());

			// Source data Cell
			HSSFCell cell1 = dataRow.createCell(1);
			cell1.setCellValue(trip.getSource());

			// destination data cell
			HSSFCell cell2 = dataRow.createCell(2);
			cell2.setCellValue(trip.getDest());
		}
	}
}
