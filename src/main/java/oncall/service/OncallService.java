package oncall.service;

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
}
