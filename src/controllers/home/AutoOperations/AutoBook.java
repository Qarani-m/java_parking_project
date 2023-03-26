package controllers.home.AutoOperations;
import java.io.File;
import java.io.FileWriter;
public class AutoBook {
    public static void main(String[] args) {
        String slot_number = "null";
        String plate_number="null";
        String size="null";
        String departure_time="null";
        String charge="null";
        String payment_id="null";
        String query1 = "delete from reservations where slot_number='"+slot_number+"';";
        String query2 = "insert into(plate_number,size_,slot_number,departure_time,charge,payment_id)values('"+plate_number+"', '"+size+"', '"+slot_number+"', '"+departure_time+"', '"+charge+"', '"+payment_id+"');";
        String query3= "update slots set occupied=true, reserved=false where slot_number='"+slot_number+"';";
    }
}
