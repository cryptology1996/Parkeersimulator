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
	private JTextField TreservationCar;
	
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
		JLabel LadHoc = new JLabel("Percentage of Adhoc Cars :");
		TadHoc = new JTextField("   0%    ");
		TadHoc.setEditable(false);
		TadHoc.setBackground(Color.RED);
		TadHoc.setBorder(BorderFactory.createLineBorder(Color.black,1));
		panel1.add(LadHoc);
		panel1.add(TadHoc);
		
		/*
		 * Create a JTextField and JLabel for the ParkingPass Cars
		 */
		JLabel LpassHolder = new JLabel("Percentage of Parking Pass Cars :");
		TpassHolder = new JTextField("   0%   ");
		TpassHolder.setEditable(false);
		TpassHolder.setBackground(Color.BLUE);
		TpassHolder.setBorder(BorderFactory.createLineBorder(Color.black,1));
		panel1.add(LpassHolder);
		panel1.add(TpassHolder);
		
		/*
		 * Create a JTextField and JLabel for the Reservation spots in the garage.
		 */
		JLabel LreservationSpot = new JLabel("Percentage of Reservation Spots :");
		TreservationSpot = new JTextField("   0%   ");
		TreservationSpot.setEditable(false);
		TreservationSpot.setBackground(Color.yellow);
		TreservationSpot.setBorder(BorderFactory.createLineBorder(Color.black,1));
		panel1.add(LreservationSpot);
		panel1.add(TreservationSpot);
		
		/*
		 * Create a JTextField and JLabel for the Reservation Cars in the garage.
		 */
		JLabel LreservationCar = new JLabel("Percentage of Reservation Cars :");
		TreservationCar = new JTextField("   0%   ");
		TreservationCar.setEditable(false);
		TreservationCar.setBackground(Color.green);
		TreservationCar.setBorder(BorderFactory.createLineBorder(Color.black,1));
		panel1.add(LreservationCar);
		panel1.add(TreservationCar);
		
		
		/*
		 * Create a JTextField and JLabel for the Empty Spots in the garage
		 */		
		JLabel Lempty = new JLabel("Percentage of Empty Spots :");
		Tempty = new JTextField("   100%  ");
		Tempty.setEditable(false);
		Tempty.setBackground(Color.white);
		Tempty.setBorder(BorderFactory.createLineBorder(Color.black,1));
		panel1.add(Lempty);
		panel1.add(Tempty);
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
		double ReservedSpot = CarParkView.GetReservedSpot();
		double ReservationCar = CarParkView.GetReservationCar();
		int AdHocCar;
		int PassParkCar;
		int ReservedSpots;
		int ReservationCars;
		
		int EmptySpots = (int) ((int) 540 - AdHoc - PassCar - ReservedSpot - ReservationCar);
		int Empty = (int) (((100 / garageSize) * EmptySpots));
		
		
		AdHocCar = (int) (((100 / garageSize) * AdHoc));
		PassParkCar = (int) (((100 / garageSize) * PassCar));
		ReservedSpots = (int) (((100 / garageSize) * ReservedSpot));
		ReservationCars = (int) (((100 / garageSize) * ReservationCar));
		
		
		
		String a = String.valueOf(AdHocCar);
		String p = String.valueOf(PassParkCar);
		String e = String.valueOf(Empty);
		String Rs = String.valueOf(ReservedSpots);
		String Rc = String.valueOf(ReservationCars);

		TadHoc.setText("   "+ a +"%");
		TpassHolder.setText("   "+ p+"%");
		Tempty.setText("   "+ e+"%");
		TreservationSpot.setText("   "+ Rs +"%");
		TreservationCar.setText("   "+ Rc +"%");
		
		
	}
}