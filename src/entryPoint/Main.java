package entryPoint;

import View.Menu;



public class Main extends Menu
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) 
	{
		try {
			Menu frame = new Menu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
