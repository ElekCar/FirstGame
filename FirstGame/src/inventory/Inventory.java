package inventory;

import java.applet.Applet;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import People.WoodCutter;
import graphics.Tiles;
import input.MainFrameMouseListener;
import input.PlantGrainMouseListener;
import input.PlantWortelMouseListener;
import input.UpdateMoney;

public class Inventory extends JFrame{
	
	private static JFrame frame;
	private static JButton wortel, wortelEten;
	private static JButton grain, grainEten;
	private static JButton money;

	private static JTextField grainVerkopen;
	private static JTextField wortelVerkopen;
	private static JTextField moneyVerkopen;

	private static JLabel grainAantal;
	private static JLabel wortelAantal;
	private static JLabel moneyAantal;

	public static void createFrame(){
		frame = new JFrame();
		frame.setTitle("grondstoffen");
		frame.setSize(64*8, 64*3);
		frame.setResizable(false);
		frame.setLocation(0, 300);
		
		BufferedImage buttonIcon = Tiles.tiles[11];
	    grain = new JButton(new ImageIcon(buttonIcon));
	    grain.setBorderPainted(false);
	    grain.setFocusPainted(false);
	    grain.setContentAreaFilled(false);
	    grain.addMouseListener(new PlantGrainMouseListener());
	    
	    BufferedImage buttonIcon2 = Tiles.tiles[13];
	    wortel = new JButton(new ImageIcon(buttonIcon2));
	    wortel.setBorderPainted(false);
	    wortel.setFocusPainted(false);
	    wortel.setContentAreaFilled(false);
	    wortel.addMouseListener(new PlantWortelMouseListener());
	    
	    BufferedImage buttonIcon3 = Tiles.money;
	    money = new JButton(new ImageIcon(buttonIcon3));
	    money.setBorderPainted(false);
	    money.setFocusPainted(false);
	    money.setContentAreaFilled(false);
	    money.addMouseListener(new UpdateMoney());
	    
	    grainAantal = new JLabel();
	    wortelAantal = new JLabel();
	    moneyAantal = new JLabel();
	    
	    grainEten = new JButton();
	    grainEten.setText("geef soldaat eten");
	    grainEten.addMouseListener(new UpdateMoney());
	    
	    wortelEten = new JButton();
	    wortelEten.setText("geef soldaat eten");
	    wortelEten.addMouseListener(new UpdateMoney());
	    
	    grainVerkopen = new JTextField();
	    wortelVerkopen = new JTextField();
	    moneyVerkopen = new JTextField();

		frame.setLayout(new GridLayout(3,4));
		
		frame.add(grain);
		frame.add(grainAantal);
		frame.add(grainVerkopen);
		frame.add(grainEten);
		
		frame.add(wortel);
		frame.add(wortelAantal);
		frame.add(wortelVerkopen);	
		frame.add(wortelEten);
		
		frame.add(money);
		frame.add(moneyAantal);
		frame.add(moneyVerkopen);
		
		
		frame.setVisible(true);
	}
	
	public static boolean healthOfMoney;
	
	public static void geefEten(){
		WoodCutter.vermeerderHealth();
	}
	
	public static void updateGrainAantal(int grainUpdate){
		grainAantal.setText(String.valueOf(grainUpdate));
	}
	
	public static void updateWortelAantal(int wortelUpdate){
		wortelAantal.setText(String.valueOf(wortelUpdate));
	}
	
	private static int totalMoney;
	
	public static void updateMoney(){

		if(Integer.valueOf(grainAantal.getText())-Integer.valueOf(grainVerkopen.getText())>=0){
			totalMoney+=Integer.valueOf(grainVerkopen.getText())*10;
			MainFrameMouseListener.grainUpdate-=Integer.valueOf(grainVerkopen.getText());
			updateGrainAantal(MainFrameMouseListener.grainUpdate);
			moneyAantal.setText(String.valueOf(totalMoney));

		}
		if(Integer.valueOf(wortelAantal.getText())-Integer.valueOf(wortelVerkopen.getText())>=0){
			totalMoney+=Integer.valueOf(wortelVerkopen.getText())*10;
			MainFrameMouseListener.wortelUpdate-=Integer.valueOf(wortelVerkopen.getText());
			updateWortelAantal(MainFrameMouseListener.wortelUpdate);
			moneyAantal.setText(String.valueOf(totalMoney));
		}
	}
	
	public static JButton getMoney() {
		return money;
	}

	public static void setMoney(JButton money) {
		Inventory.money = money;
	}

	public static JTextField getGrainVerkopen() {
		return grainVerkopen;
	}

	public static void setGrainVerkopen(JTextField grainVerkopen) {
		Inventory.grainVerkopen = grainVerkopen;
	}

	public static JTextField getMoneyVerkopen() {
		return moneyVerkopen;
	}

	public static void setMoneyVerkopen(JTextField moneyVerkopen) {
		Inventory.moneyVerkopen = moneyVerkopen;
	}

	public static JLabel getGrainAantal() {
		return grainAantal;
	}

	public static void setGrainAantal(JLabel grainAantal) {
		Inventory.grainAantal = grainAantal;
	}

	public static JLabel getMoneyAantal() {
		return moneyAantal;
	}

	public static void setMoneyAantal(JLabel moneyAantal) {
		Inventory.moneyAantal = moneyAantal;
	}

	public static int getTotalMoney() {
		return totalMoney;
	}

	public static void setTotalMoney(int totalMoney) {
		Inventory.totalMoney = totalMoney;
	}
	
	
}

