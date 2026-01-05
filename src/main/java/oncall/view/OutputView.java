package oncall.view;

import static oncall.constant.ViewMessage.DEFAULT_WORK_TABLE;

import java.util.List;

public class OutputView {
    public void printWorkTableMessage(int month, int days, List<String> outputDayList) {
        for (int i = 0; i < days; i++) {
            System.out.println(DEFAULT_WORK_TABLE.getViewMessage(month, i + 1, outputDayList.get(i), "j"));
        }
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
