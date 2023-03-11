package controllers.home.table;
import utils.db_config;

public class Statistics extends Thread {
    int total_spaces = 200;
    String reservation_count="";
    String free_space="";
    String percent_occupancy="";
    String capacity="";

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
        free_space = String.valueOf(total_spaces-Integer.parseInt(free_space));
        percent_occupancy = String.valueOf(((float)(Integer.parseInt(reservation_count)+Integer.parseInt(free_space))/total_spaces)*100)+" %";



    }
}
