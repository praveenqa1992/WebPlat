package testCases;

public class tryyyyy {

	
	
	public static void main(String[] args) {
		
	
		
		
	String aaa=	"Showing 1 to 5 of 1433 entries";
		
		String[] aspStrings = aaa.split(" ");
		
//		System.out.println(aspStrings);
//		System.out.println(aspStrings.length);
//
//		System.out.println(aspStrings);

		String firstNo = null;
		String lastNo = null;
		String totalTxns = null;
		
		
		for(int a=0;a<=(aspStrings.length-1);a++) 
		{
			System.out.println("index - value"+a+"-"+aspStrings[a]);

			
			
			if(a==0 || a==2 || a==4 || a==6)
			{
				continue;
			}
			else 
			{
				if(a==1) 
				{
					 firstNo = aspStrings[a];
				}
				else if(a==3) 
				{
					 lastNo = aspStrings[a];
				}
				else if(a==5) 
				{
					 totalTxns = aspStrings[a];
				}
				
			}

		}
		
		System.out.println("1 st no -"+firstNo);
		System.out.println("last no -"+lastNo);
		System.out.println("total nos -"+totalTxns);

		
		
	}
	
	
}
