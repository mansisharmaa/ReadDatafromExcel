package com.example.demo.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Bins;

public class Binshelper {
	
	
	//check that files is of excel type or not
	public static boolean checkExcelFormate(MultipartFile file) 
	{
	    String contentType=	file.getContentType();
	    
	    if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) 
	    {
	    	return true;
	    }
	    else 
	    {
	    	return false;
	    }
	}
	
	
	//convert excel to list of Bins
	@SuppressWarnings("resource")
	public static List<Bins> convertExcelToListOfBins(InputStream is)
	{
	List<Bins> list=new ArrayList<>();
	try
	{
		
		XSSFWorkbook workbook=new XSSFWorkbook(is);
		
		XSSFSheet data=workbook.getSheet("Sheet1");
		
		int rowNumber=0;
		Iterator<Row> iterator =data.iterator();
		
		while(iterator.hasNext()) 
		{
			Row row=iterator.next();
			
			if(rowNumber==0) 
			{
				rowNumber++;
				continue;
			}
			
			Iterator<Cell> cells=row.iterator();
			
			int cid=0;
			Bins b=new Bins();
			
			while(cells.hasNext()) 
			{
				Cell cell=cells.next();
				
				switch (cid) 
				{
				case 0:
					b.setId(cell.getNumericCellValue());
				    break;
				case 1:
					b.setBar_code(cell.getNumericCellValue());
				    break;
				case 2:
					b.setWeight_capacity(cell.getNumericCellValue());
				    break;
				case 3:
					b.setHeight(cell.getNumericCellValue());
			        break;	
				case 4:
					b.setLength(cell.getNumericCellValue());
				    break;
				case 5:
					b.setWidth(cell.getNumericCellValue());
				default:
					break;
					
				}
				cid++;
			}
			list.add(b);
		}	
		
	}catch(Exception e) 
	{
	 e.printStackTrace();	
	}
	
	return list;
	}
	

}
