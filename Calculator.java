//Importing Libraries
import java.awt.*;
import java.math.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

//Creating Class
class CFrame extends JFrame
{
	//Creating Frame
	CFrame()
	{
		//Creating Tab Pane
		JTabbedPane jtp=new JTabbedPane(JTabbedPane.LEFT);

		//Creating Tabs 
		jtp.add("Calculator",new CalculatorTab());
		jtp.add("Unit Converter",new UnitConverterTab());
		jtp.add("More",new MoreTab());
		jtp.setFont(new Font("Helvetica", Font.BOLD, 24));

		//Creating Container
		Container c=getContentPane();

		//Adding Tabs to Container
		c.add(jtp);
	}
	public static void main(String ar[])
	{
		//Creating Main Frame
		CFrame f=new CFrame();

		//Frame Titling
		f.setTitle("Calculator");

		//Setting Frame Size
		f.setSize(600,400);
		f.setResizable( false );

		//Setting Frame Visibility
		f.setVisible(true);

		//Close Operation
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
//Calculator Tab
class CalculatorTab extends JPanel implements ActionListener
{
	JTextField tf;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18;
    String sm="",s1="",s2="",o1="",o2="";
	double i=0,j=0,k=0,sc;
    CalculatorTab()
	{
		//Creating Label Panel
		JPanel LabelPanel = new JPanel();

		//Creating Label
		JLabel Cal=new JLabel("Calculator");
        Cal.setFont(new Font("Helvetica", Font.BOLD, 28));

		//Applying Border Layout
		LabelPanel.setLayout(new BorderLayout());

		//Adding Label to Panel
		LabelPanel.add(Cal,"North");
		Cal.setHorizontalAlignment(JLabel.CENTER);
		Cal.setVerticalAlignment(JLabel.CENTER);

		//Creating Text Field Panel
		JPanel tfPanel = new JPanel();

		//Creating Text Field
		tf= new JTextField(16);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setEditable(false);

		//Adding Text Field to Panel
		tfPanel.add(tf);

		//Creating Calculator Buttons Panel
		JPanel CalPanel = new JPanel();

		//Applying Grid Layout
		CalPanel.setLayout(new GridLayout(4,5,5,5));

		//Creating Buttons
		b1=new JButton("7");
		b2=new JButton("8");
		b3=new JButton("9");
		b4=new JButton("/");
		b5=new JButton("-");
		b6=new JButton("4");
		b7=new JButton("5");
		b8=new JButton("6");
		b9=new JButton("X");
		b10=new JButton("+");
		b11=new JButton("1");
		b12=new JButton("2");
		b13=new JButton("3");
		b14=new JButton("CE");
		b15=new JButton("AC");
		b16=new JButton("0");
		b17=new JButton(".");
		b18=new JButton("=");

        //Adding Action Listener to Buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);

		//Adding Colors to Buttons
		b4.setBackground(Color.orange);
		b5.setBackground(Color.orange);
		b9.setBackground(Color.orange);
		b10.setBackground(Color.orange);
		b14.setBackground(Color.cyan);
		b15.setBackground(Color.red);
		b17.setBackground(Color.gray);
		b18.setBackground(Color.green);

		//Adding Buttons to Panel
		CalPanel.add(b1);
		CalPanel.add(b2);
		CalPanel.add(b3);
		CalPanel.add(b4);
		CalPanel.add(b5);
		CalPanel.add(b6);
		CalPanel.add(b7);
		CalPanel.add(b8);
		CalPanel.add(b9);
		CalPanel.add(b10);
		CalPanel.add(b11);
		CalPanel.add(b12);
		CalPanel.add(b13);
		CalPanel.add(b14);
		CalPanel.add(b15);
		CalPanel.add(b16);
		CalPanel.add(b17);
		CalPanel.add(b18);

		//Creating Main Panel
		JPanel mp = new JPanel();

		//Box Layout
		mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));

		//Adding Panels to Main Panel
		mp.add(LabelPanel);
		mp.add(tfPanel);
		mp.add(CalPanel);
		
		//Adding tp to Frame
		add(mp);
	}
    public void actionPerformed(ActionEvent e1)
    {
        //Creating String to store the value of the button
		String s=e1.getActionCommand();
		
		//Algorithm
		if((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.')
        {
            sm=sm.concat(s);
			if(!o1.equals(""))
			{
				s2=sm;
				System.out.println("s1="+s1+" o1="+o1+" s2="+s2);
				tf.setText(s2);
			}
			else
			{
				s1=sm;
				System.out.println("s1="+s1);
				tf.setText(s1);
			}
        }
		else if (s.charAt(0) == 'X' || s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '/' || s.charAt(0) == '%') 
        {
			sm=sm.concat(s);
			if(o1.equals(""))
			{
				o1=sm.replaceAll("[0-9]", "");
				sm="";
				tf.setText(s1+" "+o1);
			}
			else
			{
				o2=sm.replaceAll("[0-9]", "");

				//Calculation Algorithm
				if (o1.equals("+") || o1.equals(".+"))
				{
					sc = (Double.parseDouble(s1) + Double.parseDouble(s2));
					s1=String.valueOf(sc);
					System.out.println("s1="+s1);
					tf.setText(s1+(sm.replaceAll("[0-9]", "")));
					sm="";
					s2="";
					o1=o2;
						
				}
				else if (o1.equals("-"))
				{
					sc = (Double.parseDouble(s1) - Double.parseDouble(s2));
					s1=String.valueOf(sc);
					tf.setText(s1+(sm.replaceAll("[0-9]", "")));
					sm="";
					s2="";
					o1=o2;
				}
				else if (o1.equals("X"))
				{
					sc = (Double.parseDouble(s1) * Double.parseDouble(s2));
					s1=String.valueOf(sc);
					tf.setText(s1+(sm.replaceAll("[0-9]", "")));
					sm="";
					s2="";
					o1=o2;
				}
				else if (o1.equals("/"))
				{
					sc = (Double.parseDouble(s1) / Double.parseDouble(s2));
					s1=String.valueOf(sc);
					tf.setText(s1+(sm.replaceAll("[0-9]", "")));
					sm="";
					s2="";
					o1=o2;
				}
			}
		}
		//AC Button Action
		else if (s.equals("AC")) 
        {
			sm="";
			s1="";
			s2="";
			o1="";
			o2="";
            tf.setText(sm);
        }
		//CE Button Action
		else if (s.equals("CE")) 
        {
			sm=sm.substring(0, sm.length()-1);
            tf.setText(sm);
			if(s2.equals(""))
			{
				s1=sm;
			}
			else if((!s1.equals("")))
			{
				s2=sm;
			}
        }
		//Equals Button Action
		else if (s.charAt(0) == '=') 
        {
			//Calculation Algorithm
			if (o1.equals("+") || o1.equals(".+"))
				{
					sc = (Double.parseDouble(s1) + Double.parseDouble(s2));
					s1=String.valueOf(sc);
					System.out.println("s1="+s1);
					tf.setText(s1+(sm.replaceAll("[0-9]", "")));
					sm="";
					s2="";
					o1="";
					o2="";
					
				}
				else if (o1.equals("-"))
				{
					sc = (Double.parseDouble(s1) - Double.parseDouble(s2));
					s1=String.valueOf(sc);
					tf.setText(s1+(sm.replaceAll("[0-9]", "")));
					sm="";
					s2="";
					o1="";
					o2="";
				}
				else if (o1.equals("X"))
				{
					sc = (Double.parseDouble(s1) * Double.parseDouble(s2));
					s1=String.valueOf(sc);
					tf.setText(s1+(sm.replaceAll("[0-9]", "")));
					sm="";
					s2="";
					o1="";
					o2="";
				}
				else if (o1.equals("/"))
				{
					sc = (Double.parseDouble(s1) / Double.parseDouble(s2));
					s1=String.valueOf(sc);
					tf.setText(s1+(sm.replaceAll("[0-9]", "")));
					sm="";
					s2="";
					o1="";
					o2="";
				}
				else if (o1.equals("%"))
				{
					sc = (Double.parseDouble(s1) % Double.parseDouble(s2));
					s1=String.valueOf(sc);
					tf.setText(s1+(sm.replaceAll("[0-9]", "")));
					sm="";
					s2="";
					o1="";
					o2="";
				}
        }
	}	
}
//Unit Converter Tab
class UnitConverterTab extends JPanel 
{
	UnitConverterTab()
	{
		//Creating Unit Converter Panel
		JPanel ucLabelPanel = new JPanel();

		//Creating Unit Converter Label
		JLabel uc=new JLabel("Unit Converter");
        uc.setFont(new Font("Helvetica", Font.BOLD, 28));

		//Applying Border Layout to Unit Converter Label Panel
		ucLabelPanel.setLayout(new BorderLayout());

		//Adding Label to Panel
		ucLabelPanel.add(uc,"North");
		uc.setHorizontalAlignment(JLabel.CENTER);
		uc.setVerticalAlignment(JLabel.CENTER);

		//Creating Menu Panel
		JPanel ucMenuPanel = new JPanel();
		
		//Creating Tabbed Pane for Menu
		JTabbedPane utp=new JTabbedPane(JTabbedPane.BOTTOM);

		//Applying Border Layout to Unit Converter Label Panel
		ucMenuPanel.setLayout(new BorderLayout());

		//Adding Label to Panel
		ucMenuPanel.add(utp,"North");

		//Creating Tabs 
		utp.add("Area",new Area());
		utp.add("Mass",new Mass());
		utp.add("Length",new Length());
		utp.add("Speed",new Speed());
		utp.add("Volume",new Volume());
		utp.add("Temperature",new Temperature());
		utp.setFont(new Font("Helvetica", Font.BOLD, 12));

		//Adding Tabs to Panel
		ucMenuPanel.add(utp);

		//Creating Unit Converter Main Panel
		JPanel ucmp = new JPanel();

		//Applying Box Layout to Unit Converter Main Panel
		ucmp.setLayout(new BoxLayout(ucmp, BoxLayout.Y_AXIS));

		//Adding all Panels to Main Panel
		ucmp.add(ucLabelPanel);
		ucmp.add(ucMenuPanel);
		
		//Adding Unit Converter Main Panel to Frame
		add(ucmp);
	}
	class Area extends JPanel implements ActionListener
	{
		JTextField ftf,ttf;
		JComboBox acb1,acb2;
		JButton conv;
		String sa;
		double n;
		Area()
		{
			//Creating Area Buttons Panel
			JPanel ap=new JPanel();

			//Creating From ->TextField, Combobox
			String from[]={"Sq Meter","Sq Kilometer","Sq Centimeter","Sq Millimeter"};
			ftf=new JTextField(6);
			acb1=new JComboBox<>(from);

			//Creating to ->TextField, Combobox
			String to[]={"Sq Meter","Sq Kilometer","Sq Centimeter","Sq Millimeter"};
			ttf=new JTextField(6);
			ttf.setEditable(false);
			acb2=new JComboBox<>(to);

			//Creating Convert Button
			conv=new JButton("Convert");

			//Adding Color to Button
			conv.setBackground(Color.green);

			//Adding Action Listener to the Convert Button
			conv.addActionListener(this);

			//Adding layout to Panel
			ap.setLayout(new GridLayout(3,2,5,5));

			//Adding constraints(only number) to TextFields
			ftf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ftf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ftf.setEditable(true);
				   } else {
					  ftf.setEditable(false);
				   }
				}
			 });
			 /*ttf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ttf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ttf.setEditable(true);
				   } else {
					  ttf.setEditable(false);
				   }
				}
			 });*/

