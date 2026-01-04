package oncall.util;

import static oncall.constant.ErrorMessage.DEFAULT_ERROR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parseByDelimeter(String inputValue) {
        List<String> parsedList = new ArrayList<>();
        Arrays.stream(inputValue.split(","))
                .map(String::trim)
                .forEach(parsedList::add);
        return parsedList;
    }

    public static int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DEFAULT_ERROR.getErrorMessage());
        }
    }
}
