/**
 * �N���X���F	PrintOutAction
 * �T�v�@�@�F	����A�N�V����
 * �쐬�Җ��F
 * �쐬���@�F
 * �C���Җ��F
 * �C�����@�F
 */

package kidda.action;

import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class PrintOutAction {

	public void execute(JFrame frame) throws Exception {

		Toolkit toolKit = Toolkit.getDefaultToolkit();
		PrintJob printJob = toolKit.getPrintJob(frame, "【配達情報印刷】", null);

		if(printJob != null) {

			Graphics graphics = printJob.getGraphics();
			graphics.translate(20, 20);
			frame.printAll(graphics);
			printJob.end();
		}
	}
}
