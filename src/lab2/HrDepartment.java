/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.text.SimpleDateFormat;

/**
 *
 * @author kevinjerke
 */
public class HrDepartment {
    private Employee employee;
    private static int cubeId;
    
    
    public void trainNewEmployee(String firstName, String lastName, String ssn){
        Employee e = new Employee();
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setSsn(ssn);
        e.doTraining("A101");
      //  e.completeEmployeeTraining(completeEmployeeTraining);
        employee = e;
        
       
    }
    
    public String getEmployeeStatus(){
        return employee.getStatus();
    }
}
 
    
    
   
