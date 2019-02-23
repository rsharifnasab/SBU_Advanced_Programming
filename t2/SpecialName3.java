class SpecialName3 {


    public static String cleaner(String main) {
      StringBuilder s = new StringBuilder(main);
      int index = s.length()-1;
      char c = s.charAt(index);
      if(c == ',' || c == '.' || c == ')' || c == '(' || c == '?' ) s.deleteCharAt(index);

      //index = 0;
      //c = s.charAt(index);
      //if(c == ',' || c == '.' || c == ')' || c == '(' ) s.deleteCharAt(index);

      return s.toString();
    }

  public static boolean isUpperCase(char c){
    if(c>='A' && c<= 'Z') return true;
    return false;
  }


    public static void main(String[] args) {

        java.util.Scanner inp= new java.util.Scanner(System.in);

        String[] all = inp.nextLine().split(" ");

        for(int i=1;i<all.length;i++){
          String thiis = cleaner(all[i]);
          if(!isUpperCase(thiis.charAt(0))) continue;
          char ch = all[i-1].charAt(all[i-1].length()-1);
          if(ch=='!' || ch=='.' || ch=='?') continue;
          if (thiis.length()>1) System.out.println(thiis);
        }
    }
}
