package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.constant.Day;
import oncall.constant.Month;

public class OncallService {
    public int calculateDaysOfMonth(int month) {
        int days = 0;
        for (Month month1 : Month.values()) {
            if (month1.getMonth() == month) {
                days = month1.getDays();
            }
        }
        return days;
    }

    public int calculateDayIndex(String startDay) {
        Day[] days = Day.values();
        int startDayIndex = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i].getDay().equals(startDay)) {
                startDayIndex = i;
            }
        }
        return startDayIndex;
    }

    public List<String> loopDay(int days,int startDayIndex) {
        Day[] tempDays = Day.values();
        List<String> outputDayList = new ArrayList<>();
        int leftLoopDay = days - 6 + startDayIndex;
        for (int i = startDayIndex; i < tempDays.length; i++) {
            outputDayList.add(tempDays[i].getDay());
        }
        for (int i = 0; i < leftLoopDay; i++) {
            for (int j = 0; j < tempDays.length; j++) {
                outputDayList.add(tempDays[j].getDay());
            }
        }
        return outputDayList;
    }
}
