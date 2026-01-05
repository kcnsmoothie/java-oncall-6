package oncall.controller;

import java.util.List;
import oncall.constant.Day;
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
        String strStartDay = parsedMonthStartDay.get(1);

        List<String> weekdayOrder = getWeekdayOrder();
        List<String> weekendOrder = getWeekendOrder();

        int days = oncallService.calculateDaysOfMonth(month);
        int startDayIndex = oncallService.calculateDayIndex(strStartDay);
        List<String> outputDayList = oncallService.loopDay(days, startDayIndex);

        outputView.printWorkTableMessage(month,days,outputDayList);
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

    private List<String> getWeekdayOrder() {
        while (true) {
            try {
                String inputWeekdayOrder = inputView.inputWeekdayOrder();
                List<String> weekdayOrder = Parser.parseByDelimeter(inputWeekdayOrder);
                return weekdayOrder;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private List<String> getWeekendOrder() {
        while (true) {
            try {
                String inputWeekendOrder = inputView.inputWeekendOrder();
                List<String> weekendOrder = Parser.parseByDelimeter(inputWeekendOrder);
                return weekendOrder;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
