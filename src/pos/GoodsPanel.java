package pos;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GoodsPanel extends JPanel implements ActionListener{
	JPanel p_south,p_north;
	JTable table;
	JTextField t_search;
	JScrollPane scroll;
	JLabel la_name;
	Choice choice;
	JButton bt_search,bt_reg,bt_edit;
	DataController dataController;
	
	public GoodsPanel() {
		p_south = new JPanel();
		p_north = new JPanel();
		table = new JTable(3,4);
		t_search = new JTextField(20);
		scroll =new JScrollPane(table);
		la_name =new JLabel("이름");
		choice = new Choice();
		bt_search = new JButton("검색");
		bt_reg = new JButton("직원 계정 추가");
		bt_edit = new JButton("직원 정보 수정");
		dataController = new DataController();
		//dataController.get();
		choice.add("이름");
		choice.add("ID");
		
		p_south.setPreferredSize(new Dimension(800, 70));
		setLayout(new BorderLayout());
		p_north.add(bt_reg);
		p_north.add(bt_edit);
		p_south.add(choice);
		p_south.add(t_search);
		p_south.add(bt_search);
		
		//버튼에 리스너 연결
		bt_edit.addActionListener(this);
		bt_reg.addActionListener(this);
		bt_search.addActionListener(this);
		
		//테이블 초기 설정
		table.setModel(dataController.getDataModel());
		
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		add(p_south,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bt_reg){
			regist();
		}else if(obj == bt_edit){
			edit();
		}else if(obj == bt_search){
			search();
		}
	}
	public void regist(){
		JOptionPane.showMessageDialog(this, "회원 계정 등록");
	}
	public void edit(){
		JOptionPane.showMessageDialog(this, "회원 정보 수정");
	}
	public void search(){
		JOptionPane.showMessageDialog(this, "검색할게요");
	}
}
