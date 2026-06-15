package org.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonUtility {

	private static JSONObject getMainObject() throws Exception {

        String path = System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\hotelData.json";

        FileReader reader = new FileReader(path);

        JSONTokener tokener = new JSONTokener(reader);
        JSONObject jsonObject = new JSONObject(tokener);

        reader.close();

        return jsonObject;
    }

    // ---------- Credentials ----------
    public static JSONObject getCredentials() throws Exception {
        return getMainObject().getJSONObject("credentials");
    }

    // ---------- Search Data ----------
    public static JSONArray getSearchHotelData() throws Exception {
        return getMainObject().getJSONArray("searchHotelData");
    }

    // ---------- Booking Data ----------
    public static JSONArray getBookingData() throws Exception {
        return getMainObject().getJSONArray("bookingData");
    }
	
	
}

