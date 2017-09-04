package com.myapp.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonUtil implements CommonUtils {

	@Override
	public JSONObject parseStringToJson(String jsonString) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject(jsonString);
		System.out.println("Parse: "+ json);
		return json;
	}

	public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
		Map<String, Object> retMap = new HashMap<String, Object>();

		if (json != JSONObject.NULL) {
			retMap = toMap(json);
		}
		return retMap;
	}

	public static Map<String, Object> toMap(JSONObject object) throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();

		Iterator<String> keysItr = object.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);

			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			map.put(key, value);
		}
		return map;
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			list.add(value);
		}
		return list;
	}
	
	public static JSONObject getElement(JSONObject obj, String keyToFind, String oldValue, String newValue) throws Exception {
	    // We need to know keys of Jsonobject
	    Iterator<?> iterator = obj.keys();
	    String key = null;
	    while (iterator.hasNext()) {
	        key = (String) iterator.next();
	        // if object is just string we change value in key
	        if ((obj.optJSONArray(key)==null) && (obj.optJSONObject(key)==null)) {
	            if ((key.equals(keyToFind)) && (obj.get(key).toString().equals(oldValue))) {
	                // put new value
	                obj.put(key, newValue);
	                return obj;
	            }
	        }

	        // if it's jsonobject
	        if (obj.optJSONObject(key) != null) {
	            getElement(obj.getJSONObject(key), keyToFind, oldValue, newValue);
	        }

	        // if it's jsonarray
	        if (obj.optJSONArray(key) != null) {
	            JSONArray jArray = obj.getJSONArray(key);
	            for (int i=0;i<jArray.length();i++) {
	                    getElement(jArray.getJSONObject(i), keyToFind, oldValue, newValue);
	            }
	        }
	    }
	    return obj;
	}
}
