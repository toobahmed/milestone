/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.Date;
import javax.swing.JOptionPane;

public class PrintSale extends ViewSales implements Printable {

    @Override
    public int print(Graphics g, PageFormat pf, int i) throws PrinterException {
        if (i > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        write(g);
        return PAGE_EXISTS;
        //To change body of generated methods, choose Tools | Templates.
    }

    void write(Graphics g) {
        try {

            final int x1 = 75;
            final int x2 = 250;
            int y = 100;
            int i = 15;
            Font f = new Font("Diavlo Book", Font.BOLD, 14);
            Font f1 = new Font("Monospac821 BT", Font.PLAIN, 12);
            Font f2 = new Font("Monospac821 BT", Font.BOLD, 14);
            g.setFont(f);
            g.drawString("Milestone Rent-a-car", x1, y);


            g.setFont(f2);
            y += 75;
            g.drawString("Sales Invoice Number", x1, y);
            g.drawString(": " + rs.getInt("sid"), x2, y);
            y += 25;
            g.drawString("VEHICLE DETAILS", x1, y);
            g.setFont(f1);
            y += 25;
            g.drawString("Registration No", x1, y);
            g.drawString(": " + rs.getString("reg_no"), x2, y);
            y += i;
            g.drawString("Make", x1, y);
            g.drawString(": " + rs.getString("make"), x2, y);
            y += i;
            g.drawString("Model and Year", x1, y);
            g.drawString(": " + rs.getString("model") + " " + rs.getString("f_year"), x2, y);
            y += i;
            g.drawString("Color and Type", x1, y);
            g.drawString(": " + rs.getString("color") + " " + rs.getString("type"), x2, y);
            y += i;
            g.drawString("Rate", x1, y);
            g.drawString(": " + rs.getFloat("rate"), x2, y);
            y += i;
            g.drawString("Dispatch Time", x1, y);
            g.drawString(": " + new Date(rs.getLong("dispatch_time")).toString(), x2, y);
            y += i;
            g.drawString("Return Time", x1, y);
            g.drawString(": " + new Date(rs.getLong("return_time")).toString(), x2, y);
            long duration = rs.getLong("return_time") - rs.getLong("dispatch_time");
            y += i;
            g.drawString("Duration", x1, y);
            g.drawString(": " + Integer.toString((int) java.lang.Math.ceil(duration / (3600.0 * 24.0 * 1000.0))) + " Days", x2, y);
            y += i;
            g.drawString("Distance Driven", x1, y);
            g.drawString(": " + rs.getFloat("distance_driven") + " Km", x2, y);
            y += 25;
            g.setFont(f2);
            g.drawString("CUSTOMER DETAILS", x1, y);
            g.setFont(f1);
            y += 25;
            g.drawString("Licence No", x1, y);
            g.drawString(": " + rs.getString("licence"), x2, y);
            y += i;
            g.drawString("Name", x1, y);
            g.drawString(": " + rs.getString("name"), x2, y);
            y += i;
            g.drawString("Phone", x1, y);
            g.drawString(": " + rs.getString("phone"), x2, y);
            y += i;
            g.drawString("Address", x1, y);
            g.drawString(":  " + rs.getString("address"), x2, y);
            y += 25;
            g.setFont(f2);
            g.drawString("PAYEMENT DETAILS", x1, y);
            g.setFont(f1);
            y += 25;
            g.drawString("Rent for duration", x1, y);
            g.drawString(": Rs " + rs.getFloat("base_amt"), x2, y);
            y += i;
            g.drawString("Extra Charges (if any)", x1, y);
            g.drawString(": Rs " + rs.getFloat("extra_charges"), x2, y);
            y += 25;
            g.drawString("Total Amount", x1, y);
            g.drawString(": Rs " + rs.getFloat("total_amt"), x2, y);
            y += i;
            g.drawString("Deposit", x1, y);
            g.drawString(": Rs " + rs.getFloat("deposit"), x2, y);
            y += 25;
            g.drawString("AMOUNT PAID", x1, y);
            g.drawString(": Rs " + (rs.getFloat("total_amt") - rs.getFloat("deposit")), x2, y);

            g.setFont(f2);
            g.drawString("Customer Signature", x1, 700);
            g.drawString("Salesman Signature", 400, 700);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }
}
