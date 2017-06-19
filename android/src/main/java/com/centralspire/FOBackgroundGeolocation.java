package com.centralspire;

import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSCallback;
import org.json.JSONObject;
import org.json.JSONArray;

public class FOBackgroundGeolocation {
  static public configureGeolocation(BackgroundGeolocation adapter, JSONObject config) {
    TSCallback callback = new TSCallBack(); // empty callback
    if (config.hasKey("config")) {
      adapter.setConfig(config.getJSONObject("config"), callback);
    }
    if (config.hasKey("stop")) {
      adapter.stop(callback);
    }
    if (config.hasKey("start")) {
      adapter.start(callback);
    }
    if (config.hasKey("geofences")) {
      adapter.removeGeofences(new JSONArray(), callback)
      adapter.addGeofences(config.getJSONArray("geofences"), callback)
    }
    if (config.hasKey("startGeofences")) {
      adapter.stop(callback);
      adapter.startGeofences(callback);
    }
  }
}
