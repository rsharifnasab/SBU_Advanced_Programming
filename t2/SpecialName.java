class SpecialName {


    public static void cleaner(StringBuilder s) {
       for (int i=0;i<s.length();i++) {
         char c = s.charAt(i);
         if ( c >= 'a' && c <= 'z' ) continue;
         if ( c >= 'A' && c <= 'Z' ) continue;
         if ( c >= '0' && c <= '9' ) continue;
         //if ( c=='!' || c=='.' || c==' ') continue;
         //if ( c=='-' || c=='_' || c==' ') continue;
         s.deleteCharAt(i);
         i--;
       }
    }

    public static void main(String[] args) {

        java.util.Scanner inp= new java.util.Scanner(System.in);

        String pre,t = inp.next();
        while(inp.hasNext()){
          pre = t;
          t = inp.next();
          char last = pre.charAt(pre.length()-1);;

          if(t.length()<3) continue;
          if(Character.isLowerCase(t.charAt(0))) continue;
          if(last == '.' || last == '!') continue;
          //System.err.print("last="+pre + " : ");Sir Daniel Michael Blake Day-Lewis (born 29 April 1957) is an English actor who holds both British and Irish citizenship. Born and raised in London, he excelled on stage at the National Youth Theatre, before being accepted at the Bristol Old Vic Theatre School, which he attended for three years.
          StringBuilder cleand = new StringBuilder(t);
          cleaner(cleand);
          System.out.print(cleand+ "\n");
        }

    }
}
