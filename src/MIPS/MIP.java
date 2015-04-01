package MIPS;

import java.util.HashMap;

/**
 * Created by ram on 7/8/14.
 */
public class MIP {
    private HashMap<String, String> symbols;

    public static void main(String[] args) {
        String line[] = {
                "addi $t, $t, 4",
                "sw $t1, 4($t0)",
                "beq $t0, $s5, Loop"
        };

        MIP m = new MIP();
        for (String s : line)
            m.exec(s);
    }

    MIP()
    {
        symbols = new HashMap<String, String>();
    }

    public void exec(String line) {
        line = line.replace(",", "");
        line = line.replace("$", "");
        String[] arg = line.split(" ");
        String cmd =  arg[0].toLowerCase();

        if (cmd.equals("addi"))
            addi(arg);
       else if (cmd.equals("beq"))
            beq(arg);
       else if (cmd.equals("sw"))
            sw(arg);
       else if (cmd.equals("bgez"))
            bgez(arg);
       else if (cmd.equals("bgez"))
            bgez(arg);
       else if (cmd.equals("blez"))
            bgez(arg);
       else if (cmd.equals("bgtz"))
            bgez(arg);
    }

    private static void pE() {
        System.out.println(";");
    }

    public static void addi(String arg[]) {
        if (arg[1].equals(arg[2])) {
            int v = Integer.parseInt(arg[3]);
            if (v == 1)
                System.out.print(arg[1] + "++");
            else if (v == -1)
                System.out.print(arg[1] + "--");
            else
                System.out.print(arg[1] + " += " + arg[3]);
        } else 
            System.out.print("int " + arg[1] + " = " + arg[2] + " + " + arg[3]);
        pE();
    }

    private void beq(String arg[]) {
        System.out.printf("if (%s == %s){\ngoto %s;\n}\n", arg[1], arg[2], arg[3]);
    }

    private void asciiz(String arg[]) {
        System.out.printf("char var[%d] = %s;\n", arg[1], arg[2]);
    }

    private void bgez(String arg[]) {
        System.out.printf("if (%s >= 0){\ngoto %s;\n}\n", arg[1], arg[2]);
    }

    private void blez(String arg[]) {
        System.out.printf("if (%s <= 0){\ngoto %s;\n}\n", arg[1], arg[2]);
    }

    private void bgtz(String arg[]) {
        System.out.printf("if (%s > 0){\ngoto %s;\n}\n", arg[1], arg[2]);
    }

    private  void bltz(String arg[]) {
        System.out.printf("if (%s < 0){\ngoto %s;\n}\n", arg[1], arg[2]);
    }

    private void bne(String arg[]) {
        System.out.printf("if (%s != %s){\ngoto %s;\n}\n", arg[1], arg[2], arg[3]);
    }

    public String between(String z, char a, char b) {
        return z.substring(z.indexOf(a) + 1, z.indexOf(b));
    }

    public void sw(String arg[]) {
        String v = between(arg[2], '(', ')');
        int size = Integer.parseInt(arg[2].replace("(" + v + ")", "")) / 4;
        System.out.println(v + "[" + size + "] = " + arg[1]);
    }

}

