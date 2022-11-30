import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
class CFrame extends JFrame
{
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

		//Setting Frame Visibility
		f.setVisible(true);

		//Close Operation
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
//Calculator Tab
class CalculatorTab extends JPanel
{
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
		JTextField tf= new JTextField(16);
		tf.setEditable(false);

		//Adding Text Field to Panel
		tfPanel.add(tf);

		//Creating Calculator Buttons Panel
		JPanel CalPanel = new JPanel();

		//Applying Grid Layout
		CalPanel.setLayout(new GridLayout(4,5,5,5));

		//Creating Buttons
		JButton b1=new JButton("7");
		JButton b2=new JButton("8");
		JButton b3=new JButton("9");
		JButton b4=new JButton("/");
		JButton b5=new JButton("-");
		JButton b6=new JButton("4");
		JButton b7=new JButton("5");
		JButton b8=new JButton("6");
		JButton b9=new JButton("X");
		JButton b10=new JButton("+");
		JButton b11=new JButton("1");
		JButton b12=new JButton("2");
		JButton b13=new JButton("3");
		JButton b14=new JButton("%");
		JButton b15=new JButton("C");
		JButton b16=new JButton("0");
		JButton b17=new JButton(".");
		JButton b18=new JButton("=");

		//Adding Colors to Buttons
		b4.setBackground(Color.orange);
		b5.setBackground(Color.orange);
		b9.setBackground(Color.orange);
		b10.setBackground(Color.orange);
		b14.setBackground(Color.orange);
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
}
//Unit Converter Tab
class UnitConverterTab extends JPanel
{
	UnitConverterTab()
	{
		//Unit Converter Panel
		JPanel ucLabelPanel = new JPanel();

		//Unit Converter Label
		JLabel uc=new JLabel("Unit Converter");
        uc.setFont(new Font("Helvetica", Font.BOLD, 28));
		uc.setHorizontalAlignment(JLabel.CENTER);
		uc.setVerticalAlignment(JLabel.CENTER);

		//Adding Label to Panel
		ucLabelPanel.add(uc);

		//Unit Converter Buttons Panel
		JPanel ucmbPanel=new JPanel();
		JButton ucmb1=new JButton("Area");
		JButton ucmb2=new JButton("Mass");
		JButton ucmb3=new JButton("Length");
		JButton ucmb4=new JButton("Speed");
		JButton ucmb5=new JButton("Volume");
		JButton ucmb6=new JButton("Temperature");

		//Grid Layout
		ucmbPanel.setLayout(new GridLayout(3,3,20,40));

		//Creating Main Panel
		JPanel mp = new JPanel();

		//Unit Converter Menu Buttons Panel
		ucmbPanel.add(ucmb1);
		ucmbPanel.add(ucmb2);
		ucmbPanel.add(ucmb3);
		ucmbPanel.add(ucmb4);
		ucmbPanel.add(ucmb5);
		ucmbPanel.add(ucmb6);

		//Box Layout
		mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));

		//Adding Panels to Main Panel
		mp.add(ucLabelPanel);
		mp.add(ucmbPanel);

		//Adding Main Panel to Frame
		add(mp);
	}
}
//More Tab
class MoreTab extends JPanel
{
	MoreTab()
	{
		//Creating More Tab Label Panel
		JPanel mLabelPanel=new JPanel();
		//Creating Label
		JLabel m=new JLabel("More");
		//Setting Grid Layout
		setLayout(new GridLayout(3,3,20,40));
        m.setFont(new Font("Helvetica", Font.BOLD, 28));
		//Adding Label to Panel
		mLabelPanel.add(m);
		m.setHorizontalAlignment(JLabel.CENTER);
		m.setVerticalAlignment(JLabel.CENTER);

		//Creating More Menu Buttons
		JButton mb1=new JButton("BMI");
		JButton mb2=new JButton("GST");

		//Creating Buttons Panel
		JPanel mbPanel=new JPanel();

		//Adding Menu Buttons to More Buttons Panel
		mbPanel.add(mb1);
		mbPanel.add(mb2);

		//Creating Main Panel
		JPanel mp = new JPanel();

		//Box Layout
		mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));

		//Adding Panels to Main Panel
		mp.add(mLabelPanel);
		mp.add(mbPanel);

		//Adding Main Panel to Frame
		add(mp);
	}
}