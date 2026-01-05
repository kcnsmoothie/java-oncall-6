package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.constant.Day;
import oncall.constant.Month;
import oncall.constant.Type;

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

    public List<Day> calculateOutputDay(int days,int startDayIndex) {
        Day[] tempDays = Day.values();
        List<Day> outputDayList = new ArrayList<>();
        int leftLoopDay = days - 6 + startDayIndex;
        for (int i = startDayIndex; i < tempDays.length; i++) {
            outputDayList.add(tempDays[i]);
        }
        for (int i = 0; i < leftLoopDay; i++) {
            for (int j = 0; j < tempDays.length; j++) {
                outputDayList.add(tempDays[j]);
            }
        }
        return outputDayList;
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

    public List<String> calculateWorkOrder( List<Day> outputDay, List<String> weekdayOrder, List<String> weekendOrder) {
        List<String> outputWorkerList = new ArrayList<>();
        int tempWeekday = 0;
        int tempWeekend = 0;
        for (int i = 0; i < outputDay.size(); i++) {
            if (outputDay.get(i).getType() == Type.WEEKDAY) {
                outputWorkerList.add(weekdayOrder.get(tempWeekday % weekdayOrder.size()));
                tempWeekday++;
            }
            if (outputDay.get(i).getType() == Type.WEEKEND) {
                outputWorkerList.add(weekendOrder.get(tempWeekend % weekendOrder.size()));
                tempWeekend++;
            }
        }
        return outputWorkerList;
    }
}
