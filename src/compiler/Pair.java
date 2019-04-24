/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author ali
 */
public class Pair {
    public Character[] key ;
    public Character[] value;
    public Pair(Object key,Object value){
         if(value instanceof Character[]){
            Character[] val = (Character[])value;
            this.value=val;
            
        }
        if(key instanceof Character[]){
             Character[] val = (Character[])key;
            this.key=val;     
        }
    }

   public Pair() {

   }
    
    public boolean Matched(Character[] word){
        if(word instanceof  Character[]){
             Character[] converted_word = ( Character[])word;
             Character[] val = ( Character[])this.value;
            for(int index =0;index<converted_word.length;index++){
                if(val[index]!=converted_word[index]){
                    return false;
                }
            }
           
        }
        return true;
    }
    public Object get_Value(Object key){
        if (key instanceof  Character[]){
            Character[] converted_key = (Character[])key;
            Character[] true_key = (Character[])this.key;
           for(int index=0;index<converted_key.length;index++){
               if(converted_key[index]!=true_key[index]){
                    return false;
                }
           }
            
           }

       return (Character[]) value;
    }

    
}
