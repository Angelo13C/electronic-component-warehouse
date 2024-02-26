package com.angelocipriani.ecw.frontend;

public class TableRow {
	public static final String EMPTY_CELL = "      EMPTY      ";
	public String number;
	public String cell1;
	public String cell1Style;
	public String cell2;
	public String cell2Style;
	public String cell3;
	public String cell3Style;
	public String cell4;
	public String cell4Style;
	public String cell5;
	public String cell5Style;
	public String cell6;
	public String cell6Style;
	public String cell7;
	public String cell7Style;
	
	public TableRow(String number, String cell1, String cell2, String cell3, String cell4, String cell5, String cell6,
			String cell7) {
		super();
		
		this.number = number;
		this.cell1 = cell1;
		cell1Style = getBorderStyle(cell1);
		this.cell2 = cell2;
		cell2Style = getBorderStyle(cell2);
		this.cell3 = cell3;
		cell3Style = getBorderStyle(cell3);
		this.cell4 = cell4;
		cell4Style = getBorderStyle(cell4);
		this.cell5 = cell5;
		cell5Style = getBorderStyle(cell5);
		this.cell6 = cell6;
		cell6Style = getBorderStyle(cell6);
		this.cell7 = cell7;
		cell7Style = getBorderStyle(cell7);
	}
	
	private static String getBorderStyle(String cell)
	{
		return cell.equals(EMPTY_CELL) ? "dashed" : "solid";
	}
}
