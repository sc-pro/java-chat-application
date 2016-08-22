import java.net.*;
import java.io.*;
import javax.swing.*;
class Client extends JOptionPane{
    public static void main(String args[])throws Exception{
        String ip=JOptionPane.showInputDialog("IP address of the server");
        Socket s=new Socket(ip,3333);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str="",str2="";
        while(!str.equals("stop")){
            str=JOptionPane.showInputDialog("");
            dout.writeUTF(str);
            dout.flush();
            str2=din.readUTF();
            JOptionPane.showMessageDialog(null,str2,"Reply",JOptionPane.PLAIN_MESSAGE);
        }

        dout.close();
        s.close();
    }}