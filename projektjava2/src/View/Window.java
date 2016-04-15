package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;

import layout.SpringUtilities;
import Controler.ButtonControler;
import Controler.TableData;

public class Window {
	public JFrame mainWindow;
	public JTabbedPane tabPane;
	public JComponent ProjectPanel;
	public JComponent ProgrammerPanel;
	public JComponent TeamPanel;
	public JComponent TeamProjectPanel;
	public JComponent ProjectEditPanel;
	public JComponent ProgrammerEditPanel;
	public JComponent TeamEditPanel;
	public JComponent TeamProjectEditPanel;
	public JComponent TeamButtonPanel;
	public JComponent TeamProjectButtonPanel;
	public JComponent ProjectButtonPanel;
	public JComponent ProgrammerButtonPanel;
	public JComponent TeamFormPanel;
	public JComponent TeamProjectFormPanel;
	public JComponent ProjectFormPanel;
	public JComponent ProgrammerFormPanel;
	public JComponent POEditPanel;
	public JComponent ROEditPanel;
	public JComponent TOEditPanel;
	public JComponent TPOEditPanel;
	public JTable ProjectTable;
	public JTable ProgrammerTable;
	public JTable TeamTable;
	public JTable TeamProjectTable;
	public JScrollPane ProjectTablePane;
	public JScrollPane ProgrammerTablePane;
	public JScrollPane TeamTablePane;
	public JScrollPane TeamProjectTablePane;
	public JButton AddProject;
	public JButton UpdProject;
	public JButton DelProject;
	public JButton SelProject;
	public JButton AddProgrammer;
	public JButton UpdProgrammer;
	public JButton DelProgrammer;
	public JButton SelProgrammer;
	public JButton AddTeam;
	public JButton UpdTeam;
	public JButton DelTeam;
	public JButton SelTeam;
	public JButton AddTeamProject;
	public JButton UpdTeamProject;
	public JButton DelTeamProject;
	public JButton SelTeamProject;
	public JButton CancelButton1;
	public JButton ControlButton1;
	public JButton CancelButton2;
	public JButton ControlButton2;
	public JButton CancelButton3;
	public JButton ControlButton3;
	public JButton CancelButton4;
	public JButton ControlButton4;
	public JLabel NameLab;
	public JLabel NameLab2;
	public JLabel StartDateLab;
	public JLabel StatusLab;
	public JLabel CategoryLab;
	public JLabel PeselLab;
	public JLabel FirstNameLab;
	public JLabel LastNameLab;
	public JLabel SalaryLab;
	public JLabel TeamLab;
	public JLabel RoomLab;
	public JLabel SpecialityLab;
	public JLabel LevelLab;
	public JLabel Team2Lab;
	public JLabel ProjectLab;
	public JTextField TeamNameBox;
	public JTextField TeamRoomBox;
	public JTextField TeamSpecialityBox;
	public JTextField TeamLevelBox;
	public JTextField ProgrammerPeselBox;
	public JTextField ProgrammerFirstNameBox;
	public JTextField ProgrammerLastNameBox;
	public JTextField ProgrammerSalaryBox;
	public JTextField ProjectNameBox;
	public JTextField ProjectStartDateBox;
	public JTextField ProjectStatusBox;
	public JTextField ProjectCategoryBox;
	
	public DefaultListModel<String> L1Model = new DefaultListModel<String>();
	public JList<String> PTL1 = new JList<String>(L1Model);
	public JScrollPane ProgrammerTeamListBox = new JScrollPane(PTL1);
	
	public DefaultListModel<String> L2Model = new DefaultListModel<String>();
	public JList<String> PTL2 = new JList<String>(L2Model);
	public JScrollPane TeamProjectListBox = new JScrollPane(PTL2);
	
	public DefaultListModel<String> L3Model = new DefaultListModel<String>();
	public JList<String> PTL3 = new JList<String>(L3Model);
	public JScrollPane ProjectTeamListBox = new JScrollPane(PTL3);
	
	
	
