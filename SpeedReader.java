/**
 * Program to implement RSVP speed reader using StdDraw library.
 *
 * This assignment originally created by Peter-Michael Osera at University of Pennsylvania.
 * 
 * @author Chris Murphy
 */

public class SpeedReader {

    /*
    This method is responsible for updating the text in the window for the speed reader.
    You will need to change the parameters as you complete this part of the assignment.
     */
    public static void show() {

        // this sets up the window... don't forget to call it!
        setup();

        // this represents the number to be displayed in the window
        int count = 0;

        while (true) { // this is an infinite loop but it's fine for now!

            // increment the number to display on each iteration of the loop
            count++;

            // this places the text in the center of the screen
            // the coordinate (50, 50) is used for the center of the text
            StdDraw.text(50, 50, String.valueOf(count));

            // this displays the text
            StdDraw.show();

            // this causes the program to wait for 500ms
            StdDraw.pause(500);

            // this removes everything that is being displayed
            StdDraw.clear();

        }

    }

    /*
    This method sets up the window for the speed reader.
    You should not need to change anything here!
    Please speak to the Instructor if you think any change is necessary.
     */
    private static void setup() {
        // this creates a window of 800x600 pixels
        StdDraw.setCanvasSize(800, 400);

        // this sets the scale of the x- and y-axis to be from 0 to 100
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        // this enables animation so that things don't appear jittery
        StdDraw.enableDoubleBuffering();

        // this sets the drawing color to black
        StdDraw.setPenColor(StdDraw.BLACK);

        // this sets the text font to be fixed-width
        StdDraw.setFont(new java.awt.Font("COURIER", java.awt.Font.BOLD, 100));
    }


    public static void main(String[] args) {
        // modify this code as needed in order to pass arguments to the show() method
        show();
    }
    
}
