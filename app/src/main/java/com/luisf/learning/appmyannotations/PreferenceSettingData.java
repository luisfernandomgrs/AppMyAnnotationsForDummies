package com.luisf.learning.appmyannotations;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class PreferenceSettingData {
   private Context context;
   private SharedPreferences preferences;
   private SharedPreferences.Editor editor;
   private final String FILE_NAME = "UserPreferenceAppAnnotations";
   private final String KEY_NOTES = "Note_Text";

   public PreferenceSettingData(Context c) {
      this.context = c;
      this.preferences = this.context.getSharedPreferences(this.FILE_NAME, 0);
      this.editor = this.preferences.edit();

      this.readDataPreference();
   }

   public void saveDataPreference(String text) {
      if (!text.trim().isEmpty()) {
         this.editor.putString(KEY_NOTES, text);
         this.editor.commit();
      }
   }

   public String readDataPreference() {
      String readContent = "";

      if (preferences.contains(KEY_NOTES)) {
         readContent = preferences.getString(KEY_NOTES, "");
      }

      return readContent;
   }
}
