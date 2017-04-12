package pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import db.DBManager;
import db.Emp;

public class DataController{
	
	DBManager manager;
	Connection con;
	Vector<Vector> data = new Vector<Vector>();
	Vector<String> columnName = new Vector<String>();
	
	public DataController() {
		manager = DBManager.getInstance();
		con =manager.getConnection();
	}
	public AbstractTableModel getDataModel(){
		DataModel  model = new DataModel(data, columnName);
		return model;
		
	}
	public void getEmp(){
		String sql = "select * from emp";
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			pstmt =  con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			System.out.println(meta.getColumnCount());
			for(int i=0;i<meta.getColumnCount();i++){
				columnName.add(meta.getColumnName(1));
			}
	
			while(rs.next()){
				Vector vec = new Vector();
				for(int i=0;i<meta.getColumnCount();i++){
					vec.add(rs.getString(i+1));
				}
				data.add(vec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getMember(){
		String sql = "select * from member";
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			pstmt =  con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			System.out.println(meta.getColumnCount());
			for(int i=0;i<meta.getColumnCount();i++){
				columnName.add(meta.getColumnName(1));
			}
			while(rs.next()){
				Vector vec = new Vector();
				for(int i=0;i<meta.getColumnCount();i++){
					vec.add(rs.getString(i+1));
				}
				data.add(vec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getSales(){
		String sql = "select * from sales";
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			pstmt =  con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			System.out.println(meta.getColumnCount());
			for(int i=0;i<meta.getColumnCount();i++){
				columnName.add(meta.getColumnName(1));
			}
			while(rs.next()){
				Vector vec = new Vector();
					for(int i=0;i<meta.getColumnCount();i++){
						vec.add(rs.getString(i+1));
					}
				
				data.add(vec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getGoods(){
		String sql = "select * from goods";
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			pstmt =  con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			System.out.println(meta.getColumnCount());
			for(int i=0;i<meta.getColumnCount();i++){
				columnName.add(meta.getColumnName(1));
			}
			while(rs.next()){
				Vector vec = new Vector();
				for(int i=0;i<meta.getColumnCount();i++){
					vec.add(rs.getString(i+1));
				}
				data.add(vec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
