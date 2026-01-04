package oncall.util;

import static oncall.constant.ErrorMessage.DEFAULT_ERROR;

import java.util.Arrays;
import java.util.Objects;
import oncall.constant.Day;

public class Validator {
    public static void validateNumberRange(int number){
        if (number < 1 || number > 12) {
            throw new IllegalArgumentException(DEFAULT_ERROR.getErrorMessage());
        }
    }

    public static void validateStartDayRange(String str){
        if (Arrays.stream(Day.values()).noneMatch(n -> n.getDay().equals(str))) {
            throw new IllegalArgumentException(DEFAULT_ERROR.getErrorMessage());
        }
    }
}
