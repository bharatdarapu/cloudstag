package labs.cloudstag.com;

import java.awt.BorderLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DragAndDropExample {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Cloud Stag");
		JPanel panel = new JPanel();

		JComponent textArea = new DropTargetTextArea();

		frame.add(textArea, BorderLayout.CENTER);

		JLabel label = new JLabel("Drag your files here.");
		panel.add(label);

		frame.add(panel, BorderLayout.SOUTH);

		int frameWidth = 250;
		int frameHeight = 250;
		frame.setSize(frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	
	
	public static class DropTargetTextArea extends JTextArea implements
			DropTargetListener {

		public DropTargetTextArea() {

			new DropTarget(this, this);
		}

		public void drop(DropTargetDropEvent evt) {

			try {

				Transferable transferable = evt.getTransferable();

				if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {

					evt.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

					String dragContents = (String) transferable
							.getTransferData(DataFlavor.stringFlavor);

					evt.getDropTargetContext().dropComplete(true);

					setText(getText() + "\nFile: " + dragContents);

				} else {

					evt.rejectDrop();

				}

			} catch (IOException e) {

				evt.rejectDrop();

			} catch (UnsupportedFlavorException e) {

				evt.rejectDrop();

			}
		}

		@Override
		public void dragEnter(DropTargetDragEvent dtde) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dragOver(DropTargetDragEvent dtde) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dragExit(DropTargetEvent dte) {
			// TODO Auto-generated method stub
			
		}

	}

}