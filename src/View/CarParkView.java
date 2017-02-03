package View;

import java.awt.*;


import Model.*;

public class CarParkView extends AbstractView {
        
		private static int AdHocCar;
		private static int ParkPassCar;
		private static int ReservationCar;
		private static int ReservedSpot;
		
        private Dimension size;
        private Image carParkImage;   
        private ParkeerGarage parkeerGarage;
            
        /**
         * Constructor for objects of class CarPark
         */
        public CarParkView(ParkeerGarage model) {
        	super(model);
        	this.parkeerGarage = model;
        	size = new Dimension(0, 0);
        }
            
        /**
         * Overridden. Tell the GUI manager how big we would like to be.
         */
        public Dimension getPreferredSize() {
            return new Dimension(800, 500);
        }
    
        /**
         * Overriden. The car park view component needs to be redisplayed. Copy the
         * internal image to screen.
         */
		public void paintComponent(Graphics g) { 
			super.paintComponent(g);
        	// Create a new car park image if the size has changed.
			if (!size.equals(getSize())) {
                size = getSize();
                carParkImage = createImage(size.width, size.height);
                
            }
          	AdHocCar = 0;
          	ParkPassCar = 0;
          	ReservationCar = 0;
          	ReservedSpot = 0;
          	
            Graphics graphics = carParkImage.getGraphics();
            for(int floor = 0; floor < parkeerGarage.getNumberOfFloors(); floor++) {
                for(int row = 0; row < parkeerGarage.getNumberOfRows(); row++) {
                    for(int place = 0; place < parkeerGarage.getNumberOfPlaces(); place++) {
                        Location location = new Location(floor, row, place);
                        Car car = parkeerGarage.getCarAt(location);
                        if (car == null){
                        Color color = Color.white;
                        drawPlace(graphics, location, color);
                        }
                        else if (car != null && car.getClass().equals(AdHocCar.class)){
                        	Color color1 = Color.red;
                        	drawPlace(graphics, location, color1);
                        	AdHocCar++;
                        }
                        else if (car != null && car.getClass().equals(ParkingPassCar.class)){
                        	Color color2 = Color.cyan;
                        	drawPlace(graphics, location, color2);
                        	ParkPassCar++;
                        }
                        else if (car != null && car.getClass().equals(ReservationCar.class) && car.getArrivalTime() != 0 && car.getArrivalTime() <= 15){
                        	Color color3 = Color.yellow;
                        	drawPlace(graphics, location, color3);
                        	ReservedSpot++;
                        }
                        else if (car != null && car.getClass().equals(ReservationCar.class) && car.getArrivalTime() == 0){
                        	Color color3 = Color.green;
                        	drawPlace(graphics, location, color3);
                        	ReservationCar++;
                        }
                   }
            }
            if (carParkImage == null) {
				return;
			}

				Dimension currentSize = getSize();
				if (size.equals(currentSize)) {
					g.drawImage(carParkImage, 0, 0, null);
				}
				else {
        // Rescale the previous image.
					g.drawImage(carParkImage, 0, 0, 800, 500, null);
			}
		repaint();
            }
            
        }
		     
            
        /**
         * Paint a place on this car park view in a given color.
         */
        private void drawPlace(Graphics graphics, Location location, Color color) {
            graphics.setColor(color);
            graphics.fillRect(
                    location.getFloor() * 260 + (1 + (int)Math.floor(location.getRow() * 0.5)) * 75 + (location.getRow() % 2) * 20,
                    60 + location.getPlace() * 10,
                    20 - 1,
                    10 - 1); // TODO use dynamic size or constants
        }
        public static int GetAdHoc(){
        	return AdHocCar;
        }
        public static int GetParkPass(){
        	return ParkPassCar;
        }
        public static int GetReservationCar(){
        	return ReservationCar;
        }
        public static int GetReservedSpot(){
        	return ReservedSpot;
        }
    }