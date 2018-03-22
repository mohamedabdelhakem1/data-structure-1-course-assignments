package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PolynomialSolver extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -1712534205806686845L;
	MyPolynomialSolver poly = new MyPolynomialSolver();
	private JPanel contentPane;
	private JTextField input;
	private JTextArea output;
	private char ch1;
	private char ch2;
	private String s = "";
	boolean flag = false;
	private JButton btnEnterVariables;
	private int counter = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PolynomialSolver frame = new PolynomialSolver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PolynomialSolver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(40, 86, 261, 14);
		contentPane.add(label);

		JLabel lblMenu = new JLabel("1- Set a polynomial variable");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMenu.setBounds(40, 23, 240, 14);
		contentPane.add(lblMenu);

		JLabel lblNewLabel = new JLabel("2- Print the value of a polynomial variable");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(40, 40, 251, 14);
		contentPane.add(lblNewLabel);

		JLabel lblAddTwo = new JLabel("3- Add two polynomials");
		lblAddTwo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddTwo.setBounds(39, 55, 141, 14);
		contentPane.add(lblAddTwo);

		JLabel lblNewLabel_1 = new JLabel("4- Subtract two polynomials");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(40, 71, 240, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblSubtractTwo = new JLabel("5- Multiply two polynomials");
		lblSubtractTwo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSubtractTwo.setBounds(40, 86, 200, 14);
		contentPane.add(lblSubtractTwo);

		JLabel lblNewLabel_2 = new JLabel("6- Evaluate a polynomial at some point");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(40, 102, 218, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("7- Clear a polynomial variable");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(40, 117, 200, 14);
		contentPane.add(lblNewLabel_3);

		input = new JTextField();
		input.setBounds(139, 142, 343, 55);
		contentPane.add(input);
		input.setColumns(10);

		JLabel lblInput = new JLabel("input");
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setBounds(40, 161, 62, 14);
		contentPane.add(lblInput);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 221, 345, 124);
		contentPane.add(scrollPane);

		output = new JTextArea();
		scrollPane.setViewportView(output);

		JLabel lblOutput = new JLabel("output");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOutput.setBounds(40, 271, 46, 14);
		contentPane.add(lblOutput);

		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addThePoly();
			}
		});
		btnAdd.setBounds(323, 20, 141, 23);
		contentPane.add(btnAdd);

		JButton btnMultiply = new JButton("multiply");
		btnMultiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				multiplyThePoly();
			}
		});
		btnMultiply.setBounds(506, 20, 129, 23);
		contentPane.add(btnMultiply);

		JButton btnSubtracte = new JButton("subtracte");
		btnSubtracte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				subtractTHePoly();
			}
		});
		btnSubtracte.setBounds(323, 52, 141, 23);
		contentPane.add(btnSubtracte);

		JButton btnSetPolynomial = new JButton("set polynomial");
		btnSetPolynomial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setpoly();
			}
		});
		btnSetPolynomial.setBounds(403, 114, 156, 23);
		contentPane.add(btnSetPolynomial);

		JButton btnEvaluate = new JButton("evaluate");
		btnEvaluate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				evaluate();
			}
		});
		btnEvaluate.setBounds(506, 52, 129, 23);
		contentPane.add(btnEvaluate);

		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearThePoly();
			}
		});
		btnClear.setBounds(323, 83, 141, 23);
		contentPane.add(btnClear);

		JButton btnPrintPolynomial = new JButton("print polynomial");
		btnPrintPolynomial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				print();
			}
		});
		btnPrintPolynomial.setBounds(506, 83, 129, 23);
		contentPane.add(btnPrintPolynomial);

		btnEnterVariables = new JButton("Enter variables");

		btnEnterVariables.setBounds(139, 374, 119, 23);
		contentPane.add(btnEnterVariables);

		JButton btnUserGuide = new JButton("user guide");
		btnUserGuide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"press the button of operation you want from the 7 avaliable operations \n(enter variables) button  to enter your inputs  " );
			}
		});
		btnUserGuide.setBounds(358, 374, 124, 23);
		contentPane.add(btnUserGuide);
	}

	public void splitter(String s) {

		String[] inputs = s.split(",");
		int[][] terms = new int[inputs.length / 2][2];
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
				String ss = "";
				int k;
				for (k = i; Character.isDigit(s.charAt(k)) || (s.charAt(k) == '-'); k++) {
					ss += s.charAt(k);
				}
				i = k;
				terms[count1][count2] = Integer.parseInt(ss);
				ss = "";
				count2++;
				if (count2 == 2) {
					count2 = 0;
					count1++;
				}
			}
		}

		poly.setPolynomial(ch1, terms);
		return;
	}

	public void setpoly() {
		counter = 0;
		output.setText("Insert the variable name: A, B or C and press enter");
		ActionListener ac2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (counter == 0) {
					s = input.getText();
					if (!s.isEmpty()) {
						ch1 = s.charAt(0);
						output.setText("Insert the polynomial terms in the form:" + "\n"
								+ "(coeff1, exponent1), (coeff2, exponent2), . and prss enter");
						input.setText("");
						counter++;
					}

				} else {
					s = input.getText();
					output.setText("variable is set");
					splitter(s);
					clearbtn(btnEnterVariables);
					counter = 0;
				}

			}
		};
		btnEnterVariables.addActionListener(ac2);

	}

	public void addThePoly() {
		counter = 0;
		output.setText("Insert first operand variable name: A, B or C");
		input.setText("");
		ActionListener ac2 = (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (counter == 0) {
					s = input.getText();
					if (!s.isEmpty()) {
						ch1 = s.charAt(0);
						input.setText("");
						output.setText("");
						output.setText("Insert second operand variable name: A, B or C");
						input.setText("");
						counter++;
					}
				} else {
					s = input.getText();
					if (!s.isEmpty()) {
						ch2 = s.charAt(0);
						input.setText("");
						output.setText("");
						clearbtn(btnEnterVariables);
						counter = 0;
						poly.add(ch1, ch2);
					}
				}

			}

		});

		btnEnterVariables.addActionListener(ac2);



	}

	public void subtractTHePoly() {
		counter = 0;
		output.setText("Insert first operand variable name: A, B or C");
		input.setText("");
		ActionListener ac2 = (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (counter == 0) {
					s = input.getText();
					if (!s.isEmpty()) {
						ch1 = s.charAt(0);
						input.setText("");
						output.setText("");
						output.setText("Insert second operand variable name: A, B or C");
						input.setText("");
						counter++;
					}
				} else {
					s = input.getText();
					if (!s.isEmpty()) {
						ch2 = s.charAt(0);
						input.setText("");
						output.setText("");
						clearbtn(btnEnterVariables);
						counter = 0;
						poly.subtract(ch1, ch2);
					}
				}

			}

		});

		btnEnterVariables.addActionListener(ac2);



	}

	public void multiplyThePoly() {

		counter = 0;
		output.setText("Insert first operand variable name: A, B or C");
		input.setText("");
		ActionListener ac2 = (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (counter == 0) {
					s = input.getText();
					if (!s.isEmpty()) {
						ch1 = s.charAt(0);
						input.setText("");
						output.setText("");
						output.setText("Insert second operand variable name: A, B or C");
						input.setText("");
						counter++;
					}
				} else {
					s = input.getText();
					if (!s.isEmpty()) {
						ch2 = s.charAt(0);
						input.setText("");
						output.setText("");
						clearbtn(btnEnterVariables);
						counter = 0;
						poly.multiply(ch1, ch2);
					}
				}

			}

		});

		btnEnterVariables.addActionListener(ac2);



	}

	public void evaluate() {
		counter = 0;
		output.setText("Insert the variable name: A, B , C , R and press enter");
		input.setText("");
		ActionListener ac2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(counter == 0) {
				output.setText("enter the value to be substituted");
				s = input.getText();
				if(!s.isEmpty()) {
				ch1 = s.charAt(0);
				input.setText("");
				counter++;
				}
				}
				else {
					String f = input.getText();
					try {
						float x = Float.parseFloat(f);
						f = "";
						f += poly.evaluatePolynomial(ch1, x);
						output.setText(f);
						clearbtn(btnEnterVariables);

					} catch (NumberFormatException r) {
						r.printStackTrace();
					}

				}
			}
		};
		btnEnterVariables.addActionListener(ac2);

	}

	public void clearThePoly() {

			output.setText("Insert the variable name: A, B , C , R and press enter");
			input.setText("");
			btnEnterVariables.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					s = input.getText();
					if(!s.isEmpty()) {
					ch1 = s.charAt(0);
					input.setText("");
					poly.clearPolynomial(ch1);
					if (poly.ISEmpty(ch1)) {
						output.setText("the polynomial is cleared");
					} else {
						output.setText("the polynomial is not cleared , try again");
					}
					} else {
						output.setText("the polynomial is not cleared , try again");
					}


				}
			});



	}

	public void print() {

		output.setText("Insert the variable name: A, B , C , R and press enter");
		input.setText("");
		btnEnterVariables.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				s = input.getText();
				if(!s.isEmpty()) {
				ch1 = s.charAt(0);
				input.setText("");
				if (ch1 == 'A' || ch1 == 'B' || ch1 == 'C' ||ch1 == 'R') {

					output.setText(poly.print(ch1));

				}
				}
			}
		});

	}

	public void clearbtn(JButton b) {
		for (ActionListener al : btnEnterVariables.getActionListeners()) {
			btnEnterVariables.removeActionListener(al);
		}
	}
}
