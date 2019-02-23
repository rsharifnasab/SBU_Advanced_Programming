class SpecialName2 {


    public static String cleaner(String main,String order) {
      StringBuilder s = new StringBuilder(main);
       for (int i=0;i<s.length();i++) {
         char c = s.charAt(i);
         if ( c >= 'a' && c <= 'z' ) break;
         if ( c >= 'A' && c <= 'Z' ) break;
         if ( c >= '0' && c <= '9' ) break;
         //if ( c=='!' || c=='.' || c==' ') continue;
         //if ( c=='-' || c=='_' || c==' ') continue;
         s.deleteCharAt(i);
         i--;
       }


      s = s.reverse();
      for (int i=0;i<s.length();i++) {
         char c = s.charAt(i);
         if ( c >= 'a' && c <= 'z' ) break;
         if ( c >= 'A' && c <= 'Z' ) break;
         if ( c >= '0' && c <= '9' ) break;
         //if ( c=='!' || c=='.' || c==' ') continue;
         //if ( c=='-' || c=='_' || c==' ') continue;
         s.deleteCharAt(i);
         i--;
       }
       s = s.reverse();

       if(s.length()>=2 && order == "print") System.out.println(s);
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
          String thiis = cleaner(all[i],"return");
          //String last = cleaner(all[i-1],"return");
          if(!isUpperCase(thiis.charAt(0))) continue;
          char ch = all[i-1].charAt(all[i-1].length()-1);
          if(ch=='!' || ch=='.') continue;
          cleaner(all[i],"print");

        }
    }
}