			//Adding All to Panel
			ap.add(ftf);
			ap.add(acb1);
			ap.add(ttf);
			ap.add(acb2);
			ap.add(conv);

			//Adding pannel to Frame
			add(ap);
		}
		//Action Listener
		public void actionPerformed(ActionEvent e1)
		{
			String s=e1.getActionCommand();
			int i = Integer.MIN_VALUE;
			if (s.equals("Convert"))
			{
				System.out.println(s);
				System.out.println(acb1.getSelectedItem());
				System.out.println(acb2.getSelectedItem());
				if((acb1.getSelectedItem()).equals("Sq Meter") && (acb2.getSelectedItem()).equals("Sq Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) * 0.000001);
					//NumberFormat nf = NumberFormat.getInstance();
    				//nf.setMinimumFractionDigits(7);
					//sa=String.valueOf(nf.format(n));
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Meter") && (acb2.getSelectedItem()).equals("Sq Centimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 10000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Meter") && (acb2.getSelectedItem()).equals("Sq Millimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1e+6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Kilometer") && (acb2.getSelectedItem()).equals("Sq Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1e+6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Kilometer") && (acb2.getSelectedItem()).equals("Sq Centimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1e+10);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Kilometer") && (acb2.getSelectedItem()).equals("Sq Millimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1e+12);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Centimeter") && (acb2.getSelectedItem()).equals("Sq Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) / 10000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Centimeter") && (acb2.getSelectedItem()).equals("Sq Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1e+10);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Centimeter") && (acb2.getSelectedItem()).equals("Sq Millimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 100);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Millimeter") && (acb2.getSelectedItem()).equals("Sq Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1e+6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Millimeter") && (acb2.getSelectedItem()).equals("Sq Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1e+12);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Sq Millimeter") && (acb2.getSelectedItem()).equals("Sq Centimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) / 100);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else
				{
					ttf.setText(ftf.getText());
				}
			}
		}
	}
	class Mass extends JPanel implements ActionListener
	{
		JTextField ftf,ttf;
		JComboBox acb1,acb2;
		JButton conv;
		String sa;
		double n;
		Mass()
		{
			//Creating Area Buttons Panel
			JPanel ap=new JPanel();

			//Creating From ->TextField, Combobox
			String from[]={"Kilogram","Gram","Pound-lb","Millogram","Tonne"};
			ftf=new JTextField(6);
			acb1=new JComboBox<>(from);

			//Creating to ->TextField, Combobox
			String to[]={"Kilogram","Gram","Pound-lb","Millogram","Tonne"};
			ttf=new JTextField(6);
			ttf.setEditable(false);
			acb2=new JComboBox<>(to);

			//Creating Convert Button
			conv=new JButton("Convert");

			//Adding Color to Button
			conv.setBackground(Color.green);

			//Adding Action Listener to the Convert Button
			conv.addActionListener(this);

			//Adding layout to Panel
			ap.setLayout(new GridLayout(3,2,5,5));

			//Adding constraints(only number) to TextFields
			ftf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ftf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ftf.setEditable(true);
				   } else {
					  ftf.setEditable(false);
				   }
				}
			 });
			 /*ttf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ttf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ttf.setEditable(true);
				   } else {
					  ttf.setEditable(false);
				   }
				}
			 });*/

			//Adding All to Panel
			ap.add(ftf);
			ap.add(acb1);
			ap.add(ttf);
			ap.add(acb2);
			ap.add(conv);

			//Adding pannel to Frame
			add(ap);
		}
		//Action Listener
		public void actionPerformed(ActionEvent e1)
		{
			String s=e1.getActionCommand();
			int i = Integer.MIN_VALUE;
			if (s.equals("Convert"))
			{
				System.out.println(s);
				System.out.println(acb1.getSelectedItem());
				System.out.println(acb2.getSelectedItem());
				if((acb1.getSelectedItem()).equals("Kilogram") && (acb2.getSelectedItem()).equals("Gram"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kilogram") && (acb2.getSelectedItem()).equals("Pound-lb"))
				{
					n=(Double.parseDouble(ftf.getText()) * 2.205);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kilogram") && (acb2.getSelectedItem()).equals("Milligram"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1e+6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kilogram") && (acb2.getSelectedItem()).equals("Tonne"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Gram") && (acb2.getSelectedItem()).equals("Kilogram"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Gram") && (acb2.getSelectedItem()).equals("Pound-lb"))
				{
					n=(Double.parseDouble(ftf.getText()) / 453.6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Gram") && (acb2.getSelectedItem()).equals("Milligram"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Gram") && (acb2.getSelectedItem()).equals("Tonne"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1e+6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Pound-lb") && (acb2.getSelectedItem()).equals("Kilogram"))
				{
					n=(Double.parseDouble(ftf.getText()) / 2.205);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Pound-lb") && (acb2.getSelectedItem()).equals("Gram"))
				{
					n=(Double.parseDouble(ftf.getText()) * 453.6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Pound-lb") && (acb2.getSelectedItem()).equals("Milligram"))
				{
					n=(Double.parseDouble(ftf.getText()) * 453600);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Pound-lb") && (acb2.getSelectedItem()).equals("Tonne"))
				{
					n=(Double.parseDouble(ftf.getText()) / 2205);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Milligram") && (acb2.getSelectedItem()).equals("Kilogram"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1e+6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Milligram") && (acb2.getSelectedItem()).equals("Gram"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Milligram") && (acb2.getSelectedItem()).equals("Pound-lb"))
				{
					n=(Double.parseDouble(ftf.getText()) / 453600);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Milligram") && (acb2.getSelectedItem()).equals("Tonne"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1e+9);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Tonne") && (acb2.getSelectedItem()).equals("Kilogram"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Tonne") && (acb2.getSelectedItem()).equals("Gram"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1e+6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Tonne") && (acb2.getSelectedItem()).equals("Pound-lb"))
				{
					n=(Double.parseDouble(ftf.getText()) * 2205);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Tonne") && (acb2.getSelectedItem()).equals("Milligram"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1e+9);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
			}
		}
	}
	class Length extends JPanel implements ActionListener
	{
		JTextField ftf,ttf;
		JComboBox acb1,acb2;
		JButton conv;
		String sa;
		double n;
		Length()
		{
			//Creating Area Buttons Panel
			JPanel ap=new JPanel();

			//Creating From ->TextField, Combobox
			String from[]={"Kilometer","Meter","Centimeter","Mile","Foot","Inch"};
			ftf=new JTextField(6);
			acb1=new JComboBox<>(from);

			//Creating to ->TextField, Combobox
			String to[]={"Kilometer","Meter","Centimeter","Mile","Foot","Inch"};
			ttf=new JTextField(6);
			ttf.setEditable(false);
			acb2=new JComboBox<>(to);

			//Creating Convert Button
			conv=new JButton("Convert");

			//Adding Color to Button
			conv.setBackground(Color.green);

			//Adding Action Listener to the Convert Button
			conv.addActionListener(this);

			//Adding layout to Panel
			ap.setLayout(new GridLayout(3,2,5,5));

			//Adding constraints(only number) to TextFields
			ftf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ftf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ftf.setEditable(true);
				   } else {
					  ftf.setEditable(false);
				   }
				}
			 });
			 /*ttf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ttf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ttf.setEditable(true);
				   } else {
					  ttf.setEditable(false);
				   }
				}
			 });*/

			//Adding All to Panel
			ap.add(ftf);
			ap.add(acb1);
			ap.add(ttf);
			ap.add(acb2);
			ap.add(conv);

			//Adding pannel to Frame
			add(ap);
		}
		//Action Listener
		public void actionPerformed(ActionEvent e1)
		{
			String s=e1.getActionCommand();
			int i = Integer.MIN_VALUE;
			if (s.equals("Convert"))
			{
				System.out.println(s);
				System.out.println(acb1.getSelectedItem());
				System.out.println(acb2.getSelectedItem());
				if((acb1.getSelectedItem()).equals("Kilometer") && (acb2.getSelectedItem()).equals("Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kilometer") && (acb2.getSelectedItem()).equals("Centimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 100000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kilometer") && (acb2.getSelectedItem()).equals("Mile"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1.609);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kilometer") && (acb2.getSelectedItem()).equals("Foot"))
				{
					n=(Double.parseDouble(ftf.getText()) * 3281);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kilometer") && (acb2.getSelectedItem()).equals("Inch"))
				{
					n=(Double.parseDouble(ftf.getText()) * 39370);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Meter") && (acb2.getSelectedItem()).equals("Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Meter") && (acb2.getSelectedItem()).equals("Centimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 100);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Meter") && (acb2.getSelectedItem()).equals("Mile"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1609);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Meter") && (acb2.getSelectedItem()).equals("Foot"))
				{
					n=(Double.parseDouble(ftf.getText()) * 3.281);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Meter") && (acb2.getSelectedItem()).equals("Inch"))
				{
					n=(Double.parseDouble(ftf.getText()) * 39.37);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Centimeter") && (acb2.getSelectedItem()).equals("Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) / 100000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Centimeter") && (acb2.getSelectedItem()).equals("Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) / 100);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Centimeter") && (acb2.getSelectedItem()).equals("Mile"))
				{
					n=(Double.parseDouble(ftf.getText()) / 160900);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Centimeter") && (acb2.getSelectedItem()).equals("Foot"))
				{
					n=(Double.parseDouble(ftf.getText()) / 30.48);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Centimeter") && (acb2.getSelectedItem()).equals("Inch"))
				{
					n=(Double.parseDouble(ftf.getText()) / 2.54);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Mile") && (acb2.getSelectedItem()).equals("Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1.609);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Mile") && (acb2.getSelectedItem()).equals("Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1609);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Mile") && (acb2.getSelectedItem()).equals("Centimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 160900);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Mile") && (acb2.getSelectedItem()).equals("Foot"))
				{
					n=(Double.parseDouble(ftf.getText()) * 5280);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Mile") && (acb2.getSelectedItem()).equals("Inch"))
				{
					n=(Double.parseDouble(ftf.getText()) * 63360);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Foot") && (acb2.getSelectedItem()).equals("Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) / 3281);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Foot") && (acb2.getSelectedItem()).equals("Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) / 3.281);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Foot") && (acb2.getSelectedItem()).equals("Centimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 30.48);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Foot") && (acb2.getSelectedItem()).equals("Mile"))
				{
					n=(Double.parseDouble(ftf.getText()) / 5280);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Foot") && (acb2.getSelectedItem()).equals("Inch"))
				{
					n=(Double.parseDouble(ftf.getText()) * 12);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Inch") && (acb2.getSelectedItem()).equals("Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) / 39370);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Inch") && (acb2.getSelectedItem()).equals("Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) / 39.37);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Inch") && (acb2.getSelectedItem()).equals("Centimeter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 2.54);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Inch") && (acb2.getSelectedItem()).equals("Mile"))
				{
					n=(Double.parseDouble(ftf.getText()) / 63360);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Inch") && (acb2.getSelectedItem()).equals("Foot"))
				{
					n=(Double.parseDouble(ftf.getText()) / 12);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else
				{
					ttf.setText(ftf.getText());
				}
			}
		}
	}
	class Speed extends JPanel implements ActionListener
	{
		JTextField ftf,ttf;
		JComboBox acb1,acb2;
		JButton conv;
		String sa;
		double n;
		Speed()
		{
			//Creating Area Buttons Panel
			JPanel ap=new JPanel();

			//Creating From ->TextField, Combobox
			String from[]={"m/s","km/hr","miles/hr"};
			ftf=new JTextField(6);
			acb1=new JComboBox<>(from);

			//Creating to ->TextField, Combobox
			String to[]={"m/s","km/hr","miles/hr"};
			ttf=new JTextField(6);
			ttf.setEditable(false);
			acb2=new JComboBox<>(to);

			//Creating Convert Button
			conv=new JButton("Convert");

			//Adding Color to Button
			conv.setBackground(Color.green);

			//Adding Action Listener to the Convert Button
			conv.addActionListener(this);

			//Adding layout to Panel
			ap.setLayout(new GridLayout(3,2,5,5));

			//Adding constraints(only number) to TextFields
			ftf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ftf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ftf.setEditable(true);
				   } else {
					  ftf.setEditable(false);
				   }
				}
			 });
			 /*ttf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ttf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ttf.setEditable(true);
				   } else {
					  ttf.setEditable(false);
				   }
				}
			 });*/

			//Adding All to Panel
			ap.add(ftf);
			ap.add(acb1);
			ap.add(ttf);
			ap.add(acb2);
			ap.add(conv);

			//Adding pannel to Frame
			add(ap);
		}
		//Action Listener
		public void actionPerformed(ActionEvent e1)
		{
			String s=e1.getActionCommand();
			int i = Integer.MIN_VALUE;
			if (s.equals("Convert"))
			{
				System.out.println(s);
				System.out.println(acb1.getSelectedItem());
				System.out.println(acb2.getSelectedItem());
				if((acb1.getSelectedItem()).equals("m/s") && (acb2.getSelectedItem()).equals("km/hr"))
				{
					n=(Double.parseDouble(ftf.getText()) * 3.6);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("m/s") && (acb2.getSelectedItem()).equals("miles/hr"))
				{
					n=(Double.parseDouble(ftf.getText()) * 2.237);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("km/hr") && (acb2.getSelectedItem()).equals("m/s"))
				{
					n=(Double.parseDouble(ftf.getText()) / 3.6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("km/hr") && (acb2.getSelectedItem()).equals("miles/hr"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1.609);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("miles/hr") && (acb2.getSelectedItem()).equals("m/s"))
				{
					n=(Double.parseDouble(ftf.getText()) * 2.237);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("miles/hr") && (acb2.getSelectedItem()).equals("km/hr"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1.609);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else
				{
					ttf.setText(ftf.getText());
				}
			}
		}
	}
	class Volume extends JPanel implements ActionListener
	{
		JTextField ftf,ttf;
		JComboBox acb1,acb2;
		JButton conv;
		String sa;
		double n;
		Volume()
		{
			//Creating Area Buttons Panel
			JPanel ap=new JPanel();

			//Creating From ->TextField, Combobox
			String from[]={"Cubic Meter","ml","liter"};
			ftf=new JTextField(6);
			acb1=new JComboBox<>(from);

			//Creating to ->TextField, Combobox
			String to[]={"Cubic Meter","ml","liter"};
			ttf=new JTextField(6);
			ttf.setEditable(false);
			acb2=new JComboBox<>(to);

			//Creating Convert Button
			conv=new JButton("Convert");

			//Adding Color to Button
			conv.setBackground(Color.green);

			//Adding Action Listener to the Convert Button
			conv.addActionListener(this);

			//Adding layout to Panel
			ap.setLayout(new GridLayout(3,2,5,5));

			//Adding constraints(only number) to TextFields
			ftf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ftf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ftf.setEditable(true);
				   } else {
					  ftf.setEditable(false);
				   }
				}
			 });
			 /*ttf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ttf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ttf.setEditable(true);
				   } else {
					  ttf.setEditable(false);
				   }
				}
			 });*/

			//Adding All to Panel
			ap.add(ftf);
			ap.add(acb1);
			ap.add(ttf);
			ap.add(acb2);
			ap.add(conv);

			//Adding pannel to Frame
			add(ap);
		}
		//Action Listener
		public void actionPerformed(ActionEvent e1)
		{
			String s=e1.getActionCommand();
			int i = Integer.MIN_VALUE;
			if (s.equals("Convert"))
			{
				System.out.println(s);
				System.out.println(acb1.getSelectedItem());
				System.out.println(acb2.getSelectedItem());
				if((acb1.getSelectedItem()).equals("Cubic Meter") && (acb2.getSelectedItem()).equals("ml"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1e+6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Cubic Meter") && (acb2.getSelectedItem()).equals("liter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("ml") && (acb2.getSelectedItem()).equals("Cubic Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1e-6);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("ml") && (acb2.getSelectedItem()).equals("liter"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("liter") && (acb2.getSelectedItem()).equals("Cubic Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) / 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("liter") && (acb2.getSelectedItem()).equals("ml"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else
				{
					ttf.setText(ftf.getText());
				}
			}
		}
	}
	class Temperature extends JPanel implements ActionListener
	{
		JTextField ftf,ttf;
		JComboBox acb1,acb2;
		JButton conv;
		String sa;
		double n;
		Temperature()
		{
			//Creating Area Buttons Panel
			JPanel ap=new JPanel();

			//Creating From ->TextField, Combobox
			String from[]={"Celsius","Fahrenheit","Kelvin","Rankine"};
			ftf=new JTextField(6);
			acb1=new JComboBox<>(from);

			//Creating to ->TextField, Combobox
			String to[]={"Celsius","Fahrenheit","Kelvin","Rankine"};
			ttf=new JTextField(6);
			ttf.setEditable(false);
			acb2=new JComboBox<>(to);

			//Creating Convert Button
			conv=new JButton("Convert");

			//Adding Color to Button
			conv.setBackground(Color.green);

			//Adding Action Listener to the Convert Button
			conv.addActionListener(this);

			//Adding layout to Panel
			ap.setLayout(new GridLayout(3,2,5,5));

			//Adding constraints(only number) to TextFields
			ftf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ftf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ftf.setEditable(true);
				   } else {
					  ftf.setEditable(false);
				   }
				}
			 });
			 /*ttf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ttf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ttf.setEditable(true);
				   } else {
					  ttf.setEditable(false);
				   }
				}
			 });*/

			//Adding All to Panel
			ap.add(ftf);
			ap.add(acb1);
			ap.add(ttf);
			ap.add(acb2);
			ap.add(conv);

			//Adding pannel to Frame
			add(ap);
		}
		//Action Listener
		public void actionPerformed(ActionEvent e1)
		{
			String s=e1.getActionCommand();
			int i = Integer.MIN_VALUE;
			if (s.equals("Convert"))
			{
				System.out.println(s);
				System.out.println(acb1.getSelectedItem());
				System.out.println(acb2.getSelectedItem());
				if((acb1.getSelectedItem()).equals("Celsius") && (acb2.getSelectedItem()).equals("Fahrenheit"))
				{
					n=((Double.parseDouble(ftf.getText()) * 9/5) + 32);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Celsius") && (acb2.getSelectedItem()).equals("Kelvin"))
				{
					n=(Double.parseDouble(ftf.getText()) + 273.15);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Celsius") && (acb2.getSelectedItem()).equals("Rankine"))
				{
					n=((Double.parseDouble(ftf.getText()) * 9/5) + 491.67);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Fahrenheit") && (acb2.getSelectedItem()).equals("Celsius"))
				{
					n=((Double.parseDouble(ftf.getText()) - 32) * 5/9);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Fahrenheit") && (acb2.getSelectedItem()).equals("Kelvin"))
				{
					n=((Double.parseDouble(ftf.getText()) - 32) * 5/9 + 273.15);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Fahrenheit") && (acb2.getSelectedItem()).equals("Rankine"))
				{
					n=(Double.parseDouble(ftf.getText()) + 459.67);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kelvin") && (acb2.getSelectedItem()).equals("Celsius"))
				{
					n=(Double.parseDouble(ftf.getText()) - 273.15);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kelvin") && (acb2.getSelectedItem()).equals("Fahrenheit"))
				{
					n=((Double.parseDouble(ftf.getText()) - 273.15) * 9/5 + 32);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Kelvin") && (acb2.getSelectedItem()).equals("Rankine"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1.8);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Rankine") && (acb2.getSelectedItem()).equals("Celsius"))
				{
					n=((Double.parseDouble(ftf.getText()) - 491.67) * 5/9);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Rankine") && (acb2.getSelectedItem()).equals("Fahrenheit"))
				{
					n=(Double.parseDouble(ftf.getText()) - 459.67);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else if((acb1.getSelectedItem()).equals("Rankine") && (acb2.getSelectedItem()).equals("Kelvin"))
				{
					n=(Double.parseDouble(ftf.getText()) * 5/9);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				else
				{
					ttf.setText(ftf.getText());
				}
			}
		}
	}
}
//More Tab
class MoreTab extends JPanel
{
	MoreTab()
	{
		//Creating Unit Converter Panel
		JPanel mLabelPanel = new JPanel();

		//Creating Unit Converter Label
		JLabel m=new JLabel("Unit Converter");
        m.setFont(new Font("Helvetica", Font.BOLD, 28));

		//Applying Border Layout to Unit Converter Label Panel
		mLabelPanel.setLayout(new BorderLayout());

		//Adding Label to Panel
		mLabelPanel.add(m,"North");
		m.setHorizontalAlignment(JLabel.CENTER);
		m.setVerticalAlignment(JLabel.CENTER);

		//Creating Menu Panel
		JPanel mMenuPanel = new JPanel();
		
		//Creating Tabbed Pane for Menu
		JTabbedPane mtp=new JTabbedPane(JTabbedPane.BOTTOM);

		//Applying Border Layout to Unit Converter Label Panel
		mMenuPanel.setLayout(new BorderLayout());

		//Adding Label to Panel
		mMenuPanel.add(mtp,"North");

		//Creating Tabs 
		mtp.add("BMI",new BMI());
		mtp.add("GST",new GST());
		mtp.setFont(new Font("Helvetica", Font.BOLD, 12));

		//Adding Tabs to Panel
		mMenuPanel.add(mtp);

		//Creating Unit Converter Main Panel
		JPanel mmp = new JPanel();

		//Applying Box Layout to Unit Converter Main Panel
		mmp.setLayout(new BoxLayout(mmp, BoxLayout.Y_AXIS));

		//Adding all Panels to Main Panel
		mmp.add(mLabelPanel);
		mmp.add(mMenuPanel);
		
		//Adding Unit Converter Main Panel to Frame
		add(mmp);
	}
	class BMI extends JPanel implements ActionListener
	{
		JTextField ftf,ttf;
		JComboBox acb1,acb2;
		JButton conv;
		String sa;
		double n;
		BMI()
		{
			//Creating Area Buttons Panel
			JPanel ap=new JPanel();

			//Creating From ->TextField, Combobox
			String from[]={"Celsius","Fahrenheit","Kelvin","Rankine"};
			ftf=new JTextField(6);
			acb1=new JComboBox<>(from);

			//Creating to ->TextField, Combobox
			String to[]={"Celsius","Fahrenheit","Kelvin","Rankine"};
			ttf=new JTextField(6);
			ttf.setEditable(false);
			acb2=new JComboBox<>(to);

			//Creating Convert Button
			conv=new JButton("Convert");

			//Adding Color to Button
			conv.setBackground(Color.green);

			//Adding Action Listener to the Convert Button
			conv.addActionListener(this);

			//Adding layout to Panel
			ap.setLayout(new GridLayout(3,2,5,5));

			//Adding constraints(only number) to TextFields
			ftf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ftf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ftf.setEditable(true);
				   } else {
					  ftf.setEditable(false);
				   }
				}
			 });
			 /*ttf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ttf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ttf.setEditable(true);
				   } else {
					  ttf.setEditable(false);
				   }
				}
			 });*/

			//Adding All to Panel
			ap.add(ftf);
			ap.add(acb1);
			ap.add(ttf);
			ap.add(acb2);
			ap.add(conv);

			//Adding pannel to Frame
			add(ap);
		}
		//Action Listener
		public void actionPerformed(ActionEvent e1)
		{
			String s=e1.getActionCommand();
			int i = Integer.MIN_VALUE;
			if (s.equals("Convert"))
			{
				System.out.println(s);
				System.out.println(acb1.getSelectedItem());
				System.out.println(acb2.getSelectedItem());
				if((acb1.getSelectedItem()).equals("Sq Meter") && (acb2.getSelectedItem()).equals("Sq Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) * 0.000001);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				if((acb1.getSelectedItem()).equals("Sq Kilometer") && (acb2.getSelectedItem()).equals("Sq Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1000000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
			}
		}
	}
	class GST extends JPanel implements ActionListener
	{
		JTextField ftf,ttf;
		JComboBox acb1,acb2;
		JButton conv;
		String sa;
		double n;
		GST()
		{
			//Creating Area Buttons Panel
			JPanel ap=new JPanel();

			//Creating From ->TextField, Combobox
			String from[]={"Celsius","Fahrenheit","Kelvin","Rankine"};
			ftf=new JTextField(6);
			acb1=new JComboBox<>(from);

			//Creating to ->TextField, Combobox
			String to[]={"Celsius","Fahrenheit","Kelvin","Rankine"};
			ttf=new JTextField(6);
			ttf.setEditable(false);
			acb2=new JComboBox<>(to);

			//Creating Convert Button
			conv=new JButton("Convert");

			//Adding Color to Button
			conv.setBackground(Color.green);

			//Adding Action Listener to the Convert Button
			conv.addActionListener(this);

			//Adding layout to Panel
			ap.setLayout(new GridLayout(3,2,5,5));

			//Adding constraints(only number) to TextFields
			ftf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ftf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ftf.setEditable(true);
				   } else {
					  ftf.setEditable(false);
				   }
				}
			 });
			 /*ttf.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
				   String value = ttf.getText();
				   int l = value.length();
				   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					  ttf.setEditable(true);
				   } else {
					  ttf.setEditable(false);
				   }
				}
			 });*/

			//Adding All to Panel
			ap.add(ftf);
			ap.add(acb1);
			ap.add(ttf);
			ap.add(acb2);
			ap.add(conv);

			//Adding pannel to Frame
			add(ap);
		}
		//Action Listener
		public void actionPerformed(ActionEvent e1)
		{
			String s=e1.getActionCommand();
			int i = Integer.MIN_VALUE;
			if (s.equals("Convert"))
			{
				System.out.println(s);
				System.out.println(acb1.getSelectedItem());
				System.out.println(acb2.getSelectedItem());
				if((acb1.getSelectedItem()).equals("Sq Meter") && (acb2.getSelectedItem()).equals("Sq Kilometer"))
				{
					n=(Double.parseDouble(ftf.getText()) * 0.000001);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
				if((acb1.getSelectedItem()).equals("Sq Kilometer") && (acb2.getSelectedItem()).equals("Sq Meter"))
				{
					n=(Double.parseDouble(ftf.getText()) * 1000000);
					sa=String.valueOf(n);
					ttf.setText(sa);
				}
			}
		}
	}
}
