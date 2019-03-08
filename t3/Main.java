class Main{
		public static void main(String[] args) {
			BigNum bigNum1 = new BigNum("123");
			BigNum bigNum2 = new BigNum("456");
			System.out.println(bigNum1.add(bigNum2));
			System.out.println(bigNum1.multiply(bigNum2));
			System.out.println(bigNum1.subtract(bigNum2));
			System.out.println(bigNum2.remainder(bigNum1));
			System.out.println(bigNum1);
			System.out.println(bigNum2);
			System.out.println();

			bigNum1 = new BigNum("+1234567");
			bigNum2 = new BigNum("-987654");
			System.out.println(bigNum1.add(bigNum2));
			System.out.println(bigNum1.multiply(bigNum2));
			System.out.println(bigNum1.subtract(bigNum2));
			System.out.println(bigNum1);
			System.out.println(bigNum2);
			System.out.println();

			bigNum1 = new BigNum("-123");
			bigNum2 = new BigNum("123");
			System.out.println(bigNum1.add(bigNum2));
	
	}


}
