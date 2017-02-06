package lab2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *    1. Not all methods need to be public
 *    2. When methods need to be called in a certain order you can do this
 *       by creating a parent method that calls the other, helper methods.
 *    3. There is some duplicate code used that violates the D.R.Y. principle.
 *       Eliminate that by encapsulating the duplicate code in a new method
 *       and then call that method in place of the duplicate code
 *    4. All method parameters should be validated.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private String cubeId;
    private Date orientationDate;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private Date currentDate;   

    public Employee() {
        currentDate = new Date();
    }

    public void completeEmployeeTraining(String cubeId){
        meetWithHrForBenefitsAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
        
    }
    
    private String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy");
        return sdf.format(currentDate);
    }
    
    public void doTraining(String cubeId) {
        meetWithHrForBenefitsAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
    
    System.out.println("Completed Training on: " + getFormattedDate());
    }   
    private void meetWithHrForBenefitsAndSalryInfo() {
        metWithHr = true;
        System.out.println("Met with HR on: " + getFormattedDate());
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.:
    private void meetDepartmentStaff() {
       if(metWithHr) {
            metDeptStaff = true;
            
            // gives method too many jobs 
            System.out.println("Met with Department Staff on: " + getFormattedDate());
        } else {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        if(metWithHr && metDeptStaff) {
            reviewedDeptPolicies = true;
            
            System.out.println("Reviewed Department Policies on: " + getFormattedDate());
        } else {
            System.out.println("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        if(metWithHr && metDeptStaff && reviewedDeptPolicies) {
            this.cubeId = cubeId;
            this.movedIn = true;
            
           System.out.println("Moved into cubical on: " + getFormattedDate());
        } else {
            System.out.println("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }
    }
    
    public String getStatus() {
        if(metWithHr && metDeptStaff && reviewedDeptPolicies && movedIn) {
            return "Training is complete";
        } else {
            return getFormattedDate() + ": Training in progress...";
        }
    }
    
    
    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.
    
   public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()) {
            // error message
            return;
        } 
       this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()) {
            // error message
            return;
        }
       this.lastName = lastName;
    }

    private String getSsn() {
        return ssn;
    }

   public void setSsn(String ssn) {
       if(ssn == null || ssn.length() < 9 || ssn.length() > 9) {
            System.out.println("Sorry you must provide a proper SSN");
                    return;
        }
        this.ssn = ssn;
    }
    public String getCubeId() {
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        if(cubeId == null || cubeId.isEmpty()) {
            System.out.println("Please Enter a cubeId");
            return;
        }
        this.cubeId = cubeId;
    }

    public Date getOrientationDate() {
        return orientationDate;
    }

    public void setOrientationDate(Date orientationDate) {
        this.orientationDate = orientationDate;
    }

    
    public boolean isMetWithHr() {
        return metWithHr;
    }

    // boolean parameters need no validation
    public void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    private boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    private void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    private boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    private void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    private boolean isMovedIn() {
        return movedIn;
    }

    private void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }


}

