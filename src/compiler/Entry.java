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
import java.util.*;
public class Entry <K,V>{
    K key;
    V value;
    public Entry(K key,V value){
        this.key = key;
        this.value =value;
    }

    Entry() {
    }
    public K Key(){
        return this.key;
    }
    public V Value(){
        return this.value;
    }
    public void set_key(K key){
            this.key=key;
        
    }
    public void set_value(V value){
         this.value=value;
 
        

    }
    @Override
     public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Entry<K, V> other = (Entry<K, V>) obj;
        if (this.key != other.key && (this.key == null || !this.key.equals(other.key)))
            return false;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value)))
            return false;
        return true;
    }

}
