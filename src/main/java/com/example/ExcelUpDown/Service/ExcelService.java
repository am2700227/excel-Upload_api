package com.example.ExcelUpDown.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ExcelUpDown.Entity.Product;
import com.example.ExcelUpDown.Helper.ExcelHelper;
import com.example.ExcelUpDown.repo.ExcelRepo;
import com.example.newEntity.Productexcel;

@Service
public class ExcelService {

	@Autowired
	private ExcelRepo excelRepo;

	public void save(MultipartFile file) {
		try {
			List<Productexcel> product = ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
			this.excelRepo.saveAll(product);
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Productexcel> getAllProduct() {
		// return this.excelRepo.findAll();
		List<Productexcel> excelTableData = excelRepo.findAll();
		List<Productexcel> result = new ArrayList<>();

		for (Productexcel excelTable : excelTableData) {
			Productexcel Data = new Productexcel();
			Data.setProductId(excelTable.getProductId());
			Data.setProductName(excelTable.getProductName());
			Data.setProductDesc(excelTable.getProductDesc());
			Data.setProductPrice(excelTable.getProductPrice());
			result.add(Data);
		}
		return result;
	}
}
