import java.util.Arrays;
import java.util.Date;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isKnown;
    private String cellPhoneNumber;
    private String type;
    private char gender;
    private String[] hobbies;
    private String instagram;
    private Date bithDate;

    public Contact(int id, String firstName, String lastName, String email, boolean isKnown, String cellPhoneNumber, String type, char gender, String[] hobbies, String instagram, Date bithDate) {
        this.id = id; this.firstName = firstName; this.lastName = lastName; this.email = email;
        this.isKnown = isKnown; this.cellPhoneNumber = cellPhoneNumber; this.type = type;
        this.gender = gender; this.hobbies = hobbies; this.instagram = instagram; this.bithDate = bithDate;
    }

    @Override
    public String toString() {
        return "Contact: id=" + id + "\nfirstName=" + firstName + "\nlastName=" + lastName
                + "\nemail=" + email + "\nisKnown=" + isKnown + "\ncellPhoneNumber=" + cellPhoneNumber
                + "\ntype=" + type + "\ngender=" + gender + "\nhobbies=" + Arrays.toString(hobbies)
                + "\ninstagram=" + instagram + "\nbithDate=" + bithDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public boolean isIsKnown() { return isKnown; }
    public void setIsKnown(boolean isKnown) { this.isKnown = isKnown; }
    public String getCellPhoneNumber() { return cellPhoneNumber; }
    public void setCellPhoneNumber(String cellPhoneNumber) { this.cellPhoneNumber = cellPhoneNumber; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }
    public String[] getHobbies() { return hobbies; }
    public void setHobbies(String[] hobbies) { this.hobbies = hobbies; }
    public String getInstagram() { return instagram; }
    public void setInstagram(String instagram) { this.instagram = instagram; }
    public Date getBithDate() { return bithDate; }
    public void setBithDate(Date bithDate) { this.bithDate = bithDate; }
}
