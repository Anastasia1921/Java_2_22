import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        //1
        Scanner in = new Scanner(System.in);
        System.out.println("введите строку с датой формата 31.12.2020");
        String strDate = in.nextLine();
        try {
            if (!strDate.isEmpty()) {
                SimpleDateFormat fmtDate = new SimpleDateFormat("dd.MM.yyyy");
                Date prsDate = fmtDate.parse(strDate);

                //2
                int y = prsDate.getYear();
                int m = prsDate.getMonth();
                int d = prsDate.getDate();
                Calendar calendar = new GregorianCalendar(1900+y, m, d);

                calendar.add(Calendar.DAY_OF_YEAR, 45);
                System.out.println(fmtDate.format(calendar.getTime()));

                //3
                int m2 = 0; // месяцы начинаются с 0
                int d2 = 1;
                int y2 = calendar.get(Calendar.YEAR);
                calendar.set(Calendar.DAY_OF_MONTH,d2);
                calendar.set(Calendar.MONTH,m2);
                System.out.println(fmtDate.format(calendar.getTime()));

                //4
                int numWorkDays = 0;
                int id = 0;
                while (numWorkDays < 10) {

                    id = calendar.get(Calendar.DAY_OF_WEEK);
                    if (!((id==Calendar.SUNDAY)||(id==Calendar.SATURDAY))) {
                        numWorkDays++;
                    }
                    if (numWorkDays< 10) calendar.add(Calendar.DAY_OF_YEAR, 1);
                }

                id = calendar.get(Calendar.DAY_OF_WEEK);
                if (id==Calendar.SUNDAY) {
                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                }
                else if (id==Calendar.SATURDAY) {
                    calendar.add(Calendar.DAY_OF_YEAR, 2);
                }
                System.out.println(fmtDate.format(calendar.getTime()));

                //5
                System.out.println("введите новую строку с датой формата 31.12.2020");
                String strNewDate = in.nextLine();
                if (!strNewDate.isEmpty()) {
                    Date prsNewDate = fmtDate.parse(strNewDate);

                    //6
                    int newY = prsNewDate.getYear();
                    int newM = prsNewDate.getMonth();
                    int newD = prsNewDate.getDate();
                    Calendar newCalendar = new GregorianCalendar(1900 + newY, newM, newD);

                    calendar.set(y+1900, m, d);
                    int numWorkDays2 = 0;
                    int newId = 0;
                    while (calendar.before(newCalendar)) {
                        newId = calendar.get(Calendar.DAY_OF_WEEK);
                        if (!((newId == Calendar.SUNDAY) || (newId == Calendar.SATURDAY))) {
                            numWorkDays2++;
                        }
                        calendar.add(Calendar.DAY_OF_YEAR, 1);
                    }

                    System.out.println(numWorkDays2);
                }
                else {
                    System.out.println("новая строка пуста");
                }
            } else {
                System.out.println("строка пуста");
            }
        } catch (ParseException e) {
            System.out.println("строку не удалось распознать");
        }
    }
}

