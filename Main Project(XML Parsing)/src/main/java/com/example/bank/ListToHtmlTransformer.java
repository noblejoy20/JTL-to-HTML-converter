/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bank;

/**
 *
 * @author HP
 */
public class ListToHtmlTransformer {
    
    public String render() {
        StringBuilder html = new StringBuilder();
        html.append( "<!doctype html>\n" );
        html.append( "<html lang='en'>\n" );

        html.append( "<head>\n" );
        html.append( "<meta charset='utf-8'>\n" );
        html.append("<style>\n");
        html.append("table, th, td {border: 1px solid black;}\n");
        html.append("</style>\n");
        
        html.append( "<title>TEST RESULTS</title>\n" );
        html.append( "</head>\n\n" );

        html.append( "<body>\n" );
        html.append( "<h1>Table of Reports</h1>\n" );
        html.append( "<table style=\"width:100%\">\n");
        html.append(" <tr>\n");
        html.append("  <th>Tests</th>\n" +
                    "  <th>Results</th> \n");
        html.append(" <tr>\n");
        html.append("<tr>\n" +
                    "    <td>Module Name</td>\n" +
                    "    <td>"+XMLRep.sent+"</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td>Total Tests</td>\n" +
                    "    <td>"+"<a href=\"file:///D:/OOPS-IN-JAVA/XML%20Report/totaltest.txt\">"+XMLRep.tot+"</a>"+"</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td>Failures</td>\n" +
                    "    <td>"+"<a href=\"file:///D:/OOPS-IN-JAVA/XML%20Report/failures.txt\">"+XMLRep.fail+"</a>"+"</td>\n" +
                    "  </tr>\n"+
                    "  <tr>\n" +
                    "    <td>Success Rate</td>\n" +
                    "    <td>"+XMLRep.per+"</td>\n" +
                    "  </tr>\n");
        html.append("</table>\n");
        html.append( "</body>\n" );

        html.append( "</html>" );

        return html.toString();
    }

    


    }
    

