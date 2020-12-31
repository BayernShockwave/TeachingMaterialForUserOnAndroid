package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DButil.SqlHelper;
import Entity.Book;

public class BookDao {

    public static List<Book> allBooks() {
        List<Book> bookList = new ArrayList<Book>();
        String sql = "select * from Book";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Book book = new Book();
                book.setBid(resultSet.getString(1));
                book.setBname(resultSet.getString(2));
                book.setBtype(resultSet.getString(3));
                book.setBarea(resultSet.getString(4));
                book.setBcount(resultSet.getInt(5));
                book.setBpublish(resultSet.getString(6));
                book.setBuseuni(resultSet.getString(7));
                book.setBusediscipline(resultSet.getString(8));
                book.setBusegrade(resultSet.getInt(9));
                bookList.add(book);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public static List<Book> selectBooksById(String id) {
        List<Book> bookList = new ArrayList<Book>();
        String sql = "select * from Book where Bid='"+id+"'";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Book book = new Book();
                book.setBid(resultSet.getString(1));
                book.setBname(resultSet.getString(2));
                book.setBtype(resultSet.getString(3));
                book.setBarea(resultSet.getString(4));
                book.setBcount(resultSet.getInt(5));
                book.setBpublish(resultSet.getString(6));
                book.setBuseuni(resultSet.getString(7));
                book.setBusediscipline(resultSet.getString(8));
                book.setBusegrade(resultSet.getInt(9));
                bookList.add(book);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public static List<Book> selectBooksByName(String name) {
        List<Book> bookList = new ArrayList<Book>();
        String sql = "select * from Book where Bname='"+name+"'";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Book book = new Book();
                book.setBid(resultSet.getString(1));
                book.setBname(resultSet.getString(2));
                book.setBtype(resultSet.getString(3));
                book.setBarea(resultSet.getString(4));
                book.setBcount(resultSet.getInt(5));
                book.setBpublish(resultSet.getString(6));
                book.setBuseuni(resultSet.getString(7));
                book.setBusediscipline(resultSet.getString(8));
                book.setBusegrade(resultSet.getInt(9));
                bookList.add(book);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public static int addBook(String id,String name,String type,String area,int count,String publish,String uni,String discipline,int grade) {
        String sql = "insert into Book values('"+id+"','"+name+"','"+type+"','"+area+"','"+count+"','"+publish+"','"+uni+"','"+discipline+"','"+grade+"')";
        return SqlHelper.executeUpdate(sql);
    }

    public static int updateBook(String id,String name,String type,String area,int count,String publish,String uni,String discipline,int grade) {
        String sql="update Book set Bname='"+name+"',Btype='"+type+"',Barea='"+area+"',Bcount='"+count+"',Bpublish='"+publish+"',Buseuni='"+uni+"',Busediscipline='"+discipline+"',Busegrade='"+grade+"' where Bid='"+id+"'";
        return SqlHelper.executeUpdate(sql);
    }

    public static int deleteBookById(String id) {
        String sql="delete from Book where Bid='"+id+"'";
        return SqlHelper.executeUpdate(sql);
    }

    public static int deleteBookByName(String name) {
        String sql="delete from Book where Bname='"+name+"'";
        return SqlHelper.executeUpdate(sql);
    }
}
