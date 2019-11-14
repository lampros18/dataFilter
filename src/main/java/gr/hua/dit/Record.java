package gr.hua.dit;

public class Record{
    
    private int year;
    private String months;
    private String country;
    private String region;
    private String city;
    private String postalCode;
    private int registrationCount;

    public Record() {
    }

    public Record(int year, String months, String country, String region, String city, String postalCode, int registrationCount) {
        this.year = year;
        this.months = months;
        this.country = country;
        this.region = region;
        this.city = city;
        this.postalCode = postalCode;
        this.registrationCount = registrationCount;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonths() {
        return this.months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getRegistrationCount() {
        return this.registrationCount;
    }

    public void setRegistrationCount(int registrationCount) {
        this.registrationCount = registrationCount;
    }


    @Override
    public String toString() {
        return "{" +
            " year='" + getYear() + "'" +
            ", months='" + getMonths() + "'" +
            ", country='" + getCountry() + "'" +
            ", region='" + getRegion() + "'" +
            ", city='" + getCity() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", registrationCount='" + getRegistrationCount() + "'" +
            "}";
    }

}