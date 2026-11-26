/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isKnown;
    private String cellPhoneNumber;
    private String type;
    private char gender;
    private String hobbies[];
    private String instagram;
    private Date bithDate;
    //añadir pictures and comments
    @Override
    public String toString() {
        return "Contact: " + "id=" + id + "\n firstName=" + firstName + "\n lastName=" + lastName + "\n email=" + email + "\n isKnown=" + isKnown + 
                "\n cellPhoneNumber=" + cellPhoneNumber + "\n type=" + type + "\n gender=" + gender + "\n hobbies=" + hobbies + 
                "\n instagram=" + instagram + "\n bithDate=" + bithDate + '}';
    }


    public Contact(int id, String firstName, String lastName, String email, boolean isKnown, String cellPhoneNumber, String type, char gender, String[] hobbies, String instagram, Date bithDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isKnown = isKnown;
        this.cellPhoneNumber = cellPhoneNumber;
        this.type = type;
        this.gender = gender;
        this.hobbies = hobbies;
        this.instagram = instagram;
        this.bithDate = bithDate;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the isKnown
     */
    public boolean isIsKnown() {
        return isKnown;
    }

    /**
     * @param isKnown the isKnown to set
     */
    public void setIsKnown(boolean isKnown) {
        this.isKnown = isKnown;
    }

    /**
     * @return the cellPhoneNumber
     */
    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    /**
     * @param cellPhoneNumber the cellPhoneNumber to set
     */
    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * @return the hobbies
     */
    public String[] getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies the hobbies to set
     */
    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * @return the instagram
     */
    public String getInstagram() {
        return instagram;
    }

    /**
     * @param instagram the instagram to set
     */
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    /**
     * @return the bithDate
     */
    public Date getBithDate() {
        return bithDate;
    }

    /**
     * @param bithDate the bithDate to set
     */
    public void setBithDate(Date bithDate) {
        this.bithDate = bithDate;
    }
    
    
}
