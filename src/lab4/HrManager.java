/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevinjerke
 */
public class HrManager {
    
    private List<Employee> employees;
    
    public HrManager() {
        employees = new ArrayList();
    }
    
    public void hireEmployee(String firstName, String lastName, String ssn) {
        Employee e = new Employee(firstName,lastName,ssn);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setSsn(ssn);
        employees.add(e);
        orientEmployee(e);
    }
    
    
    public void orientEmployee(Employee e) {
        e.doFirstTimeOrientation("A1");
    }
    
    public void outputReport(String ssn) {
        Employee e = null;
        
        //find employee in list
        
        //      for(Employee emp : employees) {
//            if(emp.getSsn().equals(ssn)) {
//                e = emp;
//                break;
//            } else {
//                // if not found end method prematurely
//                return;
//            }
//        }
//
//        // if found run report
//        if(e.isMetWithHr() && e.isMetDeptStaff()
//           && e.isReviewedDeptPolicies() && e.isMovedIn()) {
//            
//            e.getReportService().outputReport();
//            
   }

        public List<Employee> getEmployees() {
            return employees;
        }
        
        public void setEmployees(List<Employee>employees) {
            this.employees = employees;
        }
    }

