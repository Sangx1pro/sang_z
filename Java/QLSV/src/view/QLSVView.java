package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaThiSinh_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_queQuan;
	private Object view;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	public JComboBox comboBox_queQuan_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 777);
		
		Action action = new QLSVController(this);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
	
		JMenuItem mntmNewMenuItem = new JMenuItem("About me");
		mntmNewMenuItem.addActionListener(action);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_QueQuan = new JLabel("Quê Quán");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_QueQuan.setBounds(31, 11, 153, 54);
		contentPane.add(label_QueQuan);
		
		JLabel label_maThiSinh = new JLabel("Mã Sinh Viên");
		label_maThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_maThiSinh.setBounds(277, 11, 125, 54);
		contentPane.add(label_maThiSinh);
		
		textField_MaThiSinh_TimKiem = new JTextField();
		textField_MaThiSinh_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_MaThiSinh_TimKiem.setColumns(10);
		textField_MaThiSinh_TimKiem.setBounds(397, 12, 153, 54);
		contentPane.add(textField_MaThiSinh_TimKiem);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnTim.setBounds(576, 11, 85, 54);
		contentPane.add(btnTim);
		
		comboBox_queQuan_timKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for(Tinh tinh : listTinh)
		{
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setBounds(142, 32, 125, 21);
		contentPane.add(comboBox_queQuan_timKiem);
		
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 75, 756, 2);
		contentPane.add(separator_1);
		
		JLabel label_QueQuan_2 = new JLabel("Danh Sách Sinh Viên");
		label_QueQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_QueQuan_2.setBounds(10, 87, 189, 54);
		contentPane.add(label_QueQuan_2);
		

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Sinh Vi\u00EAn", "H\u1ECD T\u00EAn", "Qu\u00EA Qu\u00E1n","Ng\u00E0y Sinh", "Gi\u1EDBi T\u00EDnh", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3"
			}
		));
		
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 128, 777,194);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(31, 359, 756, 2);
		contentPane.add(separator_1_1);
		
		JLabel label_QueQuan_1 = new JLabel("Thông Tin");
		label_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_QueQuan_1.setBounds(31, 370, 111, 54);
		contentPane.add(label_QueQuan_1);
		
		JLabel label_maThiSinh_1 = new JLabel("Mã Sinh Viên");
		label_maThiSinh_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_maThiSinh_1.setBounds(20, 417, 153, 54);
		contentPane.add(label_maThiSinh_1);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_ID.setColumns(10);
		textField_ID.setBounds(153, 417, 166, 29);
		contentPane.add(textField_ID);
		
		JLabel label_HoVaTen = new JLabel("Họ Và Tên");
		label_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_HoVaTen.setBounds(20, 468, 153, 54);
		contentPane.add(label_HoVaTen);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(153, 481, 166, 29);
		contentPane.add(textField_HoVaTen);
		
		JLabel label_maThiSinh_1_1 = new JLabel("Quê Quán");
		label_maThiSinh_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_maThiSinh_1_1.setBounds(20, 532, 153, 54);
		contentPane.add(label_maThiSinh_1_1);
		
		JLabel label_NgaySinh = new JLabel("Ngày Sinh");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_NgaySinh.setBounds(10, 584, 153, 54);
		contentPane.add(label_NgaySinh);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(149, 597, 166, 29);
		contentPane.add(textField_NgaySinh);
		
		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for(Tinh tinh : listTinh)
		{
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		
		comboBox_queQuan.setBounds(155, 553, 160, 21);
		contentPane.add(comboBox_queQuan);
		
		JLabel label_maThiSinh_1_2 = new JLabel("Giới Tính");
		label_maThiSinh_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_maThiSinh_1_2.setBounds(422, 417, 103, 54);
		contentPane.add(label_maThiSinh_1_2);
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nam.setBounds(511, 435, 63, 21);
		contentPane.add(radioButton_nam);
		
		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nu.setBounds(576, 435, 63, 21);
		contentPane.add(radioButton_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);
		
		JLabel label_Mon1 = new JLabel("Môn 1");
		label_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Mon1.setBounds(410, 468, 153, 54);
		contentPane.add(label_Mon1);
		
		textField_Mon1 = new JTextField();
		textField_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(543, 481, 166, 29);
		contentPane.add(textField_Mon1);
		
		JLabel label_Mon2 = new JLabel("Môn 2");
		label_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Mon2.setBounds(410, 520, 153, 54);
		contentPane.add(label_Mon2);
		
		textField_Mon2 = new JTextField();
		textField_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(543, 533, 166, 29);
		contentPane.add(textField_Mon2);
		
		JLabel label_Mon3 = new JLabel("Môn 3");
		label_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Mon3.setBounds(410, 584, 153, 54);
		contentPane.add(label_Mon3);
		
		textField_Mon3 = new JTextField();
		textField_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(543, 597, 166, 29);
		contentPane.add(textField_Mon3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnThem.setBounds(44, 648, 85, 54);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnXoa.setBounds(162, 648, 85, 54);
		contentPane.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCapNhat.setBounds(277, 648, 125, 54);
		contentPane.add(btnCapNhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnLuu.setBounds(434, 648, 131, 54);
		contentPane.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Cancle");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuyBo.setBounds(608, 648, 131, 54);
		contentPane.add(btnHuyBo);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 636, 756, 2);
		contentPane.add(separator_1_2);
		
		JButton btnHuyTim = new JButton("Huỷ Tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuyTim.setBounds(671, 11, 116, 54);
		contentPane.add(btnHuyTim);
		
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaThiSinh_TimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText(""); 
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	
	public void themThiSinhVaoTable(ThiSinh ts)
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + "", });
	}
	
	public void themHoacSinhVien(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	if(!this.model.kiemTraTonTai(ts)) {
		this.model.insert(ts);
//		String mts = ts.getMaThiSinh()+ "";
		this.themThiSinhVaoTable(ts);
		}else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for(int i = 0;i < soLuongDong;i++)
			{
				String id = model_table.getValueAt(i,0) +"";
				if(id.equals(ts.getMaThiSinh()+ ""))
				{
					model_table.setValueAt(ts.getMaThiSinh()+"",i,0);
					model_table.setValueAt(ts.getTenThiSinh()+"",i,1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh()+"",i,2);
					model_table.setValueAt(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900)+"",i,3);
					model_table.setValueAt((ts.isGioiTinh()? "Nam" : "Nữ")+"",i,4);
					model_table.setValueAt(ts.getDiemMon1()+"",i,5);
					model_table.setValueAt(ts.getDiemMon2()+"",i,6);
					model_table.setValueAt(ts.getDiemMon3()+"",i,7);
				}
			}
		}
	}
	
	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaysinh = model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh = new Date(s_ngaysinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+ "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();
		
		this.textField_ID.setText(ts.getTenThiSinh());
		this.textField_HoVaTen.setText(ts.getTenThiSinh() + "");
		this.comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900);
		this.textField_NgaySinh.setText(s_ngaySinh + "");
		if(ts.isGioiTinh())
		{
			radioButton_nam.setSelected(true);
		}else {
			radioButton_nu.setSelected(true);
		}
		this.textField_Mon1.setText(ts.getDiemMon1()+"");
		this.textField_Mon2.setText(ts.getDiemMon2()+"");
		this.textField_Mon3.setText(ts.getDiemMon3()+"");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn xoá !");
		if(luaChon == JOptionPane.YES_OPTION)
		{
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemThiSinh() {
		//Get du lieu
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
//		String ngaySinh = this.view.textField_NgaySinh.getText();
		boolean gioiTinh = true;
		if(this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		}else if(this.radioButton_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());
		
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacSinhVien(ts);
	}

	public void thucHienTim() {
//		Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
//		Thuc hien tim kiem
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.textField_MaThiSinh_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan >= 0)
		{
		 Tinh tinhDaChon = Tinh.getTinhById(queQuan);
		 for(int i = 0;i < soLuongDong;i++)
		  {
			String tenTinh = model_table.getValueAt(i,2) +"";
			String id = model_table.getValueAt(i,0) + "";
			if(!tenTinh.equals(tinhDaChon.getTenTinh()))
			{
				idCuaThiSinhCanXoa.add(Integer.valueOf(id));
			}
		  }
		}
		if(maThiSinhTimKiem.length() > 0){
			 for(int i = 0;i < soLuongDong;i++)
			  {
				String id = model_table.getValueAt(i,0) + "";
				if(!id.equals(maThiSinhTimKiem))
				{
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			  }
		}
		
		for(Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong = model_table.getColumnCount();
			for(int i = 0;i < soLuongDong;i++)
			  {
				String idTrongTable = model_table.getValueAt(i,0) + "";
				if(idTrongTable.equals(idCanXoa.toString()))
				{
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			  }
		}
	}
	
	public void thucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong == 0)
			{
				break;
			}else 
			{
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Quản Lý Sinh Viên");
		
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình ?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	
	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}
	

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
	
//End Block
}
