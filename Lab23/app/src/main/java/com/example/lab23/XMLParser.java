package com.example.lab23;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    public String getXmlFromUrl(String urlString) {
        StringBuilder xml = new StringBuilder();
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream in = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                xml.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) try { reader.close(); } catch (IOException ignored) {}
            if (connection != null) connection.disconnect();
        }
        return xml.toString();
    }

    public ArrayList<News> parseXML(String url) {
        List<News> mylist = new ArrayList<>();
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            String xml = getXmlFromUrl(url); // getting XML from URL
            Log.d("XML", xml);
            parser.setInput(new StringReader(xml));
            int eventType = parser.getEventType();
            News currentItem = null;

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("item".equals(tagName)) {
                            currentItem = new News();
                        } else if (currentItem != null) {
                            if ("title".equals(tagName)) {
                                currentItem.setTitle(parser.nextText());
                            } else if ("description".equals(tagName)) {
                                currentItem.setDescription(parser.nextText());
                            } else if ("link".equals(tagName)) {
                                currentItem.setUrl(parser.nextText());
                            } else if ("enclosure".equals(tagName)) {
                                String imgUrl = parser.getAttributeValue(null, "url");
                                currentItem.setImage(loadImage(imgUrl)); // Load as Bitmap
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if ("item".equals(tagName) && currentItem != null) {
                            mylist.add(currentItem);
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return (ArrayList<News>) mylist;
    }

    private Bitmap loadImage(String imgUrl) {
        try {
            URL url = new URL(imgUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            Log.e("MainActivity", "Error loading image: " + imgUrl, e);
            return null; // Return null if image loading fails
        }
    }
}