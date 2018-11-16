package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

public class Test {

	public static void main(String[] args) {
	/*	DoubleLinkedList a =  new DoubleLinkedList();
		a.add(0);
		a.add(1);



		for(int i=0 ; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
		a.add(2,"d");
		for(int i=0 ; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
		int i = 6;
		int e = 7;
		String s = "";
		s += i ;
		s += e ;
		System.out.println(s)
		;

		int[][]terms = {{2,5},{2,7},{2,6}};


		 b.setPolynomial('A', terms);
		 System.out.println(b.A.get(0));
		 System.out.println(b.A.get(1));
		 System.out.println(b.A.get(2));
		 System.out.println(b.A.get(3));
		 System.out.println(b.A.get(4));
		 System.out.println(b.A.get(5));*/

		MyPolynomialSolver  b = new MyPolynomialSolver() ;
		 int[][]terms1 = {{3,7}, {45,5}, {176,3}, {128,1}};
		 b.setPolynomial('A', terms1);
		 int[][]terms2 = {{-120,5}, {-1,3}, {27,2}, {1,1}, {-1,0}};
		 b.setPolynomial('B', terms2);
	//	  int [][] terms3 = b.subtract('A', 'B');
		  for (int i = 0;i<b.r.size();i++ ) {

			  System.out.println(b.r.get(i));
		  }
		// System.out.println(b.evaluatePolynomial('B', (float)2.000));
		  String s = b.print('R');

		//  System.out.println(s);
		 // s = b.print('B');
		  System.out.println(s);
	/*	  for (int i = 0;i<b.R.size();i++ ) {

				  System.out.println(b.R.get(i));
			  }
*/

	/*  String s = b.print('B');

		 System.out.println(s);
		  for (int i = 0;i<terms2.length;i++ ) {
			  for(int j=0;j < terms2[0].length;j++) {
				  System.out.println(terms2[i][j]);

			  }

		  }

*/







	}

}
