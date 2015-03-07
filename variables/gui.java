package uaiominer.variables;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import uaiominer.strategies.Banking;

public class gui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public gui() {
		initComponents();
	}

	private void button_RunActionPerformed(ActionEvent e) {
		String chosen = comboBox_Ore.getSelectedItem().toString();
		if (chosen.equals("Tin Ore")) {
			constants.oreId = constants.tinOre;
		} else {
			if (chosen.equals("Iron Ore")) {
				constants.oreId = constants.ironOre;

			} else {
				if (chosen.equals("Silver Ore")) {
					constants.oreId = constants.silverOre;

				} else {
					if (chosen.equals("Coal")) {
						constants.oreId = constants.coalOre;
					} else {
						if (chosen.equals("Gold Ore")) {
							constants.oreId = constants.goldOre;
						} else {
							if (chosen.equals("Mithril Ore")) {
								constants.oreId = constants.mithrilOre;
							} else {
								if (chosen.equals("Adamantite Ore")) {
									constants.oreId = constants.adamantiteOre;
								} else {
									if (chosen.equals("Runeite Ore")) {
										constants.oreId = constants.runeiteOre;
									}
								}
							}
						}
					}
				}
			}
		}
		String location = comboBox_Location.getSelectedItem().toString();
		if (location.equals("Varrock East")) {
			Banking.x = 270;
			Banking.y = 383;
		} else {
			if (location.equals("Al Kharid")) {
				Banking.x = 260;
				Banking.y = 398;
			} else {
				if (location.equals("Dwarven Mine")) {
					Banking.x = 260;
					Banking.y = 416;
				} else {
					if (location.equals("Lumbridge East")) {
						Banking.x = 260;
						Banking.y = 429;
					}
				}
			}
		}
		setVisible(false);
	}

	private void initComponents() {
		tabbedPane1 = new JTabbedPane();
		panel1 = new JPanel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label9 = new JLabel();
		panel2 = new JPanel();
		checkBox_Relogin = new JCheckBox();
		comboBox_Location = new JComboBox<>();
		comboBox_Ore = new JComboBox<>();
		label1 = new JLabel();
		label2 = new JLabel();
		checkBox_Powermine = new JCheckBox();
		label8 = new JLabel();
		button_Run = new JButton();

		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		{
			tabbedPane1.setFont(new Font("Tekton Pro", Font.BOLD, 14));

			{

				panel1.setLayout(null);

				// ---- label3 ----
				label3.setText("UMiner - Aio");
				label3.setFont(new Font("Trajan Pro", Font.BOLD | Font.ITALIC,
						18));
				panel1.add(label3);
				label3.setBounds(65, 5, 190, label3.getPreferredSize().height);

				// ---- label4 ----
				label4.setText("Information");
				label4.setFont(new Font("Trajan Pro", Font.BOLD, 12));
				panel1.add(label4);
				label4.setBounds(5, 35, 100, label4.getPreferredSize().height);

				// ---- label5 ----
				label5.setText("- Choose mining location, Then select correct ore");
				panel1.add(label5);
				label5.setBounds(5, 60, 350, label5.getPreferredSize().height);

				// ---- label6 ----
				label6.setText("That is at the mining location");
				panel1.add(label6);
				label6.setBounds(10, 80, 215, label6.getPreferredSize().height);

				// ---- label7 ----
				label7.setText("- Auto Relog will log you in if logged out");
				panel1.add(label7);
				label7.setBounds(5, 100, 220, label7.getPreferredSize().height);

				// ---- label9 ----
				label9.setText("- Will bank if powermine is not selected");
				panel1.add(label9);
				label9.setBounds(5, 120, 240, label9.getPreferredSize().height);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for (int i = 0; i < panel1.getComponentCount(); i++) {
						Rectangle bounds = panel1.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width,
								preferredSize.width);
						preferredSize.height = Math.max(bounds.y
								+ bounds.height, preferredSize.height);
					}
					Insets insets = panel1.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel1.setMinimumSize(preferredSize);
					panel1.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("Information", panel1);

			// ======== panel2 ========
			{
				panel2.setLayout(null);

				// ---- checkBox_Relogin ----
				checkBox_Relogin.setText("Want To Auto Login?");
				checkBox_Relogin.setFont(new Font("Arial", Font.BOLD, 11));
				panel2.add(checkBox_Relogin);
				checkBox_Relogin.setBounds(160, 25, 150,
						checkBox_Relogin.getPreferredSize().height);

				// ---- comboBox_Location ----
				comboBox_Location.setModel(new DefaultComboBoxModel<>(
						new String[] { "Varrock East", "Al Kharid",
								"Dwarven Mine", "Lumbridge East" }));
				panel2.add(comboBox_Location);
				comboBox_Location.setBounds(10, 25, 140,
						comboBox_Location.getPreferredSize().height);

				// ---- comboBox_Ore ----
				comboBox_Ore.setModel(new DefaultComboBoxModel<>(new String[] {
						"Copper Ore", "Tin Ore", "Iron Ore", "Silver Ore",
						"Coal", "Gold Ore", "Mithril Ore", "Adamantite Ore",
						"Runeite Ore" }));
				panel2.add(comboBox_Ore);
				comboBox_Ore.setBounds(10, 85, 140,
						comboBox_Ore.getPreferredSize().height);

				// ---- label1 ----
				label1.setText("Location To Mine");
				label1.setFont(new Font("Trajan Pro", Font.BOLD, 12));
				panel2.add(label1);
				label1.setBounds(10, 5, 135, label1.getPreferredSize().height);

				// ---- label2 ----
				label2.setText("Ore To Mine");
				label2.setFont(new Font("Trajan Pro", Font.BOLD, 12));
				panel2.add(label2);
				label2.setBounds(new Rectangle(new Point(10, 65), label2
						.getPreferredSize()));

				// ---- checkBox_Powermine ----
				checkBox_Powermine.setText("Power Mine?");
				panel2.add(checkBox_Powermine);
				checkBox_Powermine.setBounds(160, 85, 115,
						checkBox_Powermine.getPreferredSize().height);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for (int i = 0; i < panel2.getComponentCount(); i++) {
						Rectangle bounds = panel2.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width,
								preferredSize.width);
						preferredSize.height = Math.max(bounds.y
								+ bounds.height, preferredSize.height);
					}
					Insets insets = panel2.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel2.setMinimumSize(preferredSize);
					panel2.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("Settings", panel2);
		}
		contentPane.add(tabbedPane1);
		tabbedPane1.setBounds(0, 0, 315, 175);

		// ---- label8 ----
		label8.setText("Made by - Unknownuser");
		label8.setFont(new Font("Trajan Pro", Font.BOLD, 12));
		contentPane.add(label8);
		label8.setBounds(5, 230, 190, label8.getPreferredSize().height);

		// ---- button_Run ----
		button_Run.setText("Run");
		button_Run.addActionListener(e -> button_RunActionPerformed(e));
		contentPane.add(button_Run);
		button_Run
				.setBounds(10, 180, 120, button_Run.getPreferredSize().height);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for (int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width,
						preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height,
						preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - etw regre
	private JTabbedPane tabbedPane1;
	private JPanel panel1;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label9;
	private JPanel panel2;
	static JCheckBox checkBox_Relogin;
	private JComboBox<String> comboBox_Location;
	private JComboBox<String> comboBox_Ore;
	private JLabel label1;
	private JLabel label2;
	static JCheckBox checkBox_Powermine;
	private JLabel label8;
	private JButton button_Run;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
