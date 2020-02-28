package ru.pfr;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>{


    public String toString(){

        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                  this.uuidPachka,this.uuidRecord,this.snils, this.surname, this.name, this.patronymic, this.birthday,this.country, this.area, this.region, this.city);
//                this.namepolicyholdershort,regnumber, this.snils, this.surname, this.name, this.patronymic, this.birthday,this.residenceCrimea ,this.country, this.area, this.region, this.city);
    }

    public String toFms(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                this.uuidPachka,this.uuidRecord, this.surname, this.name, this.patronymic, this.birthday,this.country, this.area, this.region, this.city);

    }


    public StringBuffer getUuidPachka(){
        return this.uuidPachka;
    }

    public StringBuffer getUuidRecord(){
        return this.uuidRecord;
    }

    public StringBuffer getSnils(){
        return this.snils;
    }

    public StringBuffer getSurname(){
        return this.surname;
    }

    public StringBuffer getName(){
        return this.name;
    }

    public StringBuffer getPatronymic(){
        return this.patronymic;
    }

    public LocalDate getBirthday(){
        return this.birthday;
    }

    public boolean getResidenceCrimea(){
        return this.residenceCrimea;
    }

    public StringBuffer getCountry() {
        return this.country;
    }

    public StringBuffer getArea() {
        return this.area;
    }

    public StringBuffer getRegion() {
        return this.region;
    }

    public StringBuffer getCity() {
        return this.city;
    }

    public StringBuffer getPolicyholderShort() {
        return this.namepolicyholdershort;
    }
    public StringBuffer getRegnumber() {
        return this.regnumber;
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
        this.uuidPachka = builder.uuidPachka;
        this.uuidRecord = builder.uuidRecord;
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
// Реализация метода сравнения интерфейса Comparable для сортировки списка по полю surname, в алфавитном порядке
    @Override
    public int compareTo(Employee o) {
        return this.surname.toString().compareTo(o.surname.toString()) ;
    }

    public static  class Builder{

        //Конструктор с обязательными параметрами
        public Builder(StringBuffer snils){
            this.snils = snils;
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
        }
        public Builder  getPolicyholder(StringBuffer valUuidPachka,StringBuffer valUuidRecord,StringBuffer valSurname,StringBuffer valName, StringBuffer valPatronymic, LocalDate valBirthday, boolean valResidenceCrimea, StringBuffer valNamePolicyholdershort, StringBuffer valRegnumber){
            this.uuidPachka=valUuidPachka;
            this.uuidRecord=valUuidRecord;
            this.surname = valSurname;
            this.name = valName;
            this.patronymic = valPatronymic;
            this.residenceCrimea = valResidenceCrimea;
            this.birthday = valBirthday;
            this.namepolicyholdershort= valNamePolicyholdershort;
            this.regnumber = valRegnumber;
            return this;
        }

        public Builder  getPolicyholder(StringBuffer valUuidPachka,StringBuffer valUuidRecord, StringBuffer valSurname,StringBuffer valName, StringBuffer valPatronymic, LocalDate valBirthday, boolean valResidenceCrimea){
            this.uuidPachka=valUuidPachka;
            this.uuidRecord=valUuidRecord;
            this.surname = valSurname;
            this.name = valName;
            this.patronymic = valPatronymic;
            this.residenceCrimea = valResidenceCrimea;
            this.birthday = valBirthday;

            return this;
        }

        public  Builder getPFR(StringBuffer valCountry, StringBuffer valArea, StringBuffer valRegion, StringBuffer valCity){
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
            this.country = valCountry;
            this.area = valArea;
            this.region = valRegion;
            this.city = valCity;

            return this;
        }

        //Метод с возвращающим типом Employee для генерации объекта
        public Employee buidl() {
            return new Employee (this); }
        
        //Обязательные параметры
        private StringBuffer uuidPachka;
        private StringBuffer uuidRecord;
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
    private StringBuffer uuidPachka;
    private StringBuffer uuidRecord;
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
