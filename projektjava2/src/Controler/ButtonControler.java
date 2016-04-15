package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import View.Window;

public class ButtonControler {
	
	Window window;
	DataValidator dv;
	
	public ButtonControler(Window w)
	{
		window=w;
		dv = new DataValidator();
	}
	
	public ActionListener ProjectAddButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
		    window.ControlButton1.setText("Add Record");
		    if(window.ControlButton1.getActionListeners().length>0) 
		    	window.ControlButton1.removeActionListener(window.ControlButton1.getActionListeners()[0]);
		    window.ControlButton1.addActionListener(ProjectControlAddButton);
		    window.ProjectFormPanel.setVisible(true);
		    window.ProjectNameBox.setVisible(true);
			window.ProjectStartDateBox.setVisible(true);
			window.ProjectStatusBox.setVisible(true);
			window.ProjectCategoryBox.setVisible(true);
			window.NameLab.setVisible(true);
			window.StartDateLab.setVisible(true);
			window.StatusLab.setVisible(true);
			window.CategoryLab.setVisible(true);
			
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
		    window.ProjectTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	public ActionListener ProjectDelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton1.setText("Delete Record");
			if(window.ControlButton1.getActionListeners().length>0) 
				window.ControlButton1.removeActionListener(window.ControlButton1.getActionListeners()[0]);
			window.ControlButton1.addActionListener(ProjectControlDelButton);
			window.ProjectFormPanel.setVisible(true);
			window.ProjectNameBox.setVisible(false);
			window.ProjectStartDateBox.setVisible(false);
			window.ProjectStatusBox.setVisible(false);
			window.ProjectCategoryBox.setVisible(false);
			window.NameLab.setVisible(false);
			window.StartDateLab.setVisible(false);
			window.StatusLab.setVisible(false);
			window.CategoryLab.setVisible(false);
			
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
		    window.ProjectTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	public ActionListener ProjectSelButton = new ActionListener() 
	{  
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton1.setText("Select Record");
			if(window.ControlButton1.getActionListeners().length>0) 
				window.ControlButton1.removeActionListener(window.ControlButton1.getActionListeners()[0]);
			window.ControlButton1.addActionListener(ProjectControlSelButton);
			window.ProjectFormPanel.setVisible(true);
			window.ProjectNameBox.setVisible(true);
			window.ProjectStartDateBox.setVisible(true);
			window.ProjectStatusBox.setVisible(true);
			window.ProjectCategoryBox.setVisible(true);
			window.NameLab.setVisible(true);
			window.StartDateLab.setVisible(true);
			window.StatusLab.setVisible(true);
			window.CategoryLab.setVisible(true);
			
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
		    window.ProjectTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	public ActionListener ProjectUpdButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton1.setText("Update Record");
			if(window.ControlButton1.getActionListeners().length>0) 
				window.ControlButton1.removeActionListener(window.ControlButton1.getActionListeners()[0]);
			window.ControlButton1.addActionListener(ProjectControlUpdButton);
			window.ProjectFormPanel.setVisible(true);
			window.ProjectNameBox.setVisible(true);
			window.ProjectStartDateBox.setVisible(true);
			window.ProjectStatusBox.setVisible(true);
			window.ProjectCategoryBox.setVisible(true);
			window.NameLab.setVisible(true);
			window.StartDateLab.setVisible(true);
			window.StatusLab.setVisible(true);
			window.CategoryLab.setVisible(true);
			
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
		    window.ProjectTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	
	public ActionListener ProgrammerAddButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
		    window.ControlButton2.setText("Add Record");
		    if(window.ControlButton2.getActionListeners().length>0) 
		    	window.ControlButton2.removeActionListener(window.ControlButton2.getActionListeners()[0]);
		    window.ControlButton2.addActionListener(ProgrammerControlAddButton);
		    window.ProgrammerFormPanel.setVisible(true);
		    window.ProgrammerPeselBox.setVisible(true);
			window.ProgrammerFirstNameBox.setVisible(true);
			window.ProgrammerLastNameBox.setVisible(true);
			window.ProgrammerSalaryBox.setVisible(true);
			window.ProgrammerTeamListBox.setVisible(true);
			window.PeselLab.setVisible(true);
			window.FirstNameLab.setVisible(true);
			window.LastNameLab.setVisible(true);
			window.SalaryLab.setVisible(true);
			window.TeamLab.setVisible(true);
		    
		    dbController db = new dbController("Database");
		    try
		    {
		    	window.L1Model.clear();
			    Statement st = db.conection.createStatement();
			    ResultSet rs = st.executeQuery("SELECT Name FROM Team;");
			    while(rs.next())
			    {
			    	window.L1Model.addElement(rs.getString("Name"));
			    }
			    rs.close();
		    }
		    catch(Exception f)
		    {
		    }
		    
		    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
		    window.ProgrammerTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};	
	public ActionListener ProgrammerDelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton2.setText("Delete Record");
			if(window.ControlButton2.getActionListeners().length>0) 
				window.ControlButton2.removeActionListener(window.ControlButton2.getActionListeners()[0]);
			window.ControlButton2.addActionListener(ProgrammerControlDelButton);
			window.ProgrammerFormPanel.setVisible(true);
			window.ProgrammerPeselBox.setVisible(false);
			window.ProgrammerFirstNameBox.setVisible(false);
			window.ProgrammerLastNameBox.setVisible(false);
			window.ProgrammerSalaryBox.setVisible(false);
			window.ProgrammerTeamListBox.setVisible(false);
			window.PeselLab.setVisible(false);
			window.FirstNameLab.setVisible(false);
			window.LastNameLab.setVisible(false);
			window.SalaryLab.setVisible(false);
			window.TeamLab.setVisible(false);
			dbController db = new dbController("Database");
		    try
		    {
		    	window.L1Model.clear();
			    Statement st = db.conection.createStatement();
			    ResultSet rs = st.executeQuery("SELECT Name FROM Team;");
			    while(rs.next())
			    {
			    	window.L1Model.addElement(rs.getString("Name"));
			    }
			    rs.close();
		    }
		    catch(Exception f)
		    {
		    }
		    
		    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
		    window.ProgrammerTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};	
	public ActionListener ProgrammerSelButton = new ActionListener() 
	{  
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton2.setText("Select Record");
			if(window.ControlButton2.getActionListeners().length>0) 
				window.ControlButton2.removeActionListener(window.ControlButton2.getActionListeners()[0]);
			window.ControlButton2.addActionListener(ProgrammerControlSelButton);
			window.ProgrammerFormPanel.setVisible(true);
			 window.ProgrammerPeselBox.setVisible(true);
				window.ProgrammerFirstNameBox.setVisible(true);
				window.ProgrammerLastNameBox.setVisible(true);
				window.ProgrammerSalaryBox.setVisible(true);
				window.ProgrammerTeamListBox.setVisible(true);
				window.PeselLab.setVisible(true);
				window.FirstNameLab.setVisible(true);
				window.LastNameLab.setVisible(true);
				window.SalaryLab.setVisible(true);
				window.TeamLab.setVisible(true);
			    
			dbController db = new dbController("Database");
		    try
		    {
		    	window.L1Model.clear();
			    Statement st = db.conection.createStatement();
			    ResultSet rs = st.executeQuery("SELECT Name FROM Team;");
			    while(rs.next())
			    {
			    	window.L1Model.addElement(rs.getString("Name"));
			    }
			    rs.close();
		    }
		    catch(Exception f)
		    {
		    }
		    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
		    window.ProgrammerTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	public ActionListener ProgrammerUpdButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton2.setText("Update Record");
			if(window.ControlButton2.getActionListeners().length>0) 
				window.ControlButton2.removeActionListener(window.ControlButton2.getActionListeners()[0]);
			window.ControlButton2.addActionListener(ProgrammerControlUpdButton);
			window.ProgrammerFormPanel.setVisible(true);
			 window.ProgrammerPeselBox.setVisible(true);
				window.ProgrammerFirstNameBox.setVisible(true);
				window.ProgrammerLastNameBox.setVisible(true);
				window.ProgrammerSalaryBox.setVisible(true);
				window.ProgrammerTeamListBox.setVisible(true);
				window.PeselLab.setVisible(true);
				window.FirstNameLab.setVisible(true);
				window.LastNameLab.setVisible(true);
				window.SalaryLab.setVisible(true);
				window.TeamLab.setVisible(true);
			    
			dbController db = new dbController("Database");
		    try
		    {
		    	window.L1Model.clear();
			    Statement st = db.conection.createStatement();
			    ResultSet rs = st.executeQuery("SELECT Name FROM Team;");
			    while(rs.next())
			    {
			    	window.L1Model.addElement(rs.getString("Name"));
			    }
			    rs.close();
		    }
		    catch(Exception f)
		    {
		    }
		    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
		    window.ProgrammerTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	
	public ActionListener TeamAddButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
		    window.ControlButton3.setText("Add Record");
		    if(window.ControlButton3.getActionListeners().length>0) 
		    	window.ControlButton3.removeActionListener(window.ControlButton3.getActionListeners()[0]);
		    window.ControlButton3.addActionListener(TeamControlAddButton);
		    window.TeamFormPanel.setVisible(true);
		    window.TeamNameBox.setVisible(true);
			window.TeamRoomBox.setVisible(true);
			window.TeamSpecialityBox.setVisible(true);
			window.TeamLevelBox.setVisible(true);
			window.NameLab2.setVisible(true);
			window.RoomLab.setVisible(true);
			window.SpecialityLab.setVisible(true);
			window.LevelLab.setVisible(true);
			
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
		    window.TeamTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	public ActionListener TeamDelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton3.setText("Delete Record");
			if(window.ControlButton3.getActionListeners().length>0) 
				window.ControlButton3.removeActionListener(window.ControlButton3.getActionListeners()[0]);
			window.ControlButton3.addActionListener(TeamControlDelButton);
			window.TeamFormPanel.setVisible(true);
			window.TeamNameBox.setVisible(false);
			window.TeamRoomBox.setVisible(false);
			window.TeamSpecialityBox.setVisible(false);
			window.TeamLevelBox.setVisible(false);
			window.NameLab2.setVisible(false);
			window.RoomLab.setVisible(false);
			window.SpecialityLab.setVisible(false);
			window.LevelLab.setVisible(false);
			
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
		    window.TeamTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	public ActionListener TeamSelButton = new ActionListener() 
	{  
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton3.setText("Select Record");
			if(window.ControlButton3.getActionListeners().length>0) 
				window.ControlButton3.removeActionListener(window.ControlButton3.getActionListeners()[0]);
			window.ControlButton3.addActionListener(TeamControlSelButton);
			window.TeamFormPanel.setVisible(true);
			window.TeamNameBox.setVisible(true);
			window.TeamRoomBox.setVisible(true);
			window.TeamSpecialityBox.setVisible(true);
			window.TeamLevelBox.setVisible(true);
			window.NameLab2.setVisible(true);
			window.RoomLab.setVisible(true);
			window.SpecialityLab.setVisible(true);
			window.LevelLab.setVisible(true);
			
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
		    window.TeamTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};	
	public ActionListener TeamUpdButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton3.setText("Update Record");
			if(window.ControlButton3.getActionListeners().length>0) 
				window.ControlButton3.removeActionListener(window.ControlButton3.getActionListeners()[0]);
			window.ControlButton3.addActionListener(TeamControlUpdButton);
			window.TeamFormPanel.setVisible(true);
			window.TeamNameBox.setVisible(true);
			window.TeamRoomBox.setVisible(true);
			window.TeamSpecialityBox.setVisible(true);
			window.TeamLevelBox.setVisible(true);
			window.NameLab2.setVisible(true);
			window.RoomLab.setVisible(true);
			window.SpecialityLab.setVisible(true);
			window.LevelLab.setVisible(true);
			
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
		    window.TeamTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	
	public ActionListener TeamProjectAddButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
		    window.ControlButton4.setText("Add Record");
		    if(window.ControlButton4.getActionListeners().length>0) 
		    	window.ControlButton4.removeActionListener(window.ControlButton4.getActionListeners()[0]);
		    window.ControlButton4.addActionListener(TeamProjectControlAddButton);
		    window.TeamProjectFormPanel.setVisible(true);
		    window.TeamProjectListBox.setVisible(true);
		    window.ProjectTeamListBox.setVisible(true);
		    window.Team2Lab.setVisible(true);
		    window.ProjectLab.setVisible(true);
		    dbController db = new dbController("Database");
		    try
		    {
		    	window.L2Model.clear();
		    	window.L3Model.clear();
			    Statement st = db.conection.createStatement();
			    ResultSet rs = st.executeQuery("SELECT Name FROM Team;");
			    while(rs.next())
			    {
			    	window.L2Model.addElement(rs.getString("Name"));
			    }
			    rs = st.executeQuery("SELECT Name FROM Project;");
			    while(rs.next())
			    {
			    	window.L3Model.addElement(rs.getString("Name"));
			    }
		    }
		    catch(Exception f)
		    {
		    }
		} 
	};
	public ActionListener TeamProjectDelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton4.setText("Delete Record");
			if(window.ControlButton4.getActionListeners().length>0) 
				window.ControlButton4.removeActionListener(window.ControlButton4.getActionListeners()[0]);
			window.ControlButton4.addActionListener(TeamProjectControlDelButton);
			window.TeamProjectFormPanel.setVisible(true);
			window.TeamProjectListBox.setVisible(false);
		    window.ProjectTeamListBox.setVisible(false);
		    window.Team2Lab.setVisible(false);
		    window.ProjectLab.setVisible(false);
			dbController db = new dbController("Database");
		    try
		    {
		    	window.L2Model.clear();
		    	window.L3Model.clear();
			    Statement st = db.conection.createStatement();
			    ResultSet rs = st.executeQuery("SELECT Name FROM Team;");
			    while(rs.next())
			    {
			    	window.L2Model.addElement(rs.getString("Name"));
			    }
			    rs = st.executeQuery("SELECT Name FROM Project;");
			    while(rs.next())
			    {
			    	window.L3Model.addElement(rs.getString("Name"));
			    }
		    }
		    catch(Exception f)
		    {
		    }
		} 
	};
	public ActionListener TeamProjectSelButton = new ActionListener() 
	{  
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton4.setText("Select Record");
			if(window.ControlButton4.getActionListeners().length>0) 
				window.ControlButton4.removeActionListener(window.ControlButton4.getActionListeners()[0]);
			window.ControlButton4.addActionListener(TeamProjectControlSelButton);
			window.TeamProjectFormPanel.setVisible(true);
			window.TeamProjectListBox.setVisible(true);
		    window.ProjectTeamListBox.setVisible(true);
		    window.Team2Lab.setVisible(true);
		    window.ProjectLab.setVisible(true);
			dbController db = new dbController("Database");
		    try
		    {
		    	window.L2Model.clear();
		    	window.L3Model.clear();
			    Statement st = db.conection.createStatement();
			    ResultSet rs = st.executeQuery("SELECT Name FROM Team;");
			    while(rs.next())
			    {
			    	window.L2Model.addElement(rs.getString("Name"));
			    }
			    rs = st.executeQuery("SELECT Name FROM Project;");
			    while(rs.next())
			    {
			    	window.L3Model.addElement(rs.getString("Name"));
			    }
		    }
		    catch(Exception f)
		    {
		    }
		} 
	};	
	public ActionListener TeamProjectUpdButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ControlButton4.setText("Update Record");
			if(window.ControlButton4.getActionListeners().length>0) 
				window.ControlButton4.removeActionListener(window.ControlButton4.getActionListeners()[0]);
			window.ControlButton4.addActionListener(TeamProjectControlUpdButton);
			window.TeamProjectFormPanel.setVisible(true);
			window.TeamProjectListBox.setVisible(true);
		    window.ProjectTeamListBox.setVisible(true);
		    window.Team2Lab.setVisible(true);
		    window.ProjectLab.setVisible(true);
			dbController db = new dbController("Database");
		    try
		    {
		    	window.L2Model.clear();
		    	window.L3Model.clear();
			    Statement st = db.conection.createStatement();
			    ResultSet rs = st.executeQuery("SELECT Name FROM Team;");
			    while(rs.next())
			    {
			    	window.L2Model.addElement(rs.getString("Name"));
			    }
			    rs = st.executeQuery("SELECT Name FROM Project;");
			    while(rs.next())
			    {
			    	window.L3Model.addElement(rs.getString("Name"));
			    }
		    }
		    catch(Exception f)
		    {
		    }
		} 
	};
	
	public ActionListener ProjectCancelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ProjectFormPanel.setVisible(false);
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
		    window.ProjectTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	public ActionListener ProgrammerCancelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.ProgrammerFormPanel.setVisible(false);
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
		    window.ProgrammerTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	public ActionListener TeamCancelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.TeamFormPanel.setVisible(false);
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
		    window.TeamTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	public ActionListener TeamProjectCancelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			window.TeamProjectFormPanel.setVisible(false);
			DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
		    window.TeamProjectTable.setModel(model);
		    model.fireTableDataChanged();
		} 
	};
	
	public ActionListener ProjectControlAddButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			if(!dv.StringValidator(window.ProjectNameBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Project Name is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.DateValidator(window.ProjectStartDateBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Project Start Date is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.ProjectStatusBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Project Status is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.ProjectCategoryBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Project Category is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				dbController db = new dbController("Database");
			    try
			    {
			    	int maxId = 0;
				    Statement st = db.conection.createStatement();
				    String max = "SELECT MAX(Id) AS max_id FROM Project";
				    ResultSet rs = st.executeQuery(max);
				    while(rs.next())
				    {
				    	maxId = rs.getInt("max_id");
				    }
				    maxId+=1;
				    String SQL = "INSERT INTO Project"
				    				+"(Id,Name,StartDate,Status,Category) "
				    				+"VALUES ("
				    				+maxId+",'"
				    				+window.ProjectNameBox.getText()+"','"
				    				+window.ProjectStartDateBox.getText()+"','"
				    				+window.ProjectStatusBox.getText()+"','"
				    				+window.ProjectCategoryBox.getText()+"');";
				    rs = st.executeQuery(SQL);
				    rs.close();
				    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
				    window.ProjectTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			    catch(SQLException f)
			    {
			    	if(!f.getSQLState().equals("SQLITE_DONE"))
			    	{
			    		JOptionPane.showMessageDialog(window.mainWindow, "Can't add new record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
			    		DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
					    window.ProjectTable.setModel(model);
					    model.fireTableDataChanged();
			    	}
			    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
				    window.ProjectTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			}
		} 
	};
	public ActionListener ProjectControlSelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{			
			boolean a = dv.StringValidator(window.ProjectNameBox.getText());
			boolean b = dv.DateValidator(window.ProjectStartDateBox.getText());
			boolean c = dv.StringValidator(window.ProjectStatusBox.getText());
			boolean d = dv.StringValidator(window.ProjectCategoryBox.getText());
			
			String SQL = "SELECT * FROM Project WHERE ";
			int len = SQL.length();
			
			if(!(a|b|c|d))
				JOptionPane.showMessageDialog(window.mainWindow, "Type some data.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				if(a)
					SQL+="Name='"+window.ProjectNameBox.getText()+"' ";
				if(b)
				{
					if(SQL.length()!=len) SQL+="AND ";
					SQL+="StartDate='"+window.ProjectStartDateBox.getText()+"' ";
				}
				if(c)
				{
					if(SQL.length()!=len) SQL+="AND ";
					SQL+="Status='"+window.ProjectStatusBox.getText()+"' ";
				}
				if(d)
				{
					if(SQL.length()!=len) SQL+="AND ";
					SQL+="Category='"+window.ProjectCategoryBox.getText()+"' ";
				}
				SQL+=";";
				DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(SQL, Model.Project.class), Model.Project.columnHeaders);
				window.ProjectTable.setModel(model);
				model.fireTableDataChanged();
			}
		} 
	};
	public ActionListener ProjectControlUpdButton = new ActionListener() 
	{ 
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) 
		{ 
			if(!dv.StringValidator(window.ProjectNameBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Project Name is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.DateValidator(window.ProjectStartDateBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Project Start Date is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.ProjectStatusBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Project Status is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.ProjectCategoryBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Project Category is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(window.ProjectTable.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(window.mainWindow, "Any Row is selected.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				dbController db = new dbController("Database");
			    try
			    {
			    	String Name = (String) window.ProjectTable.getValueAt(window.ProjectTable.getSelectedRow(), 0);
				    Statement st = db.conection.createStatement();
				    String SQL = "UPDATE Project SET "
				    		+"Name='"+window.ProjectNameBox.getText()+"',"
				    		+"StartDate='"+window.ProjectStartDateBox.getText()+"',"
				    		+"Status='"+window.ProjectStatusBox.getText()+"',"
				    		+"Category='"+window.ProjectCategoryBox.getText()+"' "
				    		+"WHERE Name='"+Name+"';";
				    ResultSet rs = st.executeQuery(SQL);
				    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
				    window.ProjectTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			    catch(SQLException f)
			    {
			    	if(!f.getSQLState().equals("SQLITE_DONE"))
			    		JOptionPane.showMessageDialog(window.mainWindow, "Can't update record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
			    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
				    window.ProjectTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			}
		} 
	};
	public ActionListener ProjectControlDelButton = new ActionListener() 
	{ 
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) 
		{ 
			if(window.ProjectTable.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(window.mainWindow, "Any Row is selected.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				int reply = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) 
		        {
		        	dbController db = new dbController("Database");
				    try
				    {
				    	String Name = (String) window.ProjectTable.getValueAt(window.ProjectTable.getSelectedRow(), 0);
					    Statement st = db.conection.createStatement();
					    String SQL = "DELETE FROM Project WHERE "
					    		+"Name='"+Name+"';";
					    ResultSet rs = st.executeQuery(SQL);
					    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
					    window.ProjectTable.setModel(model);
					    model.fireTableDataChanged();
				    }
				    catch(SQLException f)
				    {
				    	if(!f.getSQLState().equals("SQLITE_DONE"))
				    		JOptionPane.showMessageDialog(window.mainWindow, "Can't delete record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
				    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Project.SQL_All, Model.Project.class), Model.Project.columnHeaders);
					    window.ProjectTable.setModel(model);
					    model.fireTableDataChanged();
				    }
		        }
			}
		} 
	};
	
	public ActionListener ProgrammerControlAddButton = new ActionListener() 
	{ 
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) 
		{ 
			if(!dv.PeselValidator(window.ProgrammerPeselBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer Pesel is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.ProgrammerFirstNameBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer First Name is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.ProgrammerLastNameBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer Last Name is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.DoubleValidator(window.ProgrammerSalaryBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer Salary is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(window.PTL1.isSelectionEmpty())
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer Team is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				dbController db = new dbController("Database");
			    try
			    {
			    	String TeamSQL = "Select Id FROM Team WHERE Name='"+window.PTL1.getSelectedValue()+"';";
			    	Statement st = db.conection.createStatement();
			    	ResultSet rs = st.executeQuery(TeamSQL);
			    	int Team = 0;
			    	while(rs.next())
			    	{
			    		Team = rs.getInt("Id");
			    	}
			    	int maxId = 0;
				    String SQL = "INSERT INTO Programmer"
				    				+"(Pesel,FirstName,SecondName,Salary,Team) "
				    				+"VALUES ('"
				    				+window.ProgrammerPeselBox.getText()+"','"
				    				+window.ProgrammerFirstNameBox.getText()+"','"
				    				+window.ProgrammerLastNameBox.getText()+"',"
				    				+window.ProgrammerSalaryBox.getText()+","
				    				+Team+");";
				    rs = st.executeQuery(SQL);
				    rs.close();
				    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
				    window.ProgrammerTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			    catch(SQLException f)
			    {
			    	
			    	if(!f.getSQLState().equals("SQLITE_DONE"))
			    	{
			    		JOptionPane.showMessageDialog(window.mainWindow, "Can't add new record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
			    		DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
					    window.ProgrammerTable.setModel(model);
					    model.fireTableDataChanged();
			    	}
			    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
				    window.ProgrammerTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			}
		} 
	};
	public ActionListener ProgrammerControlSelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			try
			{
				dbController db = new dbController("Database");
				String TeamSQL = "Select Id FROM Team WHERE Name='"+window.PTL1.getSelectedValue()+"';";
		    	Statement st = db.conection.createStatement();
		    	ResultSet rs = st.executeQuery(TeamSQL);
		    	int Team = 0;
		    	while(rs.next())
		    	{
		    		Team = rs.getInt("Id");
		    	}
				rs.close();
				boolean a = dv.PeselValidator(window.ProgrammerPeselBox.getText());
				boolean b = dv.StringValidator(window.ProgrammerFirstNameBox.getText());
				boolean c = dv.StringValidator(window.ProgrammerLastNameBox.getText());
				boolean d = dv.DoubleValidator(window.ProgrammerSalaryBox.getText());
				boolean f = dv.IntegerValidator(String.valueOf(Team));
			
				String SQL = "SELECT Pesel,FirstName,SecondName,Salary,t.Name AS TeamName FROM Programmer p INNER JOIN Team t ON p.Team = t.Id WHERE ";
				int len = SQL.length();
				
				
				if(!(a|b|c|d|f))
					JOptionPane.showMessageDialog(window.mainWindow, "Type some data.","Error",JOptionPane.ERROR_MESSAGE);
				else
				{
					if(a)
						SQL+="Pesel='"+window.ProgrammerPeselBox.getText()+"' ";
					if(b)
					{
						if(SQL.length()!=len) SQL+="AND ";
						SQL+="FirstName='"+window.ProgrammerFirstNameBox.getText()+"' ";
					}
					if(c)
					{
						if(SQL.length()!=len) SQL+="AND ";
						SQL+="SecondName='"+window.ProgrammerLastNameBox.getText()+"' ";
					}
					if(d)
					{
						if(SQL.length()!=len) SQL+="AND ";
						SQL+="Salary="+window.ProgrammerSalaryBox.getText()+" ";
					}
					if(f)
					{
						if(SQL.length()!=len) SQL+="AND ";
						SQL+="Team="+String.valueOf(Team)+" ";
					}
					SQL+=";";
					
					DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(SQL, Model.Programmer.class), Model.Programmer.columnHeaders);
					window.ProgrammerTable.setModel(model);
					model.fireTableDataChanged();
				}
			}
			catch(SQLException f)
			{
			}
		} 
	};
	public ActionListener ProgrammerControlUpdButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			if(!dv.PeselValidator(window.ProgrammerPeselBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer Pesel is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.ProgrammerFirstNameBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer First Name is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.ProgrammerLastNameBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer Last Name is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.DoubleValidator(window.ProgrammerSalaryBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer Salary is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.IntegerValidator(String.valueOf(window.PTL1.getSelectedIndex()+1)))
				JOptionPane.showMessageDialog(window.mainWindow, "Programmer Team is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				dbController db = new dbController("Database");
			    try
			    {
			    	String TeamSQL = "Select Id FROM Team WHERE Name='"+window.PTL1.getSelectedValue()+"';";
			    	Statement st = db.conection.createStatement();
			    	ResultSet rs = st.executeQuery(TeamSQL);
			    	int Team = 0;
			    	while(rs.next())
			    	{
			    		Team = rs.getInt("Id");
			    	}
					rs.close();
			    	String Pesel = (String) window.ProgrammerTable.getValueAt(window.ProgrammerTable.getSelectedRow(), 0);
				    String SQL = "UPDATE Programmer SET "
				    		+"Pesel='"+window.ProgrammerPeselBox.getText()+"',"
				    		+"FirstName='"+window.ProgrammerFirstNameBox.getText()+"',"
				    		+"SecondName='"+window.ProgrammerLastNameBox.getText()+"',"
				    		+"Salary="+window.ProgrammerSalaryBox.getText()+","
				    		+"Team="+String.valueOf(Team)+" "
				    		+"WHERE Pesel='"+Pesel+"';";
				    rs = st.executeQuery(SQL);
				    rs.close();
				    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
				    window.ProgrammerTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			    catch(SQLException f)
			    {
			    	if(!f.getSQLState().equals("SQLITE_DONE"))
			    	{
			    		JOptionPane.showMessageDialog(window.mainWindow, "Can't update record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
			    		DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
					    window.ProgrammerTable.setModel(model);
					    model.fireTableDataChanged();
			    	}
				    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
				    window.ProgrammerTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			}
		} 
	};
	public ActionListener ProgrammerControlDelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			if(window.ProgrammerTable.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(window.mainWindow, "Any Row is selected.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				int reply = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) 
		        {
		        	dbController db = new dbController("Database");
				    try
				    {
				    	String Pesel = (String) window.ProgrammerTable.getValueAt(window.ProgrammerTable.getSelectedRow(), 0);
					    Statement st = db.conection.createStatement();
					    String SQL = "DELETE FROM Programmer WHERE "
					    		+"Pesel='"+Pesel+"';";
						JOptionPane.showMessageDialog(window.mainWindow, SQL,"Error",JOptionPane.ERROR_MESSAGE);
				    	
					    ResultSet rs = st.executeQuery(SQL);
					    rs.close();
					    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
					    window.ProgrammerTable.setModel(model);
					    model.fireTableDataChanged();
				    }
				    catch(SQLException f)
				    {
				    	if(!f.getSQLState().equals("SQLITE_DONE"))
				    		JOptionPane.showMessageDialog(window.mainWindow, "Can't delete record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
				    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Programmer.SQL_All, Model.Programmer.class), Model.Programmer.columnHeaders);
					    window.ProgrammerTable.setModel(model);
					    model.fireTableDataChanged();
				    }
		        }
			}
		} 
	};

	public ActionListener TeamControlAddButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			if(!dv.StringValidator(window.TeamNameBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Team Name is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.IntegerValidator(window.TeamRoomBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Team Room is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.TeamSpecialityBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Team Speciality is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.IntegerValidator(window.TeamLevelBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Team Level is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				dbController db = new dbController("Database");
			    try
			    {
			    	int maxId = 0;
				    Statement st = db.conection.createStatement();
				    String max = "SELECT MAX(Id) AS max_id FROM Team";
				    ResultSet rs = st.executeQuery(max);
				    while(rs.next())
				    {
				    	maxId = rs.getInt("max_id");
				    }
				    maxId+=1;
				    String SQL = "INSERT INTO Team"
				    				+"(Id,Name,Room,Speciality,Level) "
				    				+"VALUES ("
				    				+maxId+",'"
				    				+window.TeamNameBox.getText()+"',"
				    				+window.TeamRoomBox.getText()+",'"
				    				+window.TeamSpecialityBox.getText()+"',"
				    				+window.TeamLevelBox.getText()+");";
				    rs = st.executeQuery(SQL);
				    rs.close();
				    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
				    window.TeamTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			    catch(SQLException f)
			    {
			    	if(!f.getSQLState().equals("SQLITE_DONE"))
			    	{
			    		JOptionPane.showMessageDialog(window.mainWindow, "Can't add new record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
			    		DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
					    window.TeamTable.setModel(model);
					    model.fireTableDataChanged();
			    	}
			    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
				    window.TeamTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			}
		} 
	};
	public ActionListener TeamControlSelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			boolean a = dv.StringValidator(window.TeamNameBox.getText());
			boolean b = dv.IntegerValidator(window.TeamRoomBox.getText());
			boolean c = dv.StringValidator(window.TeamSpecialityBox.getText());
			boolean d = dv.IntegerValidator(window.TeamLevelBox.getText());
			
			String SQL = "SELECT * FROM Team WHERE ";
			int len = SQL.length();
			
			if(!(a|b|c|d))
				JOptionPane.showMessageDialog(window.mainWindow, "Type some data.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				if(a)
					SQL+="Name='"+window.TeamNameBox.getText()+"' ";
				if(b)
				{
					if(SQL.length()!=len) SQL+="AND ";
					SQL+="Room="+window.TeamRoomBox.getText()+" ";
				}
				if(c)
				{
					if(SQL.length()!=len) SQL+="AND ";
					SQL+="Speciality='"+window.TeamSpecialityBox.getText()+"' ";
				}
				if(d)
				{
					if(SQL.length()!=len) SQL+="AND ";
					SQL+="Level="+window.TeamLevelBox.getText()+" ";
				}
				SQL+=";";
				DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(SQL, Model.Team.class), Model.Team.columnHeaders);
				window.TeamTable.setModel(model);
				model.fireTableDataChanged();
			}
		} 
	};
	public ActionListener TeamControlUpdButton = new ActionListener() 
	{ 
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) 
		{ 
			if(!dv.StringValidator(window.TeamNameBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Team Name is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.IntegerValidator(window.TeamRoomBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Team Room is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.StringValidator(window.TeamSpecialityBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Team Speciality is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(!dv.IntegerValidator(window.TeamLevelBox.getText()))
				JOptionPane.showMessageDialog(window.mainWindow, "Team Level is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				dbController db = new dbController("Database");
			    try
			    {
			    	String Name = (String) window.TeamTable.getValueAt(window.TeamTable.getSelectedRow(), 0);
				    Statement st = db.conection.createStatement();
				    String SQL = "UPDATE Team SET "
				    		+"Name='"+window.TeamNameBox.getText()+"',"
				    		+"Room="+window.TeamRoomBox.getText()+","
				    		+"Speciality='"+window.TeamSpecialityBox.getText()+"',"
				    		+"Level="+window.TeamLevelBox.getText()+" "
				    		+"WHERE Name='"+Name+"';";
				    ResultSet rs = st.executeQuery(SQL);
				    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
				    window.TeamTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			    catch(SQLException f)
			    {
			    	if(!f.getSQLState().equals("SQLITE_DONE"))
			    		JOptionPane.showMessageDialog(window.mainWindow, "Can't update record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
			    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
				    window.TeamTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			}
		} 
	};
	public ActionListener TeamControlDelButton = new ActionListener() 
	{ 
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) 
		{ 
			if(window.TeamTable.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(window.mainWindow, "Any Row is selected.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				int reply = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) 
		        {
		        	dbController db = new dbController("Database");
				    try
				    {
				    	String Name = (String) window.TeamTable.getValueAt(window.TeamTable.getSelectedRow(), 0);
					    Statement st = db.conection.createStatement();
					    String SQL = "DELETE FROM Team WHERE "
					    		+"Name='"+Name+"';";
					    ResultSet rs = st.executeQuery(SQL);
					    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
					    window.TeamTable.setModel(model);
					    model.fireTableDataChanged();
				    }
				    catch(SQLException f)
				    {
				    	if(!f.getSQLState().equals("SQLITE_DONE"))
				    		JOptionPane.showMessageDialog(window.mainWindow, "Can't delete record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
				    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.Team.SQL_All, Model.Team.class), Model.Team.columnHeaders);
					    window.TeamTable.setModel(model);
					    model.fireTableDataChanged();
				    }
		        }
			}
		} 
	};
	
	public ActionListener TeamProjectControlAddButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			if(window.PTL2.isSelectionEmpty())
				JOptionPane.showMessageDialog(window.mainWindow, "Team is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(window.PTL3.isSelectionEmpty())
				JOptionPane.showMessageDialog(window.mainWindow, "Project is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				dbController db = new dbController("Database");
			    try
			    {
			    	String TeamSQL = "Select Id FROM Team WHERE Name='"+window.PTL2.getSelectedValue()+"';";
			    	String ProjectSQL = "Select Id FROM Project WHERE Name='"+window.PTL3.getSelectedValue()+"';";
			    	Statement st = db.conection.createStatement();
			    	ResultSet rs = st.executeQuery(TeamSQL);
			    	int Team = 0;
			    	while(rs.next())
			    	{
			    		Team = rs.getInt("Id");
			    	}
			    	rs = st.executeQuery(ProjectSQL);
			    	int Project = 0;
			    	while(rs.next())
			    	{
			    		Project = rs.getInt("Id");
			    	}
				    String SQL = "INSERT INTO Team_Project"
				    				+"(Project_Id,Team_Id) "
				    				+"VALUES ("
				    				+Project+","
				    				+Team+");";
				    rs = st.executeQuery(SQL);
				    rs.close();
				    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
				    window.TeamProjectTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			    catch(SQLException f)
			    {
			    	if(!f.getSQLState().equals("SQLITE_DONE"))
			    	{
			    		JOptionPane.showMessageDialog(window.mainWindow, "Can't add new record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
			    		DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
					    window.TeamProjectTable.setModel(model);
					    model.fireTableDataChanged();
			    	}
			    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
				    window.TeamProjectTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			}
		} 
	};
	public ActionListener TeamProjectControlSelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			try
			{
				dbController db = new dbController("Database");
				String TeamSQL = "Select Id FROM Team WHERE Name='"+window.PTL2.getSelectedValue()+"';";
		    	String ProjectSQL = "Select Id FROM Project WHERE Name='"+window.PTL3.getSelectedValue()+"';";
		    	Statement st = db.conection.createStatement();
		    	ResultSet rs = st.executeQuery(TeamSQL);
		    	int Team = 0;
		    	while(rs.next())
		    	{
		    		Team = rs.getInt("Id");
		    	}
		    	rs = st.executeQuery(ProjectSQL);
		    	int Project = 0;
		    	while(rs.next())
		    	{
		    		Project = rs.getInt("Id");
		    	}
				boolean a = dv.IntegerValidator(String.valueOf(Project));
				boolean b = dv.IntegerValidator(String.valueOf(Team));
				
				String SQL = "SELECT t.Name AS TeamName, p.Name AS ProjectName FROM Team_Project tp INNER JOIN Team t ON tp.Team_Id = t.Id INNER JOIN Project p ON tp.Project_Id = p.Id WHERE ";
				int len = SQL.length();
				
				if(!(a|b))
					JOptionPane.showMessageDialog(window.mainWindow, "Type some data.","Error",JOptionPane.ERROR_MESSAGE);
				else
				{
					if(a)
						SQL+="Team_Id="+Team+" ";
					if(b)
					{
						if(SQL.length()!=len) SQL+="AND ";
						SQL+="Project_Id="+Project+" ";
					}
					SQL+=";";
					DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(SQL, Model.TeamProject.class), Model.TeamProject.columnHeaders);
					window.TeamProjectTable.setModel(model);
					model.fireTableDataChanged();
				}
		
			}
			catch(SQLException f)
			{
			
			}
		}
	};
	public ActionListener TeamProjectControlUpdButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			if(window.PTL2.isSelectionEmpty())
				JOptionPane.showMessageDialog(window.mainWindow, "Team is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else if(window.PTL3.isSelectionEmpty())
				JOptionPane.showMessageDialog(window.mainWindow, "Project is wrong.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				dbController db = new dbController("Database");
			    try
			    {
			    	String TeamSQL = "Select Id FROM Team WHERE Name='"+window.PTL2.getSelectedValue()+"';";
			    	String ProjectSQL = "Select Id FROM Project WHERE Name='"+window.PTL3.getSelectedValue()+"';";
			    	Statement st = db.conection.createStatement();
			    	ResultSet rs = st.executeQuery(TeamSQL);
			    	int Team = 0;
			    	while(rs.next())
			    	{
			    		Team = rs.getInt("Id");
			    	}
			    	rs = st.executeQuery(ProjectSQL);
			    	int Project = 0;
			    	while(rs.next())
			    	{
			    		Project = rs.getInt("Id");
			    	}
			    	int selectedTeam = 0;
			    	int selectedProject = 0;
			    	String SelectedTeamSQL = "SELECT Id FROM Team WHERE Name='"+(String) window.TeamProjectTable.getValueAt(window.TeamProjectTable.getSelectedRow(), 0)+"';";
			    	String SelectedProjectSQL = "SELECT Id FROM Project WHERE Name='"+(String) window.TeamProjectTable.getValueAt(window.TeamProjectTable.getSelectedRow(), 1)+"';";
			    	
			    	rs = st.executeQuery(SelectedProjectSQL);
			    	while(rs.next())
			    	{
			    		selectedProject = rs.getInt("Id");
			    	}
			    	rs.close();
			    	
			    	rs = st.executeQuery(SelectedTeamSQL);
			    	while(rs.next())
			    	{
			    		selectedTeam = rs.getInt("Id");
			    	}
			    	rs.close();
			    	
				    String SQL = "UPDATE Team_Project SET "
				    				+"Project_Id="+Project+","
				    				+"Team_Id="+Team+" "
				    				+"WHERE Project_Id="+selectedProject+" AND "
				    				+"Team_Id="+selectedTeam+";";
				    rs = st.executeQuery(SQL);
				    rs.close();
				    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
				    window.TeamProjectTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			    catch(SQLException f)
			    {
			    	if(!f.getSQLState().equals("SQLITE_DONE"))
			    	{
			    		JOptionPane.showMessageDialog(window.mainWindow, "Can't add new record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
			    		DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
					    window.TeamProjectTable.setModel(model);
					    model.fireTableDataChanged();
			    	}
			    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
				    window.TeamProjectTable.setModel(model);
				    model.fireTableDataChanged();
			    }
			}
		} 
	};
	public ActionListener TeamProjectControlDelButton = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent e) 
		{ 
			if(window.TeamProjectTable.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(window.mainWindow, "Any Row is selected.","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				int reply = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) 
		        {
					dbController db = new dbController("Database");
				    try
				    {
				    	Statement st = db.conection.createStatement();
				    	
				    	
				    	int selectedTeam = 0;
				    	int selectedProject = 0;
				    	String SelectedTeamSQL = "SELECT Id FROM Team WHERE Name='"+(String) window.TeamProjectTable.getValueAt(window.TeamProjectTable.getSelectedRow(), 0)+"';";
				    	String SelectedProjectSQL = "SELECT Id FROM Project WHERE Name='"+(String) window.TeamProjectTable.getValueAt(window.TeamProjectTable.getSelectedRow(), 1)+"';";
				    	
				    	ResultSet rs = st.executeQuery(SelectedProjectSQL);
				    	while(rs.next())
				    	{
				    		selectedProject = rs.getInt("Id");
				    	}
				    	rs.close();
				    	
				    	rs = st.executeQuery(SelectedTeamSQL);
				    	while(rs.next())
				    	{
				    		selectedTeam = rs.getInt("Id");
				    	}
				    	rs.close();
				    	
					    String SQL = "DELETE FROM Team_Project "
					    				+"WHERE Project_Id="+selectedProject+" AND "
					    				+"Team_Id="+selectedTeam+";";
					    rs = st.executeQuery(SQL);
					    rs.close();
					    DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
					    window.TeamProjectTable.setModel(model);
					    model.fireTableDataChanged();
				    }
				    catch(SQLException f)
				    {
				    	if(!f.getSQLState().equals("SQLITE_DONE"))
				    	{
				    		JOptionPane.showMessageDialog(window.mainWindow, "Can't add new record.\n"+f.getSQLState(),"Error",JOptionPane.ERROR_MESSAGE);
				    		DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
						    window.TeamProjectTable.setModel(model);
						    model.fireTableDataChanged();
				    	}
				    	DefaultTableModel model = new DefaultTableModel(new Controler.dbController("Database").executeStatement(Model.TeamProject.SQL_All, Model.TeamProject.class), Model.TeamProject.columnHeaders);
					    window.TeamProjectTable.setModel(model);
					    model.fireTableDataChanged();
				    }
		        }
			}
		} 
	};
}
