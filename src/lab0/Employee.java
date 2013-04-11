package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    public static final int MIN_VACATION_DAYS = 1;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }

    /**
     * Do not allow null or zero days vacation
     * Do not allow over max days vacation
     * Do not allow under min days of vacation
     * @param daysVacation 
     */
    public void setDaysVacation(int daysVacation) {
        if(daysVacation < MIN_VACATION_DAYS || daysVacation > MAX_VACATION_DAYS) {
            throw new IllegalArgumentException("Vacation days must be " +
                    "between 1 and 28");            
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * do not allow null or zero length. Ask about number first name
     * Maybe allow number at end only.  Allow hyphens only or spaces
     * Allow any letter or case
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        if(firstName == null || firstName.length() == 0){
            throw new IllegalArgumentException("Entry required");
        }
    }

    public Date getHireDate() {
        return hireDate;
    }

    /**
     * Check date for correct format
     * Allow forward slashes or hyphens in date
     * Do not allow null values
     * Split date to make sure there are three parts to the date
     * The three parts to the date should also be validated to make sure
     * they are in a certain range
     * Probably should use a regular expression here to validate
     * @param hireDate 
     */
    public void setHireDate(Date hireDate) {
        if(hireDate == null) {
            throw new IllegalArgumentException("Entry Required");
        }
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Do not allow null or 0 length values
     * Make sure last name contains at least 2 characters
     * Allow hyphens for a hyphenated last name
     * 
     * @param lastName 
     */
    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() == 0) {
            throw new IllegalArgumentException("Entry Required");
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    /**
     * Do not allow null or zero length
     * Allow optional hyphens
     * Only allow digits
     * Make sure 9 digits are entered
     * @param ssn 
     */
    public void setSsn(String ssn) {
        if(ssn == null || ssn.length() == 0) {
            throw new IllegalArgumentException("Entry Required");
        }
        String[] pieces = ssn.split("-");
        if(ssn.contains("-") && pieces.length != 3) {
            throw new IllegalArgumentException ("must have 2 hyphens");
    }
        ssn = ssn.replaceAll("-", "");
        if(ssn.length() != 9) {
            throw new IllegalArgumentException ("ssn must be 9 digits");
        }
        char[] chars = ssn.toCharArray();
        for(char c: chars) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException ("ssn must be 9 digits");
            }
        }
        this.ssn = ssn;
    }
    
}
