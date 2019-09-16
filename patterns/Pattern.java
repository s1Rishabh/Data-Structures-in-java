package LOO2;

import java.util.Scanner;

public class Pattern
{   
   private static Scanner scn= new Scanner(System.in) ;  
	public static void main(String[] args) 
 	{  
	  int n=scn.nextInt()  ;
	 // starprint(n);
	   //starprint2(n);
	  starprint4(n);
      //Trainglepattern3(n);
	}
    
	public static void starprint(int n)
	{   
		for(int nst=1 ; nst<=n ; nst++)
		{ 
			for(int cst=1 ;cst<=nst;cst++)
			{ 
				System.out.print("*");
			}
			System.out.println();
		}
		
	} 
	
	public static void starprint2(int n)
	{ 
		for(int nst=1 ; nst<=n;nst++)
		{
		  for(int cst=n;cst>=nst;cst--)
		  { 
			  System.out.print("*");
		  }
		  System.out.println();
		}
		
	}
	
	public static void starprint3(int n )
	{ 
		for(int nst=1 ; nst<=n;nst++)
		{
			for(int nsp=n-1 ;nsp>=nst;nsp--)
			{ 
				System.out.print(" ");
			}
			
			for(int cst=1 ;cst<=nst ; cst++)
			{ 
				System.out.print("*");
			}
			System.out.println();
		}
	} 
	
	public static void starprint4(int n)
	{ 
	  for(int nst=1 ; nst<=n/2;nst++)
	  {  
		  for(int nsp=n/2;nsp>=nst;nsp--)
		  { 
			  System.out.print(" ");
		  } 
		  if(nst%2==0)
		  { 
		  for(int cst=1;cst<=nst+1; cst++)
		  { 
			  System.out.print("*");
		  } 
		  }  else
		  { 
		     for(int cst=1;cst<=nst ; cst++)
			  { 
				  System.out.print("*");
			  } 
			  
		  }
		  System.out.println();
	 }  
	  
	 for(int cst=1 ; cst<=n;cst++)
	   { 
		   System.out.print("*");
	   } 
	 System.out.println();
	  
	 for(int nst=((n/2)+1) ;nst<n ; nst++) 
	  { 
		 
		   for(int nsp=1 ; nsp<=nst/2;nsp++)
		   { 
			   System.out.print(" ");
		   } 
		   
		   if(nst%2!=0)
		   {   
		   for(int cst=1 ; cst<=nst;cst++)
		   { 
			   System.out.print("*");
		   }
		   }
		   else
		   { 
			   for(int cst=1 ; cst<nst/2;cst++)
			   { 
				   System.out.print("*");
			   }
			   
		   }
		   System.out.println();  
	  }
	  
   } 
	
private static void TrainglePattern(int n) 
{
		
		int nsp=n-1;
		int nst=1;
		for(int row=1;row<=n;row++) {
			
			for(int csp=1;csp<=nsp;csp++) {
				System.out.print(" ");
			}
			
			for(int cst=1;cst<=nst;cst++) {
				System.out.print("*");
			}
			
			
			nsp--;
			nst++;
			System.out.println();
		}
		
		
		
}
	
	private static void Trainglepattern2(int n )
	{
		int nst=5 , nsp=0 ; 
		
            for(int row=1;row<=n;row++)
            {
			
			for(int csp=1;csp<=nsp;csp++) {
				System.out.print(" ");
			}
			
			for(int cst=1;cst<=nst;cst++) {
				System.out.print("*");
			}
			
			
			nsp++;
			nst--;
			System.out.println();

            }
	} 
	
	private static void Trainglepattern3(int n )
	{
		int nst=1 , nsp=n/2, row ; 
		
		for( row=1; row<=n; row++)
		{ 
			for(int csp=1 ;csp<=nsp ; csp++)
			{ 
				System.out.print(" ");
			}
			for(int cst=1 ; cst<=nst;cst++)
			{ 
				System.out.print("*");
			}
	    if(row<=n/2)
		{ 
			nsp-- ; 
			nst+=2 ; 
		} 
		else 
		{ 
		 nsp++ ; 
		 nst-=2 ; 
		}  
   		System.out.println();
	  }        
	}
	 
	private static  void Trainglepattern4(int n)
	{  

		int nst=1 , nsp=n/2, row ; 
		
		for( row=1; row<=n; row++)
		{ 
			for(int csp=1 ;csp<=nsp ; csp++)
			{ 
				System.out.print("*");
			}
			for(int cst=1 ; cst<=nst;cst++)
			{ 
				System.out.print(" ");
			} 
			
			for(int csp=1 ;csp<=nsp ; csp++)
			{ 
				System.out.print("*");
			}
	    if(row<=n/2)
		{ 
			nsp-- ; 
			nst+=2 ; 
		} 
		else 
		{ 
		 nsp++ ; 
		 nst-=2 ; 
		}  
   		System.out.println();
	  }    
		
	}
	
	private static void Trainglepattern5(int n)
	{  
		
     int nst=1 , nsp=n/2, row ; 
		
		for( row=1; row<=n; row++)
		{ 
			for(int csp=1 ;csp<=nsp ; csp++)
			{ 
				System.out.print(" ");
			}
			for(int cst=1 ; cst<=nst;cst++)
			{ 
				System.out.print(cst);
			}
			
			
	    if(row<=n/2)
		{ 
			nsp-- ; 
			nst+=2 ; 
		} 
		else 
		{ 
		 nsp++ ; 
		 nst-=2 ; 
		}  
   		System.out.println();
	  } 	
	}
	
	
	
	
	
} 
