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
public class Stack_s {
    private int top =0;
    private int size =0;
    private Stack_Entry [] s ; 
     
    public Stack_s() {
        s = new Stack_Entry[10000000];
    }
    public void push(Stack_Entry word){
        this.s[top] = word;
       this.top++;
    }
    public void pop(){
        top--;
    }
    public Stack_Entry top(){     
        return this.s[top];
    }
    public int Size(){
        return this.size;
    }
    public boolean IsEmpty(){
        if(this.size==0)return true;
        return false;
    }
}
