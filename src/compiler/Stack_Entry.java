/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author ahmed2m
 */
public class Stack_Entry {
    private String entry ;

    public Stack_Entry() {
      // entry = new char[200];
    }
    public void Set_entry(String word ){
        this.entry=word;
    }
    public String Get_entry(){
        return this.entry;
    }
    
}
