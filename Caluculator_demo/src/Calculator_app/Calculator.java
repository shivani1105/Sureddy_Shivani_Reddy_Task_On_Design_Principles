package Calculator_app;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Calculator extends Applet implements ActionListener{
	
	String msg=" ";
	int v1,v2,result;
	TextField t;
	Button b[]=new Button[10];
	Button add,sub,mul,div,clear,equal;
	char op;
	public void init()
	{
		t=new TextField();
		t.setBounds(50,50,200,300);
		GridLayout g=new GridLayout(6,5);
		setLayout(g);
		for(int i=0;i<10;i++)
			b[i]=new Button(""+i);
		add=new Button("+");
		sub=new Button("-");
		mul=new Button("*");
		div=new Button("/");
		clear=new Button("clear");
		equal=new Button("=");
		t.addActionListener(this);
		add(t);
		for(int i=0;i<10;i++)
			add(b[i]);
		add(add);add(sub);add(mul);add(div);
		add(clear);add(equal);
		for(int i=0;i<10;i++)
			b[i].addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		clear.addActionListener(this);
		equal.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		char ch=s.charAt(0);
		if(Character.isDigit(ch))
			t.setText(t.getText()+s);
		else if(s.equals("add"))
		{
			v1=Integer.parseInt(t.getText());
			op='+';
			t.setText("");
		}
		else if(s.equals("sub"))
		{
			v1=Integer.parseInt(t.getText());
			op='-';
			t.setText("");
		}
		else if(s.equals("mul"))
		{
			v1=Integer.parseInt(t.getText());
			op='*';
			t.setText("");
		}
		else if(s.equals("div"))
		{
			v1=Integer.parseInt(t.getText());
			op='/';
			t.setText("");
		}
		if(s.contentEquals("equal"))
		{
			v2=Integer.parseInt(t.getText());
			if(op=='+')
				result=v1+v2;
			else if(op=='-')
				result=v1-v2;
			else if(op=='*')
				result=v1*v2;
			else if(op=='/')
				result=v1/v2;
			t.setText(""+result);
		}
		if(s.contentEquals("clear"))
			t.setText("");
	}

}
