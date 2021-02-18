package com.mrkazofficial.kpreferencelib;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author MRKaZ
 * @since 5:58 PM, 2/17/2021, 2021
 */

public class KPreference {

    private static KPreference instance;
    private static SharedPreferences sharedPreferences;

    public KPreference() {

    }

    public static void Initiate(Context Context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Context);
    }

    public static KPreference getInstance() {
        if (instance == null) {
            ValidateInitialization();
            synchronized (KPreference.class) {
                if (instance == null) {
                    instance = new KPreference();
                }
            }
        }
        return instance;
    }

    public void PutInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int GetInt(String key, int defaultValue) {
        if (IsKeyExists(key)) {
            return sharedPreferences.getInt(key, defaultValue);
        }
        return defaultValue;
    }

    public void PutBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean GetBoolean(String key, boolean defaultValue) {
        if (IsKeyExists(key)) {
            return sharedPreferences.getBoolean(key, defaultValue);
        }
        return defaultValue;
    }


    public void PutFloat(String key, float value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public float GetFloat(String key, float defaultValue) {
        if (IsKeyExists(key)) {
            return sharedPreferences.getFloat(key, defaultValue);
        }
        return defaultValue;
    }


    public void PutLong(String key, long value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public long GetLong(String key, long defaultValue) {
        if (IsKeyExists(key)) {
            return sharedPreferences.getLong(key, defaultValue);
        }
        return defaultValue;
    }


    public void PutString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String GetString(String key, String defaultValue) {
        if (IsKeyExists(key)) {
            return sharedPreferences.getString(key, defaultValue);
        }
        return defaultValue;
    }

    public <T> void PutObject(String key, T object) {
        String objectString = new Gson().toJson(object);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, objectString);
        editor.apply();
    }

    public <T> T GetObject(String key, Class<T> classType) {
        if (IsKeyExists(key)) {
            String objectString = sharedPreferences.getString(key, null);
            if (objectString != null) {
                return new Gson().fromJson(objectString, classType);
            }
        }
        return null;
    }


    public <T> void PutObjectsList(String key, List<T> objectList) {
        String objectString = new Gson().toJson(objectList);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, objectString);
        editor.apply();
    }

    public <T> List<T> GetObjectsList(String key, Class<T> classType) {
        if (IsKeyExists(key)) {
            String objectString = sharedPreferences.getString(key, null);
            if (objectString != null) {

                ArrayList<T> t = new Gson().fromJson(objectString, new TypeToken<List<T>>() {
                }.getType());

                List<T> finalList = new ArrayList<>();

                for (int i = 0; i < t.size(); i++) {
                    String s = String.valueOf(t.get(i));
                    finalList.add(new Gson().fromJson(s, classType));
                }

                return finalList;
            }
        }

        return null;
    }

    public void ClearSession() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public boolean DeleteValue(String key) {
        if (IsKeyExists(key)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(key);
            editor.apply();
            return true;
        }

        return false;
    }

    public boolean IsKeyExists(String key) {
        Map<String, ?> map = sharedPreferences.getAll();
        if (map.containsKey(key)) {
            return true;
        } else {
            Log.e("KPreference", "No element founded in sharedPrefs with the key " + key);
            return false;
        }
    }

    private static void ValidateInitialization() {
        if (sharedPreferences == null)
            throw new KPreferenceException("KPreference Library must be initialized inside your application class by calling KPreference.Initiate(YOUR_CONTEXT)");
    }

}
