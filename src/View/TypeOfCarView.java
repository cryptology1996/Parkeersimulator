package View;

import java.awt.*;
import javax.swing.*;

import Model.ParkeerGarage;
import Model.Simulator;

/**
 * Creates a view of the type's of cars inside the parking garage
 * 
 *
 */
public class TypeOfCarView extends AbstractView{
	private JTextField TadHoc;
	private JTextField TpassHolder;
	private JTextField Tempty;
	private JTextField TreservationSpot;
	
	
		
	public TypeOfCarView(Simulator model) {
		super(model);
    	
    	
    	   	
		this.setLayout(new GridLayout(0,1));
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		JLabel LadHoc = new JLabel("Percentage of adhoc car's :");
		TadHoc = new JTextField("0%     ");
		TadHoc.setEditable(false);
		TadHoc.setBackground(Color.RED);
		TadHoc.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel1.add(LadHoc);
		panel1.add(TadHoc);
		this.add(panel1);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBackground(Color.LIGHT_GRAY);
		JLabel LpassHolder = new JLabel("Percentage of parking pass car's :");
		TpassHolder = new JTextField("0%    ");
		TpassHolder.setEditable(false);
		TpassHolder.setBackground(Color.BLUE);
		TpassHolder.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel2.add(LpassHolder);
		panel2.add(TpassHolder);
		this.add(panel2);
		
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setBackground(Color.LIGHT_GRAY);
		JLabel Lempty = new JLabel("Percentage of empty spots :");
		Tempty = new JTextField("100%");
		Tempty.setEditable(false);
		Tempty.setBackground(Color.YELLOW);
		Tempty.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel3.add(Lempty);
		panel3.add(Tempty);
		this.add(panel3);
		
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		panel4.setBackground(Color.LIGHT_GRAY);
		JLabel LreservationSpot = new JLabel("Percentage of reservation spots :");
		TreservationSpot = new JTextField("0%");
		TreservationSpot.setEditable(false);
		TreservationSpot.setBackground(Color.green);
		TreservationSpot.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel4.add(LreservationSpot);
		panel4.add(TreservationSpot);
		this.add(panel4);
		
	}
	
	public void updateView() {
		calculatePercentage();		
	}
	
	public void calculatePercentage()
	{
		double garageSize = 540;
		double AdHoc = CarParkView.GetAdHoc();
		double PassCar = CarParkView.GetParkPass();
		int AdHocCar;
		int PassParkCar;
		int EmptySpots = (int) ((int) 540 - AdHoc - PassCar);
		int AnotherEmpty = (int) (((100 / garageSize) * EmptySpots));
		AdHocCar = (int) (((100 / garageSize) * AdHoc));
		PassParkCar = (int) (((100 / garageSize) * PassCar));
		String a = String.valueOf(AdHocCar);
		String p = String.valueOf(PassParkCar);
		String e = String.valueOf(AnotherEmpty);

		TadHoc.setText(a +"%");
		TpassHolder.setText(p+"%");
		Tempty.setText(e+"%");
		
		
	}
}