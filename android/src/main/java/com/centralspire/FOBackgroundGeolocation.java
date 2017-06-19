package com.centralspire;

import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSCallback;
import org.json.JSONObject;
import org.json.JSONArray;

public class FOBackgroundGeolocation {
  static public configureGeolocation(BackgroundGeolocation adapter, JSONObject config) {
    TSCallback callback = new TSCallback(); // empty callback
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
      adapter.removeGeofences(new JSONArray(), callback);
      adapter.addGeofences(config.getJSONArray("geofences"), callback);
    }
    if (config.has("startGeofences")) {
      adapter.stop(callback);
      adapter.startGeofences(callback);
    }
  }
}
