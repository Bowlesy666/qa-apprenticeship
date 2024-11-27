package lab02;

public class RegistrationPlate {
    private String regPlate, city, country, yearOfRegistration;

    public RegistrationPlate(String regPlate, String city, String country, String yearOfRegistration) {
        this.regPlate = regPlate;
        this.city = city;
        this.country = country;
        this.yearOfRegistration = yearOfRegistration;
    }

    public String getDetails() {
        return this.regPlate + this.city + this.country + this.yearOfRegistration;
    }


}
