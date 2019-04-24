/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.*;

/**
 *
 * @author ahmed2m
 */
public class parser {
    private Stack_s input_stack;
    private Stack_s parse_stack;
    private Dictionray<Entry , Integer > Statements;
    private Dictionray<String  , String > terminals;
    private char [][][] parse_table=new char[50][50][] ;
    public int number_of_errors= 0;
    public parser() {
    parse_stack = new  Stack_s();
    input_stack = new Stack_s();
        Set_parse_table(parse_table);
        Set_terminals(terminals);
    
    }
    private void Set_parse_table(char[][][] parse_table){
        char [] item ={'d','e','c','l','a','r','a','t','i','o','n','-','l','i','s','t'};
 
        this.parse_table[1][1]=item;
        
        this.parse_table[1][2]=item;
        
        this.parse_table[1][3]=item;
        
        this.parse_table[1][4]=item;
        
        this.parse_table[1][5]=item;
        
        this.parse_table[1][6]=item;
        char item = {'i','n','c','l','u','d','e','_','c','o','m','m','a','n','d'};
        this.parse_table[1][35]="include_command";
        
        this.parse_table[2][1]="declaration DL'";
        this.parse_table[2][2]="declaration DL'";
        this.parse_table[2][3]="declaration DL'";
        this.parse_table[2][4]="declaration DL'";
        this.parse_table[2][5]="declaration DL'";
        this.parse_table[2][6]="declaration DL'";


        this.parse_table[3][1]="declaration DL'";
        this.parse_table[3][2]="declaration DL'";
        this.parse_table[3][3]="declaration DL'";
        this.parse_table[3][4]="declaration DL'";
        this.parse_table[3][5]="declaration DL'";
        this.parse_table[3][6]="declaration DL'";
        this.parse_table[3][38]="e";


        this.parse_table[4][1]="type-specifier ID dec'";
        this.parse_table[4][2]="type-specifier ID dec'";
        this.parse_table[4][3]="type-specifier ID dec'";
        this.parse_table[4][4]="type-specifier ID dec'";
        this.parse_table[4][5]="type-specifier ID dec'";
        this.parse_table[4][6]="type-specifier ID dec'";


        this.parse_table[5][11]="#";
        this.parse_table[5][14]=" ( params ) compound-stmt";

        this.parse_table[6][1]="Iow";
        this.parse_table[6][2]="SIow";
        this.parse_table[6][3]="Chlo";
        this.parse_table[6][4]="Chain";
        this.parse_table[6][5]="SIowf";
        this.parse_table[6][6]="Worthless";

        this.parse_table[7][1]="param-list";
        this.parse_table[7][2]="param-list";
        this.parse_table[7][3]="param-list";
        this.parse_table[7][4]="param-list";
        this.parse_table[7][5]="param-list";
        this.parse_table[7][6]="Worthless";

        this.parse_table[8][1]="param PL`";
        this.parse_table[8][2]="param PL`";
        this.parse_table[8][3]="param PL`";
        this.parse_table[8][4]="param PL`";
        this.parse_table[8][5]="param PL`";
        this.parse_table[8][6]="param PL`";
        
        this.parse_table[9][15]="e";
        this.parse_table[9][40]=", param PL`";

        this.parse_table[10][1]="type-specifier ID";
        this.parse_table[10][2]="type-specifier ID";
        this.parse_table[10][3]="type-specifier ID";
        this.parse_table[10][4]="type-specifier ID";
        this.parse_table[10][5]="type-specifier ID";


        this.parse_table[11][8]="{ local-declarations statement-list }";

        this.parse_table[12][1]="type-specifier ID # local-declaration";
        this.parse_table[12][2]="type-specifier ID # local-declaration";
        this.parse_table[12][3]="type-specifier ID # local-declaration";
        this.parse_table[12][4]="type-specifier ID # local-declaration";
        this.parse_table[12][5]="type-specifier ID # local-declaration";
        this.parse_table[12][6]="type-specifier ID # local-declaration";
        this.parse_table[12][7]="e";
        this.parse_table[12][8]="e";
        this.parse_table[12][9]="e";
        this.parse_table[12][11]="e";
        this.parse_table[12][12]="e";
        this.parse_table[12][14]="e";
        this.parse_table[12][18]="e";
        this.parse_table[12][31]="e";
        this.parse_table[12][32]="e";
        this.parse_table[12][33]="e";
        this.parse_table[12][34]="e";
        
        this.parse_table[13][7]="statement statement-list";
        this.parse_table[13][8]="statement statement-list";
        this.parse_table[13][9]="e";
        this.parse_table[13][11]="statement statement-list";
        this.parse_table[13][12]="statement statement-list";
        this.parse_table[13][13]="statement statement-list";
        this.parse_table[13][14]="statement statement-list";
        this.parse_table[13][17]="statement statement-list";
        this.parse_table[13][18]="statement statement-list";
        this.parse_table[13][33]="statement statement-list";
        this.parse_table[13][34]="statement statement-list";
        this.parse_table[13][35]="statement statement-list";

        this.parse_table[14][7]="expression-stmt";
        this.parse_table[14][8]="compound-stmt";
        this.parse_table[14][11]="expression-stmt";
        this.parse_table[14][12]="selection-stmt";
        this.parse_table[14][13]="selection-stmt";
        this.parse_table[14][14]="expression-stmt";
        this.parse_table[14][17]="iteration-stmt";
        this.parse_table[14][18]="jump-stmt";
        this.parse_table[14][31]="expression-stmt";
        this.parse_table[14][32]="expression-stmt";
        this.parse_table[14][33]="expression-stmt";
        this.parse_table[14][34]="expression-stmt";
        
    }
    private void Set_Parse_Stack(){
        parse_stack = new Stack_s();
        Stack_Entry item = new Stack_Entry();
        item.Set_entry("$");
        parse_stack.push(item);
        item.Set_entry("program");
        parse_stack.push(item);
        
        
        
    }
    private void get_form_scanner(){

//        Entry <char [],char[]>item_real = new Entry<>();
//        for(int index =0;index<tokens.Size();index++){
            item = tokens.EntryAt(index);
            item_real = item.Key();
            int size = Char_array_util.len(item_real.Key())+1;
            char [] item11 = new char [size];
            item11[size-1]= '$';
//            int line_no = tokens.EntryAt(index).Value();
//            parse(item11,line_no);
//            
//        }
        
    
    }
    private void parse(Dictionray<Entry , Integer > tokens,int line_no){
        Entry<Entry,Integer> item = new Entry<>();
        char []item12= {'$'};
        Entry<char[],char[]> a = new Entry<>();
        a.set_key(item12);
        item.set_key(a);
        item.set_value(10);
        tokens.insert(a,10);
        String rule_used = new String();
        while(!this.parse_stack.IsEmpty()){
            Stack_Entry non_terminal = new Stack_Entry();
           
     
            non_terminal= parse_stack.top();
            item = tokens.EntryAt(index);
            item_real = item.Key();

            if(is_terminal(non_terminal)){
                if(match(token,non_terminal)){
                Entry<String,String> match= new Entry<>();
                match.set_key("matched");
                match.set_value(rule_used);
                this.Statements.insert(match,line_no);
                parse_stack.pop();
                }else{
               Entry<String,String> match= new Entry<>();
                match.set_key("not matched");
                match.set_value("error");
                this.Statements.insert(match,line_no); 
                number_of_errors++;
                }
            }else{
                parse_stack.push(parse_table[][]);
                
            } 
        }
       
    }
    private void Set_terminals(Dictionray<String , String > terminals){
        
        terminals.insert("Iow", "yes");
        terminals.insert("Slow", "yes");
        terminals.insert("Chlo", "yes");
        terminals.insert("Chain", "yes");
        terminals.insert("Iowf", "yes");
        terminals.insert("Worthless", "yes");
        terminals.insert("ID", "yes");
        terminals.insert("#", "yes");
        terminals.insert(",", "yes");
        terminals.insert(";", "yes");
        terminals.insert("(", "yes");
        terminals.insert(")", "yes");
        terminals.insert("{", "yes");
        terminals.insert("}", "yes");
        terminals.insert("iteratewhen", "yes");
        terminals.insert("Loopwhen", "yes");
        terminals.insert("Turnback", "yes");
        terminals.insert("Stope", "yes");
        terminals.insert("=", "yes");
        terminals.insert(">", "yes");
        terminals.insert("<", "yes");
        terminals.insert("<=", "yes");
        terminals.insert(">=", "yes");
        terminals.insert("!=", "yes");
        terminals.insert("==", "yes");
        terminals.insert("&&", "yes");
        terminals.insert("||", "yes");
        terminals.insert("+", "yes");
        terminals.insert("-", "yes");
        terminals.insert("*", "yes");
        terminals.insert("/", "yes");
        terminals.insert("Constant", "yes");
        terminals.insert("include", "yes");
        terminals.insert("STR", "yes");
        terminals.insert("\"", "yes");
        terminals.insert("'", "yes");
       
    }
    private boolean is_terminal(Stack_Entry non_terminal) {
        String check = non_terminal.Get_entry();
        if(this.terminals.Get_value(check)!=null){
            return true;
        }
        
        return false;
    }

    private boolean match(char[] token, Stack_Entry non_terminal) {
       char []item1 = non_terminal.Get_entry().toCharArray();
       if(Char_array_util.equals(item1, token))return true;
       return false;
    }
    
}

