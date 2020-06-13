package example.converter;

import java.util.HashMap;
import java.util.Map;

public class Converter {
    public static Map<String, Integer> applyTypeMap = new HashMap<String, Integer>() {
        {
            put("Main", 0);
            put("Info", 1);
            put("Area", 2);
            put("Commercial", 3);
            put("Doctor", 4);
            put("Medical", 5);

        }
    };

    public static Map<String, Integer> durationMap = new HashMap<String, Integer>() {
        {
            put("forever", 0);
            put("one-month", 1);
        }
    };

    public static Map<Integer, String> durationReverseMap = new HashMap<Integer, String>() {
        {
            put(0, "forever");
            put(1, "one-month");
        }
    };

    public static Map<String, Integer> colorMap = new HashMap<String, Integer>() {
        {
            put("green", 0);
            put("yellow", 1);
            put("orange", 2);

        }
    };

    public static Map<String, Integer> genderMap = new HashMap<String, Integer>() {
        {
            put("male", 0);
            put("female", 1);
        }
    };

    public static Map<Integer, String> genderReverseMap = new HashMap<Integer, String>() {
        {
            put(0, "male");
            put(1, "female");
        }
    };
}
