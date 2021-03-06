package jlog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author yasyf
 */
public class JLog {
//static variables
    public static Double base;
    public static Double x;
    
    // 0 = log
    // 1 = ln
    public static int function;

    public static void main(String[] args) {
       //JOptionPane lines are merely for functional GUI purposes        
        String[] options = new String[]{"log", "ln"};
        function = JOptionPane.showOptionDialog(null, "Which Function?", "JLog", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        
        //calculator runs the following on button press
        //determine what variation of function was intended
        if (function == 0) {

            try {

                base = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Base"));
            } catch (NumberFormatException ex) {
                base = null;
            }
        } else if (function == 1) {
            base = Math.E;
        }

        try {
            x = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter x"));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Value for x must be specified");
            System.exit(1);
        }

        //calculate the answer, depending on what function was intended
        if (base != null) {

            if (base == Math.E) {
                result("ln(" + x + ")");

            }
            result("log(" + x + "," + base + ")");

        } else {
            result("log(" + x + ")");

        }
        System.exit(0);

    }

    public static double c_log(Double x, Double base) {
        //This is the function your calculator runs to actually calculate the log behind the scenes
        if (base != null) {
            return Math.log(x) / Math.log(base);
        } else {
            base = 10.0;
            return Math.log(x) / Math.log(base);
        }

    }

    public static void result(String message) {
        //display GUI prompt of result
        JOptionPane.showMessageDialog(new JDialog(), message + " = " + c_log(x, base), message, JOptionPane.INFORMATION_MESSAGE);

    }
}
