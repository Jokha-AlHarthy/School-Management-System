package utils;

public class HelperUtils {
    //empty checks: for text, and for a collection
    public static boolean isEmpty(String text){
        return text == null || text.trim().isEmpty();
    }

    public static boolean isEmptyCollection(Object[]items, int count){
        return items == null || count==0;
    }

    //valid-text checks: text alone / text with a minimum length / text with a min and max length
    public static boolean isValidText(String text){
        return !isEmpty(text);
    }

    public static boolean isValidText(String text, int min){
        return !isEmpty(text) && text.trim().length() >= min;
    }

    public static boolean isValidText(String text, int min, int max){
        return !isEmpty(text) && text.trim().length() >= min && text.trim().length() <= max;
    }
}
