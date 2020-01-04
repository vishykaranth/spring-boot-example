package misc;

import product.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectRows {
    public static void main(String args[]) {
        SelectRows select = new SelectRows();
        List<Company> companyList = select.getCompanyList();
        System.out.println(companyList);
    }

    public List<Company> getCompanyList() {
        DatabaseUtil databaseUtil = new DatabaseUtil();
        Connection c;
        Statement stmt;
        List<Company> companyList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            c = databaseUtil.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
            Company company = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                company = new Company(id, name, age, address, salary);
                companyList.add(company);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return companyList;
    }
}
