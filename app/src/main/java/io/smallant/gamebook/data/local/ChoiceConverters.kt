package io.smallant.gamebook.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.smallant.gamebook.data.models.Choice
import java.util.*

class ChoiceConverters {
    companion object {
        private val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun fromString(data: String?): List<Choice> {
            if (data == null) return Collections.emptyList()
            val listType = object : TypeToken<List<Choice>>() {}.type
            return gson.fromJson(data, listType)
        }

        @TypeConverter
        @JvmStatic
        fun toString(someObjects: List<Choice>): String {
            return gson.toJson(someObjects)
        }
    }
}