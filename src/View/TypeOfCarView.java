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
	
	/*
	 * Constructor of TypeOfCarView
	 */
	public TypeOfCarView(Simulator model) {
		super(model);
    	
    	/*
    	 * Create a JPanel for all the Textfields and Labels
    	 */
		this.setLayout(new GridLayout(0,1));
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		
		/*
		 * Create a JTextField and JLabel for the AdHoc Cars
		 */
		JLabel LadHoc = new JLabel("Percentage of adhoc car's :");
		TadHoc = new JTextField("0%     ");
		TadHoc.setEditable(false);
		TadHoc.setBackground(Color.RED);
		TadHoc.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel1.add(LadHoc);
		panel1.add(TadHoc);
		
		/*
		 * Create a JTextField and JLabel for the ParkingPass Cars
		 */
		JLabel LpassHolder = new JLabel("Percentage of parking pass car's :");
		TpassHolder = new JTextField("0%    ");
		TpassHolder.setEditable(false);
		TpassHolder.setBackground(Color.BLUE);
		TpassHolder.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel1.add(LpassHolder);
		panel1.add(TpassHolder);
		
		/*
		 * Create a JTextField and JLabel for the Empty Spots in the garage
		 */		
		JLabel Lempty = new JLabel("Percentage of empty spots :");
		Tempty = new JTextField("100%   ");
		Tempty.setEditable(false);
		Tempty.setBackground(Color.white);
		Tempty.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel1.add(Lempty);
		panel1.add(Tempty);
		
		/*
		 * Create a JTextField and JLabel for the Reservation spots in the garage.
		 */
		JLabel LreservationSpot = new JLabel("Percentage of reservation spots :");
		TreservationSpot = new JTextField("0%   ");
		TreservationSpot.setEditable(false);
		TreservationSpot.setBackground(Color.green);
		TreservationSpot.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel1.add(LreservationSpot);
		panel1.add(TreservationSpot);
		
		/* 
		 * Add everything to the JPanel 
		 */
		this.add(panel1);
		
	}
	
	/*
	 * Method updateView for updating the view each time something changes
	 */
	public void updateView() {
		calculatePercentage();		
	}
	
	/*
	 * Method calculatePercentage, calculates the percentages.
	 */
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