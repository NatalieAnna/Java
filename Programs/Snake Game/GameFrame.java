import javax.swing.JFrame;

public class GameFrame extends JFrame {

	public GameFrame() {
		
		GamePanel panel = new GamePanel(); // or just 'new GamePanel()'
		this.add(panel); // or 'this.add(new GamePanel());
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
}
