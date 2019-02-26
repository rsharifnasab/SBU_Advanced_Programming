public class Jabeja2 {

    public static String bishMaker(int t,char c){
      StringBuilder str = new StringBuilder();
      for (int i=0;i<t ; i++) {
        str.append(c);
      }
      return str.toString();
    }

    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.next());
        final String u = sc.next();
        final String v = sc.next();
        int u_len = u.length();
        int v_len = v.length();
        final int bish = (u_len>v_len)? u_len : v_len;

        int v_aval = s.indexOf(v);
        if(v_aval != -1)
          s.replace(v_aval, ( v_aval + v.length() ) , bishMaker(bish,'-'));

        int u_last = s.lastIndexOf(u);
        if (u_last != -1)
            s.replace(u_last , ( u_last + u.length() ) , bishMaker(bish,'#'));

        v_aval = s.indexOf(Character.toString('-'));
        if(v_aval != -1)
          s.replace(v_aval, (v_aval + bish) , u);

        u_last = s.indexOf(Character.toString('#'));
        if (u_last != -1)
            s.replace(u_last ,(u_last + bish) , v);

        System.out.println(s);
    }
}
