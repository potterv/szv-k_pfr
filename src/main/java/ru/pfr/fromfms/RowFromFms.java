package ru.pfr.fromfms;

/**
 * Класс в который загружается информация о  подтверждении
 * проживания гражданина на момент референдума в Крыму
 * 18.03.2014
 * @author 092goncharVV
 */
public class RowFromFms {
    @Override
    public String toString() {
        return "RowFromFms{" +
                "uuidPachki='" + uuidPachki + '\'' +
                ", uuidRecord='" + uuidRecord + '\'' +
                ", residentCrimea=" + residentCrimea +
                ", commentary='" + commentary + '\'' +
                '}';
    }

    public void setUuidPachki(String uuidPachki) {
        this.uuidPachki = uuidPachki;
    }

    public void setUuidRecord(String uuidRecord) {
        this.uuidRecord = uuidRecord;
    }

    public void setResidentCrimea(boolean residentCrimea) {
        this.residentCrimea = residentCrimea;
    }

    public String getUuidPachki() {
        return uuidPachki;
    }

    public String getUuidRecord() {
        return uuidRecord;
    }

    public boolean isResidentCrimea() {
        return residentCrimea;
    }



    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    private String uuidPachki;
    private String uuidRecord;
    private boolean residentCrimea;
    private String commentary;



}
