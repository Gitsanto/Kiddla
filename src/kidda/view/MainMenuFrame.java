/**
 * �N���X���F	MainMenuFrame
 * �T�v�@�@�F	�u���C�����j���[�v���
 * �쐬�Җ��F
 * �쐬���@�F
 * �C���Җ��F
 * �C�����@�F
 */

package kidda.view;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import kidda.control.KiddaLaController;
import kidda.model.OrderControlUtility;

public class MainMenuFrame extends JFrame implements ActionListener {

	public MainMenuFrame() {


		OrderControlUtility.setIconImage(this);

		setTitle("【メインメニュー】 KIDDA-LA 業務システム");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		JButton orderControl = new JButton("01 注文管理");
		orderControl.setBounds(20, 20, 460, 40);
		orderControl.addActionListener(this);
		add(orderControl);

		setVisible(true);
	}

	public void addNotify() {

		super.addNotify();

		Insets insets = getInsets();
		setSize(500 + insets.left + insets.right, 250 + insets.top + insets.bottom);
		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent e) {

		setVisible(false);

		KiddaLaController.customerSearchDisplay();
	}
}