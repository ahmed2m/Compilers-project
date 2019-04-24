package compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Tamer A.Yassen
 */
public class FileManger {
    Char_array_util CharHelper = new Char_array_util();

    public boolean write(String Query, String FilePath, boolean appendType) {

        PrintWriter writter = null;
        try {
            System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writter.println(Query);

            System.out.println(" ... Done ! ");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }
    
    public Entry<char[] , char[] > t2seem(char[] chars){
        Entry<char[] , char[] > Entry = new Entry();
        int l = CharHelper.len(chars);
        int i=0;
        for(;i<l;i++){
            if (chars[i]=='@'){
                char[] key = charslice(chars,0,i);
               // System.out.println(Arrays.toString(key));
                Entry.set_key(key);
                break;
            }
        }
        
        char[] value =charslice(chars,i+1,l);
        //System.out.println(Arrays.toString(value));
        
        Entry.set_value(value);

        return Entry;
    }
    
    public char[] charslice(char[] chars,int start,int end){
        char[] slice= new char[end-start]; 
        int i;
        int x = 0;
        for(i=start;i<end;i++){
            slice[x]=chars[i];
            x++;
        }
        //slice[x]='\0';
        return slice;
    }
    
    
    
    public Dictionray<char[] , char[] > read(String FilePath) {
        Scanner Reader = null;
        try {
            //System.out.println("Reading ! From " + FilePath);
            File Path = new File(FilePath);

            Reader = new Scanner(Path);
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        if (FilePath.equals("Tokens.txt")) {

            Dictionray<char[] , char[] > Entries = new Dictionray<char[] , char[] >();
            Entry <char[] , char[]> seprated;
            
            while (Reader.hasNext()) {
                seprated = new Entry();
                char[] Line = Reader.nextLine().toCharArray();
                //if@condition                
                seprated = this.t2seem(Line);

                Entries.insert(seprated.Key(),seprated.Value());
            }
            return Entries;

        }else {
            return null;
        }

    }
    
    
    public char[] readfromText(char[] FilePat) {
//        System.out.println(FilePat);
        String FilePath = new String(FilePat);
        Scanner Reader = null;
        try {
            //System.out.println("Reading ! From " + FilePath);
            File Path = new File(FilePath);

            Reader = new Scanner(Path);
            
        } catch (FileNotFoundException e) {
            return null;
        }
        
        String code=" ";
        while (Reader.hasNext()) {
            code += Reader.nextLine();
            //if@condition
        }
        return code.toCharArray();
    }

}
