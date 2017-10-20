package com.centralspire;

import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.callback.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
public class FOBackgroundGeolocation {
  static public void configureGeolocation(BackgroundGeolocation adapter, JSONObject config) {
    try {
      TSCallback callback = new TSCallback() {
        public void onSuccess() {
        }
        public void onFailure(String error) {
        }
      }; // empty callback
      if (config.has("config")) {
        adapter.setConfig(config.getJSONObject("config"), callback);
      }
      if (config.has("stop")) {
        adapter.stop(callback);
      }
      if (config.has("start")) {
        adapter.start(callback);
      }
      if (config.has("geofences")) {
        List<String> identifiers = new ArrayList<>();
        adapter.removeGeofences(identifiers, callback);
        adapter.addGeofences(config.getJSONArray("geofences"), callback);
      }
      if (config.has("startGeofences")) {
        adapter.stop(callback);
        adapter.startGeofences(callback);
      }
    } catch (JSONException e) {
    }
  }
}
