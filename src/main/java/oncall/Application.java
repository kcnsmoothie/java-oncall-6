package oncall;

import oncall.controller.Controller;
import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        OncallService oncallService = new OncallService();

        Controller controller = new Controller(inputView, outputView, oncallService);
        controller.run();
    }
}
