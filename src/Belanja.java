import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Belanja extends JFrame {

	private JPanel contentPane;
	private JTextField angka1;
	private JTextField angka2;
	private JTextField bayar;
	private JTextField total;
	private JTextField kembalian;
	
	Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Belanja frame = new Belanja();
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
	public Belanja() {
		setTitle("Aneka Payment App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Toko Aneka");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(156, 23, 121, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Harga Barang");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(86, 71, 107, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jumlah Barang");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(86, 107, 107, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Uang yang dibayar");
		lblNewLabel_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(79, 148, 121, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		angka1 = new JTextField();
		angka1.setBounds(203, 71, 107, 20);
		contentPane.add(angka1);
		angka1.setColumns(10);
		
		angka2 = new JTextField();
		angka2.setColumns(10);
		angka2.setBounds(203, 112, 107, 20);
		contentPane.add(angka2);
		
		bayar = new JTextField();
		bayar.setColumns(10);
		bayar.setBounds(203, 151, 107, 20);
		contentPane.add(bayar);
		
		JLabel lblNewLabel_2 = new JLabel("Total Belanja");
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(99, 260, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Uang Kembalian");
		lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(92, 295, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		total = new JTextField();
		total.setBounds(203, 258, 107, 20);
		contentPane.add(total);
		total.setColumns(10);
		
		kembalian = new JTextField();
		kembalian.setBounds(203, 289, 107, 20);
		contentPane.add(kembalian);
		kembalian.setColumns(10);
		
		JButton btnNewButton = new JButton("Hitung");
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalJumlah = Integer.parseInt(angka1.getText()) * Integer.parseInt(angka2.getText());
				total.setText("" + totalJumlah);
				
				int kembalianJumlah = Integer.parseInt(bayar.getText()) - Integer.parseInt(total.getText());
				kembalian.setText("" + kembalianJumlah);
			}
		});
		btnNewButton.setBounds(58, 205, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ulang");
		btnNewButton_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				angka1.setText("");
				angka2.setText("");
				bayar.setText("");
				total.setText("");
				kembalian.setText("");
			}
		});
		btnNewButton_1.setBounds(172, 205, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Keluar");
		btnNewButton_2.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(287, 205, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		// Timer
		
		final JLabel Jam = new JLabel("");
		Jam.setFont(new Font("Roboto", Font.PLAIN, 12));
		Jam.setBounds(343, 35, 81, 25);
		contentPane.add(Jam);
		
		final JLabel Tanggal = new JLabel("");
		Tanggal.setFont(new Font("Roboto", Font.PLAIN, 12));
		Tanggal.setBounds(343, 11, 81, 25);
		contentPane.add(Tanggal);
		
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
				String time = timeFormat.format(date);
				Jam.setText(time);
				
				Date date1 = new Date();
				DateFormat timeFormat1 = new SimpleDateFormat("dd/MM/YY");
				String time1 = timeFormat1.format(date1);
				Tanggal.setText(time1);
			}
		};
		
		timer = new Timer(1000, actionListener);
		timer.setInitialDelay(0);
		timer.start();
		
	}
}
