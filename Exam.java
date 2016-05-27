import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Random;

public class Exam implements ActionListener,ItemListener {
	Statement stmt;
	ResultSet rs;
static	ProgressMonitor pm;
	JProgressBar jpb;
	JFrame jf1,jf2,jf3;
	JPanel jpquestion,jpbutton,jpfinish;
	JPanel jbar,jpre;//
	JButton jprev,jexitt;//
	JLabel jlf3,jlf31,jlextra,jlextra1,jlextra2,jlextra3;//
	JButton jbstart,jbexitatstart,jbprev,jbnext,jbfinish,jbexit,jbpreview;
	ButtonGroup jcb;
	JRadioButton jloptionA,jloptionB,jloptionC,jloptionD;
	JLabel jlquestion,jlscore;

	JFrame jfcbox;
	JPanel jpcboxquestion,jpcboxbutton;
	JCheckBox jcboxoptionB,jcboxoptionC,jcboxoptionD;
	JCheckBox jcboxoptionA;
	JLabel jlcboxquestion;
	JButton jbcboxprev,jbcboxnext,jbcboxfinish;
	
	Exam()
{try{
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	String url = "jdbc:mysql://localhost:3306/test?user=root&password=sidsql";

	Connection con = DriverManager.getConnection(url);// here student is envirment variable 
	stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	rs = stmt.executeQuery("select * from exam");
while(rs.next())
{
	System.out.println(rs.getString("Question"));
}

//con.close();
}
catch(Exception e)
{
	System.out.println(e.getMessage());
}
jf1 = new JFrame();
jf2= new JFrame();
jpquestion = new JPanel();
jpbutton = new JPanel();
jpfinish = new JPanel();
pm = new ProgressMonitor(jf2,"PM","score is",0,100);

jbstart = new JButton("Start");
jbexitatstart = new JButton("Exit");
jbprev = new JButton("Previous");
jbnext = new JButton("Next");
jbfinish = new JButton("Finish");
jbexit = new JButton("Exit");
jbpreview = new JButton("Preview");

jfcbox = new JFrame();
jpcboxquestion = new JPanel();
jpcboxbutton = new JPanel();
jlcboxquestion = new JLabel("bb");
jcboxoptionA = new JCheckBox("aa");
jcboxoptionB = new JCheckBox();
jcboxoptionC = new JCheckBox();
jcboxoptionD = new JCheckBox();
jbcboxnext = new JButton("Next");
jbcboxprev = new JButton("Previous");
jbcboxfinish = new JButton("Finish");

jcb = new ButtonGroup();
jlquestion = new JLabel("q");
jloptionA = new JRadioButton("a");
jloptionB = new JRadioButton("b");
jloptionC = new JRadioButton("c");
jloptionD = new JRadioButton("d");
jcb.add(jloptionA);
jcb.add(jloptionB);
jcb.add(jloptionC);
jcb.add(jloptionD);
jlscore = new JLabel();

//for frame 1
jlextra = new JLabel();
jlextra1 = new JLabel();
jlextra2 = new JLabel();
jlextra3 = new JLabel();
jf1.setLayout(new GridLayout(5,2));
jf1.setSize(650, 450);
jf1.add(jlextra);
jf1.add(jlextra1);
jf1.add(jlextra2);
jf1.add(jlextra3);
jf1.add(jbstart);
jf1.add(jbexitatstart);
jf1.setVisible(true);
jbstart.addActionListener(this);

//for frame check 3
jfcbox.setLayout(new BorderLayout());
jfcbox.setSize(650, 450);
jfcbox.add(jpcboxquestion,BorderLayout.CENTER);
jfcbox.add(jpcboxbutton,BorderLayout.SOUTH);
jpcboxquestion.setLayout(new GridLayout(5,1));

jpcboxquestion.add(jlcboxquestion);
jpcboxquestion.add(jcboxoptionA);
jpcboxquestion.add(jcboxoptionB);
jpcboxquestion.add(jcboxoptionC);
jpcboxquestion.add(jcboxoptionD);

jpcboxbutton.add(jbcboxprev);
jpcboxbutton.add(jbcboxnext);
jpcboxbutton.add(jbcboxfinish);
//jfcbox.setVisible(true);

//for frame 2

jf2.setSize(750, 500);
jf2.setLayout(new BorderLayout());

jpquestion.setLayout(new GridLayout(5,1));
jpquestion.add(jlquestion);
jpquestion.add(jloptionA);
jpquestion.add(jloptionB);
jpquestion.add(jloptionC);
jpquestion.add(jloptionD);
//jpquestion.add(pm);
jpbutton.add(jbprev);
jpbutton.add(jbnext);
jpbutton.add(jbfinish);
//jpbutton.add(jbpreview);
jbprev.setEnabled(false);
//action
jbnext.addActionListener(this);
jbprev.addActionListener(this);
jloptionA.addActionListener(this);
jloptionB.addActionListener(this);
jloptionC.addActionListener(this);
jloptionD.addActionListener(this);
jbpreview.addActionListener(this);
jbfinish.addActionListener(this);
jbexitatstart.addActionListener(this);
jcboxoptionA.addItemListener(this);
jbcboxnext.addActionListener(this);
jbcboxprev.addActionListener(this);
jbcboxfinish.addActionListener(this);
//jbcboxnext.addActionListener(this);

//jcboxoptionA.addItemListener(this);
//jcboxoptionA.addItemListener(this);
//jcboxoptionA.addItemListener(this);

jf2.add(jpquestion,BorderLayout.CENTER);
jf2.add(jpbutton,BorderLayout.SOUTH);
}
public static void main(String args[])
{
	Exam e = new Exam();
}


LinkedHashSet lhs = new LinkedHashSet();
Vector <Integer>v = new <Integer>Vector();
HashMap hm = new HashMap();
int count;
public void actionPerformed(ActionEvent ae) {
	if(ae.getActionCommand().equals("Start"))
	{
		Random rand = new Random();
		while(v.size()<=10)
		{int add=rand.nextInt(20)+1;
		System.out.println(add);
		if(lhs.add(add)){
		v.add(add);}
		else{
			
		}
		}
		try{rs.absolute(v.get(count));
//		jlquestion.setText(	"set");
	
	jloptionA.setText(rs.getString("OptionA"));
	jloptionB.setText(rs.getString("OptionB"));
	jloptionC.setText(rs.getString("OptionC"));
	jloptionD.setText(rs.getString("OptionD"));
	jlquestion.setText("1"+"."+rs.getString("Question"));
		}
		catch(SQLException sql)
		{System.out.println(sql.getMessage());
				}
		
		jf2.setVisible(true);
		jf1.setVisible(false);
	}
if(ae.getActionCommand().equals("Next"))
{System.out.println("heyynext");
if(count<9)
{
	
}
else
{jbcboxnext.setEnabled(false);
	return;
}
try{rs.absolute(v.get(count));

String  sbox2 =rs.getString("Answer");
if(sbox2.length()==2)
{
	callforcheck();
}
else{
	
}
}catch(SQLException sw)
{
	
}
	
	count++;
jbprev.setEnabled(true);

	try{rs.absolute(v.get(count));

	String  sbox2 =rs.getString("Answer");
if(sbox2.length()==2){
	jlcboxquestion.setText(count+1+"."+	rs.getString("Question"));
	jcboxoptionA.setText(rs.getString("OptionA"));
	jcboxoptionB.setText(rs.getString("OptionB"));
	jcboxoptionC.setText(rs.getString("OptionC"));
	jcboxoptionD.setText(rs.getString("OptionD"));
	jfcbox.setVisible(true);
	jf2.setVisible(false);
	}else{
		jfcbox.setVisible(false);
		jf2.setVisible(true);
		jlquestion.setText(count+1+"."+	rs.getString("Question"));
		jloptionA.setText(rs.getString("OptionA"));
		jloptionB.setText(rs.getString("OptionB"));
		jloptionC.setText(rs.getString("OptionC"));
		jloptionD.setText(rs.getString("OptionD"));
		
	}

}
catch(SQLException sqle)
{
	
}

	
String s2="";
if(count<9)
{
	
}else{
	jbnext.setEnabled(false);
jbcboxnext.setEnabled(false);
	//jbprev.setVisible(false);
}
if(pactive!=1){
if(hm.containsKey(count)){
String s =	(String)hm.get(count);
System.out.println(s);
if(s=="A")
jloptionA.setSelected(true);	
if(s=="B")
jloptionB.setSelected(true);	
if(s=="C")
jloptionC.setSelected(true);	
if(s=="D")
jloptionD.setSelected(true);	
}	
else{ jcb.clearSelection();
}
}
if(pactive==1)
{
	jloptionA.setBackground(Color.white);
	jloptionB.setBackground(Color.white);
	jloptionC.setBackground(Color.white);
	jloptionD.setBackground(Color.white);

	jloptionA.setSelected(false);
	jloptionB.setSelected(false);
	jloptionC.setSelected(false);
	jloptionD.setSelected(false);
jcboxoptionA.setSelected(false);
jcboxoptionA.setSelected(false);
jcboxoptionA.setSelected(false);
jcboxoptionA.setSelected(false);

	try{rs.absolute(v.get(count));
	 s2 =rs.getString("Answer");
	}
	catch(SQLException a){System.out.println(a.getMessage());}
if(s2.length()==2)
{String sfirst="",ssecond="";
	String s =	(String)hm.get(count);
try{ sfirst = s.substring(0, 1);
System.out.print("5963"+sfirst);
 ssecond = s.substring(1, 2);
}
catch (NullPointerException npe)
{
	
}if(sfirst=="A"|ssecond=="A")
{System.out.println("inside previous pactive A");
jcboxoptionA.setSelected(true);	
jcboxoptionA.setBackground(Color.red);

}
if(sfirst=="B"|ssecond=="B")
{System.out.println("inside previous pactive B");
jcboxoptionB.setSelected(true);	
jcboxoptionB.setBackground(Color.red);
	System.out.println("inside previous pactive D");

}
if(sfirst=="C"|ssecond=="C")
	
	{
	jcboxoptionC.setSelected(true);	
	jcboxoptionC.setBackground(Color.red);
	System.out.println("inside previous pactive D");

System.out.println("inside previous pactive C");
}
if(sfirst=="D"|ssecond=="D")
{jcboxoptionD.setSelected(true);	
jcboxoptionD.setBackground(Color.red);

	System.out.println("inside previous pactive D");

if(sfirst.equals("A")|ssecond.equals("A"))
{System.out.println("inside previous pactive A");
jcboxoptionA.setSelected(true);	
jcboxoptionA.setBackground(Color.green);
}
if(sfirst.equals("B")|ssecond.equals("B"))
{System.out.println("inside previous pactive B");
jcboxoptionB.setSelected(true);	
jcboxoptionB.setBackground(Color.green);
}
if(sfirst.equals("C")|ssecond.equals("C"))
{
	jcboxoptionC.setSelected(true);	
	jcboxoptionC.setBackground(Color.green);
System.out.println("inside previous pactive C");
}
if(sfirst.equals("D")|ssecond.equals("D"))
{jcboxoptionD.setSelected(true);	
jcboxoptionD.setBackground(Color.green);

System.out.println("inside previous pactive D");
}

}

}else{
	String s =	(String)hm.get(count);
System.out.println(s);
if(s=="A")
{System.out.println("inside previous pactive A");
jloptionA.setSelected(true);	
jloptionA.setBackground(Color.red);

}
if(s=="B")
{System.out.println("inside previous pactive B");
jloptionB.setSelected(true);	
jloptionB.setBackground(Color.red);
	System.out.println("inside previous pactive D");

}
if(s=="C")
	
	{jloptionC.setSelected(true);	
	jloptionC.setBackground(Color.red);
		System.out.println("inside previous pactive D");

System.out.println("inside previous pactive C");
}
if(s=="D")
{jloptionD.setSelected(true);	
jloptionD.setBackground(Color.red);
	System.out.println("inside previous pactive D");

}

if(s2.equals("A"))
{System.out.println("inside previous pactive A");
jloptionA.setSelected(true);	
jloptionA.setBackground(Color.green);
}
if(s2.equals("B"))
{System.out.println("inside previous pactive B");
jloptionB.setSelected(true);	
jloptionB.setBackground(Color.green);
}
if(s2.equals("C"))
{
jloptionC.setSelected(true);	
jloptionC.setBackground(Color.green);
System.out.println("inside previous pactive C");
}
if(s2.equals("D"))
{jloptionD.setSelected(true);	
jloptionD.setBackground(Color.green);
System.out.println("inside previous pactive D");
}
}

if(count<=9){
		try{
			rs.absolute(v.get(count));
jlquestion.setText(count+1+"."+	rs.getString("Question"));
jloptionA.setText(rs.getString("OptionA"));
jloptionB.setText(rs.getString("OptionB"));
jloptionC.setText(rs.getString("OptionC"));
jloptionD.setText(rs.getString("OptionD"));
	}
	catch(SQLException sql)
	{System.out.println(sql.getMessage());
			}
	}
}
}
if(ae.getActionCommand().equals("Previous"))
{count--;
String s2="";
jbnext.setEnabled(true);
System.out.println("pre");
if(count>0)
{
	
}else{
	jbprev.setEnabled(false);
//jbprev.setVisible(false);
}
if(pactive!=1){
if(hm.containsKey(count)){
String s =	(String)hm.get(count);
System.out.println(s);
if(s=="A")
jloptionA.setSelected(true);	
if(s=="B")
jloptionB.setSelected(true);	
if(s=="C")
jloptionC.setSelected(true);	
if(s=="D")
jloptionD.setSelected(true);	
}	
else{ //jcb.clearSelection();
}
}
if(pactive==1)
{
	jloptionA.setBackground(Color.white);
	jloptionB.setBackground(Color.white);
	jloptionC.setBackground(Color.white);
	jloptionD.setBackground(Color.white);
System.out.println("inside previous pactive");
jloptionA.setSelected(false);
jloptionB.setSelected(false);
jloptionC.setSelected(false);
jloptionD.setSelected(false);
try{
rs.absolute(v.get(count));
 s2 =rs.getString("Answer");
 System.out.print(s2);
}
catch(SQLException a)
{System.out.println(a.getMessage());}
String s="";
try
	{s =	(String)hm.get(count);}
	catch(Exception e ){System.out.println(e.getMessage());}
 
 System.out.println(s);
 if(s=="A")
 {System.out.println("inside previous pactive A");
 jloptionA.setSelected(true);	
 jloptionA.setBackground(Color.red);

 }
 if(s=="B")
 {System.out.println("inside previous pactive B");
 jloptionB.setSelected(true);	
 jloptionB.setBackground(Color.red);
 	System.out.println("inside previous pactive D");

 }
 if(s=="C")
 	
 	{jloptionC.setSelected(true);	
 	jloptionC.setBackground(Color.red);
 		System.out.println("inside previous pactive D");

 System.out.println("inside previous pactive C");
 }
 if(s=="D")
 {jloptionD.setSelected(true);	
 jloptionD.setBackground(Color.red);
 	System.out.println("inside previous pactive D");

 }

 if(s2.equals("A"))
 {System.out.println("inside previous pactive A");
 jloptionA.setSelected(true);	
 jloptionA.setBackground(Color.green);

 }
 if(s2.equals("B"))
 {System.out.println("inside previous pactive B");
 jloptionB.setSelected(true);	
 jloptionB.setBackground(Color.green);


 }
 if(s2.equals("C"))
 {jloptionC.setSelected(true);	
 jloptionC.setBackground(Color.green);

 System.out.println("inside previous pactive C");
 }
 if(s2.equals("D"))
 {jloptionD.setSelected(true);	
 jloptionD.setBackground(Color.green);
 	System.out.println("inside previous pactive D");


 	
 }	
}
if(count>=0){
		try{ 
			rs.absolute(v.get(count));
			s2 =rs.getString("Answer");
			if(s2.length()==2)
			{
System.out.println("inside update");
				jlcboxquestion.setText(count+1+"."+	rs.getString("Question"));
	jcboxoptionA.setText(rs.getString("OptionA"));
	jcboxoptionB.setText(rs.getString("OptionB"));
	jcboxoptionC.setText(rs.getString("OptionC"));
	jcboxoptionD.setText(rs.getString("OptionD"));
				
			}else{
				
			}
			jlquestion.setText(count+1+"."+	rs.getString("Question"));
jloptionA.setText(rs.getString("OptionA"));
jloptionB.setText(rs.getString("OptionB"));
jloptionC.setText(rs.getString("OptionC"));
jloptionD.setText(rs.getString("OptionD"));
	}
	catch(SQLException sql)
	{System.out.println(sql.getMessage());
			}
	}
else{
	jbprev.setEnabled(true);
}

}
Object obj;
obj=ae.getSource();
if(obj.equals(jloptionA))
{
hm.put(count, "A");	
}
if(obj.equals(jloptionB))
{
hm.put(count, "B");	
}
if(obj.equals(jloptionC))
{
hm.put(count, "C");	
}
if(obj.equals(jloptionD))
{
hm.put(count, "D");	
}

if(ae.getActionCommand().equals("Finish"))
{count=0;
int marks=0;
try{while(count<10)
{
	String s = (String)hm.get(count);
	System.out.println(s);
rs.absolute(v.get(count));
String s2 = rs.getString("Answer");
System.out.println(s2);
try{if(s.equals(s2))
{System.out.println("inside");
	marks++;
}}catch(Exception e)
{
	//System.out.println(e.getMessage());
}
count++;
}
}
catch(SQLException s)
{
	System.out.println(s.getMessage());
}
System.out.println(marks);
	jpb = new JProgressBar(JProgressBar.HORIZONTAL,0,100);
jf3 = new JFrame();
jf3.setSize(450,150);
jf3.setVisible(true);
jf3.setLayout(new BorderLayout());
jlf3 = new JLabel("your score is "+marks*10+"%");
jlf31 = new JLabel("");
jprev = new JButton("Preview");
jexitt = new JButton("Exit ");
jexitt.addActionListener(this);
	jpb.setValue(marks*10);
	jbar = new JPanel();
	jbar.setLayout(new GridLayout(3,1));
	jpre = new JPanel();
	jbar.add(jlf31);
	jbar.add(jlf3);
	jbar.add(jpb);
	jpre.add(jbpreview);
	jpre.add(jexitt);
	jf2.setVisible(false);
	jf3.add(jbar,BorderLayout.CENTER);
	jf3.add(jpre,BorderLayout.SOUTH);
	
}

if(ae.getActionCommand().equals("Preview"))
{jf3.setVisible(false);
jf2.setVisible(true);
	System.out.println("preview active");
	pactive=1;
	jcb.remove(jloptionA);
	jcb.remove(jloptionB);
	jcb.remove(jloptionC);
	jcb.remove(jloptionD);
count=0;
jbnext.setEnabled(true);
jbprev.setEnabled(false);
try{rs.absolute(v.get(count));
jlquestion.setText(	"set");
jlquestion.setText(	rs.getString("Question"));
jloptionA.setText(rs.getString("OptionA"));
jloptionB.setText(rs.getString("OptionB"));
jloptionC.setText(rs.getString("OptionC"));
jloptionD.setText(rs.getString("OptionD"));


}
catch(SQLException sql)
{System.out.println(sql.getMessage());
		}
String s2="";
if(pactive==1)
{
	jloptionA.setBackground(Color.white);
	jloptionB.setBackground(Color.white);
	jloptionC.setBackground(Color.white);
	jloptionD.setBackground(Color.white);

System.out.println("inside previous pactive");
jloptionA.setSelected(false);
jloptionB.setSelected(false);
jloptionC.setSelected(false);
jloptionD.setSelected(false);
try{
rs.absolute(v.get(count));
 s2 =rs.getString("Answer");
 System.out.print(s2);
}
catch(SQLException a)
{System.out.println(a.getMessage());}
String s="";
try
	{s =	(String)hm.get(count);}
	catch(Exception e ){System.out.println(e.getMessage());}
 
 System.out.println(s);
if(s=="A")
{System.out.println("inside previous pactive A");
jloptionA.setSelected(true);	
jloptionA.setBackground(Color.red);

}
if(s=="B")
{System.out.println("inside previous pactive B");
jloptionB.setSelected(true);	
jloptionB.setBackground(Color.red);
	System.out.println("inside previous pactive D");

}
if(s=="C")
	
	{jloptionC.setSelected(true);	
	jloptionC.setBackground(Color.red);
		System.out.println("inside previous pactive D");

System.out.println("inside previous pactive C");
}
if(s=="D")
{jloptionD.setSelected(true);	
jloptionD.setBackground(Color.red);
	System.out.println("inside previous pactive D");

}

if(s2.equals("A"))
{System.out.println("inside previous pactive A");
jloptionA.setSelected(true);	
jloptionA.setBackground(Color.green);

}
if(s2.equals("B"))
{System.out.println("inside previous pactive B");
jloptionB.setSelected(true);	
jloptionB.setBackground(Color.green);


}
if(s2.equals("C"))
{jloptionC.setSelected(true);	
jloptionC.setBackground(Color.green);

System.out.println("inside previous pactive C");
}
if(s2.equals("D"))
{jloptionD.setSelected(true);	
jloptionD.setBackground(Color.green);
	System.out.println("inside previous pactive D");


	
}
}
jloptionA.setEnabled(false);
jloptionB.setEnabled(false);
jloptionC.setEnabled(false);
jloptionD.setEnabled(false);

}
if(ae.getActionCommand().equals("Exit "))
{
	System.exit(1);
	
}
if(ae.getActionCommand().equals("Exit"))
{
	System.exit(1);
}
}
int pactive;

	public void callforcheck()
	{String sb="";
		if(jcboxoptionA.isSelected())
		{
			sb+="A";
		}
		if(jcboxoptionB.isSelected())
		{

			sb+="B";
			
		}
		if(jcboxoptionC.isSelected())
		{
			sb+="C";
					
		}
		if(jcboxoptionD.isSelected())
		{
			sb+="D";
			
		}
	hm.put(count, sb);
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
