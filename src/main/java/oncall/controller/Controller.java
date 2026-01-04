package oncall.controller;

import oncall.service.OncallService;
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

    }

    private int getMonthStartDay() {
        while (true) {
            try {

            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
