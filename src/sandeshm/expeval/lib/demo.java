package sandeshm.expeval.lib;

public class demo {
    public static void main(String[] args) {
        StringBuffer sa = new StringBuffer("2 + ( 3 * 5)");
        int i1 = sa.indexOf("(");
        int i2 = sa.indexOf(")");
        String newstr = sa.substring(i1+1, i2);
        System.out.println(newstr);
    }
}
