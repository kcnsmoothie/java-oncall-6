package oncall.controller;

import java.util.List;
import oncall.service.OncallService;
import oncall.util.Parser;
import oncall.util.Validator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Controller {
    private final InputView inputView; //private final로 설정
    private final OutputView outputView;
    private final OncallService oncallService;

    public Controller(InputView inputView, OutputView outputView, OncallService oncallService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.oncallService = oncallService;
    }

    public void run() {
        List<String> parsedMonthStartDay = getMonthStartDay();
        int month = Parser.stringToInt(parsedMonthStartDay.get(0));
        String startDay = parsedMonthStartDay.get(1);
    }

    private List<String> getMonthStartDay() {
        while (true) {
            try {
                String inputMonthStartDay = inputView.inputMonthStartDay();
                List<String> parsedMonthStartDay = Parser.parseByDelimeter(inputMonthStartDay);
                int month = Parser.stringToInt(parsedMonthStartDay.get(0));
                Validator.validateNumberRange(month);
                String startDay = parsedMonthStartDay.get(1);
                Validator.validateStartDayRange(startDay);
                return parsedMonthStartDay;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
