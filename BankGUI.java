import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BankAccount{
    private double balance = 0;

    public void deposit(double amount){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }
    public double getBalance(){
        return balance;
    }
}
public class BankGUI extends JFrame implements ActionListener{
    BankAccount account = new BankAccount();

    JLabel label;
    JTextField amountField;
    JButton depositBtn, withdrawbtn, balancebtn;

    BankGUI(){
        setTitle("Bank managemt system");
        setSize(5000,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Enter Amount:");
        amountField = new JTextField(15);

        depositBtn = new JButton("deposit");
        withdrawbtn= new JButton("withdraw");
        balancebtn = new JButton("check balance");

        depositBtn.addActionListener(this);
        withdrawbtn.addActionListener(this);
        balancebtn.addActionListener(this);

        add(label);
        add(amountField);
        add(depositBtn);
        add(withdrawbtn);
        add(balancebtn);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        try{
            double Amount = 0;

            if(!amountField.getText().isEmpty()){
                Amount = Double.parseDouble(amountField.getText());
            }
            if(e.getSource() == depositBtn){
                account.deposit(Amount);
                JOptionPane.showMessageDialog(this,"Deposited: ₹" + Amount);
            }
            else if(e.getSource() == withdrawbtn){
                if(account.withdraw(Amount)){
                    JOptionPane.showMessageDialog(this, "withdraw :₹" + Amount);
                } else{
                    JOptionPane.showMessageDialog(this, "insufficient balance");
                }
            }
            else if(e.getSource() == balancebtn){
                JOptionPane.showMessageDialog(this,"balance: ₹"+ account.getBalance());
            }
            amountField.setText("getName()");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Enter Valid Amount");
        }
    }

    public static void main(String[] args){
        new BankGUI();
    }
}
