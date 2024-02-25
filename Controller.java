import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Controller implements ActionListener, MouseListener, KeyListener
{
	private View view;
	private Model model;

	private boolean editMode = false;
  private boolean addingWalls = true;


	public Controller(Model m)
	{
		model = m;
	}

	public void setView(View v)
	{
		view = v;
	}


	public void mousePressed(MouseEvent e)
	{
		if (editMode) {
			if (addingWalls && editMode) {
				// Add a new wall at the click position
				Wall wall = new Wall(e.getX(), e.getY(), 100, 100); // Example dimensions
				model.addWall(wall);
			} else {
				// Remove a wall at the click position
				model.removeWallAt(e.getX(), e.getY());
			}
			view.repaint(); // Repaint to reflect changes
		}

		/*if (editMode) {
			if (addingWalls) {
				// Add a new wall
				Wall wall = new Wall(e.getX(), e.getY(), 50, 50); // Example dimensions
				model.addWall(wall);
			} else {
				// Remove a wall if clicked
				model.removeWallIfClicked(e.getX(), e.getY());
			}
			view.repaint(); // Repaint to update the view
		}*/

	}

	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}



	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{ 

			case KeyEvent.VK_Q:
			if (e.getKeyChar() == 'q' || e.getKeyChar() == 'Q') 
			{ 
			System.exit(0);
			} 

            case KeyEvent.VK_ESCAPE: 
			System.exit(0); break;// exit game

			case KeyEvent.VK_E:
            editMode = !editMode; // Toggle edit mode
            if (editMode) 
			{
                addingWalls = true; // Default to adding walls when entering edit mode
            }
            System.out.println("Edit mode: " + (editMode ? "ON" : "OFF"));
            break;

        	case KeyEvent.VK_A:
            if (editMode) 
			{
                addingWalls = !addingWalls; // Toggle between adding and removing walls
                System.out.println("Adding Walls: " + addingWalls);
            }
            break;

        case KeyEvent.VK_C:
            model.clearWalls(); // Clear all walls
            view.repaint(); // Repaint the view to reflect the cleared walls
            System.out.println("Cleared all walls");
            break;
			
		}

	}

	public void keyReleased(KeyEvent e)
	{
		
	}

	public void keyTyped(KeyEvent e)
	{
	}


}
