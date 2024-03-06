package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getdata() throws IOException
	{
		String path="I:\\OpenCart_Automation\\OpenCart\\testData\\LogintestData.xlsx ";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcells=xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[totalrows][totalcells];// creating two dimensional array with excel size
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcells;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
		
		
		
	}

}
