package com.example.hello;

import com.example.bank.XMLRep;
import java.io.File;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class testresult 
{
    public static void main( String[] args )
    {
        String s=System.getProperty("user.dir")+"\\target\\jmeter\\results\\";
        File folder = new File(s);
        File[] listOfFiles = folder.listFiles();
        int n=listOfFiles.length;
        String[] myjtl=new String[1];

        for (int i = 0; i < n; i++) {
        File file = listOfFiles[i];
        if (file.isFile()&& file.getName().endsWith(".jtl")) {
        myjtl[0]=s+file.getName();
        System.out.print(Arrays.toString(myjtl));
        XMLRep.main(myjtl);
    /* do somthing with content */
        }
        }
 
      
        
	
    }
}