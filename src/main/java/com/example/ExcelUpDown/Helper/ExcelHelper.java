package com.example.ExcelUpDown.Helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.ExcelUpDown.Entity.Product;
import com.example.newEntity.Productexcel;

public class ExcelHelper {

	public static boolean checkExcelFormat(MultipartFile file) {

		// check that file type is excel or not
		System.out.println("inside the excel check format method");
		String ContentType = file.getContentType();
		System.out.println(ContentType);
		if(ContentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}

	// convert excelFile to list of product
	public static List<Productexcel> convertExcelToListOfProduct(InputStream is) {
		List<Productexcel> list = new ArrayList<>();

		try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {

			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();

				int cid = 0;
				Productexcel p = new Productexcel();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					switch (cid) {
					case 0:
						p.setProductId((int) cell.getNumericCellValue());
						break;
					case 1:
						p.setProductName(cell.getStringCellValue());
						break;

					case 2:
						p.setProductDesc(cell.getStringCellValue());
						break;
					case 3:
						p.setProductPrice((int) cell.getNumericCellValue());
						break;

					default:
						break;
					}
					cid++;
				}
				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

}
