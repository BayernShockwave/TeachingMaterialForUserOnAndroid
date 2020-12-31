package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DButil.SqlHelper;
import Entity.Discipline;

public class DisciplineDao {
    public static List<Discipline> allDisciplines() {
        List<Discipline> disciplineList = new ArrayList<Discipline>();
        String sql = "select * from Discipline";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(resultSet.getString(1));
                discipline.setName(resultSet.getString(2));
                discipline.setG1(resultSet.getInt(3));
                discipline.setG2(resultSet.getInt(4));
                discipline.setG3(resultSet.getInt(5));
                discipline.setG4(resultSet.getInt(6));
                discipline.setUni(resultSet.getString(7));
                disciplineList.add(discipline);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return disciplineList;
    }

    public static List<Discipline> selectDisciplineById(String id) {
        List<Discipline> disciplineList = new ArrayList<Discipline>();
        String sql = "select * from Discipline where Did='"+id+"'";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(resultSet.getString(1));
                discipline.setName(resultSet.getString(2));
                discipline.setG1(resultSet.getInt(3));
                discipline.setG2(resultSet.getInt(4));
                discipline.setG3(resultSet.getInt(5));
                discipline.setG4(resultSet.getInt(6));
                discipline.setUni(resultSet.getString(7));
                disciplineList.add(discipline);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return disciplineList;
    }

    public static List<Discipline> selectDisciplineByName(String name) {
        List<Discipline> disciplineList = new ArrayList<Discipline>();
        String sql = "select * from Discipline where Dname='"+name+"'";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(resultSet.getString(1));
                discipline.setName(resultSet.getString(2));
                discipline.setG1(resultSet.getInt(3));
                discipline.setG2(resultSet.getInt(4));
                discipline.setG3(resultSet.getInt(5));
                discipline.setG4(resultSet.getInt(6));
                discipline.setUni(resultSet.getString(7));
                disciplineList.add(discipline);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return disciplineList;
    }

    public static int addDiscipline(String id,String name,int g1,int g2,int g3,int g4,String uni) {
        String sql = "insert into Discipline values('"+id+"','"+name+"','"+g1+"','"+g2+"','"+g3+"','"+g4+"','"+uni+"')";
        return SqlHelper.executeUpdate(sql);
    }

    public static int updateDiscipline(String id,String name,int g1,int g2,int g3,int g4,String uni) {
        String sql="update Discipline set Dname='"+name+"',Dstu1count='"+g1+"',Dstu2count='"+g2+"',Dstu3count='"+g3+"',Dstu4count='"+g4+"',Duni='"+uni+"' where Did='"+id+"'";
        return SqlHelper.executeUpdate(sql);
    }

    public static int deleteDisciplineById(String id) {
        String sql="delete from Discipline where Did='"+id+"'";
        return SqlHelper.executeUpdate(sql);
    }

    public static int deleteDisciplineByName(String name) {
        String sql="delete from Discipline where Dname='"+name+"'";
        return SqlHelper.executeUpdate(sql);
    }
}