	public Window()
	{
		mainWindow = new JFrame();
		mainWindow.setVisible(true);
		mainWindow.setSize(800, 600);
		mainWindow.setTitle("Project Manager");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ProgrammerTeamListBox.setSize(new JTextField().getSize());
		
		ProjectPanel = new JPanel();
		ProjectEditPanel = new JPanel();
		ProgrammerPanel = new JPanel();
		ProgrammerEditPanel = new JPanel();
		TeamPanel = new JPanel();
		TeamEditPanel = new JPanel();
		TeamProjectPanel = new JPanel();
		TeamProjectEditPanel = new JPanel();
		TeamButtonPanel = new JPanel();
		TeamProjectButtonPanel = new JPanel();
		ProjectButtonPanel = new JPanel();
		ProgrammerButtonPanel = new JPanel();
		TeamFormPanel = new JPanel();
		TeamProjectFormPanel = new JPanel();
		ProjectFormPanel = new JPanel();
		ProgrammerFormPanel = new JPanel();
		TOEditPanel = new JPanel();
		TPOEditPanel = new JPanel();
		POEditPanel = new JPanel();
		ROEditPanel = new JPanel();

		ButtonControler BC= new ButtonControler(this);
		
		AddProject = new JButton();
		AddProject.addActionListener(BC.ProjectAddButton);
		UpdProject = new JButton();
		UpdProject.addActionListener(BC.ProjectUpdButton);
		DelProject = new JButton();
		DelProject.addActionListener(BC.ProjectDelButton);
		SelProject = new JButton();
		SelProject.addActionListener(BC.ProjectSelButton);
		AddProgrammer = new JButton();
		AddProgrammer.addActionListener(BC.ProgrammerAddButton);
		UpdProgrammer = new JButton();
		UpdProgrammer.addActionListener(BC.ProgrammerUpdButton);
		DelProgrammer = new JButton();
		DelProgrammer.addActionListener(BC.ProgrammerDelButton);
		SelProgrammer = new JButton();
		SelProgrammer.addActionListener(BC.ProgrammerSelButton);
		AddTeam = new JButton();
		AddTeam.addActionListener(BC.TeamAddButton);
		UpdTeam = new JButton();
		UpdTeam.addActionListener(BC.TeamUpdButton);
		DelTeam = new JButton();
		DelTeam.addActionListener(BC.TeamDelButton);
		SelTeam = new JButton();
		SelTeam.addActionListener(BC.TeamSelButton);
		AddTeamProject = new JButton();
		AddTeamProject.addActionListener(BC.TeamProjectAddButton);
		UpdTeamProject = new JButton();
		UpdTeamProject.addActionListener(BC.TeamProjectUpdButton);
		DelTeamProject = new JButton();
		DelTeamProject.addActionListener(BC.TeamProjectDelButton);
		SelTeamProject = new JButton();
		SelTeamProject.addActionListener(BC.TeamProjectSelButton);
		CancelButton1 = new JButton();
		CancelButton1.addActionListener(BC.ProjectCancelButton);
		ControlButton1 = new JButton();
		CancelButton2 = new JButton();
		CancelButton2.addActionListener(BC.ProgrammerCancelButton);
		ControlButton2 = new JButton();
		CancelButton3 = new JButton();
		CancelButton3.addActionListener(BC.TeamCancelButton);
		ControlButton3 = new JButton();
		CancelButton4 = new JButton();
		CancelButton4.addActionListener(BC.TeamProjectCancelButton);
		ControlButton4 = new JButton();
		
		NameLab = new JLabel("Name:",JLabel.TRAILING);
		NameLab2 = new JLabel("Name:",JLabel.TRAILING);
		StartDateLab = new JLabel("Start Date:",JLabel.TRAILING);
		StatusLab = new JLabel("Status:",JLabel.TRAILING);
		CategoryLab = new JLabel("Category:",JLabel.TRAILING);
		PeselLab = new JLabel("Pesel:",JLabel.TRAILING);
		FirstNameLab = new JLabel("First Name:",JLabel.TRAILING);
		LastNameLab = new JLabel("Last Name:",JLabel.TRAILING);
		SalaryLab = new JLabel("Salary:",JLabel.TRAILING);
		TeamLab = new JLabel("Team:",JLabel.TRAILING);
		RoomLab = new JLabel("Room:",JLabel.TRAILING);
		SpecialityLab = new JLabel("Speciality:",JLabel.TRAILING);
		LevelLab = new JLabel("Level:",JLabel.TRAILING);
		Team2Lab = new JLabel("Team:",JLabel.TRAILING);
		ProjectLab = new JLabel("Project:",JLabel.TRAILING);
		
		TeamNameBox = new JTextField();
		TeamRoomBox = new JTextField();
		TeamSpecialityBox = new JTextField();
		TeamLevelBox = new JTextField();
		ProgrammerPeselBox = new JTextField();
		ProgrammerFirstNameBox = new JTextField();
		ProgrammerLastNameBox = new JTextField();
		ProgrammerSalaryBox = new JTextField();
		ProjectNameBox = new JTextField();
		ProjectStartDateBox = new JTextField();
		ProjectStatusBox = new JTextField();
		ProjectCategoryBox = new JTextField();
		
		ProjectPanel.setLayout(new BorderLayout());
		ProgrammerPanel.setLayout(new BorderLayout());
		TeamPanel.setLayout(new BorderLayout());
		TeamProjectPanel.setLayout(new BorderLayout());
		
		TableData td = new TableData();
		
		ProjectTable = new JTable(td.ProjectData, td.ProjectColNames);
		ProgrammerTable = new JTable(td.ProgrammerData, td.ProgrammerColNames);
		TeamTable = new JTable(td.TeamData, td.TeamColNames);
		TeamProjectTable = new JTable(td.TeamProjectData, td.TeamProjectColNames);
		
		ProjectPanel.setVisible(true);
		ProgrammerPanel.setVisible(true);
		TeamPanel.setVisible(true);
		TeamProjectPanel.setVisible(true);
		
		TeamFormPanel.setVisible(false);
		TeamFormPanel.setBackground(Color.WHITE);
		TeamProjectFormPanel.setVisible(false);
		TeamProjectFormPanel.setBackground(Color.WHITE);
		ProjectFormPanel.setVisible(false);
		ProjectFormPanel.setBackground(Color.WHITE);
		ProgrammerFormPanel.setVisible(false);
		ProgrammerFormPanel.setBackground(Color.WHITE);
		
		ProjectEditPanel.setVisible(true);
		ProjectEditPanel.setBackground(Color.WHITE);;
		ProjectEditPanel.setBorder(BorderFactory.createTitledBorder("Add or Edit Project"));
		ProgrammerEditPanel.setVisible(true);
		ProgrammerEditPanel.setBackground(Color.WHITE);;
		ProgrammerEditPanel.setBorder(BorderFactory.createTitledBorder("Add or Edit Programmer"));
		TeamEditPanel.setVisible(true);
		TeamEditPanel.setBackground(Color.WHITE);;
		TeamEditPanel.setBorder(BorderFactory.createTitledBorder("Add or Edit Team"));
		TeamProjectEditPanel.setVisible(true);
		TeamProjectEditPanel.setBackground(Color.WHITE);;
		TeamProjectEditPanel.setBorder(BorderFactory.createTitledBorder("Add or Edit Team Project"));
		
		ProjectTable.setVisible(true);
		ProjectTable.setFillsViewportHeight(true);
		ProgrammerTable.setVisible(true);
		ProgrammerTable.setFillsViewportHeight(true);
		TeamTable.setVisible(true);
		TeamTable.setFillsViewportHeight(true);
		TeamProjectTable.setVisible(true);
		TeamProjectTable.setFillsViewportHeight(true);
		
		ProjectTablePane = new JScrollPane(ProjectTable);
		ProgrammerTablePane = new JScrollPane(ProgrammerTable);
		TeamTablePane = new JScrollPane(TeamTable);
		TeamProjectTablePane = new JScrollPane(TeamProjectTable);
		
		ProjectPanel.add(ProjectEditPanel,BorderLayout.LINE_START);
		ProjectPanel.add(ProjectTablePane,BorderLayout.CENTER);
		ProgrammerPanel.add(ProgrammerEditPanel,BorderLayout.LINE_START);
		ProgrammerPanel.add(ProgrammerTablePane,BorderLayout.CENTER);
		TeamPanel.add(TeamEditPanel,BorderLayout.LINE_START);
		TeamPanel.add(TeamTablePane,BorderLayout.CENTER);
		TeamProjectPanel.add(TeamProjectEditPanel,BorderLayout.LINE_START);
		TeamProjectPanel.add(TeamProjectTablePane,BorderLayout.CENTER);
		
		AddProject.setVisible(true);
		UpdProject.setVisible(true);
		SelProject.setVisible(true);
		DelProject.setVisible(true);
		
		AddProgrammer.setVisible(true);
		UpdProgrammer.setVisible(true);
		SelProgrammer.setVisible(true);
		DelProgrammer.setVisible(true);
		
		AddTeam.setVisible(true);
		UpdTeam.setVisible(true);
		SelTeam.setVisible(true);
		DelTeam.setVisible(true);
		
		AddTeamProject.setVisible(true);
		UpdTeamProject.setVisible(true);
		SelTeamProject.setVisible(true);
		DelTeamProject.setVisible(true);
		
		AddProject.setText("Add");;
		UpdProject.setText("Update");
		SelProject.setText("Select");
		DelProject.setText("Delete");
		
		AddProgrammer.setText("Add");;
		UpdProgrammer.setText("Update");
		SelProgrammer.setText("Select");
		DelProgrammer.setText("Delete");
		
		AddTeam.setText("Add");;
		UpdTeam.setText("Update");
		SelTeam.setText("Select");
		DelTeam.setText("Delete");
		
		AddTeamProject.setText("Add");;
		UpdTeamProject.setText("Update");
		SelTeamProject.setText("Select");
		DelTeamProject.setText("Delete");
		
		ProjectEditPanel.setLayout(new BorderLayout());
		ProgrammerEditPanel.setLayout(new BorderLayout());
		TeamEditPanel.setLayout(new BorderLayout());
		TeamProjectEditPanel.setLayout(new BorderLayout());
		
		POEditPanel.setLayout(new BorderLayout());
		ROEditPanel.setLayout(new BorderLayout());
		TOEditPanel.setLayout(new BorderLayout());
		TPOEditPanel.setLayout(new BorderLayout());
		
		ProjectButtonPanel.setLayout(new FlowLayout());
		ProjectButtonPanel.setBackground(Color.WHITE);
		ProgrammerButtonPanel.setLayout(new FlowLayout());
		ProgrammerButtonPanel.setBackground(Color.WHITE);
		TeamButtonPanel.setLayout(new FlowLayout());
		TeamButtonPanel.setBackground(Color.WHITE);
		TeamProjectButtonPanel.setLayout(new FlowLayout());
		TeamProjectButtonPanel.setBackground(Color.WHITE);
		
		ProjectFormPanel.setLayout(new SpringLayout());
		ProgrammerFormPanel.setLayout(new SpringLayout());
		TeamFormPanel.setLayout(new SpringLayout());
		TeamProjectFormPanel.setLayout(new SpringLayout());
		
		ProjectButtonPanel.add(AddProject);
		ProjectButtonPanel.add(UpdProject);
		ProjectButtonPanel.add(SelProject);
		ProjectButtonPanel.add(DelProject);
		
		ProgrammerButtonPanel.add(AddProgrammer);
		ProgrammerButtonPanel.add(UpdProgrammer);
		ProgrammerButtonPanel.add(SelProgrammer);
		ProgrammerButtonPanel.add(DelProgrammer);
		
		TeamButtonPanel.add(AddTeam);
		TeamButtonPanel.add(UpdTeam);
		TeamButtonPanel.add(SelTeam);
		TeamButtonPanel.add(DelTeam);
		
		TeamProjectButtonPanel.add(AddTeamProject);
		TeamProjectButtonPanel.add(UpdTeamProject);
		TeamProjectButtonPanel.add(SelTeamProject);
		TeamProjectButtonPanel.add(DelTeamProject);
		
		ProjectFormPanel.add(NameLab);
		NameLab.setLabelFor(ProjectNameBox);
		ProjectFormPanel.add(ProjectNameBox);
		
		ProjectFormPanel.add(StartDateLab);
		StartDateLab.setLabelFor(ProjectStartDateBox);
		ProjectFormPanel.add(ProjectStartDateBox);
		
		ProjectFormPanel.add(StatusLab);
		StatusLab.setLabelFor(ProjectStatusBox);
		ProjectFormPanel.add(ProjectStatusBox);
		
		ProjectFormPanel.add(CategoryLab);
		CategoryLab.setLabelFor(ProjectCategoryBox);	
		ProjectFormPanel.add(ProjectCategoryBox);
		
		CancelButton1.setText("Cancel");
		ControlButton1.setText(" ");
		ProjectFormPanel.add(CancelButton1);
		ProjectFormPanel.add(ControlButton1);
		
		SpringUtilities.makeCompactGrid(ProjectFormPanel,5,2,6,6,6,6);
		
		ProgrammerFormPanel.add(PeselLab);
		PeselLab.setLabelFor(ProgrammerPeselBox);
		ProgrammerFormPanel.add(ProgrammerPeselBox);
		
		ProgrammerFormPanel.add(FirstNameLab);
		FirstNameLab.setLabelFor(ProgrammerFirstNameBox);
		ProgrammerFormPanel.add(ProgrammerFirstNameBox);
		
		ProgrammerFormPanel.add(LastNameLab);
		LastNameLab.setLabelFor(ProgrammerLastNameBox);
		ProgrammerFormPanel.add(ProgrammerLastNameBox);
		
		ProgrammerFormPanel.add(SalaryLab);
		SalaryLab.setLabelFor(ProgrammerSalaryBox);
		ProgrammerFormPanel.add(ProgrammerSalaryBox);
		
		ProgrammerFormPanel.add(TeamLab);
		TeamLab.setLabelFor(ProgrammerTeamListBox);
		ProgrammerFormPanel.add(ProgrammerTeamListBox);
		
		CancelButton2.setText("Cancel");
		ControlButton2.setText(" ");
		ProgrammerFormPanel.add(CancelButton2);
		ProgrammerFormPanel.add(ControlButton2);
		
		SpringUtilities.makeCompactGrid(ProgrammerFormPanel,6,2,6,6,6,6);
		
		TeamFormPanel.add(NameLab2);
		NameLab2.setLabelFor(TeamNameBox);
		TeamFormPanel.add(TeamNameBox);
		
		TeamFormPanel.add(RoomLab);
		RoomLab.setLabelFor(TeamRoomBox);
		TeamFormPanel.add(TeamRoomBox);
		
		TeamFormPanel.add(SpecialityLab);
		SpecialityLab.setLabelFor(TeamSpecialityBox);
		TeamFormPanel.add(TeamSpecialityBox);
		
		TeamFormPanel.add(LevelLab);
		LevelLab.setLabelFor(TeamLevelBox);
		TeamFormPanel.add(TeamLevelBox);
		
		CancelButton3.setText("Cancel");
		ControlButton3.setText(" ");
		TeamFormPanel.add(CancelButton3);
		TeamFormPanel.add(ControlButton3);
		
		SpringUtilities.makeCompactGrid(TeamFormPanel,5,2,6,6,6,6);
		
		TeamProjectFormPanel.add(Team2Lab);
		Team2Lab.setLabelFor(TeamProjectListBox);
		TeamProjectFormPanel.add(TeamProjectListBox);
		
		TeamProjectFormPanel.add(ProjectLab);
		ProjectLab.setLabelFor(ProjectTeamListBox);
		TeamProjectFormPanel.add(ProjectTeamListBox);
		
		CancelButton4.setText("Cancel");
		ControlButton4.setText(" ");
		TeamProjectFormPanel.add(CancelButton4);
		TeamProjectFormPanel.add(ControlButton4);
		
		SpringUtilities.makeCompactGrid(TeamProjectFormPanel,3,2,6,6,6,6);
		
		POEditPanel.add(ProjectButtonPanel,BorderLayout.NORTH);
		POEditPanel.add(ProjectFormPanel,BorderLayout.CENTER);
		ROEditPanel.add(ProgrammerButtonPanel,BorderLayout.NORTH);
		ROEditPanel.add(ProgrammerFormPanel,BorderLayout.CENTER);
		TOEditPanel.add(TeamButtonPanel,BorderLayout.NORTH);
		TOEditPanel.add(TeamFormPanel,BorderLayout.CENTER);
		TPOEditPanel.add(TeamProjectButtonPanel,BorderLayout.NORTH);
		TPOEditPanel.add(TeamProjectFormPanel,BorderLayout.CENTER);
		
		ProjectEditPanel.add(POEditPanel,BorderLayout.NORTH);
		ProgrammerEditPanel.add(ROEditPanel,BorderLayout.NORTH);
		TeamEditPanel.add(TOEditPanel,BorderLayout.NORTH);
		TeamProjectEditPanel.add(TPOEditPanel,BorderLayout.NORTH);
		
		tabPane = new JTabbedPane();
		tabPane.setVisible(true);
		
		tabPane.addTab("Projects", ProjectPanel);
		tabPane.addTab("Programmers", ProgrammerPanel);
		tabPane.addTab("Teams", TeamPanel);
		tabPane.addTab("Team Projects", TeamProjectPanel);
		
		mainWindow.add(tabPane);
	}
}
