package ru.pfr;

import java.time.LocalDate;

public class Employee {

    public String toString(){

        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                  this.snils, this.surname, this.name, this.patronymic, this.birthday,this.residenceCrimea ,this.country, this.area, this.region, this.city);
//                this.namepolicyholdershort,regnumber, this.snils, this.surname, this.name, this.patronymic, this.birthday,this.residenceCrimea ,this.country, this.area, this.region, this.city);
    }

    public StringBuffer getSnils(){
        return this.snils;
    }

    public StringBuffer getCountry() {
        return country;
    }

    public StringBuffer getArea() {
        return area;
    }

    public StringBuffer getRegion() {
        return region;
    }

    public StringBuffer getCity() {
        return city;
    }

    public void setCountry(StringBuffer country) {
        this.country = country;
    }

    public void setArea(StringBuffer area) {
        this.area = area;
    }

    public void setRegion(StringBuffer region) {
        this.region = region;
    }

    public void setCity(StringBuffer city) {
        this.city = city;
    }

    private Employee(Builder builder) {
        this.snils = builder.snils;
        this.surname = builder.surname;
        this.name = builder.name;
        this.patronymic = builder.patronymic;
        this.residenceCrimea = builder.residenceCrimea;
        this.birthday = builder.birthday;
        this.country = builder.country;
        this.area = builder.area;
        this.region = builder.region;
        this.city = builder.city;
        this.namepolicyholdershort = builder.namepolicyholdershort;
        this.regnumber = builder.regnumber;
    }

    public static  class Builder{

        //Конструктор с обязательными параметрами
        public Builder(StringBuffer snils){
            this.snils = snils;
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
        }
        public Builder  getPolicyholder(StringBuffer valSurname,StringBuffer valName, StringBuffer valPatronymic, LocalDate valBirthday, boolean valResidenceCrimea, StringBuffer valNamePolicyholdershort, StringBuffer valRegnumber){
            surname = valSurname;
            name = valName;
            patronymic = valPatronymic;
            residenceCrimea = valResidenceCrimea;
            birthday = valBirthday;
            namepolicyholdershort= valNamePolicyholdershort;
            regnumber = valRegnumber;
            return this;
        }

        public Builder  getPolicyholder(StringBuffer valSurname,StringBuffer valName, StringBuffer valPatronymic, LocalDate valBirthday, boolean valResidenceCrimea){
            surname = valSurname;
            name = valName;
            patronymic = valPatronymic;
            residenceCrimea = valResidenceCrimea;
            birthday = valBirthday;

            return this;
        }

        public  Builder getPFR(StringBuffer valCountry, StringBuffer valArea, StringBuffer valRegion, StringBuffer valCity){
            surname = surname;
            name = name;
            patronymic = patronymic;
            country = valCountry;
            area = valArea;
            region = valRegion;
            city = valCity;

            return this;
        }

        //Метод с возвращающим типом Employee для генерации объекта
        public Employee buidl() {
            return new Employee (this); }
        
        //Обязательные параметры
        private StringBuffer snils;
        private StringBuffer surname;
        private StringBuffer name;
        private StringBuffer patronymic;

        //Необязательные параметры со значениями по умолчанию
        private LocalDate birthday;
        private boolean sex;
        private StringBuffer country;
        private StringBuffer area;
        private StringBuffer region;
        private StringBuffer city;
        private StringBuffer numberInsured;
        private StringBuffer nameInsured;
        private boolean residenceCrimea;
        private StringBuffer  namepolicyholdershort;
        private StringBuffer regnumber;

    }


    private int id;
    private StringBuffer snils;
    private StringBuffer surname;
    private StringBuffer name;
    private StringBuffer patronymic;
    private LocalDate birthday;
    private boolean sex;
    private StringBuffer country;
    private StringBuffer area;
    private StringBuffer region;
    private StringBuffer city;
    private StringBuffer numberInsured;
    private StringBuffer nameInsured;
    private boolean residenceCrimea;
    private StringBuffer  namepolicyholdershort;
    private StringBuffer regnumber;

}
