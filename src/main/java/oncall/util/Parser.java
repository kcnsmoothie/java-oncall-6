package oncall.util;

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
}
