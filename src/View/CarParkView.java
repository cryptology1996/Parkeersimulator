package View;

import java.awt.*;


import Model.*;

public class CarParkView extends AbstractView {
        
        private Dimension size;
        private Image carParkImage;   
        //private Simulator model;
        //added
        private ParkeerGarage parkeerGarage;
        //ParkeerGarage = new ParkeerGarage(); 
    
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
            return new Dimension(1920, 1000);
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
            Graphics graphics = carParkImage.getGraphics();
            for(int floor = 0; floor < parkeerGarage.getNumberOfFloors(); floor++) {
                for(int row = 0; row < parkeerGarage.getNumberOfRows(); row++) {
                    for(int place = 0; place < parkeerGarage.getNumberOfPlaces(); place++) {
                        Location location = new Location(floor, row, place);
                        Car car = parkeerGarage.getCarAt(location);
                        Color color = car == null ? Color.white : car.getColor();
                        drawPlace(graphics, location, color);
                    }
                }
            }
            if (carParkImage == null) {
				return;
			}

				Dimension currentSize = getSize();
				System.out.println(currentSize);
				if (size.equals(currentSize)) {
					g.drawImage(carParkImage, 0, 0, null);
				}
				else {
        // Rescale the previous image.
					g.drawImage(carParkImage, 0, 0, 800, 500, null);
			}
		repaint();
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
    }