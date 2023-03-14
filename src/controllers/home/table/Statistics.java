package controllers.home.table;
import utils.db_config;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Statistics extends Thread {
    int total_spaces = 200;
    String reservation_count="";
    String free_space="";
    String percent_occupancy="";
    String capacity="";
    String filled_floors="";
    String avg_time="";
    String todays_income;
    String weekly_income;
    String turnover_rate;
    String profit;
//"SELECT charge FROM lot WHERE date_ BETWEEN DATE_SUB(CURDATE(), INTERVAL 7 DAY) AND CURDATE()"

    @Override
    public void run() {
        while (true) {
            update();
            try {Thread.sleep(2000);}
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
    public void update(){
        reservation_count= (String) db_config.executeQuery("select count(id) from reservations");
        free_space = (String) db_config.executeQuery("select count(id) from lot");
        capacity= free_space;
        free_space = String.valueOf((parseInt("200")- parseInt(free_space))- parseInt(reservation_count));
        percent_occupancy = String.valueOf(((float)(parseInt(reservation_count)+ parseInt(capacity))/total_spaces)*100)+" %";
        avg_time = (String) db_config.executeQuery("SELECT SEC_TO_TIME((AVG(TIME_TO_SEC(entry_time)) + AVG(TIME_TO_SEC(departure_time))) / 2) AS avg_time FROM lot;");
        weekly_income = (String) db_config.executeQuery("SELECT charge FROM lot WHERE date_ BETWEEN DATE_SUB(CURDATE(), INTERVAL 7 DAY) AND CURDATE()");
        todays_income = (String) db_config.executeQuery("SELECT * FROM lot WHERE date_ = CURDATE();");
         turnover_rate = String.valueOf(( (float) db_config.executeQuery("SELECT count(*) FROM lot WHERE date_ = CURDATE();")/parseFloat(capacity))*100);


//      turnover_rate = String.valueOf(turnover_rate1-turnover_rate2)

        if (parseInt(capacity)<50) {filled_floors = "0  of 4";}
        else if (parseInt(capacity)>=50 && parseInt(free_space)<=100) {filled_floors = "1  of 4";}
        else if (parseInt(capacity)>=101 && parseInt(free_space)<=150) {filled_floors = "2  of 4";}
        else if (parseInt(capacity)>=151 && parseInt(free_space)<=200) {filled_floors = "3  of 4";}
        else {filled_floors = "4  of 4";}

    }
}
