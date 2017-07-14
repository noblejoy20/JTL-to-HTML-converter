/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bank;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

public class XMLRep{
    static int tot,fail;
    static double per;
    static String sent;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //XMLReport ob=new XMLReport();
        try
        {
            String fileName = args[0];
        //File inputFile = new File("C:\\Users\\HP\\Documents\\New folder\\OracleBanking\\src\\main\\java\\com\\example\\bank\\busTicketing.jtl");
        File inputFile = new File(fileName);
        PrintWriter writer = new PrintWriter(args[0]+"failures.txt", "UTF-8");
        PrintWriter write = new PrintWriter(args[0]+"totaltest.txt", "UTF-8");
        PrintWriter writ = new PrintWriter(args[0]+"output.html", "UTF-8");
        
        
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
                       
			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			Document dom = db.parse(inputFile);
                        dom.getDocumentElement().normalize();
                        NodeList x = dom.getElementsByTagName("httpSample");
                        Element n=(Element)x.item(0);
                        NamedNodeMap y = n.getAttributes();
                        Node attr = y.item(10);
                        String val=attr.getNodeValue();
           
                        char[] ch= new char[40];
                        val.getChars(0, 30, ch, 0);
                        String v= String.copyValueOf(ch);
                        System.out.println("Module Name : " + v);
                        //System.out.println(v);
                        int count=1,c=1;
                        int no=x.getLength();
                        System.out.println("Total of tests : " + no);
                        int countfail=0;
                        //NodeList as = dom.getElementsByTagName("assertionResult");
                        System.out.println("The following test cases are failed:-");
                        for(int temp = 0; temp < x.getLength(); temp++)
                        {
                            Node as = x.item(temp);
                            Element firstLevel = (Element)as;
                            NodeList value1Nodes = (firstLevel).getElementsByTagName("assertionResult");
                            int length = value1Nodes.getLength();
                            NamedNodeMap tota = as.getAttributes();
                             Node at=tota.item(2);
                             write.print(c++ +". "+"TEST "+temp+":  ");
                             write.println(at.getNodeValue());
                         for(int tem = 0; tem < length; tem++)
                         {
                             Node nNode = value1Nodes.item(tem);
                             
                             //NodeList h= nNode.getChildNodes();
                             Element ni=(Element)nNode;
                             String bin= ni.getElementsByTagName("failure").item(0).getTextContent();
                             
                             

                             if(bin.equals("true"))
                             {
                                 countfail++;
                                 NamedNodeMap nf = as.getAttributes();
                                 Node att = nf.item(2);
                                 String va=att.getNodeValue();
                                 System.out.print("TEST "+temp+":  ");
                                 System.out.println(va);
                                 
                                 writer.print(count++ +". "+"TEST "+temp+":  ");
                                 writer.println(va);
                                 break;
                             }
                             
                         }
                         
                        }
                        writer.close();
                        write.close();
                        System.out.println("The total no of failures: ="+ countfail);
                        double success=no-countfail;
                        double percent=(success*100)/110;
                        double roundOff = (double) Math.round(percent * 100) / 100;
                        System.out.println("The total no of success: ="+ success);
                        System.out.println("Success Percent="+ roundOff +"%");
                        sent=v;
                        tot=no;
                        fail=countfail;
                        per=roundOff;
                        ListToHtmlTransformer renderer = new ListToHtmlTransformer();
                        String renderedHtml = renderer.render();

                        System.out.println( "The following HTML was rendered: " + new java.util.Date().toString() );
                        System.out.println( renderedHtml );
                        System.out.println( "*** End of HTML ***" );
                        writ.print(renderedHtml);
                        writ.close();
                            
                        


		}catch (IOException e1) 
                {
			
                }catch(ParserConfigurationException e2)
		{

		}catch(SAXException e3)
		{
		
		}
                }catch(IOException e)
                {
                    
                  System.out.println("File Not Found");
                }
    }

    

    
    }
    
