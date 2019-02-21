public class Jabeja {

    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.next());
        String u = sc.next();
        String v = sc.next();
        int v_aval = s.indexOf(v);
        int u_last = s.lastIndexOf(u);
        if (v_aval != -1 && u_last != -1) { //none of the above
            s.replace(v_aval, (v_aval + v.length()) , u);
        // nedd TODO work!
        }
        // doesnt need if,else
        if (v_aval == -1 && u_last != -1) { //just v
            s.replace(u_last, u_last + u.length(), v);
        }

        if (u_last == -1 && v_aval != -1) { //just v
            s.replace(v_aval, v_aval + v.length(), u);
        }
        // if none of the above : s is main s!
        System.out.println(s);
    }
}
