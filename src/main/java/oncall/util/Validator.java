package oncall.util;

import static oncall.constant.ErrorMessage.DEFAULT_ERROR;

import java.util.Arrays;
import java.util.List;
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

    public static void validateNotDuplicate(List<String> intWinningNumber) {
        if (intWinningNumber.size() != intWinningNumber.stream().distinct().count()) {
            throw new IllegalArgumentException(DEFAULT_ERROR.getErrorMessage());
        }
    }

    public static void validateStrSize(List<String> stringList) {
        for (String str : stringList) {
            if (str.length() > 5) {
                throw new IllegalArgumentException(DEFAULT_ERROR.getErrorMessage());
            }
        }
    }
}
