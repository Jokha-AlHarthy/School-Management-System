package utils;

public class HelperUtils {
    private static int counter = 1000;

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

    //id generation: no prefix / with prefix (simple static counter — no UUID, no regex)
    public static String generateId(){
        counter++;
        return "Id"+counter;
    }

    public static String generateId(String prefix){
        counter++;
        return prefix +counter;
    }

    //positive checks: for a whole number / for a decimal.
    public static boolean isPositive(int number){
        return number>=0;
    }

    public static boolean isPositive(double number){
        return number>=0;
    }

    //range checks: whole number in min–max / decimal in min–max.
    public static boolean isInRange(double value, double min, double max){
        return value >= min && value<=max;
    }
    public static boolean isInRange(int value, int min, int max){
        return value >= min && value<=max;
    }
}
