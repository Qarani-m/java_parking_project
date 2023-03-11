package controllers.home.table;
import utils.db_config;

public class Statistics extends Thread {
    int total_spaces = 200;
    String reservation_count="";
    String free_space="";
    String percent_occupancy="";
    String capacity="";
    String filled_floors="";
    String avg_time="";

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
        free_space = String.valueOf((Integer.parseInt("200")-Integer.parseInt(free_space))-Integer.parseInt(reservation_count));
        percent_occupancy = String.valueOf(((float)(Integer.parseInt(reservation_count)+Integer.parseInt(capacity))/total_spaces)*100)+" %";
        avg_time = (String) db_config.executeQuery("SELECT avg_time FROM (SELECT SEC_TO_TIME((AVG(TIME_TO_SEC(departure_time)) - AVG(TIME_TO_SEC(entry_time)))/ 2) AS avg_time FROM lot) AS subquery;");


        if (Integer.parseInt(capacity)<50) {filled_floors = "0  of 4";}
        else if (Integer.parseInt(capacity)>=50 && Integer.parseInt(free_space)<=100) {filled_floors = "1  of 4";}
        else if (Integer.parseInt(capacity)>=101 && Integer.parseInt(free_space)<=150) {filled_floors = "2  of 4";}
        else if (Integer.parseInt(capacity)>=151 && Integer.parseInt(free_space)<=200) {filled_floors = "3  of 4";}
        else {filled_floors = "4  of 4";}

    }
}
