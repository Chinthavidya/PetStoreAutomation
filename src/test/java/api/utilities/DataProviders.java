package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders{
@DataProvider(name="Data")
public String[][]  data() throws IOException
  {
String path=System.getProperty("user.dir")+"//Testdata//Automation_RestAssured.xlsx";
XLUtility xl=new XLUtility(path);
int rowcount=xl.getRowcount("sheet1");
int colcount=xl.getcellcount("sheet1", 1);
String apidata[][]=new String[rowcount][colcount];
for(int i=1; i<=rowcount; i++)
{
	for(int j=0; j<colcount; j++)
	{
		apidata[i-1][j]=xl.getcelldata("sheet1", i, j);
	}
}
return apidata;
  }
//2.get Usernames

@DataProvider(name="alldata")
public String[] getalldata() throws IOException
{
	String path=System.getProperty("user.dir")+"//Testdata//Automation_RestAssured.xlsx";
	XLUtility xl=new XLUtility(path);
	int rownum=xl.getRowcount("sheet1");
	String apidata[]=new String[rownum];
	for(int i=1; i<=rownum; i++)
	{
		apidata[i-1]=xl.getcelldata("sheet1", i, 2);
	}
	return apidata;
	
}
}