package libararypublisher;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class LibraryServiceImpl implements LibraryService {

	LibraryMenuWindow menuWindow;
	
	@Override
	public void publishService() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		menuWindow = new LibraryMenuWindow();
		menuWindow.setVisible(true);
	}

	@Override
	public void disposeService() {
		menuWindow.dispose();
	}

}
