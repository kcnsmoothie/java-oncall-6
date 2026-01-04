package oncall.view;

import static oncall.constant.ViewMessage.DEFAULT_WORK_TABLE;

public class OutputView {
    public void printWorkTableMessage() {
        System.out.println(DEFAULT_WORK_TABLE.getViewMessage(1,2,"S","D"));
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
