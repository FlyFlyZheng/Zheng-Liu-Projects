/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Employee;

/**
 *
 * @author liufulai
 */
public class Employee implements java.io.Serializable{
    private String name;
    private int id;
    private static int count = 1;

    public Employee() {
        id = count;
        count++;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }   
     @Override
    public String toString() {
        return name;
    }
    
    
}
