package controllers.home.AutoOperations;

public class AutoRelease {
    public static void main(String[] args) {
        String slot_number = "null";
        String query1 = "delete from reservations where slot_number='"+slot_number+"';";
        String query2 = "delete from reservations where lot='"+slot_number+"';";
        String query3= "update slots set occupied=true, reserved=false where slot_number='"+slot_number+"';";
    }
}
