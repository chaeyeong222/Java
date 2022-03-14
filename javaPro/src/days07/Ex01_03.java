package days07;

public class Ex01_03 {
	public static void main(String[] args) {
		/*  2 3 4
		 *  5 6 7 
		 *  8 9
		  
		 
		for(int i = 1; i<=3; i++) {
			for(int j = 2; j<=9; j++) {
				for(int dan = i*2+(i-1); dan<=i*3+1; dan++) {
					if(dan ==10) {
						break;
					}
					System.out.printf("%d*%d=%d\t", dan, j, dan*j);
                }System.out.println();
			}
		} System.out.println("-----------------------");
		
		 for(int i = 1; i<=3; i++) {
			System.out.println("i="+i);
			 for(int j = 2; j<=9; j++) {
				for(int dan = i*3-1; dan<=i*3-1+2; dan++) {
					if(dan ==10)			break ;  //비효율적임. p.178
					System.out.printf("%d*%d=%d\t", dan, j, dan*j);
                }System.out.println();
			}
		}
		*/
		 for(int i = 1; i<=3; i++) {
				System.out.println("i="+i);
				 for(int j = 2; j<=9; j++) {
					for(int dan = i*3-1; dan<=i*3-1+2 && dan!=10; dan++) {
						System.out.printf("%d*%d=%d\t", dan, j, dan*j);
	                }System.out.println();
				}
			}
		
	}

}
