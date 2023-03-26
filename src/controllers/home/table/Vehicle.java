package controllers.home.table;

public class Vehicle {
    private String date_column;
    private String plates_column;
    private String slotnumber_column;
    private String entrytime_column;
    private String departuretime_column;
    private String charge_column;
    private String paymentid_column;

    public Vehicle(String date_column, String plates_column, String slotnumber_column, String entrytime_column, String departuretime_column, String charge_column, String paymentid_column) {
        this.date_column = date_column;
        this.plates_column = plates_column;
        this.slotnumber_column = slotnumber_column;
        this.entrytime_column = entrytime_column;
        this.departuretime_column = departuretime_column;
        this.charge_column = charge_column;
        this.paymentid_column = paymentid_column;
    }

    public String getDate_column() {
        return date_column;
    }

    public String getPlates_column() {
        return plates_column;
    }

    public String getSlotnumber_column() {
        return slotnumber_column;
    }

    public String getEntrytime_column() {
        return entrytime_column;
    }

    public String getDeparturetime_column() {
        return departuretime_column;
    }

    public String getCharge_column() {
        return charge_column;
    }

    public String getPaymentid_column() {
        return paymentid_column;
    }
}
