/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class XMLDownloadTask {
    /*
        XMLDownloadtask is a subclass of Swingworker.
        used to download xml data in the background thread.
        "Needs to add the published album objects to the text area
        in the parent class one at a time, and/or add them to an arraylist
        and return the list when the task is complete so that they can be
        displayed all at once
     */
    String url;
    String xmlString; // holds the url string passed to the constructor
    // passed to the constructor
    ArrayList<Album> albumList;

    //default constructor
    public XMLDownloadTask(){
        xmlString = "";
        albumList = new ArrayList<>();
    }

    public String getUrl(){
        return xmlString;
    }

    public void setUrl(String s){
        xmlString = s;
    }
    //string constructor
    public XMLDownloadTask(String url){
        xmlString = url;
        albumList = new ArrayList<>();
        this.doInBackground();
    }
    public void clearAlbumList() {
        albumList.clear();
    }

    public String setURL(String xmlURL) {
        xmlString = xmlURL;
        this.doInBackground();
        return xmlString;
    }

    public void doInBackground(){


        HttpURLConnection connection = null;
        try{
            //create a url object from a String that contains a valid URL
            URL url = new URL(getUrl());
            //open an http connection for the url
            connection = (HttpURLConnection) url.openConnection();

            //set http request method
            connection.setRequestMethod("GET");

            //if the http status code is 200, we have succesfully connected
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                //use a mutable String builder to store the downloaded text
                StringBuilder xmlResponse = new StringBuilder();

                //create a buffered reader to read the lines of xml from the
                // connection's input stream
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );

                // read lines of xml and append them to the string builder
                // object until the end of the stream is reached
                String strLine;
                while((strLine = input.readLine()) != null){
                    xmlResponse.append(strLine);
                }

                //convert the stringbuilder object to a string
                xmlString = xmlResponse.toString();
                AlbumHandler albumHandler = new AlbumHandler(xmlString, this);
                /*
                    do something to process the xml in xmlstring
                 */
                saxParser(xmlString);
                //close the input stream
                input.close();
            }


        }catch (MalformedURLException e) {
            // Handle MalformedURLException
        } catch (IOException e) {
            // Handle IOException
        } catch (Exception e) {
            // Handle any other exceptions thrown by the code that
            // processes xmlString
        } finally {
            // close connection
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    //string xml cointains the xml downloaded from itunes. this method
    // has to store the contents into a album container
    public void saxParser(String xml){
        try{
            //create an instance of the class saxparser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser betterThanSax = factory.newSAXParser(); //( ͡° ͜ʖ ͡°)

            //call the parse method for the parser, passing it the xmlstring and
            // an instance of a subclass of DefaultHandler that you have written
            // to parse the xml
            betterThanSax.parse(new InputSource(new ByteArrayInputStream(
                    xmlString.getBytes("utf-8"))), new AlbumHandler(this));

        } catch (ParserConfigurationException e){
            System.out.println("sax config error");
        } catch (SAXException e){
            System.out.println("sax parser error");
        } catch (UnsupportedEncodingException e){
            System.out.println("unsupported enconding error");
        } catch (IOException e){
            System.out.println("IO error");
        }
    }

    public ArrayList<Album> getAlbumList() {
        return albumList;
    }

    public void printAlbumList(){
        for (Album a : albumList) {
            System.out.println("Album: " + a.getName());
            System.out.println("Artist: " + a.getArtistName());
            System.out.println("Genre: " + a.getGenre() + "\n");
        }
    }

    public static void main(String[] args){
        String testString = "https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/10/explicit.atom\n";
        XMLDownloadTask xml = new XMLDownloadTask(testString);

        xml.printAlbumList();

    }
}
