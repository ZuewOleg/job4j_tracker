package ru.job4j.profession;

public class Profession {
   private String name;
    private String surname;
    private String education;
    private String birthday;

    public String getName() {}

    public String getSurname() {}

    public String getEducation() {}

    public String getBirthday() {}

    public static void main(String[] args) {
        Dentist dentis = new Dentist();
        Builder builder = new Builder();
        dentis.diagnosis();
        builder.build();
    }
}
