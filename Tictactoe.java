
import java.io.*;
import java.util.Scanner;

class operation{
	void display(char  systemview[], char userview[]){
		    /*for(int j=0;j<9;j++) {
		    	if(a[j]==10)
		    		userview[j]='V';
		    	if(a[j]==11)
		    		userview[j]= 'X';
		    	if(a[j]==12)
		    		userview[j] = 'O';
		    }*/
			System.out.println(" "+userview[0]+" | " +userview[1]+ " | " +userview[2]+ "\n--- --- ---");
			System.out.println(" "+userview[3]+" | " +userview[4]+ " | " +userview[5]+"\n--- --- ---");
			System.out.println(" "+userview[6]+" | " +userview[7]+ " | " +userview[8]);
			System.out.println("");
	  }
     void usergo(int value, char  systemview[], char userview[]) {
    	 systemview[value] = 12;
    	 userview[value]='X'; // 12 implies X(user)
     } 
     void systemgo(int value, char  systemview[], char userview[]) {
    	 systemview[value] = 11;
    	 userview[value]='O'; // 12 implies X(user)
     } 
     void first(char  systemview[], char userview[]) {
    	 if( systemview[4]==10) {
    		 systemview[4] = 11;// 11 implies 0(computer)
    		 userview[4]='O';
    	 }
    	 else {
    		 systemview[0] = 11;
    	     userview[0]='O';
    	 }
     }
     int checkposswinuser(char systemview[], char equality , int result) {
    	 int us = equality;
    	 if(systemview[0] * systemview[1] * systemview[2] == us ) {
    		 
    		if(systemview[0]==10)
    			result = 0;
    		if(systemview[1]==10)
    			result = 1;
            if(systemview[2]==10)
            	result = 2;
    	 } //012
    	 if(systemview[0] * systemview[4] * systemview[8] == us) {
    		 
    		 if(systemview[0]==10)
     			result = 0;
     		 if(systemview[4]==10)
     			result = 4;
             if(systemview[8]==10)
             	result = 8;
     	 }//048
    	  if(systemview[3] * systemview[4] * systemview[5] == us) {
    		 
    		 if(systemview[3]==10)
     			result = 0;
     		 if(systemview[4]==10)
     			result = 4;
             if(systemview[5]==10)
             	result = 5;
     	 }//345
    	 if(systemview[6] * systemview[7] * systemview[8] == us) {
    		 
    		 if(systemview[6]==10)
     			result = 6;
     		 if(systemview[7]==10)
     			result = 7;
             if(systemview[8]==10)
             	result = 8;
     	 }//678
    	 if(systemview[2] * systemview[5] * systemview[8] == us) {
    		
    		 if(systemview[2]==10)
     			result = 2;
     		 if(systemview[4]==10)
     			result = 4;
             if(systemview[8]==10)
             	result = 8;
     	 }//258
    	 if(systemview[0] * systemview[3] * systemview[6] == us) {
    		 
    		 if(systemview[0]==10)
     			result = 0;
     		 if(systemview[3]==10)
     			result = 3;
             if(systemview[6]==10)
             	result = 6;
     	 }//036
    	 if(systemview[1] * systemview[4] * systemview[7] == us) {
    		 
    		 if(systemview[1]==10)
     			result = 1;
     		 if(systemview[4]==10)
     			result = 4;
             if(systemview[7]==10)
             	result = 7;
     	 }//147
    	 if(systemview[2] * systemview[4] * systemview[6] == us) {
    		 
    		 if(systemview[2]==10)
     			result = 2;
     		 if(systemview[4]==10)
     			result = 4;
             if(systemview[6]==10)
             	result = 6;
     	 }//248
    	 
    		return result;
      }
     void maketwo(char systemview[], char userview[]) {
    	 // check if 1/3/5/7 is blank
    	 int make[] = {1, 3, 5, 7};
    	 for(int m=0; m<9;m++) {
    		 //int j = make[m];
    		 if(systemview[m]==10)
        	     systemgo(m, systemview, userview);
    		     m = 10;
    	 }
     }
     int checkforwin(char systemview[], int result, int count) {
    	 final char Xfinalresult = 1728;
         final char Ofinalresult = 1331;
         if(systemview[0] * systemview[1] * systemview[2] == 1728 || systemview[0] * systemview[4] * systemview[8]== 1728 ||systemview[3] * systemview[4] * systemview[5]== 1728 ||systemview[6] * systemview[7] * systemview[8]== 1728 ||systemview[2] * systemview[5] * systemview[8]== 1728 ||systemview[0] * systemview[3] * systemview[6]== 1728 ||systemview[0] * systemview[3] * systemview[6]== 1728 ||systemview[2] * systemview[4] * systemview[6] == 1728 )
              System.out.println("YOU WON!"+result);
         	  count = 10;
         if(systemview[0] * systemview[1] * systemview[2] == 1331 || systemview[0] * systemview[4] * systemview[8]== 1331 ||systemview[3] * systemview[4] * systemview[5]== 1331 ||systemview[6] * systemview[7] * systemview[8]== 1331 ||systemview[2] * systemview[5] * systemview[8]== 1331 ||systemview[0] * systemview[3] * systemview[6]== 1331 ||systemview[0] * systemview[3] * systemview[6]== 1331 ||systemview[2] * systemview[4] * systemview[6] == 1331 )
     	      System.out.println("YOU LOST :( \nBETTER LUCK NEXT TIME :-P \nCOMPUTER WON ");
              count = 10;
        return count;
     }
    	
    }

