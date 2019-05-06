package generic;

import java.util.HashMap;
import java.util.Map;

public class DataProviderGenerator
{

	
	public static  Object[][] objectGeneratorWithSingleSheet(String xlName,String sheetName)
	{
		
		Object[][] data = null;
		int row=Excel.getRowCount("./TestData/"+xlName+".xlsx",sheetName);
		int cell =Excel.getCellCount("./TestData/"+xlName+".xlsx", sheetName,1);
		
		
		 data= new Object[row-2][1];
		
		for(int i=2;i<row;i++)
		{
			Map<String, String> datamap1  = new HashMap<String, String>();
			
			for(int j=0;j<cell;j++)
			{
	
					datamap1.put(Excel.getCellValue("./TestData/"+xlName+".xlsx", sheetName, 1, j).toString(),Excel.getCellValue("./TestData/"+xlName+".xlsx", sheetName,i, j).toString());	
			}
			data [i-2][0]= datamap1 ;
		}
		
		return data;
	}

	
	public static  Object[][] objectGeneratorWithMultiSheet(String xlName)
    {
                   
		String path="./TestData/"+xlName+".xlsx";
		String sheetName1=Excel.getSheetName(path, 0);
		int row=Excel.getRowCount(path,sheetName1);
		int numberofSheets= Excel.getNumberOfSheets(path);
		      
		
		Object[][]  data= new Object[row-2][1];
                                                                                             
                                                                                                                    
		for(int i=2;i<row;i++)
		{
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for(int j=0;j<numberofSheets;j++)
			{	
				String sheetName=Excel.getSheetName(path, j);
				int cell =Excel.getCellCount(path, sheetName, i);
                            
				for(int k=0;k<cell;k++)
				{
					 
					datamap.put(Excel.getCellValue(path, sheetName, 1, k), Excel.getCellValue(path, sheetName, i, k));
				}
                            			
			}

			data[i-2][0] = datamap;
		}
                    
		return data;
    }
	
}

