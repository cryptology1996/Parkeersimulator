package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.*;
/**
 * Class for the Text overview
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class TextOverview extends AbstractView {
	private JTextField txtRevenue;
	private JTextField txtExpRevenue;
	private Simulator simulator;
	double ticketPrice = 7.50;
	
	
	
	/**
	 * Constructor for TextOverview
	 */
	
	public TextOverview(Simulator model) {
		super(model);
		this.simulator = model;
		
		
		
		/**
		 * Create the panel
		 */
		this.setLayout(new FlowLayout());
		
		/**
		 * Revenue JTextField en JLabel
		 */
		JLabel lblRevenue = new JLabel("Total revenue:                                         ");
		txtRevenue = new JTextField(5);
		txtRevenue.setEditable(false);
		txtRevenue.setBackground(Color.LIGHT_GRAY);
		txtRevenue.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(lblRevenue);
		add(txtRevenue);
		
	
		/**
		 * Expected revenue JTextField en JLabel
		 */
		JLabel expRevL = new JLabel("Revenue of remaining cars:                ");
		txtExpRevenue = new JTextField(5);
		txtExpRevenue.setEditable(false);
		txtExpRevenue.setBackground(Color.LIGHT_GRAY);
		txtExpRevenue.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(expRevL);
		add(txtExpRevenue);
		
		/**
		 * Add everything to the JPanel
		 */
		calcRevenue();
		calcExpRevenue();

	}
	
	/**
	 * updates the values inside the textFields
	 */
	
	public void updateView(){
		calcRevenue();
		calcExpRevenue();

	}	
	
	/**
	 * calculates the revenue
	 */
	public void calcRevenue()
	{
		
		int totalCars = simulator.getPayingCars();	
		double totalRevenue = totalCars * ticketPrice;
		txtRevenue.setText(" € "+totalRevenue+"0");
	}
	
	/**
	 * Calculates the expected Revenue of cars which still have to pay.
	 */
	 public void calcExpRevenue(){
		
	 int totalCarsLeft =  CarParkView.GetReservationCar()+CarParkView.GetAdHoc();
	
	double totalExpRevenue = totalCarsLeft * ticketPrice;
	
		txtExpRevenue.setText(" € "+totalExpRevenue+"0");	
	}
}