public class Tictactoe {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// array to store values which is been intialized to zero
         char systemview[] = new char[9];
         char userview[] = new char[9];
         for(int i=0;i<9;i++) {
        	 systemview[i]=10; // 10 implies empty/blank
        	 userview[i]=' ';
         }
         
         System.out.println(" TIC TAC TOE ");
         System.out.println(" Instructions :\n Index number are as follows");
         System.out.println("  0 | 1 | 2 \n --- --- ---\n  3 | 4 | 5 \n --- --- ---\n  6 | 7 | 8 ");
         System.out.print("Don't enter same number twice" );
         System.out.println("\n "); 
         operation vv = new operation();
         int count = 0;
         int win = 100;
         int systemwin;
         char systemvalue = 1210;
         char uservalue = 1440;
         int result = 100;
       while(count<=8) {
		 if(count%2==0) {
			 System.out.println("Enter index number between 0 to 8");
             int value = sc.nextInt();
             System.out.println(systemview[value]);
             if(systemview[value]==10) {
            	 vv.usergo(value, systemview,userview);
        		 vv.display( systemview,userview);
        		 vv.checkforwin(systemview, result, count);
            }
             else {
            	 System.out.println("Warning! Don't be too smart\n Follow intructions");
            	 break;
             }
             
    		 if(count<8) {
    		 System.out.println("\nComputers turn ");
    		 System.out.println("\nEnter any digit/character to continue or 0 to quit");
    		 char check =sc.next().charAt(0);
    		// count++;
    		 if(check == 0) {
    			 break;
    		 }
    	   }
    	 }
    	 else {
    		if(count==1) {
    			vv.first( systemview,userview);
                vv.display( systemview,userview);
    		}
    		if(count==3) {
    			 win = vv.checkposswinuser(systemview,uservalue, result);
    			if(win!=100) {
    				vv.systemgo(win, systemview, userview);
    			    vv.display( systemview,userview);
    			}
    			else {
    				vv.maketwo(systemview, userview);
    				vv.display( systemview,userview);
    			}
    		}
    		if(count==5) {
    			win =100;
    			systemwin =100;
    			win = vv.checkposswinuser(systemview, uservalue, result);
    			systemwin =  vv.checkposswinuser(systemview, systemvalue, result);
    			if(systemwin!=100) {
    				vv.systemgo(systemwin, systemview, userview);
     			    vv.display( systemview,userview);
    			}
    			else if(win!=100) {
     				vv.systemgo(win, systemview, userview);
     			    vv.display( systemview,userview);
     			}
     			else {
     				vv.maketwo(systemview, userview);
     			    vv.display( systemview,userview);
     			}
    			
    		}
             
    	 if(count==7) {
    		 win =100;
 			systemwin =100;
 			win = vv.checkposswinuser(systemview, uservalue, result);
 			systemwin =  vv.checkposswinuser(systemview, systemvalue, result);
 			if(systemwin!=100) {
 				vv.systemgo(systemwin, systemview, userview);
  			    vv.display( systemview,userview);
 			}
 			else if(win!=100) {
  				vv.systemgo(win, systemview, userview);
  			    vv.display( systemview,userview);
  			}
 			else {
 				for(int markany=0; markany<9;markany++) {
 					if(systemview[markany]==10) {
 						vv.systemgo(markany, systemview, userview);
 		  			    vv.display( systemview,userview);
 		  			    markany = 9;
 					}
 						
 				}
 			}
    	  }
    	 }count++;
    	 vv.checkforwin(systemview, result, count);
    }
  } 
}
