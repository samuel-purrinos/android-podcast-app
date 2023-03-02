package com.uichesoh.podcast_applicattion;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class LoadData {
    /**
     * Donde se guardan las entradas de la lista.
     */
    public static ArrayList<ItunesResponse.Welcome> PODCAST_ENTRIES = new ArrayList<>();

    /**
     * Donde se asigna el identificador a cada entrada de la lista
     */
    public static Map<String, ItunesResponse.Welcome> PODCAST_ENTRIES_MAP = new HashMap<String, ItunesResponse.Welcome>();

    /**
     * Creamos estáticamente las entradas

    static {
        aniadirEntrada(new Lista_entrada("0", R.drawable.im_buho, "BUHO", "Búho es el nombre común..."));
        aniadirEntrada(new Lista_entrada("1", R.drawable.im_colibri, "COLIBRÍ", "Los troquilinos (Trochilinae) son..."));
        aniadirEntrada(new Lista_entrada("2", R.drawable.im_cuervo, "CUERVO", "El cuervo común (Corvus corax) es ..."));
        aniadirEntrada(new Lista_entrada("3", R.drawable.im_flamenco, "FLAMENCO", "Los fenicopteriformes..."));
        aniadirEntrada(new Lista_entrada("4", R.drawable.im_kiwi, "KIWI", "Los kiwis (Apterix, gr. 'sin alas') son..."));
        aniadirEntrada(new Lista_entrada("5", R.drawable.im_loro, "LORO", "Las Psitácidas (Psittacidae) son..."));
        aniadirEntrada(new Lista_entrada("6", R.drawable.im_pavo, "PAVO", "Pavo es un género de aves..."));
    }
     */
    private static void addEntry(ItunesResponse.Welcome podcastEntry) {
        PODCAST_ENTRIES.add(podcastEntry);
        //PODCAST_ENTRIES_MAP.put(podcastEntry.id, podcastEntry);
    }

    public ItunesResponse.Welcome getPodcasts() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                URL itunesEndpoint = null;
                HttpsURLConnection myConnection = null;
                try {
                    itunesEndpoint = new URL("https://itunes.apple.com/us/rss/toppodcasts/limit=100/genre=1310/json");
                    myConnection = (HttpsURLConnection) itunesEndpoint.openConnection();
                    myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");
                    myConnection.setRequestProperty("Accept", "application/json");
                    myConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    myConnection.setRequestMethod("GET");
                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                        while (jsonReader.hasNext()) { // Loop through all keys¡
                            String key = jsonReader.nextName(); // Fetch the next key
                            if (key.equals("feed")) { // Check if desired key
                                // Fetch the value as a String
                                String value = jsonReader.nextString();
                                System.out.println(value);
                                break; // Break out of the loop
                            } else {
                                jsonReader.skipValue(); // Skip values of other keys
                            }
                        }
                        jsonReader.close();
                    }

                } catch (ProtocolException e) {
                    throw new RuntimeException(e);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (myConnection != null) {
                        myConnection.disconnect();
                    }
                }
            }
        });
        return null;
    }

}
