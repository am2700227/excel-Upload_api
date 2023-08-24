package com.example.ExcelUpDown.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ExcelUpDown.Entity.Product;
import com.example.ExcelUpDown.Helper.ExcelHelper;
import com.example.ExcelUpDown.Service.ExcelService;
import com.example.newEntity.Productexcel;

@RestController
@CrossOrigin("*")
public class ExcelController {

	@Autowired
	private ExcelService excelService;

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		System.out.println("inside the upload method");
		if (ExcelHelper.checkExcelFormat(file)) {
			System.out.println("inside the if of excel upload method");
			// true
			this.excelService.save(file);
			return ResponseEntity.ok(Map.of("message", "file is uploaded and data is saved to db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file");
	}

	@GetMapping("/products")

	public List<Productexcel> getAllProduct() {
		return this.excelService.getAllProduct();

	}
}
