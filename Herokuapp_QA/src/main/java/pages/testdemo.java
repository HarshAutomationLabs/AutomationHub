package pages;

public class testdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0, n=0, i=1, j=1;
		while(n<25) {
			a=0;
		}
		
		while(j<=i) {
			if(j%i==0) {
				a++;
				j++;
			}
		}
		
		if(a==2) {
			System.out.println(i);
			n++;
		}
		i++;
	}

}
