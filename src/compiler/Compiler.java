/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;
import GUI.Frame;
import java.util.Arrays;

/**
 *
 * @author omarf
 */
public class Compiler {
    
    Char_array_util CharHelper = new Char_array_util();

    /**
     * @param args the command line arguments
     */
    preprocessor pre = new preprocessor();
    compiler_scanner s = new compiler_scanner();
    static Frame GUI=new Frame();
    public static void main(String[] args) {
            
        
        //frame.setVisible(true);
        boolean [] a = new boolean[2];
        compiler_scanner s = new compiler_scanner();
//        String test = "Iow ali = 10 # \n Law $omar \n 0ali 1. -> -10 ( ali == 10 ) { print ( ali ) } Else { print ( omar ) } \0";
//        String test2 = "1.1 \0";
//        char words [] =test.toCharArray();
//        char[] x = {'I','o','w'};
//        char[] z ={'I','o','w'};
       
//       Dictionray<Entry , Integer > tokens=s.Scan(words);
       
//        System.out.println(tokens.Size());
//        for(int i =0;i<tokens.Size();i++){
//            System.out.print(tokens.EntryAt(i).Value());
//            System.out.print(" ");
//            System.out.print((char[])(tokens.EntryAt(i).Key().Key()));
//            System.out.print(" ");
//            System.out.println((char[])tokens.EntryAt(i).Key().Value());
//          }
        GUI.setVisible(true);
    }
    
    public void PreprocessAndScan(char[] code,Frame GUI){
        s = new compiler_scanner();
        code = pre.prepro(code);
//        System.out.println("CODE is :");
//        System.out.println(code);
//        System.out.println("END OF CODE");
        Dictionray<Entry , Integer > tokens=s.Scan(code);
//        System.out.println("size:");
//        System.out.println(tokens.Size());
        for(int i =0;i<tokens.Size();i++){
            GUI.PrintInLog("Line ");
            GUI.PrintInLog(tokens.EntryAt(i).Value());
            GUI.PrintInLog(": Token Text: ");
            char[] key = (char[])tokens.EntryAt(i).Key().Key();
            if(key[0]=='\n')
                GUI.PrintInLog("\\n");
            else    
                GUI.PrintInLog((char[])tokens.EntryAt(i).Key().Key());
            GUI.PrintInLog(" Token Type: "); 
            GUI.PrintInLog((char[])tokens.EntryAt(i).Key().Value());
            GUI.PrintInLog("\n");
          }
        GUI.PrintInLog("count Error");

    }
    //System.out.print("Done");
    //System.exit(1);
    //System.out.print(a[0]);
    ///frame.setVisible(true);

        
        
        
  }
    

