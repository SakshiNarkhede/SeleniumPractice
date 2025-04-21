package ExcelDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class dataDriven {

	public ArrayList<String> getData(String TestCases) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Documents\\datademo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets= workbook.getNumberOfSheets();
		ArrayList<String> a=new ArrayList<String>();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows =sheet.iterator();
				Row firstRow=rows.next();
				Iterator <Cell> ce=firstRow.cellIterator();
				int k=0;
				int column =0;
				while(ce.hasNext()) {
					if(ce.next().getStringCellValue().equalsIgnoreCase("TestCases")){
						column=k;
					}
					k++;
				}
				while(rows.hasNext()) {
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("TestCases")) {
					Iterator <Cell> cv=r.cellIterator();
					while(cv.hasNext()) {
						 Cell c=cv.next();
						 if(c.getCellType()==CellType.STRING) {
						a.add(c.getStringCellValue());
					}
						 else {
							// a.NumberToTextConverter.toText(c.getNumericCellValue());
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						 }
					}
				}
				}
			}
		}
		return a;
	}
 	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
 		dataDriven d = new dataDriven();
 		ArrayList data = d.getData("Add Profile");
 		System.out.println(data.get(0));
 		System.out.println(data.get(1));
	}

}
