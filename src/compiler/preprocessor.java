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
public class preprocessor {
    Char_array_util CharHelper = new Char_array_util();
    
    public preprocessor(){
        
    }
    
    public  char[] prepro(char[] code){
        int len = CharHelper.len(code);
        char[] code1= new char[len+100];
        int i=0;
        boolean isComment= false; 
        boolean isMultiComment= false;
        int noOfNewLines = 0;
        code = CharHelper.copyandspace(code);
        for(int j=0;j<len;j++){
            if(isMultiComment&&code[j]=='\n'){
                code1[i]=code[j];
                i++;
                code1[i]=' ';
                i++;
            }
            if(isMultiComment && code[j]=='-'&&code[j+1]=='/'){
                if(code[j+2]!=' '){
                    code1[i]=' ';
                    i++;
                }
                j+=1;
                isMultiComment = false;
                isComment = false;
            }else if( code[j]=='/' && code[j+1]=='/'&& code[j+2]=='/'){
                j+=3;
                isComment = true;
            }else if(code[j]=='/'&&code[j+1]=='-'){
                j+=2;
                isMultiComment = true;
            }else if(!isComment && !isMultiComment){
                if((code[j]=='&'&&code[j+1]=='&')||(code[j]=='|'&&code[j+1]=='|')||(code[j]=='<'&&code[j+1]=='=')
                        ||(code[j]=='>'&&code[j+1]=='=')||(code[j]=='='&&code[j+1]=='=')||(code[j]=='!'&&code[j+1]=='=')
                        ||(code[j]=='-'&&code[j+1]=='>')||(code[j]=='='&&code[j+1]=='=')){
                    code1[i]=' ';
                    i++;
                    code1[i]=code[j];
                    i++;
                    code1[i]=code[j+1];
                    i++;
                    code1[i]=' ';
                    i++;
                    j++;
                    continue;
                }else if(code[j]=='\n'||code[j]=='#'||code[j]=='+'||code[j]=='-'||code[j]=='/'||code[j]=='*'||
                        code[j]=='~'||code[j]=='<'||code[j]=='>'||code[j]=='='||code[j]=='('
                        ||code[j]==')'||code[j]=='['||code[j]==']'||code[j]=='{'||code[j]=='}'
                        ||code[j]==','||code[j]=='\''||code[j]=='"'){
                    code1[i]=' ';
                    i++;
                    code1[i]=code[j];
                    i++;
                    code1[i]=' ';
                    i++;
                    continue;
                }
                code1[i] = code[j];
                i++;
            }else if(isComment && code[j]=='\n' && !isMultiComment){
                code1[i] = code[j];
                i++;
                code1[i] = ' ';
                i++;
                isComment = false;
            }
        }
      //  System.out.println(i);
        code1[i]=' ';
        code1[i+1]='\0';
        return code1;
    }
}
