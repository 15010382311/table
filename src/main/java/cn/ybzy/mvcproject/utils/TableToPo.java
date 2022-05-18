package cn.ybzy.mvcproject.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import util.JDBCUtils;

public class TableToPo {
	private String tablename = "student";// ����
	private String[] colnames; // ��������
	private String[] colTypes; // ������������
	private int[] colSizes; // ������С����
	private boolean f_util = false; // �Ƿ���Ҫ�����java.util.*
	private boolean f_sql = false; // �Ƿ���Ҫ�����java.sql.*
	private boolean f_math = false;// �Ƿ���Ҫ�����java.math.*

	public TableToPo() {
		Connection con;
		
			con = JDBCUtils.getConnection();
		
		PreparedStatement ps = null;
		ResultSetMetaData rs = null;
		String strsql = "select * from " + tablename;
		try {
			ps = con.prepareStatement(strsql);
			rs = ps.getMetaData();
			int size = rs.getColumnCount();
			colnames = new String[size];
			colTypes = new String[size];
			colSizes = new int[size];
			for (int i = 0; i < rs.getColumnCount(); i++) {
				colnames[i] = rs.getColumnName(i + 1);
				colTypes[i] = rs.getColumnTypeName(i + 1);
				if (colTypes[i].equalsIgnoreCase("datetime") || colTypes[i].equalsIgnoreCase("date")
						|| colTypes[i].equalsIgnoreCase("smalldatetime") || colTypes[i].equalsIgnoreCase("time")) {
					f_sql = true;
				}
				if (colTypes[i].equalsIgnoreCase("money") || colTypes[i].equalsIgnoreCase("decimal")
						|| colTypes[i].equalsIgnoreCase("smallmoney") || colTypes[i].equalsIgnoreCase("numeric")) {
					f_math = true;
				}
				colSizes[i] = rs.getColumnDisplaySize(i + 1);
			}
			String content = parse(colnames, colTypes, colSizes);
			FileWriter fileWriter = new FileWriter(initcap(tablename) + ".java");
			PrintWriter pw = new PrintWriter(fileWriter);
			pw.println(content);
			pw.flush();
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * ��������(����ʵ�����������)
	 */
	private String parse(String[] colNames, String[] colTypes, int[] colSizes) {
		StringBuffer sb = new StringBuffer();
		if (f_util) {
			sb.append("import java.util.Date;\r\n");
		}
		if (f_sql) {
			sb.append("import java.sql.*;\r\n");
		}
		if (f_math) {
			sb.append("import java.math.BigDecimal;\r\n\r\n\r\n");
		}
		sb.append("public class " + initcap(tablename) + " {\r\n");
		processAllAttrs(sb);
		processAllMethod(sb);
		sb.append("}\r\n");
		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * �������еķ���
	 * 
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "(){\r\n");
			sb.append("\t\treturn " + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
			sb.append("\tpublic void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " "
					+ colnames[i] + "){\r\n");
			sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");

		}
	}

	/**
	 * �����������
	 * 
	 * @return
	 */
	private void processAllAttrs(StringBuffer sb) {
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + colnames[i] + ";\r\n");
		}
	}

	/**
	 * �������ַ���������ĸ�ĳɴ�д
	 * 
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	private String sqlType2JavaType(String sqlType) {
		if (sqlType.equalsIgnoreCase("bit")) {
			return "Boolean";
		} else if (sqlType.equalsIgnoreCase("timestamp") || sqlType.equalsIgnoreCase("binary")
				|| sqlType.equalsIgnoreCase("image") || sqlType.equalsIgnoreCase("varbinary")) {
			return "byte[]";
		} else if (sqlType.equalsIgnoreCase("smallint") || sqlType.equalsIgnoreCase("tinyint")) {
			return "short";
		} else if (sqlType.equalsIgnoreCase("int")) {
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("bigint")) {
			return "long";
		} else if (sqlType.equalsIgnoreCase("real")) {
			return "float";
		} else if (sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("float")) {
			return "double";
		} else if (sqlType.equalsIgnoreCase("money") || sqlType.equalsIgnoreCase("decimal")
				|| sqlType.equalsIgnoreCase("smallmoney") || sqlType.equalsIgnoreCase("numeric")) {
			return "BigDecimal";
		} else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
				|| sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
				|| sqlType.equalsIgnoreCase("text") || sqlType.equalsIgnoreCase("ntext")
				|| sqlType.equalsIgnoreCase("uniqueidentifier")) {
			return "String";
		} else if (sqlType.equalsIgnoreCase("date")) {
			return "Date";// Date
		} else if (sqlType.equalsIgnoreCase("smalldatetime") || sqlType.equalsIgnoreCase("datetime")) {
			return "Timestamp";
		} else if (sqlType.equalsIgnoreCase("time")) {
			return "Time";
		}
		return null;
	}

	public static void main(String[] args) {
		new TableToPo();
	}
}
