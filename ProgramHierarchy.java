/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
//Declaring Box Height as constant
	private static final int BOX_HEIGHT = 50;
//Declaring Box Width as constant
	private static final int BOX_WIDTH = 150;
//Declaring Row Height as constant
	private static final int ROW_DISTANCE = 100;
//Declaring Box Distance as constant
	private static final int BOX_DISTANCE = 20;
//Declaring Number of Under Boxes
	private static final int UNDER_BOXES = 3;
	
	public void run() {
		//Using center of screen as reference point
		int x = getWidth()/2;
		int y = getHeight()/2;
		//Declaring box labels as strings within an array
		String name[] = new String[4];
		name[0] = "Program";
		name[1] = "GraphicsProgram";
		name[2] = "ConsoleProgram";
		name[3] = "DialogProgram";
		//Adding first box
		addBox(x-(BOX_WIDTH/2), y-(BOX_HEIGHT)-(ROW_DISTANCE/2), name[0]);
		//Adding under boxes w/ labels and linking them to the upper box with a line from center top of under box to center bottom of upper box
		int xcord = x - ((UNDER_BOXES*BOX_WIDTH)/2+((UNDER_BOXES-1)*BOX_DISTANCE)/2);
		for(int i=0; i<UNDER_BOXES; i++){
		addBox(xcord,y+(ROW_DISTANCE/2), name[i+1]);
		GLine link = new GLine(xcord+(BOX_WIDTH/2), y+(ROW_DISTANCE/2), x, y-(ROW_DISTANCE/2));
		xcord += BOX_DISTANCE + BOX_WIDTH;
		add(link);
		}
	}
	//Takes in coordinates of box and label name, then draws box at coordinates, adds and centers label within the box.
	private void addBox(int x, int y, String name){
		GRect rect = new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(rect);
		GLabel label = new GLabel(name, x, y);
		label.setLocation(x+(BOX_WIDTH/2)-(label.getWidth()/2), y+(BOX_HEIGHT/2)+(label.getAscent()/2));
		add(label);
	}
	
}

